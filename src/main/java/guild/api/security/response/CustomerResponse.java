package guild.api.security.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {
    private Integer id;
    private String fullName;
    private String email;
    private String phone;
    private String city;
    private String profilePictureURL;
    private String role;
}
