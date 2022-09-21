package Home;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.xml.crypto.Data;
import java.util.List;


public interface carsreprository extends JpaRepository<cars,String>
{ List<cars> findByName(String date);}

