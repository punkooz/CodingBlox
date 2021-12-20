package controllers;

import dtos.ContestDTO;
import entities.Questions;
import entities.User;
import repositories.ContestRepo;
import repositories.QuestionsRepo;
import repositories.UserRepo;
import services.ServicePickerService;

public class ContestController {

    ContestRepo contestRepo = new ContestRepo();
    QuestionsRepo questionsRepo = new QuestionsRepo();
    UserRepo userRepo = new UserRepo();

    ServicePickerService servicePickerService = new ServicePickerService();

    public void createContest(String contestDTO){
        contestRepo.save(contestDTO, questionsRepo);
    }

    public void createQuestions(String command){

        String[] arr = command.split(" ");

        questionsRepo.save(arr[1], Integer.parseInt(arr[2]));
    }

    public void createUser(String user){
        userRepo.save(user);
    }

    public void contestQuestionsUsers(String command){
        servicePickerService.runService(command,userRepo, contestRepo, questionsRepo);
    }

}
