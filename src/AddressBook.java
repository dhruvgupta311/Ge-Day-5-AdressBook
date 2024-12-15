import java.util.*;
import java.util.stream.Collectors;

public class AddressBook {
    private String name;
    private List<Contact> contacts;

    public AddressBook(String name) {
        this.name = name;
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    // Method to sort contacts by name (first name and last name)
    public List<Contact> getSortedContactsByName() {
        return contacts.stream()
                .sorted(Comparator.comparing(Contact::getFullName))
                .collect(Collectors.toList());
    }
}
