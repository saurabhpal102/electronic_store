package electronicStore.helper;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImageResponseMesage {

    private String message;

    private String imageName;

    private boolean success;

    private HttpStatus status;

}
