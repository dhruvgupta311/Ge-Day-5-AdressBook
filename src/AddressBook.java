import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    public String name;
    private List<Contact> contacts;

    public AddressBook(String name) {
        this.name = name;
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public List<Contact> getContactsByCityOrState(String cityOrState) {
        return contacts.stream()
                .filter(contact -> contact.getCity().equalsIgnoreCase(cityOrState) || contact.getState().equalsIgnoreCase(cityOrState))
                .toList();
    }
}
