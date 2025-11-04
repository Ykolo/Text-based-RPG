package rpg;

public class Monstre {
  private String name;
  private double hp;

  public Monstre(String name, double hp) {
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
