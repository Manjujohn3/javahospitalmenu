import java.sql.*;
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
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb", "root", "");
                        String sql = "SELECT `patientid`, `name`, `address`, `pincode`, `phone`, `symptoms`, `doctorname` FROM `patients`";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()) {
                            String getPatientid = rs.getString("patientid");
                            String getName = rs.getString("name");
                            String getAddress = rs.getString("address");
                            String getPincode = rs.getString("pincode");
                            String getPhone = rs.getString("phone");
                            String getSymptoms= rs.getString("symptoms");
                            String getDoctorname = rs.getString("doctorname");
                            System.out.println("patientid="+getPatientid);
                            System.out.println("name="+getName);
                            System.out.println("address="+getAddress);
                            System.out.println("pincode="+getPincode);
                            System.out.println("phone="+getPhone);
                            System.out.println("symptoms="+getSymptoms);
                            System.out.println("doctorname="+getDoctorname+"\n");
                        }
                    }
                    catch (Exception e) {
                        System.out.println(e);
                    }
                    break;

                case 3:
                    System.out.println("search selected");
                    System.out.println("Enter the name : ");
                    name = scanner.next();
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb","root","");
                        String sql = " SELECT `patientid`, `name`, `address`, `pincode`, `phone`, `symptoms`, `doctorname` FROM `patients` WHERE `name`='"+name+"'";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()){
                            String getPatientid = rs.getString("patientid");
                            String getName = rs.getString("name");
                            String getAddress = rs.getString("address");
                            String getPincode = rs.getString("pincode");
                            String getPhone = rs.getString("phone");
                            String getSymptoms= rs.getString("symptoms");
                            String getDoctorname = rs.getString("doctorname");
                            System.out.println("patientid="+getPatientid);
                            System.out.println("name="+getName);
                            System.out.println("address="+getAddress);
                            System.out.println("pincode="+getPincode);
                            System.out.println("phone="+getPhone);
                            System.out.println("symptoms="+getSymptoms);
                            System.out.println("doctorname="+getDoctorname+"\n");
                        }
                    }
                    catch (Exception e ){
                        System.out.println(e);
                    }
                    break;
                case 4:
                    System.out.println("delete selected");
                    System.out.println("Enter the patientid : ");
                    String patienti= scanner.next();
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb","root","");
                        String sql = "DELETE FROM `patients` WHERE`patientid`= " +patienti;
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("data deleted successfully");
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 5:
                    System.out.println("update selected");
                    System.out.println("enter the patientid:");
                    patientid = scanner.nextInt();
                    System.out.println("enter the name to be updated:");
                    name = scanner.next();
                    System.out.println("enter the address to be updated :");
                    address = scanner.next();
                    System.out.println("enter the pincode to be updated:");
                    pincode = scanner.nextInt();
                    System.out.println("enter the phone to be updated:");
                    phone = scanner.next();
                    System.out.println("enter the symptoms to be updated:");
                    symptoms = scanner.next();
                    System.out.println("enter the doctorname to be updated:");
                    doctorname = scanner.next();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb", "root", "");
                        String sql = "UPDATE `patients` SET `patientid`='"+String.valueOf(patientid)+"',`name`='"+name+"',`address`='"+address+"',`pincode`='"+String.valueOf(pincode)+"',`phone`='"+phone+"',`symptoms`='"+symptoms+"',`doctorname`='"+doctorname+"' WHERE `patientid`="+String.valueOf(patientid);
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("Updated successfully");
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }

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
