package services;

import entities.User;
import repositories.UserRepo;

import java.util.*;

public class LeaderBoard {

    public void showBoard(String command, UserRepo userRepo){

        String[] arr = command.split(" ");

        List<User> userList = new ArrayList<>();

        HashMap<String, User> userMap = userRepo.getUserMap();

        for(Map.Entry<String, User> entry : userMap.entrySet()){
            userList.add(entry.getValue());
        }

        if (arr[2].equals("desc"))
        userList.sort((o1, o2) -> {
            if (o1.getScore() < o2.getScore())
                return -1;
            else if (o1.getScore() > o2.getScore())
                return 1;

            return 0;
        });
        else
            userList.sort((o1, o2) -> {
                if (o1.getScore() < o2.getScore())
                    return 1;
                else if (o1.getScore() > o2.getScore())
                    return -1;

                return 0;
            });



        for (User u : userList){
            System.out.println(u.getName() + " : " + u.getScore());
        }

    }

}
