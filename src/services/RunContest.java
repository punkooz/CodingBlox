package services;

import entities.Contest;
import entities.Questions;
import entities.User;
import repositories.ContestRepo;
import repositories.UserRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RunContest {

    public void runContest(String command, ContestRepo contestRepo, UserRepo userRepo){
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

        if (!contest.getContestCreator().equals(userName)){
            System.out.println("Contest with ID: " + userName + ", is not the creator of the contest");
            return;
        }

        User user = userRepo.findUserByName(userName);

        HashMap<User, Integer> userScoreMap = contest.getUserScoreMap();

        for(Map.Entry<User, Integer> entry : userScoreMap.entrySet()){
            User u = entry.getKey();
            int score = entry.getValue();

            List<Questions> questions = generateQuestions(u, contest);

            for (Questions q : questions){
                score += q.getScore();
            }

            score += contest.getScore();

            u.updateScore(score);
            userRepo.saveUser(u);

            userScoreMap.put(u, score);

        }

        contest.setUserScoreMap(userScoreMap);

        contestRepo.saveContest(contest);
    }

    private List<Questions> generateQuestions(User user, Contest contest) {

        List<Questions> questionsList = contest.getQuestionsList();
        List<Questions> ans = new ArrayList<>();

        int size = questionsList.size();

        int numberOfQuestionsSolved = (int) Math.floor(Math.random() * size + 1);

        while(numberOfQuestionsSolved > 0){

            int questionNumber = (int) Math.floor(Math.random() * size);

            ans.add(questionsList.get(questionNumber));

            numberOfQuestionsSolved--;
        }

        return ans;
    }

}
