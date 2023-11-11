package com.adrianliz;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public final class BoardShould {

  @Test
  public void return_x_as_winner_when_has_a_line() {
    final Board board = new Board();

    board.play(new Position(0, 0));
    board.play(new Position(1, 0));
    board.play(new Position(0, 1));
    board.play(new Position(1, 1));
    board.play(new Position(0, 2));

    assertThat(board.getWinner()).isEqualTo("X");
  }

  @Test
  public void return_o_as_winner_when_has_a_line() {
    final Board board = new Board();

    board.play(new Position(0, 0));
    board.play(new Position(1, 0));
    board.play(new Position(0, 1));
    board.play(new Position(1, 1));
    board.play(new Position(2, 2));
    board.play(new Position(1, 2));

    assertThat(board.getWinner()).isEqualTo("O");
  }
}
