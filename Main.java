package rpg;

import rpg.entities.Player;
import rpg.game.WeaponStore;
import rpg.weapon.Bow;
import rpg.weapon.Sword;
import rpg.weapon.Weapon;

public class Main {
  public static void main(String[] args) {
    Player p = new Player();
    p.setGold(100);
    Weapon w = new Sword();
    Weapon w2 = new Bow();
    WeaponStore ws = new WeaponStore();
    ws.buyWeapon(p, w);
    System.out.println("Il vous reste " + p.getGold() + " d'or");
    p.getWeapons();
    ws.buyWeapon(p, w2);
    System.out.println("Il vous reste " + p.getGold() + " d'or");
    p.getWeapons();
  }
}
