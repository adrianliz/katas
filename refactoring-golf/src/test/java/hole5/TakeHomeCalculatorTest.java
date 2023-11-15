package hole5;

import static hole5.Money.money;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TakeHomeCalculatorTest {

  @Test
  public void canCalculateTax() throws Exception {
    Integer first =
        new TakeHomeCalculator(10)
            .netAmount(money(40, "GBP"), money(50, "GBP"), money(60, "GBP"))
            .value;
    assertEquals(135, first.intValue());
  }

  @Test
  public void cannotSumDifferentCurrencies() throws Exception {
    assertThrows(
        Incalculable.class,
        () ->
            new TakeHomeCalculator(10)
                .netAmount(money(4, "GBP"), money(5, "USD"), money(6, "GBP")));
  }
}
