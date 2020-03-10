package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

public class Product {

    private String id;

    private BigDecimal price;

    private String name;

    private Date snapshotDate;

    private String type;

    public Product(String productId, BigDecimal productPrice, String productName, Date productSnapshotDate, String productType) {
        this.id = productId;
        this.price = productPrice;
        this.name = productName;
        this.snapshotDate = productSnapshotDate;
        this.type = productType;
    }

    public String getId() {
        return id;
    }

    public void setId(String productId) {
        this.id = productId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getSnapshotDate() {
        return snapshotDate;
    }

    public void setSnapshotDate(Date snapshotDate) {
        this.snapshotDate = snapshotDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
