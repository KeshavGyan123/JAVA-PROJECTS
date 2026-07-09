package StudentManagementSystem.src.studentApp;

// package studentApp;

import java.util.ArrayList;

public class StudentManager {

    // ================= Student Collection =================

    private ArrayList<Student> students = new ArrayList<>();


    // ================= Constructor =================

    public StudentManager() {
    students = FileManager.loadStudents();

}

    // ================= Add Student =================

    public void addStudent(Student student){
        students.add(student);
    }
    
        // ================= Search Student =================
     
         public Student searchStudent(int studentId){
              
            for(Student student : students){

                if(student.getStudentId() == studentId){
                    return student;
                }
            }
                  return null;

         }

         // ================= Update Student =================
   
        public boolean updateStudent(int studentId,
             String name,
             int age,
             String course,
             String year,
             String gender) {

         Student student = searchStudent(studentId);

    if (student != null) {

        student.setName(name);
        student.setAge(age);
        student.setCourse(course);
        student.setYear(year);
        student.setGender(gender);

        return true;
    }

    return false;
}


             // ================= Delete Student =================
                
             public  boolean deleteStudent(int studentId){

                Student student = searchStudent(studentId);

                if(student != null){
                    students.remove(student);
                    return true;
                }
                return false;
             }

             // ================= Get All Students =================

         public ArrayList<Student> getAllStudents() {
         return students;

}
             


}
