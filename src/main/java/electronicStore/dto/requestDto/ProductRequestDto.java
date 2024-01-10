package electronicStore.dto.requestDto;

import electronicStore.dto.responseDto.CategoryResponseDto;
import electronicStore.model.Category;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ProductRequestDto {

    @NotBlank
    @Min(value = 4, message = "title can`t blank")
    public String title;

    public String description;

    public int price;

    public int discount;

    public int quantity;

    public boolean live;

    public boolean stock;

    public Category category;
}
