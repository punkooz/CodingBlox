package repositories;

import dtos.ContestDTO;
import entities.Contest;

import java.util.HashMap;

public class ContestRepo {

    HashMap<Integer, Contest> contestMap;
    int count;

    public ContestRepo() {
        this.contestMap = new HashMap<>();
        this.count = 0;
    }

    public void save(String contestDetails, QuestionsRepo questionsRepo){

        String[] arr = contestDetails.split(" ");

        String contestName = arr[1];
        String contestCreator = arr[3];
        String level = arr[2];
        count++;
        Contest contest = new Contest(level, contestCreator, questionsRepo, contestName, count);
        contestMap.put(count, contest);
    }

    public Contest findContestById(int id){
        return contestMap.get(id);
    }

    public HashMap<Integer, Contest> getContestMap() {
        return contestMap;
    }

    public int getCount() {
        return count;
    }

    public void saveContest(Contest contest) {

        contestMap.put(contest.getId(), contest);

    }
}
