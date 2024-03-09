package com.piashraful.quizapp.controller;

import com.piashraful.quizapp.entity.Question;
import com.piashraful.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/add")
    public ResponseEntity<List<String>> addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> allQuestions() {
        return questionService.getAllQuestions();
    }


    @GetMapping("/allQuestions/category/{category}")
    public List<Question> findQuestionByCategory(@PathVariable("category") String category) {
        return questionService.findQuestionByCategory(category);
    }

    @GetMapping("/allQuestions/difficulty/{difficulty}")
    public List<Question> findQuestionByDifficulty(@PathVariable("difficulty") String difficultyLevel) {
        return questionService.findQuestionByDifficulty(difficultyLevel);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteQuestionById(@PathVariable("id") int id) {
        questionService.deleteQuestionById(id);

    }


}
