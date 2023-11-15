package hole4;

public class Money {
  final Integer value;
  final String currency;

  public Money(Integer value, String currency) {
    this.value = value;
    this.currency = currency;
  }

  public static Money money(Integer value, String currency) {
    return new Money(value, currency);
  }

  Money plus(Money other) {
    if (!other.currency.equals(currency)) {
      throw new Incalculable();
    }
    return money(value + other.value, other.currency);
  }

  Money minus(Money other) {
    if (!this.currency.equals(other.currency)) {
      throw new Incalculable();
    }
    return money(this.value - other.value, other.currency);
  }
}
