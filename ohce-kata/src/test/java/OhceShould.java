import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public final class OhceShould {

  @Test
  public void greets_with_good_nights_when_clock_is_between_20_and_6() {
    final Clock clock = Mockito.mock(Clock.class);
    Mockito.when(clock.getHour()).thenReturn(21);
    final Console console = Mockito.spy(Console.class);
    final Ohce ohce = new Ohce(clock, console);

    ohce.greet("Pedro");

    Mockito.verify(console).print("¡Buenas noches Pedro!");
  }

  @Test
  public void greets_with_good_days_when_clock_is_between_6_and_12() {
    final Clock clock = Mockito.mock(Clock.class);
    Mockito.when(clock.getHour()).thenReturn(7);
    final Console console = Mockito.spy(Console.class);
    final Ohce ohce = new Ohce(clock, console);

    ohce.greet("Pedro");

    Mockito.verify(console).print("¡Buenos días Pedro!");
  }

  @Test
  public void greets_with_good_afternoons_when_clock_is_between_12_and_20() {
    final Clock clock = Mockito.mock(Clock.class);
    Mockito.when(clock.getHour()).thenReturn(15);
    final Console console = Mockito.spy(Console.class);
    final Ohce ohce = new Ohce(clock, console);

    ohce.greet("Pedro");

    Mockito.verify(console).print("¡Buenas tardes Pedro!");
  }
}
