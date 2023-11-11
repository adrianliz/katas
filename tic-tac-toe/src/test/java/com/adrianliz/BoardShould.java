package com.adrianliz;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public final class BoardShould {

  @Test
  public void return_x_as_winner_when_has_a_line() {
    final Board board = new Board();

    board.play(0, 0);
    board.play(1, 0);
    board.play(0, 1);
    board.play(1, 1);
    board.play(0, 2);

    assertThat(board.getWinner()).isEqualTo("X");
  }
}
