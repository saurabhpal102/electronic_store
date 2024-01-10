package electronicStore.dto.requestDto;

import lombok.Data;

@Data
public class UserRequestDto {

    private String name;

    private String email;

    private String password;

    private String age;

    private boolean deleted;
}
