package Home;

import org.springframework.data.jpa.repository.JpaRepository;

public interface parametersreposatory extends JpaRepository <parameter,String>{
public parameter findByName(String name);
}
