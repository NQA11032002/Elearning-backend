package guild.api.security.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "Authentication")
public class Authentication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Nullable
    @Column(name = "UserID")
    private Integer userID;

    @Nullable
    @Column(name = "Token")
    private String token;

    @Nullable
    @Column(name = "ExpirationTime")
    private Date expirationTime;



    @OneToOne
    @JoinColumn(name = "userID", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonManagedReference(value = "reference-authentication-user")
    private User user;
}
