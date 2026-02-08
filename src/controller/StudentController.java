package controller;

import model.dto.StudentCreateDto;
import model.dto.StudentResponseDto;
import model.service.StudentService;
import model.service.StudentServiceImpl;

public class StudentController {
    private StudentService studentServic=new StudentServiceImpl();
    public StudentResponseDto createNewStudent(
            StudentCreateDto studentCreateDto
    ){
    return studentServic.createStudent(studentCreateDto);
    }
}
