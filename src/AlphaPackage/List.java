package AlphaPackage;

// Class List definition
public class List
{
    private ListNode firstNode;
    private ListNode lastNode;
    private String name; // String like "list" used in printing

    /**
     * Default constructor: Construct an empty List with "list" as the name
     */
    public List()
    {
        this( "list" );
    }

    /**
     * Constructor: Construct an empty List with s as the name
     * @param s String to initiate the list
     */
    public List(String s)
    {
        name = s;
        firstNode = lastNode = null;
    }

    
    /**
     * Insert an Object at the front of the List
     * If List is empty, firstNode and lastNode will refer to
     * the same object. Otherwise, firstNode refers to new node.
     * @param insertItem object to insert
     */
    public synchronized void insertAtFront( Object insertItem )
    {
        if ( isEmpty() )
            firstNode = lastNode = new ListNode( insertItem );
        else
            firstNode = new ListNode( insertItem, firstNode );
    }

    /**
     * Insert an Object at the end of the List
     * If List is empty, firstNode and lastNode will refer to
     * the same Object. Otherwise, lastNode's next instance
     * variable refers to new node.
     * @param insertItem object to insert
     */
    public synchronized void insertAtBack( Object insertItem )
    {
    if ( isEmpty() )
        firstNode = lastNode = new ListNode( insertItem );
    else
        lastNode = lastNode.next = new ListNode( insertItem );
    }
    /**
     * Remove the first node from the List.
     * @return Remove the first node from the List.
     * @throws EmptyQueueException  If empty
     */
    public synchronized Object removeFromFront() throws EmptyQueueException
    {
        Object removeItem = null;
        if ( isEmpty() )
            throw new EmptyQueueException( name );
        removeItem = firstNode.data; // retrieve the data
        // reset the firstNode and lastNode references
        if ( firstNode.equals( lastNode ) )
            firstNode = lastNode = null;
        else
            firstNode = firstNode.next;
        return removeItem;
    }
    /**
     * Remove the last node from the List
     * @return Remove the last node from the List
     * @throws EmptyQueueException if empty queue
     */
    public synchronized Object removeFromBack() throws EmptyQueueException
    {
        Object removeItem = null;
        if ( isEmpty() )
            throw new EmptyQueueException( name );
        removeItem = lastNode.data; // retrieve the data
        // reset the firstNode and lastNode references
        if ( firstNode.equals( lastNode ) )
            firstNode = lastNode = null;
        else
        {
            ListNode current = firstNode;
            while ( current.next != lastNode ) // not last node
            current = current.next; // move to next node
            lastNode = current;
            current.next = null;
        }
        return removeItem;
    }
    /**
     * Checks if empty
     * @return true if the List is empty
     */
    public synchronized boolean isEmpty()
    { 
        return firstNode == null;
    }
    /**
     * Buffers the contents of each queue.
     * @return  each to string method of each node
     */
    public synchronized String print()
    {
        if ( isEmpty() )
        {
            System.out.println( "Empty " + name );
            return "";
        }
        //System.out.print( "The " + name + " is: " );
        ListNode current = firstNode;
        StringBuffer buff = new StringBuffer("[" + current.data.toString());
        current = current.next;
        while(current != null)
        {
            buff.append(", " + current.data.toString());
            //System.out.print(", " + current.data.toString());
            current = current.next;
        }
        return buff.append("]").toString();
    }
    /**
     * Checks the size of the queue and returns it by traveling through each 
     * node.
     * @return  the size of the array
     */
    public synchronized int size() {
        if(firstNode == null)
            return 0;
        ListNode current = firstNode;
        int amount = 1;
        while((current = current.next) != null) {
            amount++;
        }
        return amount;
    }
}