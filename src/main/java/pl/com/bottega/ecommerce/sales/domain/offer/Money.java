package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
    BigDecimal value;
    String currency;

    public Money(BigDecimal value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }
     public int compareTo(Money money){
        return money.getValue().compareTo(this.value);
     }

     public Money subtract(Money money){
        value = value.subtract(money.getValue());
        return  new Money(value, currency);
     }


    @Override
    public int hashCode() {
        return Objects.hash(value, currency);
    }

    @Override
    public boolean equals(Object obj) {
        Money other = (Money) obj;
        return Objects.equals(value, other.value)
                && Objects.equals(currency, other.currency);
    }


}
