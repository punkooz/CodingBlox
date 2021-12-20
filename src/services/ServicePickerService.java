package services;

import repositories.ContestRepo;
import repositories.QuestionsRepo;
import repositories.UserRepo;

public class ServicePickerService {

    public void runService(String command, UserRepo userRepo, ContestRepo contestRepo, QuestionsRepo questionsRepo){

        String[] arr = command.split(" ");

        switch (arr[0]){
            case "ListQuestion":
                ListQuestion listQuestion = new ListQuestion();
                listQuestion.listQuestions(command, questionsRepo);
                break;
            case "ListContest":
                ListContests listContests = new ListContests();
                listContests.listContests(command, contestRepo);
                break;
            case "AttendContest":
                AttendContest attendContest = new AttendContest();
                attendContest.attendContests(command, contestRepo, userRepo);
                break;
            case "RunContest":
                RunContest runContest = new RunContest();
                runContest.runContest(command, contestRepo, userRepo);
                break;
            case "LeaderBoard":
                LeaderBoard leaderBoard = new LeaderBoard();
                leaderBoard.showBoard(command, userRepo);
                break;
            default:
                System.out.println("Service is yet to be built");

        }


    }

}
