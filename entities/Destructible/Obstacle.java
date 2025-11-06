package rpg.entities.Destructible;

public class Obstacle implements Destructible {
  private String name;
  private double hp;

  // constructor
  public Obstacle(String name, double hp) {
    this.name = name;
    this.hp = hp;
  }

  // getters and setters
  @Override
  public String getName() {
    return name;
  }

  @Override
  public double getHp() {
    return hp;
  }

  @Override
  public void setHp(double hp) {
    this.hp = hp;
  }

  @Override
  public double getAttack() {
    return 0;
  }

  @Override
  public boolean isAlive() {
    return hp > 0;
  }
}
