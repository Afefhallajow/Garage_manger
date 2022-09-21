package Home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableCaching
public class parameterService {
@Autowired
    parametersreposatory paramtersreposatory;
public parameter Save(parameter parameter) {
 return   paramtersreposatory.save(parameter);
}
@Cacheable(value = "parameters")
public List<parameter> findall()
{
    return paramtersreposatory.findAll();
}
@CacheEvict(value = "parameters",key = "#name")
public String Delete(String name)
{parameter parameter= FindByName(name);
paramtersreposatory.delete(parameter);

    return "ok";
}
@CacheEvict(value = "parameters",allEntries = true)
public void ClearCahe ()
{}


    @Cacheable(value = "parameters",key = "#name")
    public parameter FindByName(String name)
    {
        return paramtersreposatory.findByName(name);
    }

}
