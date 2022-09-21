package Home;

import javax.persistence.Entity;
import javax.persistence.Id;


public class Date {
   int Day;
int monthe;
int year;

    public int getDay() {
        return Day;
    }

    public void setDay(int day) {
        Day = day;
    }

    public int getMonthe() {
        return monthe;
    }

    public void setMonthe(int monthe) {
        this.monthe = monthe;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Date(int day, int monthe, int year) {
        Day = day;
        this.monthe = monthe;
        this.year = year;
    }

    public Date() {
    }
}
