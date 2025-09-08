
public class Cook {

    public void turnOvenOn() {
        System.out.println("Turning the oven on");
    }

    public void turnOvenOff() {
        System.out.println("Turning the oven off");
    }

    public void bake(String product) throws BakingException {
        System.out.println("Baking");

        if (product.equalsIgnoreCase("Bad flour") || product.equalsIgnoreCase("RancidButter")) {
            throw new BakingException(product);
        }

        System.out.println("End of baking");
    }
}
