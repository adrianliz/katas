package hole7;

import static hole7.Money.money;
import static hole7.TaxRate.taxRate;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TakeHomeCalculatorTest {

  @Test
  public void canCalculateTax() throws Exception {
    Integer first =
        new TakeHomeCalculator(taxRate(10))
            .netAmount(money(40, "GBP"), money(50, "GBP"), money(60, "GBP"))
            .value;
    assertEquals(135, first.intValue());
  }

  @Test
  public void cannotSumDifferentCurrencies() throws Exception {
    Assertions.assertThrows(
        Incalculable.class,
        () ->
            new TakeHomeCalculator(taxRate(10))
                .netAmount(money(4, "GBP"), money(5, "USD"), money(6, "GBP")));
  }
}
