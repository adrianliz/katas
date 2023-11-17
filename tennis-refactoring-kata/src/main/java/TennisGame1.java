import java.util.Optional;

public class TennisGame1 implements TennisGame {
  private Player server;
  private Player receiver;

  public TennisGame1(String serverName, String receiverName) {
    this.server = new Player(serverName);
    this.receiver = new Player(receiverName);
  }

  public void wonPoint(String playerName) {
    if (server.is(playerName)) {
      server.incrementScore();
      return;
    }
    receiver.incrementScore();
  }

  public String getScore() {
    return new ServerWonScore()
        .calculate(server, receiver)
        .or(() -> new ReceiverWonScore().calculate(server, receiver))
        .or(() -> new ServerAdvantageScore().calculate(server, receiver))
        .or(() -> new ReceiverAdvantageScore().calculate(server, receiver))
        .or(() -> new DeuceScore().calculate(server, receiver))
        .or(() -> new EqualScore().calculate(server, receiver))
        .or(() -> new RegularScore().calculate(server, receiver))
        .orElseThrow(() -> new IllegalStateException("Invalid score."));
  }

  private interface Score {
    Optional<String> calculate(final Player server, final Player receiver);
  }

  private static class ServerWonScore implements Score {
    @Override
    public Optional<String> calculate(final Player server, final Player receiver) {
      return server.hasWon(receiver) ? Optional.of("Win for player1") : Optional.empty();
    }
  }

  private static class ReceiverWonScore implements Score {
    @Override
    public Optional<String> calculate(final Player server, final Player receiver) {
      return receiver.hasWon(server) ? Optional.of("Win for player2") : Optional.empty();
    }
  }

  private static class ServerAdvantageScore implements Score {
    @Override
    public Optional<String> calculate(final Player server, final Player receiver) {
      return server.hasAdvantage(receiver) ? Optional.of("Advantage player1") : Optional.empty();
    }
  }

  private static class ReceiverAdvantageScore implements Score {
    @Override
    public Optional<String> calculate(final Player server, final Player receiver) {
      return receiver.hasAdvantage(server) ? Optional.of("Advantage player2") : Optional.empty();
    }
  }

  private static class DeuceScore implements Score {
    @Override
    public Optional<String> calculate(final Player server, final Player receiver) {
      return server.isInDeuce(receiver) ? Optional.of("Deuce") : Optional.empty();
    }
  }

  private static class EqualScore implements Score {
    @Override
    public Optional<String> calculate(Player server, Player receiver) {
      return server.hasSameScore(receiver)
          ? Optional.of(
              switch (server.getScore()) {
                case 0 -> "Love-All";
                case 1 -> "Fifteen-All";
                case 2 -> "Thirty-All";
                default -> "Deuce";
              })
          : Optional.empty();
    }
  }

  private static class RegularScore implements Score {
    @Override
    public Optional<String> calculate(Player server, Player receiver) {
      return Optional.of(
          formatPlayerScore(server.getScore()) + "-" + formatPlayerScore(receiver.getScore()));
    }

    private String formatPlayerScore(int playerScore) {
      return switch (playerScore) {
        case 0 -> "Love";
        case 1 -> "Fifteen";
        case 2 -> "Thirty";
        case 3 -> "Forty";
        default -> throw new IllegalArgumentException("Invalid player score.");
      };
    }
  }
}
