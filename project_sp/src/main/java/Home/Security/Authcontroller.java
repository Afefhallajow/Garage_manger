package Home.Security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/")
public class Authcontroller {
public String username;
@Autowired
private TokenUtil tokenUtil;
@Autowired
    private UserService userService;
@Autowired
private AuthenticationManager authenticationManager;
public JwtResponse response1;

@GetMapping(value = "out")
public String log(HttpServletResponse request)
{Cookie cookie=new Cookie("Authorization",null);
    request.addCookie(cookie);

    return "logout";
}

    @GetMapping(value = "login")
    public String PostAccount(Model model) {
        SigneRequest signeRequest=new SigneRequest();
        model.addAttribute("signeRequest",signeRequest);

        return "register";
    }
    @PostMapping (value = "/login")
public String SigneIn(@ModelAttribute("signeRequest") SigneRequest signeRequest, HttpServletResponse response2)

{System.out.println(signeRequest.getUsername());
    username =signeRequest.getUsername();
    Authentication authentication1=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signeRequest.getUsername(),signeRequest.getPassword()));
 SecurityContextHolder.getContext().setAuthentication(authentication1);
   UserDetails userDetails =userService.loadUserByUsername(signeRequest.getUsername());
    String token =tokenUtil.generatetokens(userDetails);
JwtResponse response=new JwtResponse(token);
   response1=response;
System.out.println(response.getToken());
    String value =response.getToken();
Cookie cookie=new Cookie("Authorization",value);

response2.addCookie(cookie);


    return "Regester_done";
}

}
