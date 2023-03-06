package ma.pfe.students.services;

import ma.pfe.students.dtos.StudentDto;

import java.util.List;

public interface StudentService {

    StudentDto create(StudentDto studentEntity);
    boolean update(StudentDto studentEntity);
    boolean delete(Long id);
    List<StudentDto> readAll();
}




