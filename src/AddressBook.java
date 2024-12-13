import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    private List<Contact> contacts;

    public AddressBook() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Contact added: " + contact);
    }

    public void displayAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Address Book is empty.");
        } else {
            System.out.println("All Contacts in Address Book:");
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }
}
