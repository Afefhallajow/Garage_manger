package Home.Security;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Userrepository extends JpaRepository<AppUser,String> {
AppUser findByUsername(String username);
}
