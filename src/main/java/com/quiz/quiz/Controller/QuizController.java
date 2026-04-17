package com.quiz.quiz.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.quiz.entity.Answer;
import com.quiz.quiz.entity.QuestionWrapper;
import com.quiz.quiz.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    @PostMapping("/{numberOfQuestion}/{title}")
    public ResponseEntity<String> getQuiz(@PathVariable int numberOfQuestion , @PathVariable String title) {
        return quizService.getQuiz(numberOfQuestion,title);
    }


    @GetMapping("/getquiz/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizById(@PathVariable Long id) {
        return quizService.getQuizById(id);
    }

    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Long id , @RequestBody List<Answer> answers) {
        return quizService.calculateResult(id, answers);
    }
}
