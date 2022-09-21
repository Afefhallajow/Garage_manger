package Home.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/")

public class userControl {
@Autowired
UserService userService;

    @GetMapping(value = "user")
    public String PostAccount(Model model) {
        SigneRequest signeRequest=new SigneRequest();
        model.addAttribute("signeRequest",signeRequest);

        return "adduser";
    }
@PostMapping(value = "user")
    public String Save_user(@ModelAttribute("signeRequest")  SigneRequest signeRequest)
{AppUser user =new AppUser(signeRequest.getUsername(),signeRequest.getPassword());
      userService.save(user);
return "useradd";}
}
