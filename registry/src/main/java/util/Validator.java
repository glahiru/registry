package util;

import registry.Id;

import java.util.regex.Pattern;

/**
 * All request validation can be implemented here.
 */
public class Validator {
    private static final String SSN_REGEX = "^(?!666|000|9\\d{2})\\d{3}"
            + "-(?!00)\\d{2}-"
            +"(?!0{4})\\d{4}$";
    private static final Pattern SSN_MATCHER = Pattern.compile(SSN_REGEX);
    public static boolean isValid(Id id) {
        return id.getSocialSecurityNumber() != null
                && SSN_MATCHER.matcher(id.getSocialSecurityNumber()).matches();
    }
}
