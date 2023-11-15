package hole2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import hole2.TakeHomeCalculator.Money;
import org.junit.jupiter.api.Test;

public class TakeHomeCalculatorTest {

  @Test
  public void canCalculateTax() throws Exception {
    Integer first =
        new TakeHomeCalculator(10)
            .netAmount(new Money(40, "GBP"), new Money(50, "GBP"), new Money(60, "GBP"))
            .value;
    assertEquals(135, first.intValue());
  }

  @Test
  public void cannotSumDifferentCurrencies() throws Exception {
    assertThrows(
        Incalculable.class,
        () ->
            new TakeHomeCalculator(10)
                .netAmount(new Money(40, "GBP"), new Money(50, "USD"), new Money(60, "GBP")));
  }
}
