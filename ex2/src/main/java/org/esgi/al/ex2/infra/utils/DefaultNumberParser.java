package org.esgi.al.ex2.infra.utils;

import org.esgi.al.ex2.domain.utils.NumberParser;

public class DefaultNumberParser implements NumberParser {
    @Override
    public Integer parse(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
