package TascaS3.Patterns1.N2.AbstractFactory;

import TascaS3.Patterns1.N2.Address.Address;
import TascaS3.Patterns1.N2.Phone.PhoneNumber;
import TascaS3.Patterns1.N2.Address.UKAddress;
import TascaS3.Patterns1.N2.Phone.UKPhoneNumber;

public class UKContactFactory implements ContactFactory {
    @Override
    public Address createAddress(String street, String city, String zipCode) {
        return new UKAddress(street, city, zipCode);
    }

    @Override
    public PhoneNumber createPhoneNumber(String countryCode, String number) {
        return new UKPhoneNumber(countryCode, number);
    }
}
