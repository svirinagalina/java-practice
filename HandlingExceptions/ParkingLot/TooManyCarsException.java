class TooManyCarsException extends Exception {

    public TooManyCarsException() {
        super("Вся парковка занята. Свободных мест нет.");
    }
}
