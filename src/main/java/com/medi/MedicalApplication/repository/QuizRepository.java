package com.medi.MedicalApplication.repository;


import com.medi.MedicalApplication.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

    Quiz findByQuizId(Long quizId);

    void deleteByQuizId(Long quizId);

    Quiz findByQuizNo(Long quizNo);
}
