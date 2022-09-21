package Home;

public class main_cars {
String name;
float price;
int numberofSeats;
int id;

    public main_cars() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberofSeats() {
        return numberofSeats;
    }

    public void setNumberofSeats(int numberofSeats) {
        this.numberofSeats = numberofSeats;
    }

    public main_cars(String name, int id,float price, int numberofSeats) {
        this.name = name;
        this.price = price;
        this.id=id;
        this.numberofSeats = numberofSeats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
