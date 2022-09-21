package Home;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//you should move it to the base project
// the Sender that he send to queue
@RestController
@RequestMapping(value ="/")
public class ControlerSendToQueue {
@Autowired
appService service;
@Autowired
    RabbitTemplate template;
@PostMapping(value = "send")
    public String publishToRabbit(@RequestBody OrderStatus orderStatus)
{


    template.convertAndSend(Messagingconfig.Exchange,Messagingconfig.Routing,orderStatus);
        return "secssful";
    }
@GetMapping(value = "test")
    public List<cars> sss() {
    return  service.FindBydate();
}
}
