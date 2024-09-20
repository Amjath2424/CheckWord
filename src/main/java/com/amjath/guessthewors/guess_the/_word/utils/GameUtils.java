package com.amjath.guessthewors.guess_the._word.utils;

import com.amjath.guessthewors.guess_the._word.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class GameUtils {

    @Autowired
    ConfigurableApplicationContext applicationContext;

    private int MAX_TRIES = 5;

    public int reduceTry(){

        MAX_TRIES -= 1;
        return MAX_TRIES;

    }



    public int getTriesRemaining(){

        return MAX_TRIES;
    }

    public void restTries(){

        MAX_TRIES =5;
    }
    public GameService reload(){
        GameService gameService = applicationContext.getBean(GameService.class);

        return gameService;
    }


}
