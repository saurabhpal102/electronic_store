package electronicStore.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

    private String id;

    private String name;

    private String email;

    private String age;

    private boolean deleted;
}
