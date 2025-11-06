package rpg.weapons;

import rpg.entities.Destructible.Monster;
import rpg.entities.Destructible.Obstacle;

public abstract class Weapon {
  private String name;
  private int damage;
  private double price;

  // constructor
  public Weapon(String name, int damage, double price) {
    this.name = name;
    this.damage = damage;
    this.price = price;
  }

  // getters
  public String getName() {
    return name;
  }

  public int getDamage() {
    return damage;
  }

  public double getPrice() {
    return price;
  }

  // functions
  public void attack(Monster monstre) {
    monstre.setHp(monstre.getHp() - this.damage);
  }

  public void attack(Obstacle obstacle) {
    obstacle.setHp(obstacle.getHp() - (this.damage * 0.8));
  }

  @Override
  public String toString() {
    return this.name + " (Degats: " + this.damage + ", Prix: " + this.price + " or)";
  }
}