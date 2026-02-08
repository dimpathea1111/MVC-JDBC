package model.service;

import mapper.StudentMapper;
import model.dto.StudentCreateDto;
import model.dto.StudentResponseDto;
import model.dto.StudentUpdateDto;
import model.entities.Student;
import model.respository.StudentRepository;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository=new StudentRepository();
    private StudentMapper studentMapper=new StudentMapper();

    @Override
    public StudentResponseDto createStudent(StudentCreateDto studentCreateDto) {
        Student student=studentMapper.mapFromStudentCrateToStudent(
                studentCreateDto
        );
        studentRepository.save(student);
        return studentMapper.mapFormStudentToStudentResponseDto(
                student
        );
    }

    @Override
    public String deleteStudentByUuid(String uuid) {
        return "";
    }

    @Override
    public StudentResponseDto updateStudentByUuid(String uuid, StudentUpdateDto studentUpdateDto) {
        return null;
    }

    @Override
    public StudentResponseDto searchByUuid(String uuid) {
        return null;
    }

    @Override
    public List<StudentResponseDto> searchStudentByName(String name) {
        return List.of();
    }
}
