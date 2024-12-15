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

    // Method to group persons by city
    public Map<String, List<Contact>> getPersonsByCity() {
        return contacts.stream()
                .collect(Collectors.groupingBy(Contact::getCity));
    }

    // Method to group persons by state
    public Map<String, List<Contact>> getPersonsByState() {
        return contacts.stream()
                .collect(Collectors.groupingBy(Contact::getState));
    }
}
