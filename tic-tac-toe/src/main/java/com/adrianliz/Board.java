package com.adrianliz;

public final class Board {

  private String playerWithTurn = "X";
  private int numberOfX = 0;
  private int numberOfO = 0;

  public void play(int x, int y) {
    if (playerWithTurn.equals("X")) {
      numberOfX++;
      playerWithTurn = "O";
    } else {
      numberOfO++;
      playerWithTurn = "X";
    }
  }

  public String getWinner() {
    if (playerWithTurn.equals("O")) {
      return numberOfX == 3 ? "X" : null;
    } else {
      return numberOfO == 3 ? "O" : null;
    }
  }
}
