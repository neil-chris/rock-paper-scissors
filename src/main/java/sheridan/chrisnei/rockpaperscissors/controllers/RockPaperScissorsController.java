package sheridan.chrisnei.rockpaperscissors.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sheridan.chrisnei.rockpaperscissors.domain.Choice;
import sheridan.chrisnei.rockpaperscissors.domain.Player;
import sheridan.chrisnei.rockpaperscissors.domain.Result;

import java.util.Random;

@Controller
@Slf4j
@RequestMapping("/rockpaperscissors")
public class RockPaperScissorsController {

    /**
     * Displays the page to play the game
     * @param model
     * @return the view name
     */
    @GetMapping()
    public String play(Model model) {
        log.info("Invoked RockPaperScissorsController.play()");
        model.addAttribute("player", new Player());
        return "play";
    }

    /**
     * Performs the necessary actions to decide the winner and then dislays the result of the game
     * @param player the player of the game
     * @param model
     * @return the view name
     */
    @PostMapping()
    public String results(@ModelAttribute Player player, Model model) {
        log.info("Invoked RockPaperScissorsController.results()");

        Player human = (Player) model.getAttribute("player");
        Player computer = new Player(makeComputerChoice(), Player.Type.COMPUTER);

        Result result = new Result();
        result.getPlayers().add(human);
        result.getPlayers().add(computer);
        result.setWinner(decideWinner(human, computer));

        model.addAttribute("results", result);

        return "results";
    }

    //makes a random choice for the computer
    private Choice makeComputerChoice() {
        log.info("Invoked RockPaperScissorsController.makeComputerChoice()");
        int validChoices = Choice.values().length;
        Choice[] choices = Choice.values();
        int choice = new Random().nextInt(choices.length);
        return choices[choice];
    }

    //decides the winner of the game
    private Player decideWinner(Player human, Player computer) {
        log.info("Invoked RockPaperScissorsController.decideWinner()");
        if(human.getChoice().equals(Choice.PAPER) && computer.getChoice().equals(Choice.ROCK)) {
            return human;
        }

        if(human.getChoice().equals(Choice.PAPER) && computer.getChoice().equals(Choice.SCISSORS)) {
            return computer;
        }

        if(human.getChoice().equals(Choice.ROCK) && computer.getChoice().equals(Choice.SCISSORS)) {
            return human;
        }

        if(human.getChoice().equals(Choice.ROCK) && computer.getChoice().equals(Choice.PAPER)) {
            return computer;
        }

        if(human.getChoice().equals(Choice.SCISSORS) && computer.getChoice().equals(Choice.ROCK)) {
            return computer;
        }

        if(human.getChoice().equals(Choice.SCISSORS) && computer.getChoice().equals(Choice.PAPER)) {
            return human;
        }

        return null; //return null if its a draw
    }
}
