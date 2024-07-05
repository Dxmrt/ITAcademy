package TascaS3.Patterns1.N2.Menu;

import TascaS3.Patterns1.N2.Address.Address;
import TascaS3.Patterns1.N2.Phone.PhoneNumber;

public class Contact {
    private final Address address;
    private final PhoneNumber phoneNumber;

    public Contact(Address address, PhoneNumber phoneNumber) {
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public void showDetails() {
        System.out.println("Address: " + address.getDetails());
        System.out.println("Phone Number: " + phoneNumber.getDetails());
    }
}
