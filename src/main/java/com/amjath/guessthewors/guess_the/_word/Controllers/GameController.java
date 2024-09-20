package com.amjath.guessthewors.guess_the._word.Controllers;


import com.amjath.guessthewors.guess_the._word.service.GameService;
import com.amjath.guessthewors.guess_the._word.utils.GameUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
 public class GameController {
    @Autowired
    private GameService gameService;


    @Autowired
    private GameUtils gameUtils;

    @GetMapping("/game-home")
    public String showGameHomePage(@RequestParam(value = "guessedChar", required = false) String guessedChar, Model model) {
        System.out.println("Captured guess word is " + guessedChar);

        String randomWord = gameService.toString(); //Father


        if (guessedChar != null) {
            boolean isGuessCorrect = gameService.addGuess(guessedChar.charAt(0));
            randomWord = gameService.toString();
            if(isGuessCorrect ==   false)
            {
                 gameUtils.reduceTry();

            }
        }
        System.out.println("numbers of tries remaining: " + gameUtils.getTriesRemaining());
        model.addAttribute("wordToDisplay", randomWord);
        model.addAttribute("triesLeft",gameUtils.getTriesRemaining());

        return "game-home-page";
    }

    @GetMapping("/reload")
    public String reloadGame(){
        gameService = gameUtils.reload();

        gameUtils.restTries();

        return "redirect:/game-home";
    }


}


