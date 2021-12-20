package dtos;

public class ContestDTO {

    String level;
    String contestCreator;
    String name;

    public ContestDTO(String level, String contestCreator, String name) {
        this.level = level;
        this.contestCreator = contestCreator;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getContestCreator() {
        return contestCreator;
    }

    public void setContestCreator(String contestCreator) {
        this.contestCreator = contestCreator;
    }
}
