package rpg.game;

import rpg.entities.Destructible.Monster;
import rpg.entities.Destructible.Obstacle;

public class Map {
  private char[][] grid;
  private int width;
  private int height;
  private int playerX;
  private int playerY;
  private int exitX;
  private int exitY;

  // Constructor
  public Map(int width, int height) {
    this.width = width;
    this.height = height;
    this.grid = new char[height][width];
    this.playerX = 0;
    this.playerY = 0;
    this.exitX = width - 1;
    this.exitY = height - 1;
    initializeMap();
  }

  // functions
  private void initializeMap() {
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        grid[i][j] = '.';
      }
    }

    // Ne pas mettre de P fixe, le joueur sera affiché dynamiquement

    grid[exitY][exitX] = 'S';

    placeRandomEntities('M', 3);

    placeRandomEntities('O', 3);
  }

  private void placeRandomEntities(char entity, int count) {
    int placed = 0;
    while (placed < count) {
      int x = (int) (Math.random() * width);
      int y = (int) (Math.random() * height);

      if (grid[y][x] == '.' && !(x == 0 && y == 0) && !(x == exitX && y == exitY)) {
        grid[y][x] = entity;
        placed++;
      }
    }
  }

  public void display() {
    System.out.println("\n=== CARTE DU DONJON ===");
    System.out.println();
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        if (j == playerX && i == playerY) {
          System.out.print("[P] ");
        } else {
          System.out.print("[" + grid[i][j] + "] ");
        }
      }
      System.out.println();
    }
    System.out.println("\nLégende:");
    System.out.println("P = Joueur | S = Sortie | M = Monstre | O = Obstacle | . = Vide");
    System.out.println();
  }

  public boolean movePlayer(String direction) {
    int newX = playerX;
    int newY = playerY;

    switch (direction.toLowerCase()) {
      case "haut":
      case "z":
        newY--;
        break;
      case "bas":
      case "s":
        newY++;
        break;
      case "gauche":
      case "q":
        newX--;
        break;
      case "droite":
      case "d":
        newX++;
        break;
      default:
        System.out.println("Direction invalide!");
        return false;
    }

    if (newX < 0 || newX >= width || newY < 0 || newY >= height) {
      System.out.println("Vous ne pouvez pas aller dans cette direction (mur)!");
      return false;
    }

    // Mettre à jour la position
    playerX = newX;
    playerY = newY;

    return true;
  }

  public char getCurrentCell() {
    return grid[playerY][playerX];
  }

  public void clearCurrentCell() {
    grid[playerY][playerX] = '.';
  }

  public boolean isAtExit() {
    return playerX == exitX && playerY == exitY;
  }

  public Monster createMonster() {
    String[] monsterNames = { "Gobelin", "Orc", "Squelette", "Loup-garou" };
    String name = monsterNames[(int) (Math.random() * monsterNames.length)];
    double hp = 40 + (Math.random() * 40);
    double attack = 10 + (Math.random() * 15);
    double xpReward = 30 + (Math.random() * 40);
    double goldReward = 15 + (Math.random() * 35);
    return new Monster(name, hp, attack, xpReward, goldReward);
  }

  public Obstacle createObstacle() {
    String[] obstacleNames = { "Mur de pierre", "Porte verrouillée", "Rocher", "Barricade" };
    String name = obstacleNames[(int) (Math.random() * obstacleNames.length)];
    double hp = 30 + (Math.random() * 30);
    return new Obstacle(name, hp);
  }

  // Getters
  public int getPlayerX() {
    return playerX;
  }

  public int getPlayerY() {
    return playerY;
  }
}
