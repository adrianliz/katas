public final class Ohce {
  private final String userName;
  private final Clock clock;
  private final Console console;

  public Ohce(final String userName, final Clock clock, final Console console) {
    this.userName = userName;
    this.clock = clock;
    this.console = console;
    greet();
  }

  private void greet() {
    final int hour = clock.getHour();
    if (hour >= 6 && hour < 12) {
      greetWithGoodDays(userName);
      return;
    }
    if (hour >= 12 && hour < 20) {
      greetWithGoodAfternoons(userName);
      return;
    }
    greetWithGoodNights(userName);
  }

  private void greetWithGoodAfternoons(String name) {
    final String message = String.format("¡Buenas tardes %s!", name);
    console.print(message);
  }

  private void greetWithGoodNights(String name) {
    final String message = String.format("¡Buenas noches %s!", name);
    console.print(message);
  }

  private void greetWithGoodDays(String name) {
    final String message = String.format("¡Buenos días %s!", name);
    console.print(message);
  }

  public void echo(String word) {
    final String stopWord = "Stop!";
    if (word.contentEquals(stopWord)) {
      console.print(stopWord);
      return;
    }
    final String reversedWord = new StringBuilder(word).reverse().toString();
    console.print(reversedWord);
    if (isPalindromic(word)) {
      console.print("¡Bonita palabra!");
    }
  }

  private boolean isPalindromic(String word) {
    return word.contentEquals(new StringBuilder(word).reverse());
  }
}
