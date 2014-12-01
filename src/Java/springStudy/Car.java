package springStudy;

/**
 * Created by Administrator on 2014/10/31.
 */
public class Car {
    private String brand;
    private String color;
    private int maxSpeed;

    public Car(){}

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getBrand() {
        return brand;

    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Car(String brand,String color,int maxSpeed){
        this.brand=brand;
        this.color=color;

        this.maxSpeed=maxSpeed;
    }

    public void introduce(){
        System.out.println("brand:"+brand+";cloar:"+color+";maxSpeed:"+maxSpeed);
    }

}
