package rpg.weapon;

import rpg.Monster;
import rpg.Obstacle;

public abstract class Weapon {
  private String name;
  private int damage;
  private double price;

  public Weapon(String name, int damage, double price) {
    this.name = name;
    this.damage = damage;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public int getDamage() {
    return damage;
  }

  public double getPrice() {
    return price;
  }

  public void attack(Monster monstre) {
    monstre.setHp(monstre.getHp() - (this.damage * 0.8));
  }

  public void attack(Obstacle obstacle) {
    obstacle.setHp(obstacle.getHp() - (this.damage * 1.2));
  }
}