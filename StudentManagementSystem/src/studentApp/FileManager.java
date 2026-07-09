package StudentManagementSystem.src.studentApp;

import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private static final String FILE_NAME = "students.txt";

    // ================= Save Students =================

    public static void saveStudents(ArrayList<Student> students) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Student student : students) {

                writer.write(
                        student.getStudentId() + "," +
                        student.getName() + "," +
                        student.getAge() + "," +
                        student.getCourse() + "," +
                        student.getYear() + "," +
                        student.getGender()
                );

                writer.newLine();

            }

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    // ================= Load Students =================

    public static ArrayList<Student> loadStudents() {

        ArrayList<Student> students = new ArrayList<>();

        File file = new File(FILE_NAME);

        if (!file.exists()) {

            return students;

        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                Student student = new Student(

                        Integer.parseInt(data[0]),
                        data[1],
                        Integer.parseInt(data[2]),
                        data[3],
                        data[4],
                        data[5]

                );

                students.add(student);

            }

        } catch (IOException e) {

            e.printStackTrace();

        }

        return students;

    }

}