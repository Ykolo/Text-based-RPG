package rpg;

import java.util.ArrayList;

import rpg.weapon.Weapon;

public class Player {
  private String name;
  private String role;
  private double gold;
  private double xp;
  private int mana;
  private double hp;
  private ArrayList<Weapon> weapon = new ArrayList<Weapon>();

  // getters
  public double getGold() {
    return this.gold;
  }

  public void getWeapons() {
    for (Weapon w : this.weapon) {
      System.out.println(w.getName());
    }
  }

  // setters
  public void setGold(double gold) {
    this.gold = gold;
  }

  // fonctions
  public void addWeapon(Weapon w) {
    this.weapon.add(w);
  }
}
