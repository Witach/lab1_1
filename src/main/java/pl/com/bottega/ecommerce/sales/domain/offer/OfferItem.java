/*
 * Copyright 2011-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class OfferItem {

    // product

    private Product product;

    private int quantity;

    private Money totalCost;

    private Discount discount;

    public OfferItem(String productId, BigDecimal productPrice, String productName, Date productSnapshotDate, String productType,
                     int quantity) {
        this(productId, productPrice, productName, productSnapshotDate, productType, quantity, null, null);
    }

    public OfferItem(String productId, BigDecimal productPrice, String productName, Date productSnapshotDate, String productType,
                     int quantity, BigDecimal discount, String discountCause) {

        product = new Product(productId, productPrice, productName, productSnapshotDate, productType);

        this.quantity = quantity;
        this.discount = new Discount(discount, discountCause);

        BigDecimal discountValue = new BigDecimal(0);
        if (discount != null) {
            discountValue = discountValue.add(discount);
        }

        BigDecimal val = productPrice.multiply(new BigDecimal(quantity))
                .subtract(discountValue);
        this.totalCost = new Money(val, "");
    }

    public String getProductId() {
        return product.getId();
    }

    public BigDecimal getProductPrice() {
        return product.getPrice();
    }

    public String getProductName() {
        return product.getName();
    }

    public Date getProductSnapshotDate() {
        return product.getSnapshotDate();
    }

    public String getProductType() {
        return product.getType();
    }

    public BigDecimal getTotalCost() {
        return totalCost.getValue();
    }

    public String getTotalCostCurrency() {
        return totalCost.getCurrency();
    }

    public BigDecimal getDiscount() {
        return discount.getValue();
    }

    public String getDiscountCause() {
        return discount.getCause();
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalCost, discount, product, quantity);
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
        OfferItem other = (OfferItem) obj;
        return Objects.equals(totalCost, other.totalCost)
                && Objects.equals(discount, other.discount)
                && Objects.equals(product, other.product)
                && quantity == other.quantity;
    }

    /**
     * @param other
     * @param delta acceptable percentage difference
     * @return
     */
    public boolean sameAs(OfferItem other, double delta) {
        if (product.getPrice() == null) {
            if (other.getProductPrice() != null) {
                return false;
            }
        } else if (!product.getPrice().equals(other.getProductPrice())) {
            return false;
        }
        if (product.getName() == null) {
            if (other.getProductName() != null) {
                return false;
            }
        } else if (!getProductName().equals(other.getProductName())) {
            return false;
        }

        if (getProductId() == null) {
            if (other.getProductId() != null) {
                return false;
            }
        } else if (!getProductId().equals(other.getProductId())) {
            return false;
        }
        if (getProductType() == null) {
            if (other.getProductType() != null) {
                return false;
            }
        } else if (!getProductType().equals(other.getProductType())) {
            return false;
        }

        if (quantity != other.quantity) {
            return false;
        }

        BigDecimal max;
        BigDecimal min;
        if (totalCost.compareTo(other.totalCost) > 0) {
            max = getTotalCost();
            min = other.getTotalCost();
        } else {
            max = getTotalCost();
            min = other.getTotalCost();
        }

        BigDecimal difference = max.subtract(min);
        BigDecimal acceptableDelta = max.multiply(BigDecimal.valueOf(delta / 100));

        return acceptableDelta.compareTo(difference) > 0;
    }

}
