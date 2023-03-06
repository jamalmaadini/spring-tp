package ma.pfe.students.controllers;

import ma.pfe.students.dtos.StudentDto;
import ma.pfe.students.services.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")

public class StudentController {

    private StudentService studentService;
    private final Logger LOG = LoggerFactory.getLogger(StudentController.class);

    public StudentController(StudentService studentService)
    {
        this.studentService = studentService;
    }

    @PostMapping
    public StudentDto save(@RequestBody StudentDto dto) {
        LOG.debug("start method save");
        StudentDto studentDto = studentService.create(dto);
        LOG.debug("end method save");
        return studentDto;
    }

    @PutMapping
    public boolean update(@RequestBody StudentDto dto) {
        LOG.debug("start method update");
        Boolean bool = studentService.update(dto);
        LOG.debug("end method update");
        return bool;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        LOG.debug("start method delete");
        Boolean bool = studentService.delete(id);
        LOG.debug("end method delete");
        return bool;
    }

    @GetMapping
    public List<StudentDto> readAll() {
        LOG.debug("start method read All");
        List<StudentDto> studentDtoList = studentService.readAll();
        LOG.debug("end method read All");
        return studentDtoList;
    }
}
