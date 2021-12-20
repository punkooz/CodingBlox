package entities;

import repositories.QuestionsRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Contest {

    String name;
    String level;
    String contestCreator;
    int score;
    List<Questions> questionsList;
    int id;
    HashMap<User, Integer> userScoreMap;
    boolean completed;
    boolean started;

    public Contest(String level, String contestCreator, QuestionsRepo questionsRepo, String name, int id) {
        this.level = level;
        this.contestCreator = contestCreator;
        setQuestionsList(level, questionsRepo);
        setScore(level);
        this.name = name;
        this.id = id;
        this.userScoreMap = new HashMap<>();
        this.completed = false;
        this.started = false;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setContestCreator(String contestCreator) {
        this.contestCreator = contestCreator;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setQuestionsList(List<Questions> questionsList) {
        this.questionsList = questionsList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HashMap<User, Integer> getUserScoreMap() {
        return userScoreMap;
    }

    public void setUserScoreMap(HashMap<User, Integer> userScoreMap) {
        this.userScoreMap = userScoreMap;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getLevel() {
        return level;
    }

    public String getContestCreator() {
        return contestCreator;
    }

    public int getScore() {
        return score;
    }

    public void setScore(String score) {

        switch (score){
            case "LOW":
                this.score = -50;
                break;
            case "MEDIUM":
                this.score = -30;
                break;
            default:
                this.score = 0;
        }

    }

    public List<Questions> getQuestionsList() {
        return questionsList;
    }

    public void setQuestionsList(String level, QuestionsRepo questionsRepo) {

        questionsList = new ArrayList<>();

        for(Map.Entry<Integer, Questions> entry : questionsRepo.getQuestionMap().entrySet()){

            Questions q = entry.getValue();

            if (q.getLevel().equals(level)){
                questionsList.add(q);
            }

        }

    }
}
