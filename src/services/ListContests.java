package services;

import entities.Contest;
import entities.Questions;
import repositories.ContestRepo;
import repositories.QuestionsRepo;

import java.util.Map;

public class ListContests {

    public void listContests(String command, ContestRepo contestRepo){
        String arr[] = command.split(" ");
        if(arr.length == 1){
            for(Map.Entry<Integer, Contest> entry : contestRepo.getContestMap().entrySet()){
                int id = entry.getKey();
                Contest contest = entry.getValue();

                System.out.println("id = " + id + ", level = " + contest.getLevel() + ", score = " + contest.getScore());

            }
        }else{

            String inputLevel = arr[1];

            boolean found = false;

            for(Map.Entry<Integer, Contest> entry : contestRepo.getContestMap().entrySet()){
                int id = entry.getKey();
                Contest contest = entry.getValue();

                if(contest.getLevel().equals(inputLevel)) {
                    found = !found;
                    System.out.println("id = " + id + ", level = " + contest.getLevel() + ", score = " + contest.getScore());
                }
            }



            if(!found)
                System.out.println("could not find a contest with Level: " + inputLevel);

        }
    }

}
