package com.adrianliz;

public class Cells {
  private final Positions positionsWithX = new Positions();
  private final Positions positionsWithO = new Positions();

  public void put(Player player, Position position) {
    if (positionsWithX.contains(position) || positionsWithO.contains(position)) {
      return;
    }
    if (player.equals(Player.X)) {
      positionsWithX.add(position);
      return;
    }
    positionsWithO.add(position);
  }

  public boolean playerHasThreeInLine(Player player) {
    return player.equals(Player.X)
        ? positionsWithX.isThreeInLine()
        : positionsWithO.isThreeInLine();
  }
}
