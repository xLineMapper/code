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
package edu.uci.isr.xarch.features;

import java.util.Collection;
import edu.uci.isr.xarch.XArchActionMetadata;
import edu.uci.isr.xarch.XArchTypeMetadata;
import edu.uci.isr.xarch.XArchPropertyMetadata;

/**
 * Interface for accessing objects of the
 * FeatureSymbol <code>xsi:type</code> in the
 * features namespace.
 * 
 * @author Automatically generated by xArch apigen
 */
public interface IFeatureSymbol extends edu.uci.isr.xarch.IXArchElement{

	public final static XArchTypeMetadata TYPE_METADATA = new XArchTypeMetadata(
		XArchTypeMetadata.XARCH_ELEMENT,
		"features", "FeatureSymbol", edu.uci.isr.xarch.IXArchElement.TYPE_METADATA,
		new XArchPropertyMetadata[]{
			XArchPropertyMetadata.createAttribute("value", "http://www.w3.org/2001/XMLSchema", "string", null, null)},
		new XArchActionMetadata[]{});

	/**
	 * Set the value attribute on this FeatureSymbol.
	 * @param value value
	 * @exception FixedValueException if the attribute has a fixed value
	 * and the value passed is not the fixed value.
	*/
	public void setValue(String value);

	/**
	 * Remove the value attribute from this FeatureSymbol.
	 */
	public void clearValue();

	/**
	 * Get the value attribute from this FeatureSymbol.
	 * if the attribute has a fixed value, this function will
	 * return that fixed value, even if it is not actually present
	 * in the XML document.
	 * @return value on this FeatureSymbol
	 */
	public String getValue();

	/**
	 * Determine if the value attribute on this FeatureSymbol
	 * has the given value.
	 * @param value Attribute value to compare
	 * @return <code>true</code> if they match; <code>false</code>
	 * otherwise.
	 */
	public boolean hasValue(String value);

	/**
	 * Determine if another FeatureSymbol is equivalent to this one, ignoring
	 * ID's.
	 * @param FeatureSymbolToCheck FeatureSymbol to compare to this one.
	 * @return <code>true</code> if all the child elements of this
	 * FeatureSymbol are equivalent, <code>false</code> otherwise.
	 */
	public boolean isEquivalent(IFeatureSymbol FeatureSymbolToCheck);

}
