public class Ship implements Transport{
    private double maxWeight;
    private double totalWeight;

    public Ship (double maxWeight) {
        this.maxWeight = maxWeight;
        this.totalWeight = 0;
    }

    @Override
    public boolean canCarry(double weight) {
        return totalWeight + weight <= maxWeight;
    }

    @Override
    public void add(double weight) {
        totalWeight += weight;
    }

    @Override
    public double getTotalWeight() {
        return totalWeight;
    }


    @Override
    public String toString() {
        return "Ship{maxWeight=" + maxWeight + ", totalWeight=" + totalWeight + "}";
    }
}
