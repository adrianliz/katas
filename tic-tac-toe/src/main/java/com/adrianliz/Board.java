package com.adrianliz;

public final class Board {
  private final Cells cells = new Cells();
  private Player playerWithTurn = Player.X;

  public void play(Position position) {
    if (playerWithTurn.equals(Player.X)) {
      cells.put(Player.X, position);
      playerWithTurn = Player.O;
      return;
    }
    cells.put(Player.O, position);
    playerWithTurn = Player.X;
  }

  public String getWinner() {
    if (playerWithTurn.equals(Player.O)) {
      return cells.playerHasLine(Player.X) ? "X" : "Tie";
    }
    return cells.playerHasLine(Player.O) ? "O" : "Tie";
  }
}
