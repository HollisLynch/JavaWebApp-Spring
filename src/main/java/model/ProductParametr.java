package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product_parametr")
public class ProductParametr implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "parameter_id", nullable = false)
    private Parametr parameter;

    @Column(name = "value")
    private String value;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Parametr getParameter() {
        return parameter;
    }

    public void setParameter(Parametr parameter) {
        this.parameter = parameter;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
