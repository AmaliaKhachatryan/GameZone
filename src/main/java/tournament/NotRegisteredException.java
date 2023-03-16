package tournament;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String massage) {
        super("Не зарегистрирован игрок : " + massage);
    }
}
