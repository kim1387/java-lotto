package lotto.view.vlidation;

import lotto.view.exception.CantBlankOrNullInputException;
import lotto.view.exception.CantDivideByThousandToZeroException;
import lotto.view.exception.OnlyNumberConsistBetweenOneToNineInputException;

import java.util.Objects;

import static lotto.domain.LottoConfig.THOUSAND;

public class InputMoneyValidator {

    private InputMoneyValidator() {
    }

    private static final Integer ZERO = 0;
    private static final String NUMBER_REGEXP = "^[0-9]+$";

    public static void validate(String input) {
        try {
            validateOnlyNumber(input);
            validateDividedByThousand(input);
            validateNumberBetweenZeroToNine(input);
            validateBlank(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void validateOnlyNumber(String input) {
        if (!input.matches(NUMBER_REGEXP)) {
//            throw new OnlyNumberConsistBetweenOneToNineInputException();
            throw new IllegalArgumentException("[ERROR] 오직 숫자만 입력할 수 있습니다.");

        }
    }

    private static void validateDividedByThousand(String input) {
        if (isDividedByThousand(input)) {
            throw new CantDivideByThousandToZeroException();
        }
    }

    private static boolean isDividedByThousand(String input) {
        return (Integer.parseInt(input) % THOUSAND.getNumber()) != ZERO;
    }

    public static void validateNumberBetweenZeroToNine(String input) {
        if (!input.matches(NUMBER_REGEXP)) {
            throw new OnlyNumberConsistBetweenOneToNineInputException();
        }
    }

    public static void validateBlank(final String input) {
        if (isBlank(input)) {
            throw new CantBlankOrNullInputException();
        }
    }

    private static boolean isBlank(String input) {
        return Objects.isNull(input) || input.isEmpty();
    }
}
