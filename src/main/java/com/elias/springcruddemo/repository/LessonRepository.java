package com.elias.springcruddemo.repository;

import com.elias.springcruddemo.entity.Lesson;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;

public interface LessonRepository extends CrudRepository<Lesson, Long> {
    Iterable<Lesson> findByTitle(String title);

//    @Query("SELECT l FROM LESSON where l.deliveredOn > {l.initialDate} AND l.deliveredOn < {l.finalDate}")
//    Iterable<Lesson> getByDeliveredOnBetween(LocalDateTime initialDate, LocalDateTime finalDate);

    @Query(value = "SELECT * FROM LESSON as u WHERE u.delivered_on between ?1 AND ?2", nativeQuery = true)
    Iterable<Lesson> findByStartDateBetween(LocalDateTime initialDate, LocalDateTime finalDate);
}
