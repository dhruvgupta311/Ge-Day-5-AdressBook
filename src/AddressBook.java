import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AddressBook {
    private String name;
    private List<Contact> contacts;

    public AddressBook(String name) {
        this.name = name;
        this.contacts = new ArrayList<>();
    }

    public boolean addContact(Contact contact) {
        // Use Streams to check for duplicates
        boolean exists = contacts.stream().anyMatch(existing -> existing.equals(contact));
        if (exists) {
            System.out.println("Duplicate contact found: " + contact.getFirstName() + " " + contact.getLastName());
            return false;
        }
        contacts.add(contact);
        System.out.println("Contact added successfully.");
        return true;
    }

    public void displayAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts in the address book.");
        } else {
            contacts.forEach(System.out::println);
        }
    }
}
