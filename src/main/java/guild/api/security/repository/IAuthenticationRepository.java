package guild.api.security.repository;

import guild.api.security.entity.Authentication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthenticationRepository extends JpaRepository<Authentication, Integer> {
    public Authentication findAuthenticationByUserID(Integer id);

//    public Authentication findAuthenticationByUserName(String userName);

}
