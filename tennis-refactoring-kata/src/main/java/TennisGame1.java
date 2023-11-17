public class TennisGame1 implements TennisGame {

  private int serverScore = 0;
  private int receiverScore = 0;
  private Player server;
  private Player receiver;

  public TennisGame1(String serverName, String receiverName) {
    this.server = new Player(serverName);
    this.receiver = new Player(receiverName);
  }

  public void wonPoint(String playerName) {
    if (server.getName().equals(playerName)) {
      serverScore += 1;
      return;
    }
    receiverScore += 1;
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
    if (serverScore == receiverScore) {
      return formatEqualScore();
    }
    return formatPlayerScore(serverScore) + "-" + formatPlayerScore(receiverScore);
  }

  private boolean player1HasWon() {
    return serverScore >= 4 && (serverScore - receiverScore) >= 2;
  }

  private boolean player2HasWon() {
    return receiverScore >= 4 && (receiverScore - serverScore) >= 2;
  }

  private boolean player1HasAdvantage() {
    return serverScore >= 4 && (serverScore - receiverScore) == 1;
  }

  private boolean player2HasAdvantage() {
    return receiverScore >= 4 && (receiverScore - serverScore) == 1;
  }

  private String formatEqualScore() {
    return switch (serverScore) {
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
