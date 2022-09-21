package Home;

import javafx.scene.chart.PieChart;
//the message you should move it to base

public class OrderStatus {
private String date;

private String message;
private String email;
    public OrderStatus() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public OrderStatus(String date, String message, String email) {
        this.date =date ;

        this.message = message;
    this.email=email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
