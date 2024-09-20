package com.amjath.guessthewors.guess_the._word.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Random;

@Service
@Scope("prototype")
public class GameService {



    private String randomlyChoosenWord;
    private String[] randomWords = {"father","mother","sister","brother","uncle","cousins","grandmother","grandfather"};
    private char[] allCharacterOfTheword;

    Random random = new Random();


    public GameService() {

        randomlyChoosenWord =randomWords[random.nextInt(randomWords.length)];
        System.out.println("Random chosen words is "+ randomlyChoosenWord);
        allCharacterOfTheword = new char[randomlyChoosenWord.length()];

    }

    @Override
    public String toString() {

        String ret = "";

        for(char c : allCharacterOfTheword){
            if(c== '\u0000'){
                ret = ret + "_";

            }
            else{
                ret = ret + c;
            }
            ret += ' ';
        }

        return ret;
    }

    public boolean addGuess(char guessedChar) {

        boolean isGuessCorrect = false;
          // We have to check if the  guessedChar (0) present inside thr randomlyChooseword(hello)
       for(int i=0;i< randomlyChoosenWord.length();i++) {
           if (guessedChar == randomlyChoosenWord.charAt(i)) {
               allCharacterOfTheword[i] = guessedChar;
               isGuessCorrect = true;
           }
       }
       return isGuessCorrect;
    }
}
