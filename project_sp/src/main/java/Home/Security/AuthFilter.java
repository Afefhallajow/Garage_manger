package Home.Security;


import Home.Aspect.logging;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthFilter extends OncePerRequestFilter {
public UsernamePasswordAuthenticationToken authenticationToken1 ;
public String UserName;
    private String token_header="Authorization";
@Autowired
private TokenUtil tokenUtil;
  @Autowired
  UserService userService;
    Logger log= LoggerFactory.getLogger(logging.class);
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        Cookie [] cookies=request.getCookies();
        int j=0;
        for(int i=0;i<cookies.length;i++)
        {if (cookies[i].getName().equals(token_header))
            {
                j=i;
            }}
        final SecurityContext  securityContext= SecurityContextHolder.getContext();
        if (cookies[j]!=null&& securityContext.getAuthentication() == null)
        {
            String token=cookies[j].getValue();
            String username=tokenUtil.getUserNameFromeToken(token);
            UserName=username;
            if (username !=null) {
                UserDetails userDetails = userService.loadUserByUsername(username);
                UserName = userDetails.getUsername();
                if (tokenUtil.IsTokenValid(token, userDetails)) {
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    authenticationToken1 = authenticationToken;
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }


            }}        final String header=request.getHeader(token_header);

if(header !=null &&securityContext.getAuthentication() ==null)
{
    String token=header.substring("Bearer ".length());
String username=tokenUtil.getUserNameFromeToken(token);
UserName=username;
if (username !=null)
{
    UserDetails userDetails= userService.loadUserByUsername(username);
UserName=userDetails.getUsername();
    if (tokenUtil.IsTokenValid(token,userDetails)) {
    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
authenticationToken1=authenticationToken;
    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
}

}



}
log.info("UserName: "+UserName);
 filterChain.doFilter(request,response);
    }
}
