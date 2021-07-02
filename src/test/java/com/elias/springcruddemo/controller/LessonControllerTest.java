package com.elias.springcruddemo.controller;
import com.elias.springcruddemo.entity.Lesson;
import com.elias.springcruddemo.repository.LessonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.transaction.annotation.Transactional;
import java.time.*;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class LessonControllerTest {
    @Autowired
    MockMvc mvc;

    @Autowired
    LessonRepository repository;

    @Test
    @Transactional
    @Rollback
    void getLessons() throws Exception {
        Lesson lesson = new Lesson();
        lesson.setTitle("Lou");
        repository.save(lesson);

        MockHttpServletRequestBuilder request = get("/lessons")
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(request)
                .andExpect(status().isOk());
    }

    @Test
    @Transactional
    @Rollback
    void getLessonsByTitle() throws Exception {
        Lesson lesson = new Lesson();
        lesson.setTitle("hello");
        LocalDateTime lt = LocalDateTime.now();
        lesson.setDeliveredOn(lt);

        repository.save(lesson);

        MockHttpServletRequestBuilder request = get("/lessons/find/hello")
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title", equalTo(lesson.getTitle() )));

    }

    @Test
    @Transactional
    @Rollback
    void testGetBetween() throws Exception {
        Lesson lesson = new Lesson();
        lesson.setTitle("Test1");
        LocalDateTime lt = LocalDateTime.of(2020,5,18,5,6);
        lesson.setDeliveredOn(lt);

        Lesson lesson2 = new Lesson();
        lesson2.setTitle("Test2");
        //2020-05-18T05:06
        LocalDateTime lt2 = LocalDateTime.of(2020,6,19,5,6);
        lesson2.setDeliveredOn(lt2);

        Lesson lesson3 = new Lesson();
        lesson3.setTitle("test 3");
        //2020-05-18T05:06
        LocalDateTime lt3 = LocalDateTime.of(2020,7,20,5,6);
        lesson3.setDeliveredOn(lt3);

        repository.save(lesson);
        repository.save(lesson2);
        repository.save(lesson3);

        MockHttpServletRequestBuilder request = get("/lessons/between?initialDate=2020-05-18T05:06&finalDate=2020-05-19T05:06")
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .equals(repository.findByStartDateBetween(lt,lt2).toString());

                System.out.println(repository.findByStartDateBetween(lt,lt2).toString());
                System.out.println(repository.findAll().toString());

    }
    @Test
    @Transactional
    @Rollback
    void updateLesson() throws Exception {
        Lesson lesson = new Lesson();
        lesson.setTitle("Lou");
        repository.save(lesson);
        //"{\"title\":\"lesson 2\"}"
        MockHttpServletRequestBuilder request = patch("/lessons/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"SQL\",\"deliveredOn\":\"2012-06-09\"}");
        this.mvc.perform(request)
                .andExpect(status().isOk());
//                .andExpect(jsonPath("$[0].id", equalTo(lesson.getId().intValue()) ));

    }

}