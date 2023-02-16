package org.esgi.al.ex2.domain;

import org.esgi.al.ex2.domain.io.Input;
import org.esgi.al.ex2.domain.io.Output;
import org.esgi.al.ex2.domain.utils.NumberParser;
import org.esgi.al.ex2.domain.state.GameState;

import java.util.Objects;

public class NumberGuesser {


    private final Output output;
    private final Input input;

    private final NumberParser numberParser;
    private final GameState gameState;

    private final boolean debug;

    public NumberGuesser(Output output, Input input, NumberParser numberParser, GameState gameState, boolean debug) {
        this.output = output;
        this.input = input;
        this.numberParser = numberParser;
        this.gameState = gameState;
        this.debug = debug;
    }

    public void play() {
        initGame();
        while (gameState.isPlaying()) {
            String userGuessStr = input.read();
            Integer userGuess = numberParser.parse(userGuessStr);
            gameState.incrementAttempts();

            if (userGuess == null) {
                output.display("Your input was '" + userGuessStr + "', please enter a valid integer. " + (gameState.remainingAttempts()) + "/" + gameState.maxAttempts() + " tries left");
                continue;
            }

            if (gameState.isCorrect(userGuess)) {
                win(gameState.attempts());
            } else if (!gameState.isRemainingAttempts()) {
                lose(gameState.maxAttempts(), gameState.numberToGuess());
            } else {
                String divergence = userGuess < gameState.numberToGuess() ? "smaller" : "greater";
                output.display("Wrong! Your number is " + divergence + " than the correct one. " + (gameState.remainingAttempts()) + "/" + gameState.maxAttempts() + " tries left");
            }

        }

    }

    private void initGame() {
        gameState.reset();
        output.display("Guess the number (between 1 and 100)!");
        if (debug) {
            output.display("debug : the expected number is " + gameState.numberToGuess());
        }
    }

    private void win(int attempts) {
        output.display("You found it after " + attempts + " tries!");
        promptRetry();
    }

    private void lose(int maxAttempts, int number) {
        output.display("You lose after " + maxAttempts + " tries, the expected number was " + number);
        promptRetry();
    }

    private void promptRetry() {
        output.display("----------------------------------------------------");
        output.display("Do you want to try again with a new number (yes/no)?");
        String userResponse = input.read();
        if (Objects.equals(userResponse, "yes")) {
            initGame();
        } else {
            endGame();
        }
    }

    private void endGame() {
        output.display("== Thanks for playing! ==");
        gameState.stopPlaying();
        input.close();
    }

    public void greet() {
        output.display("-===========================-");
        output.display("=== GUESS THE NUMBER GAME ===");
        output.display("-===========================-");
    }
}
