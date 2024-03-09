package com.piashraful.quizapp.service;

import com.piashraful.quizapp.dao.QuestionDao;
import com.piashraful.quizapp.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionDao questionDao;

    public List<Question> getAllQuestions() {
        return questionDao.findAll();

    }

    public List<Question> findQuestionByCategory(String category) {
        return questionDao.findByCategoryIgnoreCase(category);
    }


    public List<Question> findQuestionByDifficulty(String difficultyLevel) {
        return questionDao.findByDifficultyLevelIgnoreCase(difficultyLevel);
    }
}
