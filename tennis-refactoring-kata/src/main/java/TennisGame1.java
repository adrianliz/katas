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
    return getSetInProgressScore();
  }

  private String getSetInProgressScore() {
    final StringBuilder score = new StringBuilder();
    int tempScore;
    for (int i = 1; i < 3; i++) {
      if (i == 1) {
        tempScore = player1Score;
      } else {
        score.append("-");
        tempScore = player2Score;
      }
      switch (tempScore) {
        case 0 -> score.append("Love");
        case 1 -> score.append("Fifteen");
        case 2 -> score.append("Thirty");
        case 3 -> score.append("Forty");
      }
    }
    return score.toString();
  }

  private String getCurrentWinnerScore() {
    int minusResult = player1Score - player2Score;
    if (minusResult == 1) {
      return "Advantage player1";
    }
    if (minusResult == -1) {
      return "Advantage player2";
    }
    if (minusResult >= 2) {
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
