public final class Ohce {

  private final Clock clock;
  private final Console console;

  public Ohce(final Clock clock, final Console console) {
    this.clock = clock;
    this.console = console;
  }

  public void echo(final String name) {
    final int hour = clock.getHour();
    if (hour >= 6 && hour < 12) {
      greetWithGoodDays(name);
    } else if (hour >= 20 || hour < 6) {
      greetWithGoodNights(name);
    }
    greetWithGoodAfternoons(name);
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
}
