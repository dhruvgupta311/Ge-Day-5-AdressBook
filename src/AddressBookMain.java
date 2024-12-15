import java.util.*;

public class AddressBookMain {
    private static Map<String, AddressBook> addressBookMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add New Address Book");
            System.out.println("2. Add Contact to an Address Book");
            System.out.println("3. Display Sorted Contacts by Name");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Address Book Name: ");
                    String addressBookName = scanner.nextLine();
                    if (!addressBookMap.containsKey(addressBookName)) {
                        addressBookMap.put(addressBookName, new AddressBook(addressBookName));
                        System.out.println("Address Book '" + addressBookName + "' created successfully.");
                    } else {
                        System.out.println("Address Book with this name already exists.");
                    }
                    break;

                case 2:
                    System.out.print("Enter Address Book Name: ");
                    String bookName = scanner.nextLine();
                    AddressBook addressBook = addressBookMap.get(bookName);
                    if (addressBook != null) {
                        System.out.print("Enter First Name: ");
                        String firstName = scanner.nextLine();
                        System.out.print("Enter Last Name: ");
                        String lastName = scanner.nextLine();
                        System.out.print("Enter Address: ");
                        String address = scanner.nextLine();
                        System.out.print("Enter City: ");
                        String city = scanner.nextLine();
                        System.out.print("Enter State: ");
                        String state = scanner.nextLine();
                        System.out.print("Enter Zip: ");
                        String zip = scanner.nextLine();
                        System.out.print("Enter Phone Number: ");
                        String phoneNumber = scanner.nextLine();
                        System.out.print("Enter Email: ");
                        String email = scanner.nextLine();

                        addressBook.addContact(new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email));
                    } else {
                        System.out.println("Address Book '" + bookName + "' does not exist.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Address Book Name to display sorted contacts: ");
                    String displayBookName = scanner.nextLine();
                    AddressBook displayAddressBook = addressBookMap.get(displayBookName);
                    if (displayAddressBook != null) {
                        List<Contact> sortedContacts = displayAddressBook.getSortedContactsByName();
                        System.out.println("Sorted Contacts by Name in Address Book '" + displayBookName + "':");
                        sortedContacts.forEach(contact -> System.out.println(contact));
                    } else {
                        System.out.println("Address Book '" + displayBookName + "' does not exist.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
