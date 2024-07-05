package TascaS3.Patterns1.N2.Address;

import TascaS3.Patterns1.N2.Menu.Contact;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    private final List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void showContacts() {
        for (Contact contact : contacts) {
            contact.showDetails();
        }
    }
}
