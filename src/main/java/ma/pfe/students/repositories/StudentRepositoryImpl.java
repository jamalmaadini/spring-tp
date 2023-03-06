package ma.pfe.students.repositories;

import ma.pfe.students.entities.StudentEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



    @Service
    public class StudentRepositoryImpl implements  StudentRepository{

        private final Logger LOG = LoggerFactory.getLogger(ma.pfe.students.repositories.StudentRepositoryImpl.class);
        @Override
        public StudentEntity create(StudentEntity studentEntity) {
            LOG.debug("start method create");
            return new StudentEntity();
        }

        @Override
        public boolean update(StudentEntity studentEntity) {
            LOG.debug("start method update");
            return false;
        }

        @Override
        public boolean delete(Long id) {
            LOG.debug("start method delete");
            return false;
        }

        @Override
        public List<StudentEntity> readAll() {
            LOG.debug("start method read all");
            return new ArrayList<>();
        }
    }

