package hole6;

class TakeHomeCalculator {

  private final TaxRate taxRate;

  TakeHomeCalculator(TaxRate taxRate) {
    this.taxRate = taxRate;
  }

  Money netAmount(Money first, Money... rest) {

    Money total = first;
    for (Money next : rest) {
      total = total.plus(next);
    }

    Money tax = taxRate.apply(total);
    return total.minus(tax);
  }
}
