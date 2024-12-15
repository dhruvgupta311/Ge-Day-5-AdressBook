import java.io.*;
import java.util.*;

public class AddressBookMain {
    private static Map<String, AddressBook> addressBookMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add New Address Book");
            System.out.println("2. Add Contact to an Address Book");
            System.out.println("3. Display Contacts of an Address Book");
            System.out.println("4. Save Address Book to File");
            System.out.println("5. Load Address Book from File");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

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
                    System.out.print("Enter Address Book Name to display: ");
                    String displayBookName = scanner.nextLine();
                    AddressBook displayAddressBook = addressBookMap.get(displayBookName);
                    if (displayAddressBook != null) {
                        displayAddressBook.displayAllContacts();
                    } else {
                        System.out.println("Address Book '" + displayBookName + "' does not exist.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Address Book Name to save to file: ");
                    String saveBookName = scanner.nextLine();
                    AddressBook saveAddressBook = addressBookMap.get(saveBookName);
                    if (saveAddressBook != null) {
                        saveAddressBookToFile(saveAddressBook, saveBookName);
                    } else {
                        System.out.println("Address Book '" + saveBookName + "' does not exist.");
                    }
                    break;

                case 5:
                    System.out.print("Enter Address Book Name to load from file: ");
                    String loadBookName = scanner.nextLine();
                    loadAddressBookFromFile(loadBookName);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to save Address Book to a file
    private static void saveAddressBookToFile(AddressBook addressBook, String bookName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(bookName + ".txt"))) {
            for (Contact contact : addressBook.getContacts()) {
                writer.write(contact.toString());
                writer.newLine();
            }
            System.out.println("Address Book '" + bookName + "' saved to file.");
        } catch (IOException e) {
            System.out.println("Error while saving the Address Book to file: " + e.getMessage());
        }
    }

    // Method to load Address Book from a file
    private static void loadAddressBookFromFile(String bookName) {
        File file = new File(bookName + ".txt");
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                AddressBook addressBook = new AddressBook(bookName);
                while ((line = reader.readLine()) != null) {
                    addressBook.addContact(Contact.fromString(line));
                }
                addressBookMap.put(bookName, addressBook);
                System.out.println("Address Book '" + bookName + "' loaded from file.");
            } catch (IOException e) {
                System.out.println("Error while loading the Address Book from file: " + e.getMessage());
            }
        } else {
            System.out.println("Address Book file '" + bookName + "' not found.");
        }
    }
}
