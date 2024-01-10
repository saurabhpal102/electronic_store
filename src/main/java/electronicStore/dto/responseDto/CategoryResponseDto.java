package electronicStore.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryResponseDto {

    public String id;

    public String title;

    public String description;

    public String coverImage;

    public boolean deleted;
}
