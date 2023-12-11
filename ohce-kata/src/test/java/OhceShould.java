import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

public final class OhceShould {

  @ParameterizedTest(name = "greet with good nights when clock is between 20 and 6")
  @CsvSource({"20", "21", "22", "23", "0", "1", "2", "3", "4", "5"})
  public void greets_with_good_nights_when_clock_is_between_20_and_6(int hour) {
    final Clock clock = Mockito.mock(Clock.class);
    Mockito.when(clock.getHour()).thenReturn(hour);
    final Console console = Mockito.spy(Console.class);

    new Ohce("Pedro", clock, console);

    Mockito.verify(console).print("¡Buenas noches Pedro!");
  }

  @ParameterizedTest(name = "greet with good days when clock is between 6 and 12")
  @CsvSource({"6", "7", "8", "9", "10", "11"})
  public void greets_with_good_days_when_clock_is_between_6_and_12(int hour) {
    final Clock clock = Mockito.mock(Clock.class);
    Mockito.when(clock.getHour()).thenReturn(hour);
    final Console console = Mockito.spy(Console.class);

    new Ohce("Pedro", clock, console);

    Mockito.verify(console).print("¡Buenos días Pedro!");
  }

  @ParameterizedTest(name = "greet with good afternoons when clock is between 12 and 20")
  @CsvSource({"12", "13", "14", "15", "16", "17", "18", "19"})
  public void greets_with_good_afternoons_when_clock_is_between_12_and_20(int hour) {
    final Clock clock = Mockito.mock(Clock.class);
    Mockito.when(clock.getHour()).thenReturn(hour);
    final Console console = Mockito.spy(Console.class);

    new Ohce("Pedro", clock, console);

    Mockito.verify(console).print("¡Buenas tardes Pedro!");
  }
}
