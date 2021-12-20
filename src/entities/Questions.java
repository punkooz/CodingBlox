package entities;

public class Questions {

    String level;
    int score;
    int id; //TODO: how to use autoincrement ID?

    public Questions(String level, int score, int count) {
        this.level = level;
        this.score = score;
        this.id = count;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
