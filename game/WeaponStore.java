package rpg.game;

import rpg.entities.Player;
import rpg.weapon.Bow;
import rpg.weapon.Sword;
import rpg.weapon.Weapon;

public class WeaponStore {
  Weapon[] weapons = { new Sword(), new Bow() };

  public Weapon[] getWeapons() {
    return weapons;
  }

  public void buyWeapon(Player p, Weapon w) {
    if (p.getGold() < w.getPrice()) {
      System.out.println("Vous n'avez pas assez d'argent");
    } else {
      p.setGold(p.getGold() - w.getPrice());
      p.addWeapon(w);
    }
  }
}
