package Home;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static  org.assertj.core.api.Assertions.*;
@RunWith(SpringRunner.class)
public class servertest {
@MockBean
public carsreprository repo;
@MockBean
private parametersreposatory parametersreposatory;
@Autowired
    carsservice servic;
@TestConfiguration
static class carserviceContextConfiguration {
    @Bean
    public carsservice carservice()
    {return new carsservice(); }

}
    @Test
    public void findall()
{ List<cars> carsList=repo.findAll();
given(repo.findAll()).willReturn(carsList);
assertThat(servic.findAll())
        .contains();
}

}
