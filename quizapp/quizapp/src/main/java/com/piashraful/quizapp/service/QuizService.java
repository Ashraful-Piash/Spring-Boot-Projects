package com.piashraful.quizapp.service;

import com.piashraful.quizapp.dao.QuestionDao;
import com.piashraful.quizapp.dao.QuizDao;
import com.piashraful.quizapp.entity.Question;
import com.piashraful.quizapp.entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;



    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questionList = questionDao.findRandomQuestionsByCategory(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questionList); // Set associated questions

        quizDao.save(quiz); // Save the quiz along with associated questions

        return new ResponseEntity<>("Quiz created successfully", HttpStatus.CREATED);
    }
}

