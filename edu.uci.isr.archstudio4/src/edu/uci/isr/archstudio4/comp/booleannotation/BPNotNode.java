package edu.uci.isr.archstudio4.comp.booleannotation;


/* Generated By:JJTree: Do not edit this line. BPNotNode.java */

import edu.uci.isr.xarchflat.ObjRef;
import edu.uci.isr.xarchflat.XArchFlatInterface;

/**
 * Logical NOT expression.
 *
 * @author Rob Egelink (egelink@ics.uci.edu)
 */
public class BPNotNode extends SimpleNode
{

    public BPNotNode( int id )
    {
        super( id );
    }

    public BPNotNode( Boolean p, int id )
    {
        super( p, id );
    }

    /**
     * Returns the NOT expression stored in an object of type
     * BooleanExp.
     * @param context A boolguard context.
     * @param xarch An XArchADT proxy.
     * @return NOT expression
     */
    public ObjRef toXArch( ObjRef context, XArchFlatInterface xarch )
    {
        ObjRef not = xarch.create( context, "Not" );
	ObjRef child = ( (SimpleNode)jjtGetChild( 0 ) ).toXArch( context, xarch );

        xarch.set( not, "BooleanExp", child );

        ObjRef boolexp = xarch.create( context, "BooleanExp" );
        xarch.set( boolexp, "Not", not );

        return boolexp;
    }

    /**
     * Returns a human readable representation of the expression stored
     * in a NOT node.
     * @return NOT expression.
     */
    public String toString()
    {
        return new String( "!(" + ( (SimpleNode)jjtGetChild( 0 ) ).toString() + ")" );
    }

}
