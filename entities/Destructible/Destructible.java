package rpg.entities.Destructible;

public interface Destructible {

  String getName();

  double getHp();

  void setHp(double hp);

  double getAttack();

  boolean isAlive();
}