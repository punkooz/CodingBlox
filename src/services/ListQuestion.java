package services;

import entities.Questions;
import repositories.QuestionsRepo;

import java.util.Map;

public class ListQuestion {

    public void listQuestions(String command, QuestionsRepo questionsRepo){
        String[] arr = command.split(" ");
        if(arr.length == 1){
            for(Map.Entry<Integer, Questions> entry : questionsRepo.getQuestionMap().entrySet()){
                int id = entry.getKey();
                Questions q = entry.getValue();

                System.out.println("id = " + id + ", level = " + q.getLevel() + ", score = " + q.getScore());

            }
        }else{

            String inputLevel = arr[1];

            boolean found = false;

            for(Map.Entry<Integer, Questions> entry : questionsRepo.getQuestionMap().entrySet()){
                int id = entry.getKey();
                Questions q = entry.getValue();

                if(q.getLevel().equals(inputLevel)) {
                    found = !found;
                    System.out.println("id = " + id + ", level = " + q.getLevel() + ", score = " + q.getScore());
                }
            }

            if(!found)
                System.out.println("could not find a question with Level: " + inputLevel);

        }
    }

}
