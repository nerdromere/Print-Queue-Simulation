package AlphaPackage;

// QueueInheritance.java
// Class QueueInheritance definition
// Derived from List
public class Queue extends List
{
    //A FIFO, doesn't have push or pop!
    public Queue()
    {
        super( "queue" );
    }
    /**
     * Add to the end of the queue
     * @param o an object to add
     */
    public synchronized void enqueue( Object o )
    {
        insertAtBack( o );
    }

    /**
     * Takes an abject away
     * @return  the first object
     * @throws EmptyQueueException if queue is empty
     */
    public synchronized Object dequeue() throws EmptyQueueException
    {
        return removeFromFront();
    }
    /**
     * Checks if its empty
     * @return  true if empty
     */
    public synchronized boolean isEmpty()
    {
        return super.isEmpty();
    }
    @Override
    /**
     * calls super print method
     */
    public synchronized String print()
    {
        return super.print();
    }
    
}