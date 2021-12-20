package entities;

public class User {

    String name;
    int score;

    public User(String name) {
        this.name = name;
        setScore(1500);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public void updateScore(int score) {

        this.score += score;

    }
}
