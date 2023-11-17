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
    if (player1HasWon()) {
      return "Win for player1";
    }
    if (player2HasWon()) {
      return "Win for player2";
    }
    if (player1HasAdvantage()) {
      return "Advantage player1";
    }
    if (player2HasAdvantage()) {
      return "Advantage player2";
    }
    if (server.getScore() == receiver.getScore()) {
      return formatEqualScore();
    }
    return formatPlayerScore(server.getScore()) + "-" + formatPlayerScore(receiver.getScore());
  }

  private boolean player1HasWon() {
    return server.getScore() >= 4 && (server.getScore() - receiver.getScore()) >= 2;
  }

  private boolean player2HasWon() {
    return receiver.getScore() >= 4 && (receiver.getScore() - server.getScore()) >= 2;
  }

  private boolean player1HasAdvantage() {
    return server.getScore() >= 4 && (server.getScore() - receiver.getScore()) == 1;
  }

  private boolean player2HasAdvantage() {
    return receiver.getScore() >= 4 && (receiver.getScore() - server.getScore()) == 1;
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
