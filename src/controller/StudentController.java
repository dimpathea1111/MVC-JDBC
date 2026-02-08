package controller;

import model.dto.StudentCreateDto;
import model.dto.StudentResponseDto;
import model.service.StudentService;
import model.service.StudentServiceImpl;

import java.util.List;

public class StudentController {
    private StudentService studentServic=new StudentServiceImpl();
    public StudentResponseDto createNewStudent(
            StudentCreateDto studentCreateDto
    ){
    return studentServic.createStudent(studentCreateDto);
    }

    public List<StudentResponseDto> getAllStudents(){
        return studentServic.getAllStudent();
    }

    public StudentResponseDto getByUuid(String uuid){
        return  studentServic.searchByUuid(uuid);
    }
    public String deleteByUuid(String uuid){
        return studentServic.deleteStudentByUuid(uuid);
    }
}

