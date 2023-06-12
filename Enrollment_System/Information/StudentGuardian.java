package Information;

public class StudentGuardian {

    int guardian_ID;
    String guardian_Name;
    String relationship;
    String guardian_Contact_Number;
    String guardian_Email;
    String guardian_Address;
    String additionalInfo;

    public StudentGuardian(int guardian_ID, String guardian_Name, String relationship, String guardian_Contact_Number,
            String guardian_Email, String guardian_Address, String additionalInfo) {
        this.guardian_ID = guardian_ID;
        this.guardian_Name = guardian_Name;
        this.relationship = relationship;
        this.guardian_Contact_Number = guardian_Contact_Number;
        this.guardian_Email = guardian_Email;
        this.guardian_Address = guardian_Address;
        this.additionalInfo = additionalInfo;
    }

}
