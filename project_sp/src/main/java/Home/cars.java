package Home;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class cars {
@Id

int id;
boolean is_sealed=false;

    public boolean isIs_sealed() {
        return is_sealed;
    }

    public void setIs_sealed(boolean is_sealed) {
        this.is_sealed = is_sealed;
    }

    public String getPersonname() {
        return personname;
    }

    public void setPersonname(String personname) {
        this.personname = personname;
    }

    public cars(int id,String name, int numberOfSeats, String date, float price, String personname) {
        this.name = name;
        this.numberOfSeats = numberOfSeats;
        this.date = date;
        this.price = price;
        this.personname = personname;
    this.id=id;
    }

    public cars() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    String name;
int numberOfSeats;
String date;
float price;
String personname;


}
