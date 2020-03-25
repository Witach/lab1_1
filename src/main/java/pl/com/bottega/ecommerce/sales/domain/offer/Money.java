package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {

    BigDecimal amount;
    String currency;

    public Money(int amount, String currency) {
        this(BigDecimal.valueOf(amount), currency);
    }

    public Money(BigDecimal amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public Money add(BigDecimal value) {
        amount = amount.add(value);
        return this;
    }

    public Money multiply(BigDecimal number) {
        amount = amount.multiply(number);
        return this;
    }

    public Money subtract(BigDecimal value) {
        amount = amount.add(value);
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        Money other = (Money) obj;
        return Objects.equals(amount, other.amount)
                && Objects.equals(currency, other.currency);
    }
}
