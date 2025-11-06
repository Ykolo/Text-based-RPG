package rpg;

import rpg.game.Game;
import rpg.game.WeaponStore;

public class Main {
  public static void main(String[] args) {
    WeaponStore weaponStore = new WeaponStore();
    weaponStore.getStock();
    Game game = new Game();
    game.start();
  }
}
