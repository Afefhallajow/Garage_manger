package Home;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = home.class
)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
public class CarRestControllerIntergrationTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    parametersreposatory parametersreposatory;
    @MockBean
    carsservice carservice;
    @MockBean
    carsreprository carsreprository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void Update_Test() {
        main_cars mainCars = new main_cars("afef", 799898, 3232, 4);
        parameter parameter = new parameter(4, "numberOfSeats");
        int numberOfSeats = 4;
        String name = "Toyota";
        cars cars1 = new cars(mainCars.getId(), mainCars.getName(), numberOfSeats, null, mainCars.getPrice(), null);
        ;


        when(carsreprository.save(cars1)).thenReturn(cars1);
        cars1.setName(name);
        assertThat(carsreprository.save(cars1)).isEqualTo(cars1);
    }

    @Test
    public void Delete_Test() {

        main_cars mainCars = new main_cars("afef", 799898, 3232, 4);
        parameter parameter = new parameter(4, "numberOfSeats");
        int numberOfSeats = 4;

        cars cars1 = new cars(mainCars.getId(), mainCars.getName(), numberOfSeats, null, mainCars.getPrice(), null);
        ;

        Mockito.when(carsreprository.findById(cars1.getId())).thenReturn(cars1);
        assertThat(carsreprository.findById(cars1.getId())).isEqualTo(cars1);
        carsreprository.delete(cars1);
        Mockito.verify(carsreprository, times(1)).delete(cars1);
        Mockito.when(carsreprository.findById(cars1.getId())).thenReturn(null);
        assertThat(carsreprository.findById(cars1.getId())).isNull();

    }

    @Test
    public void save_Test() {

        main_cars mainCars = new main_cars("afef", 799898, 3232, 4);
        parameter parameter = new parameter(4, "numberOfSeats");
        int numberOfSeats = 4;

        cars car = new cars(mainCars.getId(), mainCars.getName(), numberOfSeats, null, mainCars.getPrice(), null);
        ;
        when(carsreprository.save(car)).thenReturn(car);
        assertThat(carsreprository.save(car)).isEqualTo(car);
    }

}

