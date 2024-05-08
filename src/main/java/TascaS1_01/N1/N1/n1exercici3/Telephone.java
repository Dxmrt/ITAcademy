package TascaS1_01.N1.N1.n1exercici3;

public class Telephone{
private final String model;
private String number;
private final String brand;

public Telephone(String brand, String model) {
    this.model = model;
    this.brand = brand;
}

public String getModel() {
    return model;
}

public String getNumber() {
     return number;
}

public String getBrand(){ return brand;}

public void setNumber(String number) {
    this.number = number;
}

public void calling(String telephone) {
    setNumber(telephone);
    System.out.println("You are calling to: " + getNumber() +  " Thelephone brand is: " + this.getBrand() + " and the model is: " + getModel());
}
}

