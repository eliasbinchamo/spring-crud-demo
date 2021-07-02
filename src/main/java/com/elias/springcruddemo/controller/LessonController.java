package com.elias.springcruddemo.controller;

import com.elias.springcruddemo.entity.Lesson;
import com.elias.springcruddemo.repository.LessonRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class LessonController {

    private final LessonRepository lessonRepository;
    LessonController(LessonRepository lessonRepository){
        this.lessonRepository = lessonRepository;
    }
    @GetMapping("/lessons")
    public Iterable<Lesson> getLessons(){
        return this.lessonRepository.findAll();
    }
    @GetMapping("/lessons/find/{title}")
    public Iterable<Lesson> findLessonByTitle(@PathVariable String title){
        return this.lessonRepository.findByTitle(title);
    }
    @PatchMapping("/lessons/{id}")
    public void updateLesson(@RequestBody Lesson body, @PathVariable Long id){
        Lesson lesson = this.lessonRepository.findById(id).get();
        lesson.setTitle(body.getTitle());
        this.lessonRepository.save(lesson);
    }
    @PostMapping("/addItems")
    public Iterable<Lesson> addLessons(@RequestBody List<Lesson> body){
        return this.lessonRepository.saveAll(body);
    }
    @GetMapping("/lessons/between")
    public Iterable<Lesson> getBetween(@RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime initialDate, @RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime finalDate) throws Exception{
        return lessonRepository.findByStartDateBetween(initialDate, finalDate);
    }

}

