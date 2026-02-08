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
        Student student=studentRepository
                .findAll().stream()
                .filter(s->s.getUuid().equals(uuid))
                .findFirst().get();
        return String.valueOf(studentRepository.delete(student));
    }

    @Override
    public StudentResponseDto updateStudentByUuid(String uuid, StudentUpdateDto studentUpdateDto) {
        Student student=studentRepository
                .findAll().stream()
                .filter(s->s.getUuid().equals(uuid))
                .findFirst().get();
        student.setProfile(studentUpdateDto.profile());
        student.setUserName(studentUpdateDto.userName());
        student.setEmail(studentUpdateDto.email());
        student.setBirthOfDate((studentUpdateDto.birthOfDate()));
        studentRepository.update(student);

        return null;
    }

    @Override
    public StudentResponseDto searchByUuid(String uuid) {
        Student student=studentRepository
                .findAll().stream()
                .filter(s->s.getUuid().equals(uuid))
                .findFirst().get();



        return studentMapper.mapFormStudentToStudentResponseDto(
                studentRepository.findById(
                        student.getId()
                )
        );
    }

    @Override
    public List<StudentResponseDto> searchStudentByName(String name) {
        return List.of();
    }

    @Override
    public List<StudentResponseDto> getAllStudent() {
        return List.of();
    }
}
