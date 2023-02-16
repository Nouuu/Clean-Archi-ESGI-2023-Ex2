package org.esgi.al.ex2.infra.io;

import org.esgi.al.ex2.domain.io.Input;

import java.util.Scanner;

public class CliInput implements Input {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String read() {
        return  scanner.nextLine().trim().toLowerCase();
    }

    @Override
    public void close() {
        this.scanner.close();
    }
}
