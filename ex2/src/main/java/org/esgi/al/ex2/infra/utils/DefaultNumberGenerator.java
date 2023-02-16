package org.esgi.al.ex2.infra.utils;

import org.esgi.al.ex2.domain.utils.NumberGenerator;

import java.util.Random;

public class DefaultNumberGenerator implements NumberGenerator {
    private final Random generator = new Random();

    @Override
    public int generateInt(int min, int max) {
        return generator.nextInt(min, max - min);
        //random.nextInt(max + 1 - min) + min
    }
}
