package com.elias.springcruddemo.repository;

import com.elias.springcruddemo.entity.Lesson;
import org.springframework.data.repository.CrudRepository;

public interface LessonRepository extends CrudRepository<Lesson, Long> {

}
