package org.esgi.al.ex2.domain.state;

import org.esgi.al.ex2.domain.utils.NumberGenerator;

public class GameState {
    private final int maxAttempts;

    private final NumberGenerator numberGenerator;
    private int attempts;

    private int numberToGuess;

    private boolean isWin;

    private boolean isPlaying;

    public GameState(int maxAttempts, NumberGenerator numberGenerator) {
        this.maxAttempts = maxAttempts;
        this.numberGenerator = numberGenerator;
        attempts = 0;
        isWin = false;
        isPlaying = true;
    }

    public void reset() {
        isPlaying = true;
        attempts = 0;
        numberToGuess = numberGenerator.generateInt(1, 100);
    }

    public void stopPlaying() {
        isPlaying = false;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public boolean isRemainingAttempts() {
        return attempts < maxAttempts;
    }

    public void incrementAttempts() {
        attempts++;
    }

    public int attempts() {
        return attempts;
    }

    public int maxAttempts() {
        return maxAttempts;
    }

    public int remainingAttempts() {
        return maxAttempts - attempts;
    }

    public int numberToGuess() {
        return numberToGuess;
    }

    public boolean isCorrect(int guess) {
        isWin = guess == numberToGuess;
        return isWin;
    }
}
