package AlphaPackage;

public class Client {

    public static int meanJobSize;                        //doesn't change
    public static Random randomJobSize = new Random(PrintQueueSimulationGUI.meanJobSize);
    private static int nextID = 0;
    private int id, jobSize, tArrived, tBegan, tEnded;
    private Server server;

    public Client(int time) {
        id = ++nextID;
        tArrived = time;
        jobSize = randomJobSize.intNextExponential();
        tArrived = time;
        //add pages
        //System.out.println(print(id,tArrived,jobSize));
        PrintQueueSimulationGUI.addToBuffer(print(id, tArrived, jobSize) + "\n");
    }

    /**
     * Returns id
     * @return id
     */
    public static int getId() {
        return nextID;
    }
    /**
     * sets the id, used in driver to reset
     * @param num num to set to 
     */
    public static void setnextID(int num) {
        nextID = num;
    }
    /**
     * getter
     * @return job size
     */
    public double getJobSize() {
        return jobSize;
    }

    /**
     * returns wait time
     * @return 
     */
    public int getWaitTime() {
        return tBegan - tArrived;
    }

    /**
     * returns service time
     * @return  serice time
     */
    public int getServiceTime() {
        return tEnded - tArrived;
    }

    /**
     * Begins the service in the client
     * @param server    server to use
     * @param time      the time it starts
     */
    public void beginService(Server server, int time) {
        this.server = server;
        //System.out.println(printBegins(server, this.id, time));
        PrintQueueSimulationGUI.addToBuffer(printBegins(server, this.id, time) + "\n");
    }

    /**
     * End the service
     * @param time  at which the server stops printing
     */
    public void endService(int time) {
        //System.out.println(printEnds(server, this.id, time));
        PrintQueueSimulationGUI.addToBuffer(printEnds(server, this.id, time) + "\n");
        server = null;
    }

    @Override
    public String toString() {
        return "#" + id + "(" + jobSize + ")";
    }

    /**
     * Information about when the job arrives
     * @param job   Current job id
     * @param time  Time at which it arrives
     * @param size  Size of the job
     * @return      Organized string of info
     */
    private static String print(int job, int time, int size) {
        return "Job #" + job + " arrives at time " + time + " with " + size + " pages";
    }

    /**
     * Information about when the job begins
     * @param server    Server used for printing
     * @param job       job that is being printed
     * @param time      The time at which the job has started
     * @return          Organized string
     */
    private static String printBegins(Server server, int job, int time) {
        return "Printer " + server + " begins Job #" + job + " at time " + time;
    }

    /**
     * Information about when the job ends
     * @param server    Server used for printing
     * @param job       job that is being printed
     * @param time      The time at which the job has ended
     * @return          Organized string
     */
    private static String printEnds(Server server, int job, int time) {
        return "Printer " + server + " ends Job #" + job + " at time " + time;
    }
}
