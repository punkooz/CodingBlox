package repositories;

import entities.Questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QuestionsRepo {

    HashMap<Integer, Questions> questionMap;
    int count;

    public QuestionsRepo(){
        this.questionMap = new HashMap<>();
        this.count = 0;
    }

    public void save(String level, int score){
        count++;
        Questions question = new Questions(level, score, count);
        questionMap.put(count, question);
    }

    public HashMap<Integer, Questions> getQuestionMap() {
        return questionMap;
    }

    public Questions findQuestionById(int id){
        return questionMap.get(id);
    }

}
