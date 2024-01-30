package com.naresh.quizapp.controller;

import com.naresh.quizapp.model.Question;
import com.naresh.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        try{
            return new ResponseEntity<>(questionService.getAllQuestions(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
    @PostMapping("/addQuestion")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question){
        return new ResponseEntity<>( questionService.addQuestion(question), HttpStatus.CREATED);
    }
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return new ResponseEntity<>( questionService.getQuestionsByCategory(category),HttpStatus.OK);

    }
}
