package ru.dronix.entity;
// Generated 16.09.2016 19:06:41 by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TableProducts generated by hbm2java
 */
@Entity
@Table(name="table_products"
    ,catalog="db_shop"
)
public class TableProducts  implements java.io.Serializable {


     private Integer productsId;
     private String title;
     private Integer price;
     private String brand;
     private String seoWorlds;
     private String seoDescription;
     private String miniDescription;
     private String image;
     private String description;
     private String miniFeatures;
     private String features;
     private Date dateTime;
     private Integer new_;
     private Integer leader;
     private Integer sale;
     private Integer visible;
     private Integer count;
     private String typeProduct;
     private Integer brandId;
     private Integer vote;
     private Float votes;

    public TableProducts() {
    }

    public TableProducts(String title, Integer price, String brand, String seoWorlds, String seoDescription, String miniDescription, String image, String description, String miniFeatures, String features, Date dateTime, Integer new_, Integer leader, Integer sale, Integer visible, Integer count, String typeProduct, Integer brandId, Integer vote, Float votes) {
       this.title = title;
       this.price = price;
       this.brand = brand;
       this.seoWorlds = seoWorlds;
       this.seoDescription = seoDescription;
       this.miniDescription = miniDescription;
       this.image = image;
       this.description = description;
       this.miniFeatures = miniFeatures;
       this.features = features;
       this.dateTime = dateTime;
       this.new_ = new_;
       this.leader = leader;
       this.sale = sale;
       this.visible = visible;
       this.count = count;
       this.typeProduct = typeProduct;
       this.brandId = brandId;
       this.vote = vote;
       this.votes = votes;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="products_id", unique=true, nullable=false)
    public Integer getProductsId() {
        return this.productsId;
    }
    
    public void setProductsId(Integer productsId) {
        this.productsId = productsId;
    }

    
    @Column(name="title")
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    
    @Column(name="price")
    public Integer getPrice() {
        return this.price;
    }
    
    public void setPrice(Integer price) {
        this.price = price;
    }

    
    @Column(name="brand")
    public String getBrand() {
        return this.brand;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }

    
    @Column(name="seo_worlds", length=65535)
    public String getSeoWorlds() {
        return this.seoWorlds;
    }
    
    public void setSeoWorlds(String seoWorlds) {
        this.seoWorlds = seoWorlds;
    }

    
    @Column(name="seo_description", length=65535)
    public String getSeoDescription() {
        return this.seoDescription;
    }
    
    public void setSeoDescription(String seoDescription) {
        this.seoDescription = seoDescription;
    }

    
    @Column(name="mini_description", length=65535)
    public String getMiniDescription() {
        return this.miniDescription;
    }
    
    public void setMiniDescription(String miniDescription) {
        this.miniDescription = miniDescription;
    }

    
    @Column(name="image")
    public String getImage() {
        return this.image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }

    
    @Column(name="description", length=65535)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    
    @Column(name="mini_features", length=65535)
    public String getMiniFeatures() {
        return this.miniFeatures;
    }
    
    public void setMiniFeatures(String miniFeatures) {
        this.miniFeatures = miniFeatures;
    }

    
    @Column(name="features", length=65535)
    public String getFeatures() {
        return this.features;
    }
    
    public void setFeatures(String features) {
        this.features = features;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date_time", length=19)
    public Date getDateTime() {
        return this.dateTime;
    }
    
    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    
    @Column(name="new")
    public Integer getNew_() {
        return this.new_;
    }
    
    public void setNew_(Integer new_) {
        this.new_ = new_;
    }

    
    @Column(name="leader")
    public Integer getLeader() {
        return this.leader;
    }
    
    public void setLeader(Integer leader) {
        this.leader = leader;
    }

    
    @Column(name="sale")
    public Integer getSale() {
        return this.sale;
    }
    
    public void setSale(Integer sale) {
        this.sale = sale;
    }

    
    @Column(name="visible")
    public Integer getVisible() {
        return this.visible;
    }
    
    public void setVisible(Integer visible) {
        this.visible = visible;
    }

    
    @Column(name="count")
    public Integer getCount() {
        return this.count;
    }
    
    public void setCount(Integer count) {
        this.count = count;
    }

    
    @Column(name="type_product")
    public String getTypeProduct() {
        return this.typeProduct;
    }
    
    public void setTypeProduct(String typeProduct) {
        this.typeProduct = typeProduct;
    }

    
    @Column(name="brand_id")
    public Integer getBrandId() {
        return this.brandId;
    }
    
    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    
    @Column(name="vote")
    public Integer getVote() {
        return this.vote;
    }
    
    public void setVote(Integer vote) {
        this.vote = vote;
    }

    
    @Column(name="votes", precision=12, scale=0)
    public Float getVotes() {
        return this.votes;
    }
    
    public void setVotes(Float votes) {
        this.votes = votes;
    }




}


