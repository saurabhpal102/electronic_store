package electronicStore.dto.responseDto;

import electronicStore.model.Category;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ProductResponseDto {

    public String productId;

    public String title;

    public String description;

    public int price;

    public int discount;

    public int quantity;

    public Date addedDate;

    public boolean live;

    public boolean stock;

    public boolean deleted;

    public Category category;
}
