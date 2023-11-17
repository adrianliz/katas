public class TennisGame1 implements TennisGame {

  private int player1Score = 0;
  private int player2Score = 0;
  private String player1Name;
  private String player2Name;

  public TennisGame1(String player1Name, String player2Name) {
    this.player1Name = player1Name;
    this.player2Name = player2Name;
  }

  public void wonPoint(String playerName) {
    if (player1Name.equals(playerName)) {
      player1Score += 1;
      return;
    }
    player2Score += 1;
  }

  public String getScore() {
    if (player1Score == player2Score) {
      return getEqualScore();
    }
    if (player1Score >= 4 || player2Score >= 4) {
      return getCurrentWinnerScore();
    }
    return formatPlayerScore(player1Score) + "-" + formatPlayerScore(player2Score);
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

  private String getCurrentWinnerScore() {
    int differencePoints = player1Score - player2Score;
    if (differencePoints == 1) {
      return "Advantage player1";
    }
    if (differencePoints == -1) {
      return "Advantage player2";
    }
    if (differencePoints >= 2) {
      return "Win for player1";
    }
    return "Win for player2";
  }

  private String getEqualScore() {
    return switch (player1Score) {
      case 0 -> "Love-All";
      case 1 -> "Fifteen-All";
      case 2 -> "Thirty-All";
      default -> "Deuce";
    };
  }
}
