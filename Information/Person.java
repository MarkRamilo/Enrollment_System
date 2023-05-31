package Information;

public class Person {

    // int person_ID;
    String name;
    int age;
    String email;
    String contact_Number;
    final int accessLevel;
    // String role;

    public Person(String name, int age, String email, String contact_Number, int accessLevel) {
        // this.person_ID = person_ID;
        this.name = name;
        this.age = age;
        this.email = email;
        this.contact_Number = contact_Number;
        this.accessLevel = accessLevel;
        // this.role = role;
    }

    // public int getPerson_ID() {
    // return person_ID;
    // }

    // public void setPerson_ID(int person_ID) {
    // this.person_ID = person_ID;
    // }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getContact_Number() {
        return contact_Number;
    }

    public void setContact_Number(String contact_Number) {
        this.contact_Number = contact_Number;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // public String getRole() {
    // return role;
    // }

    // public void setRole(String role) {
    // this.role = role;
    // }

}

// class contact_Number {

// String contact_Number;

// public contact_Number(String contact_Number) {
// this.contact_Number = contact_Number;
// }

// public String getContact_Number() {
// return contact_Number;
// }

// public void setContact_Number(String contact_Number) {
// this.contact_Number = contact_Number;
// }
// }
