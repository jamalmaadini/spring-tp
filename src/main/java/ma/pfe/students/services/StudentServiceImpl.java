package ma.pfe.students.services;

import ma.pfe.students.dtos.StudentDto;
import ma.pfe.students.entities.StudentEntity;
import ma.pfe.students.mappers.StudentMapper;
import ma.pfe.students.repositories.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Profile({"local","prod"})
public class StudentServiceImpl implements StudentService {
    private final Logger LOG = LoggerFactory.getLogger(StudentServiceImpl.class);
    StudentRepository studentRepository;
    StudentMapper studentMapper ;

    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public StudentDto create(StudentDto studentDto) {

        LOG.debug("start method create {} ",studentDto);
        StudentEntity studentEntity = studentRepository.create(studentMapper.convertToEntity(studentDto));
        LOG.debug("end method create");
        return studentMapper.convertToDto(studentEntity);
    }

    @Override
    public boolean update(StudentDto studentDto) {

        LOG.debug("start method update");
        boolean bool = studentRepository.update(studentMapper.convertToEntity(studentDto));
        LOG.debug("end method create");
        return bool;
    }

    @Override
    public boolean delete(Long id) {

        LOG.debug("start method delete id {} ", id );
        boolean bool = studentRepository.delete(id);
        LOG.debug("end method delete");
        return bool;
    }

    @Override
    public List<StudentDto> readAll() {
        LOG.debug("start method read all");
        List<StudentDto> studentDtoList = studentMapper.convertToDto(studentRepository.readAll());
        LOG.debug("end method read all");
        return studentDtoList;
    }
}
