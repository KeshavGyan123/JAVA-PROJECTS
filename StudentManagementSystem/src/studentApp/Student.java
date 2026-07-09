package StudentManagementSystem.src.studentApp;
// package studentApp;

public class Student { 


    // ================= Student Attributes =================

    private int studentId;
    private String name;
    private int age;
    private String course;
    private String year;
    private String gender;

// ================= Constructor =================

public Student(int studentId, String name, int age,
               String course, String year, String gender) {

    this.studentId = studentId;
    this.name = name;
    this.age = age;
    this.course = course;
    this.year = year;
    this.gender = gender;
    
}

public int getStudentId(){
    return studentId;
}

public String getName(){
    return name;
}

public int getAge(){
    return age;
}

public String getCourse(){
    return course;
}

public String getYear(){
    return year;
}

public String getGender(){
    return gender;
}

// ================= Setter Methods =================

public void setStudentId(int studentId){
        this.studentId = studentId;
}

public void setName(String name){
    this.name = name;
}

public void setAge( int age){
    this.age = age;
}

public void setCourse(String course){
    this.course = course;
}

public void setYear(String year){
    this.year = year;
}

public void setGender(String gender){
    this.gender = gender;
}

// ================= toString Method =================

@Override
public String toString(){
    return "Student ID: " + studentId + 
            "\nName : " + name +
            "\nAge :" + age +
            "\nCourse :" + course +
            "\nYear : "  + year +
            "\nGender : " + gender;
}



}


