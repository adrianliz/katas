package com.adrianliz;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public final class BoardShould {

  private static Stream<Arguments> movementsWithoutGameEnded() {
    /*
     *  X | X | -
     *  O | O | -
     *  X | - | -
     */

    /*
     *  O | O | -
     *  X | X | -
     *  O | X | -
     */
    return Stream.of(
        Arguments.of(
            List.of(
                new Position(0, 0),
                new Position(1, 0),
                new Position(0, 1),
                new Position(1, 1),
                new Position(2, 0))),
        Arguments.of(
            List.of(
                new Position(1, 0),
                new Position(0, 0),
                new Position(1, 1),
                new Position(0, 1),
                new Position(2, 1),
                new Position(2, 0))));
  }

  private static Stream<Arguments> repeatedMovements() {
    /*
     *  X | X | -
     *  O | O | -
     *  (X) | - | -
     */

    /*
     *  O | O | -
     *  X | X | -
     *  (O) | X | -
     */
    return Stream.of(
        Arguments.of(
            // Repeated position on 2, 0 for O
            List.of(
                new Position(0, 0),
                new Position(1, 0),
                new Position(0, 1),
                new Position(1, 1),
                new Position(2, 0),
                new Position(2, 0))),
        Arguments.of(
            // Repeated position on 2, 0 for X
            List.of(
                new Position(1, 0),
                new Position(0, 0),
                new Position(1, 1),
                new Position(0, 1),
                new Position(2, 1),
                new Position(2, 0),
                new Position(2, 0))));
  }

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

    assertThat(board.getWinner()).hasValue(Player.X);
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

    assertThat(board.getWinner()).hasValue(Player.O);
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

    assertThat(board.getWinner()).isNotPresent();
  }

  @ParameterizedTest
  @MethodSource("movementsWithoutGameEnded")
  public void return_tie_when_game_continues(final List<Position> movements) {
    final Board board = new Board();

    movements.forEach(board::play);

    assertThat(board.getWinner()).isNotPresent();
  }

  @ParameterizedTest
  @MethodSource("repeatedMovements")
  public void does_not_allow_to_play_in_a_played_position(final List<Position> movements) {
    final Board board = new Board();

    movements.forEach(board::play);

    assertThat(board.getWinner()).isNotPresent();
  }
}
