package mapper;

import model.dto.StudentCreateDto;
import model.dto.StudentResponseDto;
import model.entities.Student;

import java.util.Random;
import java.util.UUID;

public class StudentMapper {
    public Student mapFromStudentCrateToStudent(
            StudentCreateDto studentCreateDto
    ){
        Student student=new Student();
        student.setId(new Random().nextInt(999999));
        student.setUuid(UUID.randomUUID().toString());
        student.setUserName(studentCreateDto.userName());
        student.setEmail(studentCreateDto.email());
        student.setPassword(studentCreateDto.password());
        student.setProfile(null);
        student.setBirthOfDate(studentCreateDto.birthOfDate());
        return student;
    }

    public StudentResponseDto mapFormStudentToStudentResponseDto(
            Student student
    ){
        StudentResponseDto studentResponseDto=new StudentResponseDto(
                student.getUuid(),
                student.getUserName(),
                student.getEmail(),
                student.getProfile(),
                student.getCardId(),
                student.getBirthOfDate()
        );
        return studentResponseDto;
    }













}
