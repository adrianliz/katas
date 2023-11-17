public final class Player {
  private final String name;
  private int score;

  public Player(String name) {
    this.name = name;
  }

  public int getScore() {
    return score;
  }

  public boolean is(final String name) {
    return this.name.equals(name);
  }

  public void incrementScore() {
    score++;
  }

  public boolean hasWon(final Player opponent) {
    return score >= 4 && (score - opponent.score) >= 2;
  }

  public boolean hasAdvantage(final Player opponent) {
    return score >= 4 && (score - opponent.score) == 1;
  }

  public boolean isInDeuce(final Player opponent) {
    return score >= 3 && opponent.score >= 3;
  }

  public boolean hasSameScore(Player opponent) {
    return score == opponent.score;
  }
}
