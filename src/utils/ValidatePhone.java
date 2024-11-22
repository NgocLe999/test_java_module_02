package utils;

import service.IPhoneMatcher;

import java.util.regex.Pattern;

public class ValidatePhone implements IPhoneMatcher {

    private static final Pattern PATTERN = Pattern.compile("^(0[3|5|7|8|9])+([0-9]{8})$");

    @Override
    public boolean matches(long phone) {
        String phoneString = Long.toString(phone);
        return PATTERN.matcher(phoneString).matches();
    }
}
