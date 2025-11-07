package rpg.game;

import java.util.Scanner;

import rpg.entities.Player;
import rpg.entities.Destructible.Monster;
import rpg.entities.Destructible.Obstacle;

public class Game {
  private Scanner scanner = new Scanner(System.in);
  private Player player;
  private Map map;
  private WeaponStore shop;
  private boolean running = true;

  public void startGame() {
    System.out.println("=== Bienvenue dans le RPG de Ykolo ===");
    createPlayer();
    map = new Map(5, 5);
    shop = new WeaponStore();
    gameLoop();
  }

  private void createPlayer() {
    System.out.println("Entrez le nom de votre personnage : ");
    String name = scanner.nextLine();
    System.out.println("Entrez le role de votre personnage : ");
    System.out
        .println("/!\\ Attention si vous ne choissiez pas un role valuide vous serez un Guerrier par défaut /!\\");
    System.out.println("1. Guerrier ");
    System.out.println("2. Sorcier ");
    System.out.println("3. Elfe ");

    String roleChoice = scanner.nextLine();

    String role = "";
    switch (roleChoice) {
      case "1":
        role = "Guerrier";
        break;
      case "2":
        role = "Sorcier";
        break;
      case "3":
        role = "Elfe";
        break;
      default:
        role = "Guerrier";
        break;
    }

    player = new Player(name, role, 100, 0, 100, 100);
    System.out.println("Bienvenue " + player.getName() + " vous etes un " + player.getRole() + " !");
    System.out.println("Voici vos statistiques de départ : ");
    System.out.println("Santé : " + player.getHp());
    System.out.println("Mana : " + player.getMana());
    System.out.println("XP : " + player.getXp());
    System.out.println("Or : " + player.getGold());
  }

  private void gameLoop() {
    while (running && player.getHp() > 0) {
      if (map.isAtExit()) {
        System.out.println("\nFÉLICITATIONS ! Vous avez atteint la sortie du donjon !");
        System.out.println("Vous avez gagné !");
        player.showStats();
        running = false;
        break;
      }

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("\n=== MENU PRINCIPAL ===");
      System.out.println("Que voulez-vous faire ?");
      System.out.println("1. Entrez dans le donjon (Déplacement)");
      System.out.println("2. Afficher les statistiques");
      System.out.println("3. Afficher l'inventaire");
      System.out.println("4. Aller au magasin");
      System.out.println("5. Quitter");
      System.out.print("Votre choix: ");
      String choice = scanner.nextLine();
      switch (choice) {
        case "1":
          explore();
          break;
        case "2":
          this.player.showStats();
          break;
        case "3":
          this.player.showInventory();
          break;
        case "4":
          shop.open(this.player, scanner);
          break;
        case "5":
          running = false;
          System.out.println("Merci d'avoir joué !");
          break;
        default:
          System.out.println("Choix invalide. Veuillez réessayer.");
      }
    }

    if (player.getHp() <= 0) {
      System.out.println("\nGAME OVER - Vous êtes mort dans le donjon...");
    }
  }

  private void explore() {
    boolean inMovementMode = true;

    while (inMovementMode && player.getHp() > 0 && !map.isAtExit()) {
      map.display();

      System.out.println("\n=== MODE DÉPLACEMENT ===");
      System.out.println("1. Haut (Z)");
      System.out.println("2. Bas (S)");
      System.out.println("3. Gauche (Q)");
      System.out.println("4. Droite (D)");
      System.out.println("5. Retourner au menu principal");
      System.out.print("Votre choix: ");
      String dirChoice = scanner.nextLine();

      if (dirChoice.equals("5")) {
        inMovementMode = false;
        System.out.println("Retour au menu principal...");
        continue;
      }

      String direction = "";
      switch (dirChoice) {
        case "1":
        case "z":
        case "Z":
          direction = "haut";
          break;
        case "2":
        case "s":
        case "S":
          direction = "bas";
          break;
        case "3":
        case "q":
        case "Q":
          direction = "gauche";
          break;
        case "4":
        case "d":
        case "D":
          direction = "droite";
          break;
        default:
          System.out.println("Direction invalide!");
          continue;
      }

      if (map.movePlayer(direction)) {
        System.out.println("Vous vous déplacez vers " + direction + "...");

        char cell = map.getCurrentCell();

        switch (cell) {
          case 'M':
            System.out.println("\n Vous rencontrez un monstre !");
            Monster monster = map.createMonster();
            Battle monsterBattle = new Battle(player, monster, scanner);
            monsterBattle.startBattle();
            if (!monster.isAlive()) {
              map.clearCurrentCell();
            }
            break;

          case 'O':
            System.out.println("\nVous rencontrez un obstacle !");
            Obstacle obstacle = map.createObstacle();
            Battle obstacleBattle = new Battle(player, obstacle, scanner);
            obstacleBattle.startBattle();
            if (!obstacle.isAlive()) {
              map.clearCurrentCell();
            }
            break;

          case 'S':
            System.out.println("\nVous êtes à la sortie !");
            break;

          case '.':
            System.out.println("Case vide. Vous pouvez continuer.");
            break;
        }

        if (player.getHp() <= 0) {
          inMovementMode = false;
        }
      }
    }
  }
}
