package org.esgi.al.ex2.infra.io;

import org.esgi.al.ex2.domain.io.Output;

public class CliOutput implements Output {
    @Override
    public void display(String message) {
        System.out.println(message);
    }
}
