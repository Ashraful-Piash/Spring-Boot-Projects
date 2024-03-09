package com.piashraful.quizapp.service;

import com.piashraful.quizapp.dao.QuestionDao;
import com.piashraful.quizapp.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);

    }

    public List<Question> findQuestionByCategory(String category) {
        return questionDao.findByCategoryIgnoreCase(category);
    }


    public List<Question> findQuestionByDifficulty(String difficultyLevel) {
        return questionDao.findByDifficultyLevelIgnoreCase(difficultyLevel);
    }

    public ResponseEntity<List<String>>addQuestion(Question question) {
        try {
            questionDao.save(question);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public void deleteQuestionById(int id) {
        questionDao.deleteById(id);
    }
}
