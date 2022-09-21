package Home;

public class Sell_Class {
String name;
String pirson_name;
String date;
float price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Sell_Class(int id,String name, String pirson_name, String date) {
        this.name = name;
        this.pirson_name = pirson_name;
        this.date = date;
this.id=id;
    }

    public Sell_Class() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPirson_name() {
        return pirson_name;
    }

    public void setPirson_name(String pirson_name) {
        this.pirson_name = pirson_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
