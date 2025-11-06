package rpg.game;

import java.util.Scanner;

import rpg.entities.Player;

public class Game {
  private Scanner scanner = new Scanner(System.in);
  private Player player;
  private boolean running = true;

  public void start() {
    System.out.println("=== Bienvenue dans le RPG de Ykolo ===");
  }

  public void createPlayer() {
    System.out.println("Entrez le nom de votre personnage : ");
    String name = scanner.nextLine();
    System.out.println("Entrez le role de votre personnage : ");
    System.out.println("1. Guerrier ");
    System.out.println("2. Sorcier ");
    System.out.println("3. Elfe ");
    System.out.println("Choix par defaut : Guerrier ");

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
}
