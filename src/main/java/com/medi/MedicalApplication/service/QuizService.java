package com.medi.MedicalApplication.service;

import com.medi.MedicalApplication.model.Quiz;
import com.medi.MedicalApplication.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class QuizService {
    @Autowired
    private QuizRepository repository;
    //Post
    public Quiz saveQuiz(Quiz quiz) { return repository.save(quiz); }
    //save all
    public List<Quiz> saveQuizzes(List<Quiz> quizzes){
        return repository.saveAll(quizzes);
    }
    public List<Quiz> getQuizzes(){ return repository.findAll(); }
    public  Quiz getQuizByQuizId(Long quizId){ return repository.findByQuizId(quizId); }
    public Quiz getQuizByQuizNo(Long quizNo){ return repository.findByQuizNo(quizNo); }
    public Long deleteQuiz(Long quizId) {
        repository.deleteByQuizId(quizId);
        return Long.valueOf("quiz removed!! "+ quizId);
    }
    public Quiz updateQuiz(Quiz quiz) { Quiz exisitingQuiz = new Quiz();return repository.save(exisitingQuiz);}
}
