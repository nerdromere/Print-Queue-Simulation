package AlphaPackage;

import java.text.DecimalFormat;

public class Server {
    private static Random randomMeanServiceRate = new Random(1.00, .20);
    private static Random randomServiceRate;
    private static char nextId = 'A';
    private char id;
    private int totalIdleTime = 0;
    private int totalWorkTime = 0;
    private double meanServiceRate;
    private double serviceRate;
    private int timeServiceEnds;
    Client client;
    
    public Server() {
        id = (char)nextId++;
        meanServiceRate = randomMeanServiceRate.nextGaussian();
        randomServiceRate = new Random(meanServiceRate, .10);
        
    }
    /**
     * Returns client
     * @return client
     */
    public Client getClient() {
        return client;
    }
    /**
     * Begins serving the customer
     * @param client    Client to serve
     * @param time      The time at which the serving begins
     */
    public void beginServing(Client client, int time) {
        this.client = client;
        this.serviceRate = randomServiceRate.nextGaussian();
        client.beginService(this, time);
        int serviceTime = (int)Math.ceil(client.getJobSize() / serviceRate);
        timeServiceEnds = time + serviceTime;
        PrintQueueSimulationGUI.setAverageServiceTimeClients(serviceTime);
        //System.out.println(serviceTime);
    }
    /**
     * Serving ends and client is forced out.
     * @param time  The time at which the serving ceases to exist
     */
    public void endServing(int time) {
        client.endService(time);
        this.client = null;
        
    }
    
    /**
     * Sets the next id, used in driver to reset the static variable
     * @param def   char to change to 
     */
    public static void setNextID(char def) {
        nextId = def;
    }
    /**
     * Driver uses this method in oder to figure out when to end the job
     * @return      the time the service should end
     */
    public int getTimeServiceEnds() {
        return timeServiceEnds;
    }
    /**
     * Checks if any client is using this server
     * @return True if Server does not contain a Client
     */
    public boolean isFree() {
        return client == null;
    }
    /**
     * Adds time to the total work time of server.
     * @param time  Time its working, usually added by 1's every iteration in
     * the driver
     */
    public void addWorkTime(int time) {
        totalWorkTime += time;
    }
    /**
     * Adds time to the total idle time of server.
     * @param time  Time its working, usually added by 1's every iteration in
     * the driver
     */
    public void addIdleTime(int time) {
        totalIdleTime += time;
    }
    /**
     * Getter for total work
     * @return  total work
     */
    public int getWork() {
        return totalWorkTime;
    }
    /**
     * Getter for total idle time
     * @return  total idle time
     */
    public int getIdle() {
        return totalIdleTime;
    }
    /**
     * The overriden toString method
     * @return toString
     */
    public String toString() {
        DecimalFormat format = new DecimalFormat("#,##0");
        return id + "(" + format.format(meanServiceRate * 100) + "%, " + format.format(serviceRate * 100) + "%)";
    }
}