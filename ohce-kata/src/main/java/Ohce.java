public final class Ohce {

  private final Clock clock;
  private final Console console;

  public Ohce(final Clock clock, final Console console) {
    this.clock = clock;
    this.console = console;
  }

  public void echo(final String name) {
    final String message = String.format("¡Buenas noches %s!", name);
    console.print(message);
  }
}
