mport java.util.*;

class Student {
    int rollNo;
    String name;
    String course;

    Student(int rollNo, String name, String course) {
        this.rollNo = rollNo;
        this.name = name;
        this.course = course;
    }

    public String toString() {
        return "Roll No: " + rollNo +
               ", Name: " + name +
               ", Course: " + course;
    }
}

public class StudentManagement {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<>();
        HashMap<Integer, Student> map = new HashMap<>();

        while (true) {
            System.out.println("\n1. Add");
            System.out.println("2. Update");
            System.out.println("3. Search");
            System.out.println("4. Delete");
            System.out.println("5. Display");
            System.out.println("6. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Roll No: ");
                    int roll = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    Student s = new Student(roll, name, course);
                    list.add(s);
                    map.put(roll, s);

                    System.out.println("Student Added.");
                    break;

                case 2:
                    System.out.print("Enter Roll No to Update: ");
                    roll = sc.nextInt();
                    sc.nextLine();

                    if (map.containsKey(roll)) {
                        Student st = map.get(roll);

                        System.out.print("Enter New Name: ");
                        st.name = sc.nextLine();

                        System.out.print("Enter New Course: ");
