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
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Nullable
    @Column(name = "UserID", length = 255)
    private Integer userID;

    @Nullable
    @Column(name = "FullName", length = 255)
    private String fullName;

    @Nullable
    @Column(name = "Phone", length = 20)
    private String phone;

    @Nullable
    @Column(name = "City", length = 100)
    private String city;

    @Nullable
    @Column(name = "ProfilePictureURL", length = 255)
    private String profilePictureURL;

    @OneToOne
    @JoinColumn(name = "userID", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonManagedReference(value = "reference-user-customer")
    private User user;
}
