package Home.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class TokenUtil {
    private final String claims_subject="sub";
    private final String claims_created ="created";
 @Value("${auth.expiration}")
    private Long token_valdity = 604800L;
    @Value("${auth.secret}")
 private String token_secret="spring_project";
 public String generatetokens(UserDetails userDetails)
{

    Map<String,Object> claims=new HashMap<>();
    claims.put(claims_subject,userDetails.getUsername());
    claims.put(claims_created,new Date());
    return Jwts.builder()
        .setClaims(claims)
            .setExpiration(generateExpirationDate())
            .signWith(SignatureAlgorithm.HS512,token_secret)
            .compact();

}
public String getUserNameFromeToken(String token)
{try {
Claims claims= getClaims(token);
return  claims.getSubject();
}
    catch (Exception ex)
    {return null ;}

}
    private Date generateExpirationDate() {

    return new Date(System.currentTimeMillis() + token_valdity*1000);
    }

    public boolean IsTokenValid(String token, UserDetails userDetails) {
  String username=getUserNameFromeToken(token);
  return (username.equals(userDetails.getUsername()) &&  !isTokenExpired(token));
    }
    boolean isTokenExpired(String token)
    {Date expiration=getClaims(token).getExpiration();
    return expiration.before(new Date());}
private Claims getClaims (String token)
{Claims claims;
try
{
   claims= Jwts.parser().setSigningKey(token_secret)
            .parseClaimsJws(token)
            .getBody();
}
catch (Exception ex)
{return null;}
return claims;
}
}


