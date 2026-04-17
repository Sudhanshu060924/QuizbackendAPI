package com.quiz.quiz.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.quiz.quiz.entity.Quiz;


@Repository
public interface QuizRepo extends JpaRepository<Quiz, Long> {

    


   

}
