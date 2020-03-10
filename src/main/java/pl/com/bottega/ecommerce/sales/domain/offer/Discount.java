package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Discount {

    private Money value;

    private String cause;

    public Discount(BigDecimal value, String cause) {
        this.value = new Money(value, "");
        this.cause = cause;
    }

    public BigDecimal getValue() {
        return value.getValue();
    }

    public void setValue(BigDecimal value) {
        this.value.setValue(value);
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }
}
