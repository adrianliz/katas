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

  private boolean playerHasWon(List<Position> positions) {
    return positions.stream().allMatch(p -> p.x() == 0)
        || positions.stream().allMatch(p -> p.x() == 1)
        || positions.stream().allMatch(p -> p.x() == 2)
        || positions.stream().allMatch(p -> p.y() == 0)
        || positions.stream().allMatch(p -> p.y() == 1)
        || positions.stream().allMatch(p -> p.y() == 2)
        || positions.stream().allMatch(p -> p.x() == p.y())
        || positions.stream().allMatch(p -> p.x() + p.y() == 2);
  }

  public String getWinner() {
    if (playerWithTurn.equals("O")) {
      return playerHasWon(positionsWithX) ? "X" : "Tie";
    }
    return playerHasWon(positionsWithO) ? "O" : "Tie";
  }
}
