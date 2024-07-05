package TascaS3.Patterns1.N2.Menu;

import TascaS3.Patterns1.N2.AbstractFactory.ContactFactory;
import TascaS3.Patterns1.N2.AbstractFactory.ESContactFactory;
import TascaS3.Patterns1.N2.AbstractFactory.UKContactFactory;
import TascaS3.Patterns1.N2.Address.AddressBook;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);
        ContactFactory ukFactory = new UKContactFactory();
        ContactFactory esFactory = new ESContactFactory();

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add UK Contact");
            System.out.println("2. Add Spain Contact");
            System.out.println("3. Show Contacts");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1 || choice == 2) {
                System.out.print("Enter street: ");
                String street = scanner.nextLine();
                System.out.print("Enter city: ");
                String city = scanner.nextLine();
                System.out.print("Enter zip code: ");
                String zipCode = scanner.nextLine();
                System.out.print("Enter name of the country: ");
                String countryCode = scanner.nextLine();
                System.out.print("Enter phone number: ");
                String number = scanner.nextLine();

                ContactFactory factory = (choice == 1) ? ukFactory : esFactory;
                Contact contact = new Contact(
                        factory.createAddress(street, city, zipCode),
                        factory.createPhoneNumber(countryCode, number)
                );
                addressBook.addContact(contact);
            } else if (choice == 3) {
                addressBook.showContacts();
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Incorrect choice or not valid. Please try again.");
            }
        }

        scanner.close();
    }
}
