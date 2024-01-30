package com.naresh.quizapp.service;

import com.naresh.quizapp.dao.QuestionDao;
import com.naresh.quizapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
     QuestionDao questionDao;
    public List<Question> getAllQuestions() {
        return  questionDao.findAll();
    }
    public Question addQuestion( Question question) {
        return questionDao.save(question);
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionDao.findByCategory(category);
    }
}
