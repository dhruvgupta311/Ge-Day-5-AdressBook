import java.util.*;

public class AddressBookMain {
    private static Map<String, AddressBook> addressBookMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add New Address Book");
            System.out.println("2. Add Contact to an Address Book");
            System.out.println("3. Count Persons by City Across All Address Books");
            System.out.println("4. Count Persons by State Across All Address Books");
            System.out.println("5. Exit");
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
                    System.out.println("Count of Persons by City:");
                    addressBookMap.values().forEach(book -> {
                        Map<String, Long> countByCity = book.getCountByCity();
                        countByCity.forEach((city, count) -> System.out.println("City: " + city + ", Count: " + count));
                    });
                    break;

                case 4:
                    System.out.println("Count of Persons by State:");
                    addressBookMap.values().forEach(book -> {
                        Map<String, Long> countByState = book.getCountByState();
                        countByState.forEach((state, count) -> System.out.println("State: " + state + ", Count: " + count));
                    });
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
