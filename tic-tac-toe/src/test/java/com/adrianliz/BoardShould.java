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

    /*
     *  X | X | X
     *  O | O | -
     *  - | - | -
     */

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

    /*
     *  X | X | -
     *  O | O | O
     *  - | - | X
     */

    assertThat(board.getWinner()).isEqualTo("O");
  }

  @Test
  public void return_tie_when_there_is_not_a_winner() {
    final Board board = new Board();

    board.play(new Position(0, 0));
    board.play(new Position(1, 0));
    board.play(new Position(0, 1));
    board.play(new Position(1, 1));
    board.play(new Position(2, 0));
    board.play(new Position(2, 2));
    board.play(new Position(2, 1));
    board.play(new Position(0, 2));
    board.play(new Position(1, 2));

    /*
     *  X | X | O
     *  O | O | X
     *  X | X | O
     */

    assertThat(board.getWinner()).isEqualTo("Tie");
  }
}
