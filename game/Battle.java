package rpg.game;

import java.util.Scanner;

import rpg.entities.Player;
import rpg.entities.Destructible.Monster;

public class Battle {
  private final Player player;
  private final Monster monster;
  private final Scanner scanner;

  // constructor
  public Battle(Player player, Monster monster, Scanner scanner) {
    this.player = player;
    this.monster = monster;
    this.scanner = scanner;
  }

  public void startBattle() {
    System.out.println("\n === Un " + monster.getName() + " sauvage apparaît ! ===");
    while (player.getHp() > 0 && monster.isAlive()) {
      System.out.println("Que voulez-vous faire ?");
      System.out.println("1. Attaquer");
      System.out.println("2. Fuir");
      String choice = scanner.nextLine();
      switch (choice) {
        case "1":
          System.out.println("Avec quelle arme voulez-vous attaquer ?");
          for (int i = 0; i < player.getInventory().size(); i++) {
            System.out.println((i + 1) + ". " + player.getInventory().get(i).getName());
          }
          String weaponChoice = scanner.nextLine();
          int weaponIndex = Integer.parseInt(weaponChoice) - 1;
          if (weaponIndex >= 0 && weaponIndex < player.getInventory().size()) {
            player.attack(monster, player.getInventory().get(weaponIndex));
          } else {
            System.out.println("Choix d'arme invalide.");
          }
          break;
        case "2":
          // flee();
          return;
        default:
          System.out.println("Choix invalide. Veuillez réessayer.");
      }
    }
    if (player.getHp() <= 0) {
      System.out.println("Vous avez été vaincu par " + monster.getName() + "...");
    } else if (!monster.isAlive()) {
      System.out.println("Bravo ! Vous avez vaincu " + monster.getName() + " !");
      player.setXp(player.getXp() + monster.getXpReward());
      player.setGold(player.getGold() + monster.getGoldReward());
    }
  }
}
