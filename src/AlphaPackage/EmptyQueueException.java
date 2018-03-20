package AlphaPackage;

// EmptyListException.java
// Class EmptyListException definition
public class EmptyQueueException extends RuntimeException
{
    public EmptyQueueException( String name )
    {
        super( "The " + name + " is empty" );
    }
}