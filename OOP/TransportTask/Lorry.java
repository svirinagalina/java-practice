package OOP.TransportTask;

public class Lorry implements Transport {
    private double maxWeight;
    private double totalWeight;

    public Lorry(double maxWeight) {
        this.maxWeight = maxWeight;
        this.totalWeight = 0;
    }

    @Override
    public boolean canCarry(double weight) {
        return totalWeight + weight <= maxWeight;
    }

    @Override
    public double getTotalWeight() {
        return totalWeight;
    }

    @Override
    public void add(double weight) {
        totalWeight += weight;
    }

    @Override
    public String toString() {
        return "Lorry{maxWeight=" + maxWeight + ", totalWeight=" + totalWeight + "}";
    }
}

