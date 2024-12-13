import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class AddressBook {
    private List<Contact> contacts;

    public AddressBook() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Contact added successfully.");
    }

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            System.out.println("Contacts in Address Book:");
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    public boolean editContact(String firstName, String lastName, Scanner scanner) {
        for (Contact contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(firstName) && contact.getLastName().equalsIgnoreCase(lastName)) {
                System.out.println("Contact found: " + contact);
                System.out.println("Enter new details:");

                System.out.print("Enter New Address: ");
                String address = scanner.nextLine();
                System.out.print("Enter New City: ");
                String city = scanner.nextLine();
                System.out.print("Enter New State: ");
                String state = scanner.nextLine();
                System.out.print("Enter New Zip: ");
                String zip = scanner.nextLine();
                System.out.print("Enter New Phone Number: ");
                String phoneNumber = scanner.nextLine();
                System.out.print("Enter New Email: ");
                String email = scanner.nextLine();

                contact.setAddress(address);
                contact.setCity(city);
                contact.setState(state);
                contact.setZip(zip);
                contact.setPhoneNumber(phoneNumber);
                contact.setEmail(email);

                System.out.println("Contact updated successfully.");
                return true;
            }
        }
        System.out.println("Contact not found.");
        return false;
    }
}
