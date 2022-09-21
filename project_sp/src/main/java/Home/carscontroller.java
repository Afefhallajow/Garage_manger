package Home;


import Home.Security.SigneRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class carscontroller {
@Autowired
parameterService parameterService;
    @Autowired
carsservice carservice;
@Autowired
parametersreposatory parametersreposatory;
@PostMapping(value = "par")
parameter pa(@RequestBody main_cars main_cars)
{return parameterService.FindByName(main_cars.getName());}
@GetMapping(value = "f")
    public String findall(Model model)
{ List<cars> cars=carservice.findAll();
model.addAttribute("cars",cars);
return "findall";}

    @GetMapping(value = "s")
    public String Postsave(Model model) {
        main_cars main_cars=new main_cars();
        model.addAttribute("main_cars",main_cars);

        return "save";
    }
@PostMapping(value = "s")
    public String save (@ModelAttribute("main_cars") main_cars mainCars )
{
    carservice.Save(mainCars);
return "done";
}
    @GetMapping(value = "d")
    public String Postdelett(Model model) {
        main_cars main_cars=new main_cars();
        model.addAttribute("main_cars",main_cars);

        return "delete";
    }
@PostMapping(value = "d")
    public String Delete(@ModelAttribute("main_cars") main_cars name)
{
    carservice.Delete(name);
    return "don";
}
    @GetMapping(value = "addpara")
    public String Postaddparamerte(Model model) {
        parameter parameter=new parameter();
        model.addAttribute("parameter",parameter);

        return "addparameter";
    }
@PostMapping(value="addpara")
public String add_parameters(@ModelAttribute("parameter") parameter parameter)
{

    parametersreposatory.save(parameter);
return "done";
}
    @PostMapping(value="pa")
    public cars findbyid(@RequestBody int id)
    {
        return carservice.Edite(2);

    }
@GetMapping(value = "sell")
    public String showcars(Model model)
{ List<cars> cars=carservice.showcars();
    model.addAttribute("cars",cars);
    Sell_Class sell_class=new Sell_Class();
    model.addAttribute("sell_class",sell_class);

    return "showsell";
} /* @GetMapping(value = "sell")
    public String sell_get(Model model) {
        Sell_Class sell_class=new Sell_Class();
        model.addAttribute("sell_class",sell_class);

        return "sell";}*/
    @PostMapping(value = "sell")
    public String sell(@ModelAttribute("sell_class") Sell_Class sell_class)
    { carservice.sell(sell_class);

        return "done";}
    @GetMapping(value = "edite")
    public String Postedit(Model model) {
   main_cars main_cars=new main_cars();
        model.addAttribute("main_cars",main_cars);

        return "edit";
    }
    @PostMapping(value = "edite")
    public String Edite(@ModelAttribute("main_cars") main_cars main_cars)
    {carservice.Edit(main_cars);
    cars cars=carservice.findbyid(main_cars.id);

    return "don";}

}
