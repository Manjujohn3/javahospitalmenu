import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Hospital {
    public static void main(String[] args) {


        int choice;

        while (true) {
            System.out.println("select an option");
            System.out.println("1.insert");
            System.out.println("2.view");
            System.out.println("3.search");
            System.out.println("4.delete");
            System.out.println("5.update");
            System.out.println("6.Exit");

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("insert patient selected");
                    System.out.println("enter the patientid:");
                    int patientid = scanner.nextInt();
                    System.out.println("enter the name:");
                    String name = scanner.next();
                    System.out.println("enter the address:");
                    String address = scanner.next();
                    System.out.println("enter the pincode:");
                    int pincode = scanner.nextInt();
                    System.out.println("enter the phone:");
                    String phone = scanner.next();
                    System.out.println("enter the symptoms");
                    String symptoms = scanner.next();
                    System.out.println("enter the doctorname");
                    String doctorname = scanner.next();

                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb", "root", "");
                        String sql = "INSERT INTO `patients`(`patientid`, `name`, `address`, `pincode`, `phone`, `symptoms`, `doctorname`) VALUES (?,?,?,?,?,?,?)";
                        PreparedStatement stmt = con.prepareStatement(sql);
                        stmt.setInt(1, patientid);
                        stmt.setString(2, name);
                        stmt.setString(3, address);
                        stmt.setInt(4, pincode);
                        stmt.setString(5, phone);
                        stmt.setString(6, symptoms);
                        stmt.setString(7, doctorname);

                        stmt.executeUpdate();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 2:
                    System.out.println("view selected");
                    break;
                case 3:
                    System.out.println("search selected");
                    break;
                case 4:
                    System.out.println("delete selected");
                    break;
                case 5:
                    System.out.println("update selected");
                    break;
                case 6:
                    System.out.println("Exit");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter correct value");
                    break;


            }

        }
    }
}
