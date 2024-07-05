package TascaS3.Patterns1.N2.AbstractFactory;

import TascaS3.Patterns1.N2.Address.Address;
import TascaS3.Patterns1.N2.Phone.PhoneNumber;

public interface ContactFactory {
    Address createAddress(String street, String city, String zipCode);
    PhoneNumber createPhoneNumber(String countryCode, String number);
}
