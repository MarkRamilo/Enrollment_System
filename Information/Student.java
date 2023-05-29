package Information;

public class Student extends Person {

    int student_ID;
    String course;
    String year;
    String type;

    public Student(String name, int age, String email, String contact_Number, String course, String year, String type,
            int accessLevel) {
        super(name, age, email, contact_Number, accessLevel);
        // TODO Auto-generated constructor stub

        this.course = course;
        this.year = year;
        this.type = type;

    }

    // public int getStudent_ID() {
    // return student_ID;
    // }

    // public void setStudent_ID(int student_ID) {
    // this.student_ID = student_ID;
    // }

}
