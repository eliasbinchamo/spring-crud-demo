package com.elias.springcruddemo.controller;

import com.elias.springcruddemo.entity.Lesson;
import com.elias.springcruddemo.repository.LessonRepository;
import org.springframework.web.bind.annotation.*;

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
    @PatchMapping("/lessons/{id}")
    public void updateLesson(@RequestBody Lesson body, @PathVariable Long id){
        Lesson lesson = this.lessonRepository.findById(id).get();
        lesson.setTitle(body.getTitle());
        this.lessonRepository.save(lesson);
    }

}

