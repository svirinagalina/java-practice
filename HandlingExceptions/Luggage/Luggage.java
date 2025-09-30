package HandlingExceptions.Luggage;

class Luggage {

    private final double maxWeight;

    public Luggage(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void checkLuggage(double weight) throws HeavyLuggageException {
        System.out.println("Взвесим багаж");
        if (weight > maxWeight) {
            throw new HeavyLuggageException();
        }
        System.out.println("Допустимый вес багажа");
    }
}
