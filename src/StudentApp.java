import java.sql.*; //imports classes to connect to database
import java.sql.Date;
import java.util.Scanner;



public class StudentApp {
    //database connection information
    private static final String URL = "jdbc:postgresql://localhost:5432/school_db"; // database URL
    private static final String USER = "postgres"; // database username
    private static final String PASSWORD = "COMP3005"; //database password


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //scanner for user input
        int choice;

        do { //start menu
            System.out.println("\n--- Student database menu ---");
            System.out.println("1. View all students");
            System.out.println("2. Add student");
            System.out.println("3. Update student email");
            System.out.println("4. Delete student");
            System.out.println("5. Exit");
            System.out.println("Please enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    getAllStudents(); //display all students from database
                    break;
                case 2: //prompt user for student details then adds the student
                    System.out.print("First name: ");
                    String firstName = scanner.next();
                    System.out.print("Last name: ");
                    String lastName = scanner.next();
                    System.out.print("Email: ");
                    String email = scanner.next();
                    System.out.print("Enrollment date (YYYY-MM-DD): ");
                    String date = scanner.next();
                    addStudent(firstName, lastName, email, date);
                    break;
                case 3: //updates email
                    System.out.print("Student ID: ");
                    int id = scanner.nextInt();
                    System.out.print("New email: ");
                    String newEmail = scanner.next();
                    updateStudentEmail(id, newEmail);
                    break;
                case 4: //delate a student record by using ID
                    System.out.print("Student ID to delete: ");
                    int delId = scanner.nextInt();
                    deleteStudent(delId);
                    break;
                case 5: //exit
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid input");


            }

        }
        while (choice != 5); //continues loop until exit
        scanner .close();

    }

    //method for retrieveing all students
    public static void getAllStudents() {
        String query = "SELECT * FROM students";
        //connects to database
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            System.out.println("\nStudent List: ");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("Student_id") + " - " +
                        resultSet.getString("first_name") + " " +
                        resultSet.getString("last_name") + " " +
                        resultSet.getString("email") + " - " +
                        resultSet.getDate("enrollment_date"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //method for adding student
    public static void addStudent(String firstName, String lastName, String email, String enrollmentDate) {
        String query = "INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, email);
            preparedStatement.setDate(4, java.sql.Date.valueOf(enrollmentDate));

            preparedStatement.executeUpdate();
            System.out.println("Student added successfully");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //method to update student email
    public static void updateStudentEmail(int studentId, String newEmail) {
        String query = "UPDATE students SET email = ? WHERE student_id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, newEmail);
            preparedStatement.setInt(2, studentId);
            preparedStatement.executeUpdate();
            System.out.println("Email updated successfully!");

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // method to delete student
    public static void deleteStudent(int studentId) {
        String query = "DELETE FROM students WHERE student_id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, studentId);
            preparedStatement.executeUpdate();
            System.out.println("Student deleted successfully!");

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }




}
