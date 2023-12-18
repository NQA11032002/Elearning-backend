package guild.api.security.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private Integer userID;
    private String userName;
    private String password;
    private String fullName;
    private String phone;
}
