package rpg.game;

import java.util.Scanner;

import rpg.entities.Player;
import rpg.entities.Destructible.Destructible;
import rpg.entities.Destructible.Monster;
import rpg.entities.Destructible.Obstacle;

public class Battle {
  private final Player player;
  private final Destructible target;
  private final Scanner scanner;

  // Constructor pour monstre
  public Battle(Player player, Monster monster, Scanner scanner) {
    this.player = player;
    this.target = monster;
    this.scanner = scanner;
  }

  // Constructor pour obstacle
  public Battle(Player player, Obstacle obstacle, Scanner scanner) {
    this.player = player;
    this.target = obstacle;
    this.scanner = scanner;
  }

  public void startBattle() {
    if (target instanceof Monster) {
      System.out.println("\n === Un " + target.getName() + " sauvage apparaît ! ===");
    } else {
      System.out.println("\n === Obstacle : " + target.getName() + " sur la route ===");
    }

    while (player.getHp() > 0 && target.isAlive()) {
      System.out.println("\n--- État ---");
      System.out.println("Vos HP: " + player.getHp());
      System.out.println(target.getName() + " HP: " + target.getHp());

      System.out.println("\nQue voulez-vous faire ?");
      System.out.println("1. Attaquer");
      System.out.println("2. Fuir");
      System.out.print("Choix: ");
      String choice = scanner.nextLine();

      switch (choice) {
        case "1":
          attackTarget();
          if (target.isAlive() && target instanceof Monster) {
            monsterCounterAttack();
          }
          break;
        case "2":
          System.out.println("Vous prenez la fuite !");
          return;
        default:
          System.out.println("Choix invalide.");
      }
    }

    handleBattleEnd();
  }

  private void attackTarget() {
    if (player.getInventory().isEmpty()) {
      System.out.println("Vous n'avez aucune arme !");
      return;
    }

    System.out.println("\nChoisissez votre arme :");
    for (int i = 0; i < player.getInventory().size(); i++) {
      System.out.println((i + 1) + ". " + player.getInventory().get(i).getName());
    }
    System.out.print("Votre choix: ");
    String weaponChoice = scanner.nextLine();

    try {
      int weaponIndex = Integer.parseInt(weaponChoice) - 1;
      if (weaponIndex >= 0 && weaponIndex < player.getInventory().size()) {
        player.attack(target, player.getInventory().get(weaponIndex));
      } else {
        System.out.println("Choix d'arme invalide.");
      }
    } catch (NumberFormatException e) {
      System.out.println("Veuillez entrer un nombre valide.");
    }
  }

  private void monsterCounterAttack() {
    Monster monster = (Monster) target;
    System.out.println("\n" + monster.getName() + " contre-attaque !");
    double damage = monster.getAttack();
    player.receiveDamage(damage);
    System.out.println("Vous subissez " + damage + " points de dégâts !");
  }

  private void handleBattleEnd() {
    if (player.getHp() <= 0) {
      System.out.println("\n GAME OVER - Vous êtes mort !");
    } else if (!target.isAlive()) {
      if (target instanceof Monster) {
        Monster monster = (Monster) target;
        System.out.println("\n Victoire ! " + monster.getName() + " vaincu !");
        System.out.println("+ " + monster.getXpReward() + " XP");
        System.out.println("+ " + monster.getGoldReward() + " Or");
        player.setXp(player.getXp() + monster.getXpReward());
        player.setGold(player.getGold() + monster.getGoldReward());
      } else if (target instanceof Obstacle) {
        System.out.println("\n Obstacle détruit : " + target.getName() + " !");
      }
    }
  }
}
