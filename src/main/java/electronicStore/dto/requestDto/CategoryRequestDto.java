package electronicStore.dto.requestDto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryRequestDto {

    @NotBlank
    @Min(value=4,message = "title can`t blank")
    public String title;

    public String description;

    public String coverImage;
}
