package rpg.entities.Destructible;

public class Monster implements Destructible {
  private final String name;
  private double hp;
  private final double attack;
  private final double xpReward;
  private final double goldReward;

  // constructor
  public Monster(String name, double hp, double attack, double xpReward, double goldReward) {
    this.name = name;
    this.hp = hp;
    this.attack = attack;
    this.xpReward = xpReward;
    this.goldReward = goldReward;
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
    return attack;
  }

  public double getXpReward() {
    return xpReward;
  }

  public double getGoldReward() {
    return goldReward;
  }

  // functions
  @Override
  public boolean isAlive() {
    return hp > 0;
  }

  @Override
  public String toString() {
    return name + " (HP: " + hp + ", Attaque: " + attack + ")";
  }
}
