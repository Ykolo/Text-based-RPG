package rpg.entities;

import java.util.ArrayList;

import rpg.weapons.Weapon;

public class Player {
  private String name;
  private String role;
  private double gold;
  private double xp;
  private int mana;
  private double hp;
  private ArrayList<Weapon> inventory = new ArrayList<Weapon>();

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

  public ArrayList<Weapon> getInventory() {
    return this.inventory;
  }

  // setters
  public void setGold(double gold) {
    this.gold = gold;
  }

  // fonctions
  public void addWeapon(Weapon w) {
    this.inventory.add(w);
  }

  public void showStats() {
    System.out.println("=== Statistiques du joueur ===");
    System.out.println("Nom : " + this.name);
    System.out.println("Role : " + this.role);
    System.out.println("Or : " + this.gold);
    System.out.println("XP : " + this.xp);
    System.out.println("Mana : " + this.mana);
    System.out.println("Santé : " + this.hp + "\n");
  }

  public void showInventory() {
    System.out.println("=== Inventaire des armes ===");
    if (this.inventory.isEmpty()) {
      System.out.println("Vous n'avez aucune arme dans votre inventaire.");
    } else {
      for (int i = 0; i < this.getInventory().size(); i++) {
        Weapon w = this.getInventory().get(i);
        System.out.println((i + 1) + ". " + w.getName() + " Degats: " + w.getDamage());
      }
    }
    System.out.println("===========================\n");
  }
}
