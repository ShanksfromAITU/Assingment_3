import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DatabaseHandler db = new DatabaseHandler();

        System.out.println("--- Educational Management System ---");

        boolean running = true;

        while (running) {
            System.out.println("\nChoose action:");
            System.out.println("1 - Add student");
            System.out.println("2 - Show all students");
            System.out.println("3 - Update student GPA");
            System.out.println("4 - Delete student");
            System.out.println("0 - Exit");

            System.out.print("Your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            try {
                switch (choice) {

                    // CREATE
                    case 1:
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter age: ");
                        int age = Integer.parseInt(scanner.nextLine());

                        System.out.print("Enter GPA: ");
                        double gpa = Double.parseDouble(scanner.nextLine());

                        db.addStudent(new Student(name, age, gpa));
                        break;

                    // READ
                    case 2:
                        System.out.println("\nAll students from Database:");
                        db.readAllStudents();
                        break;

                    // UPDATE
                    case 3:
                        System.out.print("Enter student ID: ");
                        int updateId = Integer.parseInt(scanner.nextLine());

                        System.out.print("Enter new GPA: ");
                        double newGpa = Double.parseDouble(scanner.nextLine());

                        db.updateStudentGpa(updateId, newGpa);
                        break;

                    // DELETE
                    case 4:
                        System.out.print("Enter student ID to delete: ");
                        int deleteId = Integer.parseInt(scanner.nextLine());

                        db.deleteStudent(deleteId);
                        break;

                    // EXIT
                    case 0:
                        running = false;
                        System.out.println("Program finished.");
                        break;

                    default:
                        System.out.println("Invalid option.");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
