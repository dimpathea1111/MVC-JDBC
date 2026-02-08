package model.respository;

import model.entities.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
   private final String dbUrl="jdbc:postgresql://localhost:5432/school_db";
   private final String username="postgres";
   private final  String password="123";
//    private  List<Student> students=new ArrayList<>();

    public List<Student> findAll(){
        String sql= """
                SELECT * FROM students;
                """;

        try(Connection connection= DriverManager.getConnection(
                dbUrl,username,password
        )){
//            Statement statement=connection.prepareStatement(sql);
//            ResultSet resultSet=statement.getResultSet();
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("uuid"));
                System.out.println(resultSet.getString("user_name"));
            }
            System.out.println("Connection to database successfully" );
        }catch (Exception exception){
            System.out.println("Error in fetching all students from"+exception.getMessage());


        }

        return  null;
//        return this.students;

    }

    public Student save(Student student){

        return student;
//        students.add(student);
    }

    public Student findById(Integer id){

        return null;
//        return this.students.stream()
//                .filter(s->s.getId().equals(id))
//                .findFirst().get();
    }

    public int delete(Student student){


        return 1;
        //        students.remove(student);
//        return 1;
    }

    public Student update(Student student){
//        ...
        return student;
    }

}
