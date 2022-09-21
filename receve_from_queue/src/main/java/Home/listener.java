package Home;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//the listener that he take the message from queue
@Component
@RestController
public class listener {
private OrderStatus orderStatus;
    @Autowired
    appService service;

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @RabbitListener (queues = Messagingconfig.queue)
    public void consumeMessageFromQueue( OrderStatus orderStatus)
{this.orderStatus=orderStatus;
    System.out.println("messag recived from queue : "+ orderStatus);
    System.out.println("messag recived from queue : "+ orderStatus.getDate());
    System.out.println("messag recived from queue : "+ orderStatus.getMessage());
    System.out.println("messag recived from queue : "+ orderStatus.getEmail());
}
@RequestMapping(value = "/a")
    public List<cars> findAll()
{return service.findAll();


}

}
