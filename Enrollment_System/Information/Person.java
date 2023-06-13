package Information;

public class Person {

    String firstName;
    String middleName;
    String lastName;
    int address_ID;
    int contact_info_ID;

    public Person(String firstName, String middleName, String lastName, int contact_info_ID) {
        // this.person_ID = person_ID;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.address_ID = address_ID;
        this.contact_info_ID = contact_info_ID;
    }

}