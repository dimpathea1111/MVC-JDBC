package model.respository;

import model.entities.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
   private final String dbUrl="jdbc:postgresql://localhost:5432/school_db";
   private final String username="postgres";
   private final  String password="123";
//    private  List<Student> students=new ArrayList<>();

    public List<Student> findAll(){
        String sql= """
                SELECT * FROM students WHERE id=?;
                """;

        try(Connection connection= DriverManager.getConnection(
                dbUrl,username,password
        )){
//            Statement statement=connection.prepareStatement(sql);
//            ResultSet resultSet=statement.getResultSet();
//            Statement statement=connection.createStatement();
//            ResultSet resultSet=statement.executeQuery(sql);
//            while (resultSet.next()){
//                System.out.println(resultSet.getInt("id"));
//                System.out.println(resultSet.getString("uuid"));
//                System.out.println(resultSet.getString("user_name"));
//            }
//            System.out.println("Connection to database successfully" );


//            Statement statement=connection.createStatement();
            PreparedStatement statement=connection.prepareStatement(sql);
            ResultSet resultSet=statement.executeQuery(sql);
//            List<Student>students=new ArrayList<>();
            Student student=new Student();
            while (resultSet.next()){
//                Student student=new Student();
                student.setId(resultSet.getInt("id"));
                student.setUuid(resultSet.getString("uuid"));
                student.setUuid(resultSet.getString("email"));
                student.setUuid(resultSet.getString("profile"));
                student.setUuid(resultSet.getString("card_id"));
                student.setBirthOfDate(resultSet.getDate("birth_of_date").toLocalDate());




            }
        }catch (Exception exception){
            System.out.println("Error in fetching students  by ID from database"+exception.getMessage());


        }

        return  null;
//        return this.students;

    }

    public Student save(Student student){

            String sql= """
                    INSERT INTO students(uuid, user_name, email, password, card_id, profile)
                    VALUE(?,?,?,?,?,?,?)
                    """;

            try(Connection connection=DriverManager.getConnection(dbUrl, username,password)) {
                PreparedStatement statement=connection.prepareStatement(sql);
                statement.setString(1, student.getUuid());
                statement.setString(2, student.getUserName());
                statement.setString(3, student.getEmail());
                statement.setString(4, student.getProfile());
                statement.setString(4, student.getCardId());
                statement.setDate(6, Date.valueOf(student.getBirthOfDate()));
                int rowAffected=statement.executeUpdate();
                if(rowAffected>0){
                    System.out.println("New student has been added");
                    return  student;
                }else {
                    System.out.println("Insert new student failed");
                }


            }catch (Exception exception){
                System.out.println("Error during insert student data: "+exception.getMessage());
            }
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

            String sql="DELETE FROM students WHERE id=?";
            student.getId();
        return 1;

    }

    public Student update(Student student){
//        ...
        String sql= """
                UPDATE students
                SET profile=?,....
                WHERE id=?
                """;
        student.getId();
        return null;
    }

}
