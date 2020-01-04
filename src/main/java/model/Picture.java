package model;

import javax.persistence.*;

@Entity
@Table(name = "photo")
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "link")
    private Long link;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getLink() {
        return link;
    }

    public void setLink(Long link) {
        this.link = link;
    }
}
