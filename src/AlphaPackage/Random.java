package AlphaPackage;
//  A Random class extension for a Client/Server Simulation

public class Random extends java.util.Random {

    private double mean;
    private double standardDeviation;

    /**
     * Assigns the mean to both to mean and standardDeviation
     * @param mean  The mean passed as a double
     */
    public Random(double mean) {
        this.mean = mean;
        this.standardDeviation = mean;
    }

    /**
     * Assigns the mean to mean and standardDeviation to standardDeviation
     * @param mean  the mean
     * @param standardDeviation     StandardDeviation
     */
    public Random(double mean, double standardDeviation) {
        this.mean = mean;
        this.standardDeviation = standardDeviation;
    }

    
    /**
     * @return a double random number that is normally distributed with
     *
     * the given mean and standard deviation
     */
    @Override
    public double nextGaussian() {
        double x = super.nextGaussian();  // x = normal(0.0, 1.0)
        return x * standardDeviation + mean;
    }

    /**
     * A number described below.
     * @return a double random number that is exponentially distributed 
     * with a given mean
     */
    public double nextExponential() {
        return -mean * Math.log(1.0 - nextDouble());
    }

    /**
     * A number described below.
     * @return a int random number that is exponentially distributed 
     * with a given mean
     */
    public int intNextExponential() {
        return (int) Math.ceil(nextExponential());
    }
}
