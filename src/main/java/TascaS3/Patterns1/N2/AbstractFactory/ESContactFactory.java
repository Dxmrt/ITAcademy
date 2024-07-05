package TascaS3.Patterns1.N2.AbstractFactory;

import TascaS3.Patterns1.N2.Address.Address;
import TascaS3.Patterns1.N2.Address.ESAddress;
import TascaS3.Patterns1.N2.Phone.ESPhoneNumber;
import TascaS3.Patterns1.N2.Phone.PhoneNumber;

public class ESContactFactory implements ContactFactory {
    @Override
    public Address createAddress(String street, String city, String zipCode) {
        return new ESAddress(street, city, zipCode);
    }

    @Override
    public PhoneNumber createPhoneNumber(String countryCode, String number) {
        return new ESPhoneNumber(countryCode, number);
    }
}
