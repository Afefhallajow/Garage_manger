package Home.Mq;

import Home.main_cars;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import Home.cars;

import java.util.List;
//you should move it to the base project
// the Sender that he send to queue
@Controller
@RequestMapping(value ="/")
public class ControlerSendToQueue {
    @Autowired
    appService service;
    @Autowired
    RabbitTemplate template;

    @GetMapping(value = "send")
    public String Postdelett(Model model) {
        OrderStatus main_cars=new OrderStatus();
        model.addAttribute("orderStatus",main_cars);

        return "sendtoqueue";
    }

    @PostMapping(value = "send")
    public String publishToRabbit(@ModelAttribute("orderStatus") OrderStatus orderStatus)
    {
        System.out.println(
orderStatus.getDate());

        template.convertAndSend(Messagingconfig.Exchange,Messagingconfig.Routing,orderStatus);
        return "done";
    }
}

