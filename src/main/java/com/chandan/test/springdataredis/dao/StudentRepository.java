package com.chandan.test.springdataredis.dao;

import com.chandan.test.springdataredis.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by chandan on 6/4/18.
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, String> {}
