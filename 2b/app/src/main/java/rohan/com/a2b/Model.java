package rohan.com.a2b;

/**
 * Created by Rohan on 05-10-2017.
 */

public class Model {
    boolean isSelected;
    String name;
    double price;
    int quant;

    public Model(String name,double price){
        this.name = name;
        this.price = price;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }
}
