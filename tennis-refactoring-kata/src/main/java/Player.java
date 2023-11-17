public final class Player {
  private final String name;
  private int score;

  public Player(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void incrementScore() {
    score++;
  }

  public int getScore() {
    return score;
  }

  public boolean hasWon(final Player opponent) {
    return score >= 4 && (score - opponent.getScore()) >= 2;
  }

  public boolean hasAdvantage(final Player opponent) {
    return score >= 4 && (score - opponent.getScore()) == 1;
  }

  public boolean hasSameScore(Player opponent) {
    return score == opponent.getScore();
  }
}
