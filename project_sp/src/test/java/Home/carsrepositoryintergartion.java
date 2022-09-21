package Home;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import Home.cars;
@RunWith(SpringRunner.class)
@DataJpaTest
public class carsrepositoryintergartion {
@MockBean
parametersreposatory parametersreposatory;
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private  carsreprository carsreposatory;
    @Test
    public void whenfindbyname_thenreturncar()
    {cars car=new cars(1,"afef",2,null,3,"22");
    entityManager.persist(car);
    entityManager.flush();
        //when
        cars found=carsreposatory.findByName(car.getName()).get(0);
        //then
        assertThat(found.getName())
                .isEqualTo(car.getName());
    }

}
