package dev.duongson.listdemo1.models;

public class WeatherModel {
    private int img;
    private String day, status;

    public WeatherModel(int img, String day, String status) {
        this.img = img;
        this.day = day;
        this.status = status;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
