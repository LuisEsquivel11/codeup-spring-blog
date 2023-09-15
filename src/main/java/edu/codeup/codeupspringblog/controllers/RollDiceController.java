package edu.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;

@Controller

public class RollDiceController {

    @RequestMapping("/roll-dice")
    public String rollDice(Model model) {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String numberPicked(@PathVariable int n, Model model) {
        int randomNumber1 = (int) Math.floor(Math.random() *(6 - 1 + 1) + 1);
        int randomNumber2 = (int) Math.floor(Math.random() *(6 - 1 + 1) + 1);
        int randomNumber3 = (int) Math.floor(Math.random() *(6 - 1 + 1) + 1);
        int randomNumber4 = (int) Math.floor(Math.random() *(6 - 1 + 1) + 1);
        int randomNumber5 = (int) Math.floor(Math.random() *(6 - 1 + 1) + 1);
        int randomNumber6 = (int) Math.floor(Math.random() *(6 - 1 + 1) + 1);

        ArrayList<Integer> randoms = new ArrayList<Integer>();
        Collections.addAll(randoms,
                randomNumber1,
                randomNumber2,
                randomNumber3,
                randomNumber4,
                randomNumber5,
                randomNumber6);
        int correctGuesses = 0;
        for (int i = 0; i < randoms.size(); i++) {
            if (n == randoms.get(i)) {
                correctGuesses++;
            }
        }

    model.addAttribute("diceRolls", "Dice Rolls: " + randoms);
    model.addAttribute("youGuessed", "You guessed: ");
    model.addAttribute("guessedNumber",  n);
    model.addAttribute("correctGuesses", ("You got " + correctGuesses + " out of 6 correct"));
        return "roll-dice";
    }



}
