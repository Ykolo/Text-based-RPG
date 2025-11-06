package rpg.entities;

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

  // constructor
  public Player(String name, String role, double gold, double xp, int mana, double hp) {
    this.name = name;
    this.role = role;
    this.gold = gold;
    this.xp = xp;
    this.mana = mana;
    this.hp = hp;
  }

  // getters
  public String getName() {
    return this.name;
  }

  public String getRole() {
    return this.role;
  }

  public double getGold() {
    return this.gold;
  }

  public double getXp() {
    return this.xp;
  }

  public int getMana() {
    return this.mana;
  }

  public double getHp() {
    return this.hp;
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
