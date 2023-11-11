package com.adrianliz;

import java.util.ArrayList;
import java.util.List;

public final class Board {
  private final List<Position> positionsWithX = new ArrayList<>();
  private final List<Position> positionsWithO = new ArrayList<>();
  private String playerWithTurn = "X";

  public void play(Position position) {
    if (playerWithTurn.equals("X")) {
      positionsWithX.add(position);
      playerWithTurn = "O";
      return;
    }
    positionsWithO.add(position);
    playerWithTurn = "X";
  }

  private boolean xHasWon() {
    return positionsWithX.stream().allMatch(p -> p.x() == 0)
        || positionsWithX.stream().allMatch(p -> p.x() == 1)
        || positionsWithX.stream().allMatch(p -> p.x() == 2)
        || positionsWithX.stream().allMatch(p -> p.y() == 0)
        || positionsWithX.stream().allMatch(p -> p.y() == 1)
        || positionsWithX.stream().allMatch(p -> p.y() == 2)
        || positionsWithX.stream().allMatch(p -> p.x() == p.y())
        || positionsWithX.stream().allMatch(p -> p.x() + p.y() == 2);
  }

  private boolean oHasWon() {
    return positionsWithO.stream().allMatch(p -> p.x() == 0)
        || positionsWithO.stream().allMatch(p -> p.x() == 1)
        || positionsWithO.stream().allMatch(p -> p.x() == 2)
        || positionsWithO.stream().allMatch(p -> p.y() == 0)
        || positionsWithO.stream().allMatch(p -> p.y() == 1)
        || positionsWithO.stream().allMatch(p -> p.y() == 2)
        || positionsWithO.stream().allMatch(p -> p.x() == p.y())
        || positionsWithO.stream().allMatch(p -> p.x() + p.y() == 2);
  }

  public String getWinner() {
    if (playerWithTurn.equals("O")) {
      return xHasWon() ? "X" : "Tie";
    }
    return oHasWon() ? "O" : "Tie";
  }
}
