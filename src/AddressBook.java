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

    // Method to count persons by city
    public Map<String, Long> getCountByCity() {
        return contacts.stream()
                .collect(Collectors.groupingBy(Contact::getCity, Collectors.counting()));
    }

    // Method to count persons by state
    public Map<String, Long> getCountByState() {
        return contacts.stream()
                .collect(Collectors.groupingBy(Contact::getState, Collectors.counting()));
    }
}
