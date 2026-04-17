package com.quiz.quiz.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
// import org.springframework.web.bind.annotation.PathVariable;

import com.quiz.quiz.entity.Question;



@Repository
public interface QuestionRepo extends JpaRepository<Question, Long> {

    
    @Query(value = "SELECT * FROM question ORDER BY RAND() LIMIT :numberOfQuestion", nativeQuery = true)
    List<Question> findRandomQues(@Param("numberOfQuestion") int numberOfQuestion);

}
