package services;

import entities.Contest;
import entities.User;
import repositories.ContestRepo;
import repositories.UserRepo;

import java.util.HashMap;
import java.util.Map;

public class AttendContest {

    public void attendContests(String command, ContestRepo contestRepo, UserRepo userRepo){
        String arr[] = command.split(" ");

        int contestId = Integer.parseInt(arr[1]);

        if (!contestRepo.getContestMap().containsKey(contestId)){
            System.out.println("Contest with ID: " + contestId + ", does not exist");
            return;
        }

        Contest contest = contestRepo.findContestById(contestId);

        if (contest.isCompleted()){
            System.out.println("Contest with ID: " + contestId + ", is already Completed");
            return;
        }else if (contest.isStarted()){
            System.out.println("Contest with ID: " + contestId + ", is already started");
            return;
        }

        String userName = arr[2];

        if (!userRepo.getUserMap().containsKey(userName)){
            System.out.println("Contest with ID: " + userName + ", does not exist");
            return;
        }

        User user = userRepo.findUserByName(userName);

        HashMap<User, Integer> userScoreMap = contest.getUserScoreMap();

        userScoreMap.put(user, 0);

        contest.setUserScoreMap(userScoreMap);

        contestRepo.saveContest(contest);
    }

}
