package utilities;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

import static java.time.temporal.ChronoUnit.HOURS;

public class Generator {

    private static final String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final Random rnd = new Random();
    private static final String NUMERIC = "123456789";

    public static String getRandomAlphaCharacters(int len) {
        return getRandomStringFromString(len, ALPHA);
    }

    public static String getRandomNumericCharacters(int len) {
        return getRandomStringFromString(len, NUMERIC);
    }

    private static String getRandomStringFromString(int len, String str) {
        if (len < 0) {
            len = 0;
        }
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(str.charAt(rnd.nextInt(str.length())));
        }
        return sb.toString();
    }

}
