package TascaS3.Patterns1.N2.Phone;

public class UKPhoneNumber implements PhoneNumber {
    private final String countryCode;
    private final String number;

    public UKPhoneNumber(String countryCode, String number) {
        this.countryCode = countryCode;
        this.number = number;
    }

    @Override
    public String getDetails() {
        return "+" + countryCode + " " + number;
    }
}
