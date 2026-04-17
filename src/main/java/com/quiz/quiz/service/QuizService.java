package com.quiz.quiz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quiz.quiz.Repo.QuestionRepo;
import com.quiz.quiz.Repo.QuizRepo;
import com.quiz.quiz.entity.Answer;
import com.quiz.quiz.entity.Question;
import com.quiz.quiz.entity.QuestionWrapper;
import com.quiz.quiz.entity.Quiz;

@Service
public class QuizService {
    @Autowired
    QuizRepo quizRepo;


    @Autowired
    QuestionRepo questionRepo;
    

    public ResponseEntity<String> getQuiz(int numberOfQuestion, String title) {
        
        List<Question> questions = questionRepo.findRandomQues(numberOfQuestion); 
        Quiz quiz = new Quiz();
        quiz.setTittle(title);
        quiz.setQuestion(questions);
        quizRepo.save(quiz);
        return ResponseEntity.ok("Quiz created successfully with title: " + title);

    }


    public ResponseEntity<List<QuestionWrapper>> getQuizById(Long id) {
        Quiz quiz = quizRepo.findById(id).orElse(null);
        if (quiz == null) {
            return ResponseEntity.notFound().build();
        }
        List<Question> questions = quiz.getQuestion();
        List<QuestionWrapper> userQuestionWrappers = new ArrayList<>();
        for (Question question : questions) {
            QuestionWrapper userQuestionWrapper = new QuestionWrapper(question.getId(), question.getQuestionText(), question.getOptionA(), question.getOptionB(), question.getOptionC(), question.getOptionD());
            userQuestionWrappers.add(userQuestionWrapper);
        }
        return new ResponseEntity<>(userQuestionWrappers , HttpStatus.OK);
    }



    public ResponseEntity<Integer> calculateResult(Long id, List<Answer> answers) {
       Quiz quiz = quizRepo.findById(id).orElse(null);
       if(quiz == null) {
        return ResponseEntity.notFound().build();
       }
       List<Question> questions = quiz.getQuestion(); 
         int score = 0;
         int i =0;
         for(Answer answer : answers) {
            if(answer.getSelectedOption().equals(questions.get(i).getCorrectAnswer())){
                score++;
            }
            i++;
            
        
         }
         return new ResponseEntity<>(score , HttpStatus.OK);

    
    }


}
