package Home;

import Home.Aspect.logging;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class carsservice {
    Logger log= LoggerFactory.getLogger(carsservice.class);
@Autowired
parameterService parameterService;
    @Autowired
    carsreprository carsreposatory;
    @Transactional(isolation= Isolation.READ_COMMITTED,readOnly = true,timeout = 5,rollbackFor = Exception.class)
    public List<cars> findAll() {
        return carsreposatory.findAll();
    }

    public cars Edite(int id) {
        return carsreposatory.findById(id);
    }
    @Transactional(isolation= Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED,readOnly = false,timeout = 5,rollbackFor = Exception.class)
    public cars Save(main_cars mainCars) {
        if(carsreposatory.findById(mainCars.getId())!=null)
        {mainCars.id=mainCars.id+100;
        while (carsreposatory.findById(mainCars.getId())!=null)
        {
            mainCars.id=mainCars.id+100;
        }
        System.out.println("id found yor new id : "+ mainCars.id );

        }
        int numberOfSeats;
        if (mainCars.getNumberofSeats() == 0) {
            if (parameterService.FindByName("numberOfSeats") == null) {
              System.out.println(parameterService.FindByName("numberOfSeats").value);
                numberOfSeats = 4;
            } else
                System.out.println(parameterService.FindByName("numberOfSeats").value);
                numberOfSeats = (int) parameterService.FindByName("numberOfSeats").getValue();
        }
        else
        { numberOfSeats= (int) mainCars.getNumberofSeats();
            System.out.println(parameterService.FindByName("numberOfSeats").value);}
            cars cars = new cars(mainCars.getId(),mainCars.getName(), numberOfSeats, null, mainCars.getPrice(), null);
            return carsreposatory.save(cars);

        }
    @Transactional(isolation= Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED,readOnly = false,timeout = 5,rollbackFor = Exception.class)
    public List<cars> showcars() {
        return carsreposatory.findByPersonname(null);
    }
    @Transactional(isolation= Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED,readOnly = false,timeout = 5,rollbackFor = Exception.class)
    public String Delete(main_cars name) {
        if (carsreposatory.findById(name.getId())!=null) {
            //for (int i=0; i<carsreposatory.findByName(name.getName()).size();i++) {
            cars cars = carsreposatory.findById(name.getId());
//System.out.println(carsreposatory.findByName(name.getName()).get(i).id);
            carsreposatory.delete(cars);

            return "ok";
        }
        else {
            return "donot found please try again";
        }
    }
    @Transactional(isolation= Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED,readOnly = false,timeout = 5,rollbackFor = Exception.class)
    public cars sell( Sell_Class sell_class) {

        if (carsreposatory.findById(sell_class.id) != null) {
            cars car = carsreposatory.findById(sell_class.id);
        if(car.is_sealed)
        {log.error("the car is sealed"+" id: "+car.getId()+" name:"+car.getName());
            return null;}
        else
        {//carsreposatory.delete(car);
        float price=parameterService.FindByName("price").getValue();
        float price1=price *car.getPrice();
        car.setPrice(car.getPrice()+price1);
        car.setDate(sell_class.getDate());
        car.setPersonname(sell_class.getPirson_name());
       car.setIs_sealed(true);
        carsreposatory.save(car);
        return car;}
    }
    else
        log.error("not found");
        return null;
}

@Transactional(isolation= Isolation.SERIALIZABLE,propagation = Propagation.REQUIRED,readOnly = false,timeout = 5,rollbackFor = Exception.class)
    public cars Edit(main_cars main_cars)
{cars car=carsreposatory.findById(main_cars.id);
//carsreposatory.delete(car);
car.setPrice(main_cars.getPrice());
car.setName(main_cars.getName());
if (main_cars.getNumberofSeats()!=0)
{car.setNumberOfSeats(main_cars.getNumberofSeats()); }
    carsreposatory.save(car);
    return car;}
public cars findbyid(int id)
{return carsreposatory.findById(id);


}
}
