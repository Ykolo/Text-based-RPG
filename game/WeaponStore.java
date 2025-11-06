package rpg.game;

import java.util.Scanner;

import rpg.entities.Player;
import rpg.weapons.Bow;
import rpg.weapons.Staff;
import rpg.weapons.Sword;
import rpg.weapons.Weapon;

public class WeaponStore {
  Weapon[] store = { new Sword(), new Bow(), new Staff() };

  // getters
  public Weapon[] getStock() {
    return store;
  }

  // functions
  public void open(Player player, Scanner scanner) {
    System.out.println("=== Bienvenue dans la boutique d'armes ===");
    System.out.println("Or disponible: " + player.getGold());
    for (int i = 0; i < store.length; i++) {
      System.out.println((i + 1) + ". " + store[i]);
    }
    System.out.println("0. Quitter la boutique");
    System.out.println("===============================");
    int choice = scanner.nextInt();
    scanner.nextLine();
    if (choice == 0) {
      System.out.println("Merci de votre visite ! \n");
    } else if (choice > 0 && choice <= store.length) {
      if (buyWeapon(player, store[choice - 1])) {
        System.out.println("Vous avez acheté " + store[choice - 1].getName() + "\n");
      }
    } else {
      System.out.println("Choix invalide \n");
    }

  }

  public boolean buyWeapon(Player p, Weapon w) {
    if (p.getGold() < w.getPrice()) {
      System.out.println("Vous n'avez pas assez d'argent \n");
      return false;
    } else {
      p.setGold(p.getGold() - w.getPrice());
      p.addWeapon(w);
      return true;
    }
  }
}
