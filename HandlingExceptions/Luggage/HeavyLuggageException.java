package HandlingExceptions.Luggage;

class HeavyLuggageException extends Exception {
    public HeavyLuggageException() {
        super("Превышение веса багажа");
    }
}
