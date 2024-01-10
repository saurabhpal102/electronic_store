package electronicStore.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    public String productId;

    public String title;

    @Column(length = 10000)
    public String description;

    public int price;

    public int discount;

    public int quantity;

    public Date addedDate;

    public boolean live;

    public boolean stock;

    public boolean deleted;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryId")
    public Category category;
}
