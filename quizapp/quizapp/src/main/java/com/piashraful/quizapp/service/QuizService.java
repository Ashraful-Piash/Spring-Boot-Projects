package com.piashraful.quizapp.service;

import com.piashraful.quizapp.dao.QuestionDao;
import com.piashraful.quizapp.dao.QuizDao;
import com.piashraful.quizapp.entity.Question;
import com.piashraful.quizapp.entity.QuestionWrapper;
import com.piashraful.quizapp.entity.Quiz;
import com.piashraful.quizapp.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionsFromDb = quiz.get().getQuestions();
        List<QuestionWrapper> questionForUser = new ArrayList<>();
        for(Question q : questionsFromDb){
            QuestionWrapper qW = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),
                    q.getOption2(),q.getOption3(),q.getOption4());
            questionForUser.add(qW);
        }

        return new ResponseEntity<>(questionForUser,HttpStatus.OK);


    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizDao.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int right =0;
        int i = 0;
        for(Response response : responses){
            if(response.getResponse().equals(questions.get(i).getRightAnswer()))
                right ++;
            i ++ ;
        }
        return new ResponseEntity<>(right,HttpStatus.OK);
    }
}

