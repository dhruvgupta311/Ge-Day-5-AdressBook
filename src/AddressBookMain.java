import java.util.ArrayList;
import java.util.List;

public class AddressBookMain {
    private List<Contact> addressBook;

    public AddressBookMain() {
        this.addressBook = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        addressBook.add(contact);
        System.out.println("Contact added: " + contact);
    }

    public void displayContacts() {
        System.out.println("Contacts in Address Book:");
        for (Contact contact : addressBook) {
            System.out.println(contact);
        }
    }

    public static void main(String[] args) {
        AddressBookMain addressBookMain = new AddressBookMain();
        System.out.println("Welcome to Address Book Program");
        System.out.println("Running on Main Branch");

        // Add a contact
        Contact contact = new Contact("John", "Doe", "123 Main St", "New York", "NY", "10001", "9876543210", "john.doe@example.com");
        addressBookMain.addContact(contact);

        // Display all contacts
        addressBookMain.displayContacts();
    }
}
