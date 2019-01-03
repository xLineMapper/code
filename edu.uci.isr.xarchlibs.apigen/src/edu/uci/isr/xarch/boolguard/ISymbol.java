/*
 * Copyright (c) 2000-2005 Regents of the University of California.
 * All rights reserved.
 *
 * This software was developed at the University of California, Irvine.
 *
 * Redistribution and use in source and binary forms are permitted
 * provided that the above copyright notice and this paragraph are
 * duplicated in all such forms and that any documentation,
 * advertising materials, and other materials related to such
 * distribution and use acknowledge that the software was developed
 * by the University of California, Irvine.  The name of the
 * University may not be used to endorse or promote products derived
 * from this software without specific prior written permission.
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND WITHOUT ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, WITHOUT LIMITATION, THE IMPLIED
 * WARRANTIES OF MERCHANTIBILITY AND FITNESS FOR A PARTICULAR PURPOSE.
 */
package edu.uci.isr.xarch.boolguard;

import java.util.Collection;
import edu.uci.isr.xarch.XArchActionMetadata;
import edu.uci.isr.xarch.XArchTypeMetadata;
import edu.uci.isr.xarch.XArchPropertyMetadata;

/**
 * Interface for accessing objects of the
 * Symbol <code>xsi:type</code> in the
 * boolguard namespace.
 * 
 * @author Automatically generated by xArch apigen
 */
public interface ISymbol extends edu.uci.isr.xarch.IXArchElement{

	public final static XArchTypeMetadata TYPE_METADATA = new XArchTypeMetadata(
		XArchTypeMetadata.XARCH_ELEMENT,
		"boolguard", "Symbol", edu.uci.isr.xarch.IXArchElement.TYPE_METADATA,
		new XArchPropertyMetadata[]{
			XArchPropertyMetadata.createAttribute("value", "http://www.w3.org/2001/XMLSchema", "string", null, null)},
		new XArchActionMetadata[]{});

	/** 
	 * Set the value for this Symbol.
	 * @param value Value to set.
	 */
	public void setValue(String value);

	/** 
	 * Remove the value for this Symbol.
	 */
	public void clearValue();

	/**
	 * Get the value for this Symbol.
	 * @return value
	 */
	public String getValue();

	/**
	 * Determine if this Symbol has the
	 * given value.  Matching is done by string
	 * equality.
	 * @return <code>true</code> if they match,
	 * <code>false</code> otherwise.
	 */
	public boolean hasValue(String value);

	/**
	 * Determine if another Symbol is
	 * equivalent to this one.
	 * @param SymbolToCompare Symbol to compare against
	 * this one.
	 * @return <code>true</code> if their values are equivalent,
	 * <code>false</code> otherwise.
	 */
	public boolean isEquivalent(ISymbol SymbolToCompare);


}
