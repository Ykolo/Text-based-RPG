package rpg.entities.Destructible;

public class Destructible {
  private String name;
  private double hp;

  public Destructible(String name, double hp) {
    this.name = name;
    this.hp = hp;
  }

  public String getName() {
    return name;
  }

  public double getHp() {
    return hp;
  }

  public void setHp(double hp) {
    this.hp = hp;
  }
}
