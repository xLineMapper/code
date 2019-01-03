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
package edu.uci.isr.xarch.implementationext;

import org.w3c.dom.*;

import edu.uci.isr.xarch.*;

import java.util.*;

/**
 * DOM-Based implementation of the IInterfaceImpl interface.
 *
 * @author Automatically generated by xArch apigen.
 */
public class InterfaceImplImpl extends edu.uci.isr.xarch.types.InterfaceImpl implements
IInterfaceImpl, edu.uci.isr.xarch.types.IInterface, DOMBased{
	
	public static final String XSD_TYPE_NSURI = ImplementationextConstants.NS_URI;
	public static final String XSD_TYPE_NAME = "InterfaceImpl";

	/** Tag name for implementations in this object. */
	public static final String IMPLEMENTATION_ELT_NAME = "implementation";

	
	private static SequenceOrder seqOrderAppend = new SequenceOrder(
		new QName[]{
			new QName(ImplementationextConstants.NS_URI, IMPLEMENTATION_ELT_NAME)
		}
	);
	
	public InterfaceImplImpl(Element elt){
		super(elt);
	}
	
	protected static SequenceOrder getSequenceOrder(){
		return new SequenceOrder(edu.uci.isr.xarch.types.InterfaceImpl.getSequenceOrder(), seqOrderAppend);
	}

	public IXArchElement cloneElement(int depth){
		synchronized(DOMUtils.getDOMLock(elt)){
			Document doc = elt.getOwnerDocument();
			if(depth == 0){
				Element cloneElt = (Element)elt.cloneNode(false);
				cloneElt = (Element)doc.importNode(cloneElt, true);
				InterfaceImplImpl cloneImpl = new InterfaceImplImpl(cloneElt);
				cloneImpl.setXArch(getXArch());
				return cloneImpl;
			}
			else if(depth == 1){
				Element cloneElt = (Element)elt.cloneNode(false);
				cloneElt = (Element)doc.importNode(cloneElt, true);
				InterfaceImplImpl cloneImpl = new InterfaceImplImpl(cloneElt);
				cloneImpl.setXArch(getXArch());
				
				NodeList nl = elt.getChildNodes();
				int size = nl.getLength();
				for(int i = 0; i < size; i++){
					Node n = nl.item(i);
					Node cloneNode = (Node)n.cloneNode(false);
					cloneNode = doc.importNode(cloneNode, true);
					cloneElt.appendChild(cloneNode);
				}
				return cloneImpl;
			}
			else /* depth = infinity */{
				Element cloneElt = (Element)elt.cloneNode(true);
				cloneElt = (Element)doc.importNode(cloneElt, true);
				InterfaceImplImpl cloneImpl = new InterfaceImplImpl(cloneElt);
				cloneImpl.setXArch(getXArch());
				return cloneImpl;
			}
		}
	}

	/**
	 * For internal use only.
	 */
	private static Object makeDerivedWrapper(Element elt, String baseTypeName){
		synchronized(DOMUtils.getDOMLock(elt)){
			QName typeName = XArchUtils.getXSIType(elt);
			if(typeName == null){
				return null;
			}
			else{
				if(!DOMUtils.hasXSIType(elt, "http://www.ics.uci.edu/pub/arch/xArch/implementationext.xsd", baseTypeName)){
					try{
						String packageTitle = XArchUtils.getPackageTitle(typeName.getNamespaceURI());
						String packageName = XArchUtils.getPackageName(packageTitle);
						String implName = XArchUtils.getImplName(packageName, typeName.getName());
						Class c = Class.forName(implName);
						java.lang.reflect.Constructor con = c.getConstructor(new Class[]{Element.class});
						Object o = con.newInstance(new Object[]{elt});
						return o;
					}
					catch(Exception e){
						//Lots of bad things could happen, but this
						//is OK, because this is best-effort anyway.
					}
				}
				return null;
			}
		}
	}

	public XArchTypeMetadata getTypeMetadata(){
		return IInterfaceImpl.TYPE_METADATA;
	}

	public XArchInstanceMetadata getInstanceMetadata(){
		return new XArchInstanceMetadata(XArchUtils.getPackageTitle(elt.getNamespaceURI()));
	}
	public void addImplementation(edu.uci.isr.xarch.implementation.IImplementation newImplementation){
		if(!(newImplementation instanceof DOMBased)){
			throw new IllegalArgumentException("Cannot handle non-DOM-based xArch entities.");
		}
		Element newChildElt = (Element)(((DOMBased)newImplementation).getDOMNode());
		newChildElt = DOMUtils.cloneAndRename(newChildElt, ImplementationextConstants.NS_URI, IMPLEMENTATION_ELT_NAME);
		((DOMBased)newImplementation).setDOMNode(newChildElt);

		synchronized(DOMUtils.getDOMLock(elt)){
			elt.appendChild(newChildElt);
			DOMUtils.order(elt, getSequenceOrder());
		}

		IXArch context = getXArch();
		if(context != null){
			context.fireXArchEvent(
				new XArchEvent(this, 
				XArchEvent.ADD_EVENT,
				XArchEvent.ELEMENT_CHANGED,
				"implementation", newImplementation,
				XArchUtils.getDefaultXArchImplementation().isContainedIn(xArch, this))
			);
		}
	}
		
	public void addImplementations(Collection implementations){
		for(Iterator en = implementations.iterator(); en.hasNext(); ){
			edu.uci.isr.xarch.implementation.IImplementation elt = (edu.uci.isr.xarch.implementation.IImplementation)en.next();
			addImplementation(elt);
		}
	}		
		
	public void clearImplementations(){
		//DOMUtils.removeChildren(elt, ImplementationextConstants.NS_URI, IMPLEMENTATION_ELT_NAME);
		Collection coll = getAllImplementations();
		removeImplementations(coll);
	}
	
	public void removeImplementation(edu.uci.isr.xarch.implementation.IImplementation implementationToRemove){
		if(!(implementationToRemove instanceof DOMBased)){
			throw new IllegalArgumentException("Cannot handle non-DOM-based xArch entities.");
		}
		NodeList nl = DOMUtils.getChildren(elt, ImplementationextConstants.NS_URI, IMPLEMENTATION_ELT_NAME);
		for(int i = 0; i < nl.getLength(); i++){
			Node n = nl.item(i);
			if(n == ((DOMBased)implementationToRemove).getDOMNode()){
				synchronized(DOMUtils.getDOMLock(elt)){
					elt.removeChild(n);
				}

				IXArch context = getXArch();
				if(context != null){
					context.fireXArchEvent(
						new XArchEvent(this, 
						XArchEvent.REMOVE_EVENT,
						XArchEvent.ELEMENT_CHANGED,
						"implementation", implementationToRemove,
						XArchUtils.getDefaultXArchImplementation().isContainedIn(xArch, this))
					);
				}

				return;
			}
		}
	}
	
	public void removeImplementations(Collection implementations){
		for(Iterator en = implementations.iterator(); en.hasNext(); ){
			edu.uci.isr.xarch.implementation.IImplementation elt = (edu.uci.isr.xarch.implementation.IImplementation)en.next();
			removeImplementation(elt);
		}
	}
	
	public Collection getAllImplementations(){
		NodeList nl = DOMUtils.getChildren(elt, ImplementationextConstants.NS_URI, IMPLEMENTATION_ELT_NAME);
		int nlLength = nl.getLength();
		ArrayList v = new ArrayList(nlLength);
		IXArch de = getXArch();
		for(int i = 0; i < nlLength; i++){
			Element el = (Element)nl.item(i);
			boolean found = false;
			if(de != null){
				IXArchElement cachedXArchElt = de.getWrapper(el);
				if(cachedXArchElt != null){
					v.add((edu.uci.isr.xarch.implementation.IImplementation)cachedXArchElt);
					found = true;
				}
			}
			if(!found){
				Object o = makeDerivedWrapper(el, "Implementation");	
				if(o != null){
					try{
						((edu.uci.isr.xarch.IXArchElement)o).setXArch(getXArch());
						if(de != null){
							de.cacheWrapper(el, ((edu.uci.isr.xarch.IXArchElement)o));
						}
						v.add((edu.uci.isr.xarch.implementation.IImplementation)o);
					}
					catch(Exception e){
						edu.uci.isr.xarch.implementation.ImplementationImpl eltImpl = new edu.uci.isr.xarch.implementation.ImplementationImpl((Element)nl.item(i));
						eltImpl.setXArch(getXArch());
						if(de != null){
							de.cacheWrapper(el, ((edu.uci.isr.xarch.IXArchElement)eltImpl));
						}
						v.add(eltImpl);
					}
				}
				else{
					edu.uci.isr.xarch.implementation.ImplementationImpl eltImpl = new edu.uci.isr.xarch.implementation.ImplementationImpl((Element)nl.item(i));
					eltImpl.setXArch(getXArch());
					if(de != null){
						de.cacheWrapper(el, ((edu.uci.isr.xarch.IXArchElement)eltImpl));
					}
					v.add(eltImpl);
				}
			}
		}
		return v;
	}

	public boolean hasImplementation(edu.uci.isr.xarch.implementation.IImplementation implementationToCheck){
		Collection c = getAllImplementations();
		
		for(Iterator en = c.iterator(); en.hasNext(); ){
			edu.uci.isr.xarch.implementation.IImplementation elt = (edu.uci.isr.xarch.implementation.IImplementation)en.next();
			if(elt.isEquivalent(implementationToCheck)){
				return true;
			}
		}
		return false;
	}
	
	public Collection hasImplementations(Collection implementationsToCheck){
		Vector v = new Vector();
		for(Iterator en = implementationsToCheck.iterator(); en.hasNext(); ){
			edu.uci.isr.xarch.implementation.IImplementation elt = (edu.uci.isr.xarch.implementation.IImplementation)en.next();
			v.addElement(new Boolean(hasImplementation(elt)));
		}
		return v;
	}
		
	public boolean hasAllImplementations(Collection implementationsToCheck){
		for(Iterator en = implementationsToCheck.iterator(); en.hasNext(); ){
			edu.uci.isr.xarch.implementation.IImplementation elt = (edu.uci.isr.xarch.implementation.IImplementation)en.next();
			if(!hasImplementation(elt)){
				return false;
			}
		}
		return true;
	}
	public boolean isEquivalent(IInterfaceImpl c){
		return
			super.isEquivalent(c) &&
			hasAllImplementations(c.getAllImplementations()) &&
			c.hasAllImplementations(getAllImplementations()) ;
	}

}
