package model.service;

import model.dto.StudentCreateDto;
import model.dto.StudentResponseDto;
import model.dto.StudentUpdateDto;
import model.entities.Student;

import java.util.List;

public interface StudentService {
    StudentResponseDto createStudent(StudentCreateDto studentCreateDto);
    String deleteStudentByUuid(String uuid);
    StudentResponseDto updateStudentByUuid(String uuid, StudentUpdateDto studentUpdateDto);
    StudentResponseDto searchByUuid(String uuid);
    List<StudentResponseDto> searchStudentByName(String name);
}
