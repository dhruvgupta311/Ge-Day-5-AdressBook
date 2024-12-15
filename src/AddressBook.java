import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    private String name;
    private List<Contact> contacts;

    public AddressBook(String name) {
        this.name = name;
        this.contacts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void displayAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            System.out.println("Displaying all contacts in the address book '" + name + "':");
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }
}
