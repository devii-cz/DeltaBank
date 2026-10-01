package account;

import java.util.Random;

public class ANG {
    private static final String BANK_CODE = "6767";
    private static final int[] WEIGHTS = {6, 3, 7, 9, 10, 5, 8, 4, 2};
    private static final Random RANDOM = new Random();

    public static String generate() {
        while (true) {
            int baseNumber = 100_000_000 + RANDOM.nextInt(900_000_000);
            String baseStr = String.valueOf(baseNumber);

            int sum = 0;
            for (int i = 0; i < 9; i++) {
                sum += (baseStr.charAt(i) - '0') * WEIGHTS[i];
            }

            int checkDigit = (11 - (sum % 11)) % 11;
            if (checkDigit != 10) {
                return baseStr + checkDigit + "/" + BANK_CODE;
            }
        }
    }
}