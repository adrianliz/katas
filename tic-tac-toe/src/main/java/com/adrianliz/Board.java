package com.adrianliz;

import java.util.Optional;

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

  public Optional<Player> getWinner() {
    if (playerWithTurn.equals(Player.O)) {
      return cells.playerHasThreeInLine(Player.X) ? Optional.of(Player.X) : Optional.empty();
    }
    return cells.playerHasThreeInLine(Player.O) ? Optional.of(Player.O) : Optional.empty();
  }
}
