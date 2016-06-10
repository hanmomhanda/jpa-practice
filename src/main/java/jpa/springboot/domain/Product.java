package jpa.springboot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author omwomw@sk.com
 *         created on 16. 6. 10.
 */
@Entity
@Table(name = "product")
public class Product {

    @Id
    @NotNull
    @Column(name = "product_code")
    private String productCode;

    @NotNull
    @Column(name = "product_name")
    private String productName;

    public Product() {
    }

    public Product(String productCode, String productName) {
        this.productCode = productCode;
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getProductName() {
        return productName;
    }
}
