package com.elias.springcruddemo.controller;

import com.elias.springcruddemo.entity.Lesson;
import com.elias.springcruddemo.repository.LessonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

