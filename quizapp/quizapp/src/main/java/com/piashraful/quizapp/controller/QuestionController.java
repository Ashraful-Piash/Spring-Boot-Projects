package com.piashraful.quizapp.controller;

import com.piashraful.quizapp.entity.Question;
import com.piashraful.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/allQuestions")
    public List<Question> allQuestions() {
        return questionService.getAllQuestions();
    }


   @GetMapping("/allQuestions/category/{category}")
    public List<Question> findQuestionByCategory(@PathVariable("category") String category){
        return questionService.findQuestionByCategory(category);
   }

   @GetMapping("/allQuestions/difficulty/{difficulty}")
    public List<Question> findQuestionByDifficulty(@PathVariable("difficulty") String difficultyLevel){
        return questionService.findQuestionByDifficulty(difficultyLevel);
   }



}
