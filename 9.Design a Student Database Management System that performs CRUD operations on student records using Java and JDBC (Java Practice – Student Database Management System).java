public class StudentCRUD {

    static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    static final String USER = "root";
    static final String PASSWORD = "root"; // Change to your MySQL password

    public static void main(String[] args) throws Exception {

        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Insert");
            System.out.println("2. View");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");

            int ch = sc.nextInt();

            switch (ch) {

                case 1:
                    System.out.print("Roll No: ");
                    int roll = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Course: ");
                    String course = sc.nextLine();

                    PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO student VALUES(?,?,?)");
                    ps.setInt(1, roll);
                    ps.setString(2, name);
                    ps.setString(3, course);
                    ps.executeUpdate();

                    System.out.println("Record Inserted");
                    break;

                case 2:
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM student");

                    while (rs.next()) {
                        System.out.println(
                            rs.getInt("rollno") + " " +
                            rs.getString("name") + " " +
                            rs.getString("course"));
                    }
                    break;

                case 3:
                    System.out.print("Enter Roll No: ");
                    roll = sc.nextInt();
                    sc.nextLine();

                    System.out.print("New Name: ");
                    name = sc.nextLine();

                    PreparedStatement ps2 = con.prepareStatement(
                        "UPDATE student SET name=? WHERE rollno=?");
                    ps2.setString(1, name);
                    ps2.setInt(2, roll);
                    ps2.executeUpdate();

                    System.out.println("Record Updated");
                    break;

                case 4:
                    System.out.print("Enter Roll No: ");
                    roll = sc.nextInt();

                    PreparedStatement ps3 = con.prepareStatement(
                        "DELETE FROM student WHERE rollno=?");
                    ps3.setInt(1, roll);
                    ps3.executeUpdate();

                    System.out.println("Record Deleted");
                    break;

                case 5:
                    con.close();
                    sc.close();
                    System.exit(0);
            }
        }
    }
}
[
