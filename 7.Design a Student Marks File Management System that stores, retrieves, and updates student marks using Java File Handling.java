import java.util.*;

public class StudentMarksFile {

    static final String FILE = "students.txt";

    public static void addStudent(String name, int marks) throws IOException {
        FileWriter fw = new FileWriter(FILE, true);
        fw.write(name + "," + marks + "\n");
        fw.close();
        System.out.println("Student record added.");
    }

    public static void viewStudents() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(FILE));
        String line;

        System.out.println("\nStudent Records:");
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            System.out.println("Name: " + data[0] + "  Marks: " + data[1]);
        }
        br.close();
    }

    public static void updateStudent(String name, int newMarks) throws IOException {
        File input = new File(FILE);
        File temp = new File("temp.txt");

        BufferedReader br = new BufferedReader(new FileReader(input));
        BufferedWriter bw = new BufferedWriter(new FileWriter(temp));

        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            if (data[0].equalsIgnoreCase(name))
                bw.write(name + "," + newMarks + "\n");
            else
                bw.write(line + "\n");
        }

        br.close();
        bw.close();

        input.delete();
        temp.renameTo(input);

        System.out.println("Student record updated.");
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Marks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Marks: ");
                    int marks = sc.nextInt();
                    addStudent(name, marks);
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    System.out.print("Enter Student Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter New Marks: ");
                    int newMarks = sc.nextInt();
                    updateStudent(name, newMarks);
                    break;

                case 4:
                    System.out.println("Program Ended.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
