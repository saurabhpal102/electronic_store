package electronicStore.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class Category {

    @Id
    public String id;

    public String title;

    @Column(length = 50)
    public String description;

    public String coverImage;

    public boolean deleted;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Product> products = new ArrayList<>();
}
