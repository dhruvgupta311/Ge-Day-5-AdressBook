public class Contact {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String email;

    public Contact(String firstName, String lastName, String address, String city, String state, String zip, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    @Override
    public String toString() {
        return firstName + "," + lastName + "," + address + "," + city + "," + state + "," + zip + "," + phoneNumber + "," + email;
    }

    // Constructor to parse Contact from String data read from file
    public static Contact fromString(String contactData) {
        String[] data = contactData.split(",");
        return new Contact(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7]);
    }
}
