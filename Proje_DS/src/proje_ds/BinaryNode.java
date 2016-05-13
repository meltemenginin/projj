package proje_ds;

public class BinaryNode<E>
{
    E element;            // The data in the node
    BinaryNode<E> left;   // Left child
    BinaryNode<E> right;  // Right child

    // Constructors
    BinaryNode( E theElement )
    {
        this( theElement, null, null );
    }

    BinaryNode( E theElement, BinaryNode<E> lt, BinaryNode<E> rt )
    {
        element  = theElement;
        left     = lt;
        right    = rt;
    }
}
