package lotto.view.exception;

public class CantDuplicatedNumberInputException extends IllegalArgumentException{
    public CantDuplicatedNumberInputException() {
        super("중복된 수를 가질 수 없습니다.");
    }
}