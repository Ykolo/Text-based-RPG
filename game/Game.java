package rpg.game;

import java.util.Scanner;

import rpg.entities.Player;

public class Game {
  private Scanner scanner = new Scanner(System.in);
  private Player player;
  private boolean running = true;

  public void start() {
    System.out.println("=== Bienvenue dans le RPG de Ykolo ===");
    createPlayer();
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
    while (running) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Que voulez-vous faire ?");
      System.out.println("1. Entrez dans le donjon");
      System.out.println("2. Afficher les statistiques");
      System.out.println("3. Afficher l'inventaire");
      System.out.println("4. Aller au magasin");
      System.out.println("5. Quitter");
      String choice = scanner.nextLine();
      switch (choice) {
        case "1":
          // explore();
          break;
        case "2":
          this.player.showStats();
          break;
        case "3":
          this.player.showInventory();
          break;
        case "4":
          new WeaponStore().open(this.player, scanner);
          break;
        case "5":
          running = false;
          break;
        default:
          System.out.println("Choix invalide. Veuillez réessayer.");
      }
    }
  }

}
