import java.util.EnumMap;
import java.util.Scanner;

public class eMail {
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private int defaultPasswordLength = 10;
    private String department;
    private int mailBoxCapacity;
    private String alternateEmail;
    private String companySuffix = "fatcompany.com";

    public eMail(String firstname, String lastName) {
        this.firstName = firstname;
        this.lastName = lastName;
        System.out.println("Email created: " + this.firstName + " " + this.lastName);

        this.department = setDepartment();
        System.out.println("Department: " + this.department);

        this.password = setPassword(defaultPasswordLength);
        System.out.println("Password: " + this.password);

        email = firstname.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
        System.out.println("Email = " + email);
    }

    private String setDepartment() {
        System.out.println(
                "New personel: " + firstName
                        + " \nDepartment Codes: \n1 for Sales\n2 for Development\n3 for Accounting\n0 for None\n Enter Department");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        if (choice == 1) {
            return "sales";
        } else if (choice == 2) {
            return "software development";
        } else if (choice == 3) {
            return "accounting";
        } else {
            return " ";
        }
    }

    private String setPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPRSTUVYZX0123456789!@#$%&*/?";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int random = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(random);
        }
        return new String(password);
    }

    public void setMailBoxCapacity(int capacity) {
        this.mailBoxCapacity = capacity;
    }

    public void setAlternateEmail(String alternativeMail) {
        this.alternateEmail = alternativeMail;
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailCapacity() {
        return mailBoxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo() {
        return "Display Name: " + firstName + " " + lastName + " " +
                "\nCOMPANY NAME: " + email +
                "\nMAILBOX CAPACITY: " + mailBoxCapacity + " mb";
    }
}
