package tournament;

public class IncorrectDataException extends RuntimeException {
    public IncorrectDataException(String massage) {
        super("Некорректные данные: " + massage);
    }
}
