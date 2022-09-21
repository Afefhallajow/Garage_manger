package Home;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class parameter implements Serializable {

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Id
    @GeneratedValue
int num;
    float value;
    String name;

    public parameter(long value, String name) {
        this.value = value;
        this.name = name;
    }

    public parameter() {
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}