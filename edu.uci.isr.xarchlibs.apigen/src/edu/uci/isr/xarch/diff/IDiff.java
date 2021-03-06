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
package edu.uci.isr.xarch.diff;

import java.util.Collection;
import edu.uci.isr.xarch.XArchActionMetadata;
import edu.uci.isr.xarch.XArchTypeMetadata;
import edu.uci.isr.xarch.XArchPropertyMetadata;

/**
 * Interface for accessing objects of the
 * Diff <code>xsi:type</code> in the
 * diff namespace.
 * 
 * @author Automatically generated by xArch apigen
 */
public interface IDiff extends edu.uci.isr.xarch.IXArchElement{

	public final static XArchTypeMetadata TYPE_METADATA = new XArchTypeMetadata(
		XArchTypeMetadata.XARCH_ELEMENT,
		"diff", "Diff", edu.uci.isr.xarch.IXArchElement.TYPE_METADATA,
		new XArchPropertyMetadata[]{
			XArchPropertyMetadata.createElement("diffPart", "diff", "DiffPart", 0, XArchPropertyMetadata.UNBOUNDED)},
		new XArchActionMetadata[]{});

	/**
	 * Add a diffPart to this Diff.
	 * @param newDiffPart diffPart to add.
	 */
	public void addDiffPart(IDiffPart newDiffPart);

	/**
	 * Add a collection of diffParts to this Diff.
	 * @param diffParts diffParts to add.
	 */
	public void addDiffParts(Collection diffParts);

	/**
	 * Remove all diffParts from this Diff.
	 */
	public void clearDiffParts();

	/**
	 * Remove the given diffPart from this Diff.
	 * Matching is done by the <code>isEquivalent(...)</code> function.
	 * @param diffPartToRemove diffPart to remove.
	 */
	public void removeDiffPart(IDiffPart diffPartToRemove);

	/**
	 * Remove all the given diffParts from this Diff.
	 * Matching is done by the <code>isEquivalent(...)</code> function.
	 * @param diffParts diffPart to remove.
	 */
	public void removeDiffParts(Collection diffParts);

	/**
	 * Get all the diffParts from this Diff.
	 * @return all diffParts in this Diff.
	 */
	public Collection getAllDiffParts();

	/**
	 * Determine if this Diff contains a given diffPart.
	 * @return <code>true</code> if this Diff contains the given
	 * diffPartToCheck, <code>false</code> otherwise.
	 */
	public boolean hasDiffPart(IDiffPart diffPartToCheck);

	/**
	 * Determine if this Diff contains the given set of diffParts.
	 * @param diffPartsToCheck diffParts to check for.
	 * @return Collection of <code>java.lang.Boolean</code>.  If the i<sup>th</sup>
	 * element in <code>diffParts</code> was found, then the i<sup>th</sup>
	 * element of the collection will be set to <code>true</code>, otherwise it
	 * will be set to <code>false</code>.  Matching is done with the
	 * <code>isEquivalent(...)</code> method.
	 */
	public Collection hasDiffParts(Collection diffPartsToCheck);

	/**
	 * Determine if this Diff contains each element in the 
	 * given set of diffParts.
	 * @param diffPartsToCheck diffParts to check for.
	 * @return <code>true</code> if every element in
	 * <code>diffParts</code> is found in this Diff,
	 * <code>false</code> otherwise.
	 */
	public boolean hasAllDiffParts(Collection diffPartsToCheck);

	/**
	 * Determine if another Diff is equivalent to this one, ignoring
	 * ID's.
	 * @param DiffToCheck Diff to compare to this one.
	 * @return <code>true</code> if all the child elements of this
	 * Diff are equivalent, <code>false</code> otherwise.
	 */
	public boolean isEquivalent(IDiff DiffToCheck);

}
