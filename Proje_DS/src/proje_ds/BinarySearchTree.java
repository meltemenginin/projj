package proje_ds;

public class BinarySearchTree<E extends Comparable<E>>
{
    private BinaryNode<E> root;

    public BinarySearchTree( )
    {
        root = null;
    }

    public void insert( E x )
    {
        root = insert( x, root );
    }

    public void remove( E x )
    {
        root = remove( x, root );
    }

    public E findMin( )
    {
        if( isEmpty( ) )
            throw new UnderflowException( );
        return findMin( root ).element;
    }

    public E findMax( )
    {
        if( isEmpty( ) )
            throw new UnderflowException( );
        return findMax( root ).element;
    }

    public boolean contains( E x )
    {
        return contains( x, root );
    }

    public void makeEmpty( )
    {
        root = null;
    }

    public boolean isEmpty( )
    {
        return root == null;
    }

    public void printInorder( )
    {
        if( isEmpty( ) )
            System.out.println( "Empty tree" );
        else
            printInorder( root );
    }

    public void printPreorder( )
    {
        if( isEmpty( ) )
            System.out.println( "Empty tree" );
        else
            printPreorder( root );
    }

    public void printPostorder( )
    {
        if( isEmpty( ) )
            System.out.println( "Empty tree" );
        else
            printPostorder( root );
    }

    public int height(){
        return height(root);
    }

    private BinaryNode<E> insert( E x, BinaryNode<E> t )
    {
        if( t == null )
            return new BinaryNode<E>( x, null, null );

        int compareResult = x.compareTo( t.element );

        if( compareResult < 0 )
            t.left = insert( x, t.left );
        else if( compareResult > 0 )
            t.right = insert( x, t.right );
        else
            ;  // Duplicate; do nothing
        return t;
    }

    private BinaryNode<E> remove( E x, BinaryNode<E> t )
    {
        if( t == null )
            return t;   // Item not found; do nothing

        int compareResult = x.compareTo( t.element );

        if( compareResult < 0 )
            t.left = remove( x, t.left );
        else if( compareResult > 0 )
            t.right = remove( x, t.right );
        else if( t.left != null && t.right != null ) // Two children
        {
            t.element = findMin( t.right ).element;
            t.right = remove( t.element, t.right );
        }
        else
            t = ( t.left != null ) ? t.left : t.right;
        return t;
    }

    private BinaryNode<E> findMin( BinaryNode<E> t )
    {
        if( t != null )
            while( t.left != null )
                t = t.left;

        return t;
    }

    private BinaryNode<E> findMax( BinaryNode<E> t )
    {
        if( t != null )
            while( t.right != null )
                t = t.right;

        return t;
    }

    private boolean contains( E x, BinaryNode<E> t )
    {
        if( t == null )
            return false;

        int compareResult = x.compareTo( t.element );

        if( compareResult < 0 )
            return contains( x, t.left );
        else if( compareResult > 0 )
            return contains( x, t.right );
        else
            return true;    // Match
    }

    private void printInorder( BinaryNode<E> t )
    {
        if( t != null )
        {
            printInorder( t.left );
            System.out.println( t.element );
            printInorder( t.right );
        }
    }

    private void printPreorder( BinaryNode<E> t )
    {
        if( t != null )
        {
            System.out.println( t.element );
            printPreorder( t.left );
            printPreorder( t.right );
        }
    }

    private void printPostorder( BinaryNode<E> t )
    {
        if( t != null )
        {
            printPostorder( t.left );
            printPostorder( t.right );
            System.out.println( t.element );
        }
    }

    private int height( BinaryNode<E> t )
    {
        if( t == null )
            return -1;
        else
            return 1 + Math.max( height( t.left ), height( t.right ) );
    }

}
