package utils;

import service.IEmailMatcher;

import java.util.regex.Pattern;

public class ValidateEmail implements IEmailMatcher {
    private static final Pattern PATTERN = Pattern.compile("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$");

    @Override
    public boolean matches(String email) {
        return PATTERN.matcher(email).matches();
    }
}
