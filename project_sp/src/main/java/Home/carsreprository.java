package Home;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface carsreprository extends JpaRepository<cars,String>{
void deleteByName(String name);
List<cars> findByDate(String date);
    List<cars> findByPersonname(String personname);
cars findById(int id);

List<cars> findByName(String name);}

