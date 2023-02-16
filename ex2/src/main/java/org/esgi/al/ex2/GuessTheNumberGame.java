package org.esgi.al.ex2;

import org.esgi.al.ex2.domain.state.GameState;
import org.esgi.al.ex2.domain.NumberGuesser;
import org.esgi.al.ex2.infra.io.CliInput;
import org.esgi.al.ex2.infra.io.CliOutput;
import org.esgi.al.ex2.infra.utils.DefaultNumberGenerator;
import org.esgi.al.ex2.infra.utils.DefaultNumberParser;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        boolean debug = true;

        GameState gameState = new GameState(
                10,
                new DefaultNumberGenerator()
        );

        NumberGuesser numberGuesser = new NumberGuesser(
                new CliOutput(),
                new CliInput(),
                new DefaultNumberParser(),
                gameState,
                debug);

        numberGuesser.greet();
        numberGuesser.play();
    }
}
