public class TennisGame1 implements TennisGame {
  private Player server;
  private Player receiver;

  public TennisGame1(String serverName, String receiverName) {
    this.server = new Player(serverName);
    this.receiver = new Player(receiverName);
  }

  public void wonPoint(String playerName) {
    if (server.getName().equals(playerName)) {
      server.incrementScore();
      return;
    }
    receiver.incrementScore();
  }

  public String getScore() {
    if (server.hasWon(receiver)) {
      return "Win for player1";
    }
    if (receiver.hasWon(server)) {
      return "Win for player2";
    }
    if (server.hasAdvantage(receiver)) {
      return "Advantage player1";
    }
    if (receiver.hasAdvantage(server)) {
      return "Advantage player2";
    }
    if (server.hasSameScore(receiver)) {
      return formatEqualScore();
    }
    return formatPlayerScore(server.getScore()) + "-" + formatPlayerScore(receiver.getScore());
  }

  private String formatEqualScore() {
    return switch (server.getScore()) {
      case 0 -> "Love-All";
      case 1 -> "Fifteen-All";
      case 2 -> "Thirty-All";
      default -> "Deuce";
    };
  }

  private String formatPlayerScore(int playerScore) {
    return switch (playerScore) {
      case 0 -> "Love";
      case 1 -> "Fifteen";
      case 2 -> "Thirty";
      case 3 -> "Forty";
      default -> "";
    };
  }
}
