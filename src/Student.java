import java.time.LocalDate;

/**
 * Клас, що представляє студента.
 */
public class Student {
    private int id;
    private String firstname;
    private String lastname;
    private String middlename;
    private LocalDate dateOfBirth;
    private String address;
    private String phoneNumber;
    private String faculty;
    private String course;
    private String group;

    // Конструктор для створення нового студента.
    public Student(int id, String firstname, String lastname, String middlename, LocalDate dateOfBirth,
                   String address, String phoneNumber, String faculty, String course, String group) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.middlename = middlename;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getCourse() {
        return course;
    }

    public String getGroup() {
        return group;
    }

    public void setId(int id) {
        try {
            if (id <= 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Помилка: Число менше 1.");
            return;
        }
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    // Рядкове представлення студента.
    @Override
    public String toString() {
        return "ID: " + id + ", firstname: " + firstname + ", lastname: " + lastname + ", middlename: " + middlename +
                ", Birthday Date: " + dateOfBirth + ", Address: " + address + "', Phone number:" + phoneNumber +
                ", Faculty: " + faculty + ", Course: " + course + ", Group: " + group;
    }
}