package OOP.TransportTask;

public interface Transport {
    boolean canCarry(double weight);


    void add (double weight);
    double getTotalWeight();

}
