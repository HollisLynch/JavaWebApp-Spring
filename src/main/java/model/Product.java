package model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    private String title;

    private String description;

    @OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true)
    //   @JoinColumn(name = "product_id", nullable = false)
    @OrderColumn(name = "order")
    private List<Picture> pictures;


    //  @OrderBy("parameter.name")
    //  @JoinColumn(name = "product_id", nullable = false)
    @OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true, mappedBy = "product")
    private List<ProductParametr> parameters;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "owner_id")
    private Long owner_id;

    public Product() {

    }

    public Product(Category category, String title, String description, List<Picture> pictures, List<ProductParametr> parameters, BigDecimal price, Long owner_id) {
        this.category = category;
        this.title = title;
        this.description = description;
        this.pictures = pictures;
        this.parameters = parameters;
        this.price = price;
        this.owner_id = owner_id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public List<ProductParametr> getParameters() {
        return parameters;
    }

    public void setParameters(List<ProductParametr> parameters) {
        this.parameters = parameters;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public Long getOwner_id() {
        return owner_id;
    }
}
