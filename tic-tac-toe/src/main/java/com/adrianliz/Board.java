package com.adrianliz;

public final class Board {
  private final Cells cells = new Cells();
  private String playerWithTurn = "X";

  public void play(Position position) {
    if (playerWithTurn.equals("X")) {
      cells.put("X", position);
      playerWithTurn = "O";
      return;
    }
    cells.put("O", position);
    playerWithTurn = "X";
  }

  public String getWinner() {
    if (playerWithTurn.equals("O")) {
      return cells.playerHasLine("X") ? "X" : "Tie";
    }
    return cells.playerHasLine("O") ? "O" : "Tie";
  }
}
