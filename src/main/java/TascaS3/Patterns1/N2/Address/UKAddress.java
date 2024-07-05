package TascaS3.Patterns1.N2.Address;

public class UKAddress implements Address {
    private final String street;
    private final String city;
    private final String zipCode;

    public UKAddress(String street, String city, String zipCode) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }

    @Override
    public String getDetails() {
        return street + ", " + city + ", " + zipCode + ", UK";
    }
}
