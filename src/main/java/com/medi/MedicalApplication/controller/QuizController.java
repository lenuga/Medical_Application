package com.medi.MedicalApplication.controller;

import com.medi.MedicalApplication.model.Quiz;
import com.medi.MedicalApplication.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping
@CrossOrigin
public class QuizController {
    @Autowired
    private QuizService service;

    @PostMapping("/addquiz")
    public Quiz addQuiz(@RequestBody Quiz quiz) { return service.saveQuiz(quiz); }
    @PostMapping("/addQuizzes")
    public List<Quiz> addQuizzes(@RequestBody List<Quiz> quizzes) {
        return service.saveQuizzes(quizzes);
    }
    @GetMapping("/quizzes")
    public List<Quiz> findAllQuizzes(){
        return service.getQuizzes();
    }
    @GetMapping("/quizById/{id}")
    public Quiz findByQuizId(@PathVariable(value="id") Long quizId) {return service.getQuizByQuizId(quizId);}
    @GetMapping("/quiz/{no}")
    public Quiz findByQuizNo(@PathVariable(value = "no") Long quizNo) {return service.getQuizByQuizNo(quizNo); }
    @PutMapping("/update")
    public Quiz updateQuiz(@RequestBody Quiz quiz){
        return service.updateQuiz(quiz);
    }
    @DeleteMapping("/delete/{id}")
    public Long deleteQuiz(@PathVariable Long id) { return service.deleteQuiz(id); }
}
