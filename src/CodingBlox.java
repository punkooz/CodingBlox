import controllers.ContestController;

public class CodingBlox {

    public static void main(String[] args){
        ContestController contestController = new ContestController();

        //create users
        contestController.createUser("Ross");
        contestController.createUser("Monica");
        contestController.createUser("Joey");
        contestController.createUser("Chandler");

        //create questions
        contestController.createQuestions("CreateQuestion LOW 10");


        //create contests
        contestController.createContest("CreateContest diwali_contest LOW Ross");

        //operations
        contestController.contestQuestionsUsers("ListContest LOW");
        contestController.contestQuestionsUsers("ListContest");
        contestController.contestQuestionsUsers("ListQuestion");
        contestController.contestQuestionsUsers("AttendContest 1 Monica");
        contestController.contestQuestionsUsers("AttendContest 1 Joey");
        contestController.contestQuestionsUsers("RunContest 1 Ross");
        contestController.contestQuestionsUsers("LeaderBoard score desc");


    }

}