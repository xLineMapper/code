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
package edu.uci.isr.xarch.pladiff;

import org.w3c.dom.*;

import edu.uci.isr.xarch.*;

import java.util.*;

/**
 * DOM-Based implementation of the IDiffPart interface.
 *
 * @author Automatically generated by xArch apigen.
 */
public class DiffPartImpl implements IDiffPart, DOMBased{
	
	public static final String XSD_TYPE_NSURI = PladiffConstants.NS_URI;
	public static final String XSD_TYPE_NAME = "DiffPart";
	
	protected IXArch xArch;
	
	/** Tag name for diffLocations in this object. */
	public static final String DIFF_LOCATION_ELT_NAME = "diffLocation";
	/** Tag name for adds in this object. */
	public static final String ADD_ELT_NAME = "add";
	/** Tag name for removes in this object. */
	public static final String REMOVE_ELT_NAME = "remove";
	/** Tag name for diffParts in this object. */
	public static final String DIFF_PART_ELT_NAME = "diffPart";

	
	protected Element elt;
	
	private static SequenceOrder seqOrd = new SequenceOrder(
		new QName[]{
			new QName(PladiffConstants.NS_URI, DIFF_LOCATION_ELT_NAME),
			new QName(PladiffConstants.NS_URI, ADD_ELT_NAME),
			new QName(PladiffConstants.NS_URI, REMOVE_ELT_NAME),
			new QName(PladiffConstants.NS_URI, DIFF_PART_ELT_NAME)
		}
	);
	
	public DiffPartImpl(Element elt){
		if(elt == null){
			throw new IllegalArgumentException("Element cannot be null.");
		}
		this.elt = elt;
	}

	public Node getDOMNode(){
		return elt;
	}
	
	public void setDOMNode(Node node){
		if(node.getNodeType() != Node.ELEMENT_NODE){
			throw new IllegalArgumentException("Base DOM node of this type must be an Element.");
		}
		elt = (Element)node;
	}
	
	protected static SequenceOrder getSequenceOrder(){
		return seqOrd;
	}
	
	public void setXArch(IXArch xArch){
		this.xArch = xArch;
	}
	
	public IXArch getXArch(){
		return this.xArch;
	}

	public IXArchElement cloneElement(int depth){
		synchronized(DOMUtils.getDOMLock(elt)){
			Document doc = elt.getOwnerDocument();
			if(depth == 0){
				Element cloneElt = (Element)elt.cloneNode(false);
				cloneElt = (Element)doc.importNode(cloneElt, true);
				DiffPartImpl cloneImpl = new DiffPartImpl(cloneElt);
				cloneImpl.setXArch(getXArch());
				return cloneImpl;
			}
			else if(depth == 1){
				Element cloneElt = (Element)elt.cloneNode(false);
				cloneElt = (Element)doc.importNode(cloneElt, true);
				DiffPartImpl cloneImpl = new DiffPartImpl(cloneElt);
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
				DiffPartImpl cloneImpl = new DiffPartImpl(cloneElt);
				cloneImpl.setXArch(getXArch());
				return cloneImpl;
			}
		}
	}

	//Override 'equals' to be DOM-based...	
	public boolean equals(Object o){
		if(o == null){
			return false;
		}
		if(!(o instanceof DOMBased)){
			return super.equals(o);
		}
		DOMBased db = (DOMBased)o;
		Node dbNode = db.getDOMNode();
		return dbNode.equals(getDOMNode());
	}

	//Override 'hashCode' to be based on the underlying node
	public int hashCode(){
		return getDOMNode().hashCode();
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
				if(!DOMUtils.hasXSIType(elt, "http://www.ics.uci.edu/pub/arch/xArch/pladiff.xsd", baseTypeName)){
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
		return IDiffPart.TYPE_METADATA;
	}

	public XArchInstanceMetadata getInstanceMetadata(){
		return new XArchInstanceMetadata(XArchUtils.getPackageTitle(elt.getNamespaceURI()));
	}

	public void setDiffLocation(IDiffLocation value){
		if(!(value instanceof DOMBased)){
			throw new IllegalArgumentException("Cannot handle non-DOM-based xArch entities.");
		}
		{
			IDiffLocation oldElt = getDiffLocation();
			DOMUtils.removeChildren(elt, PladiffConstants.NS_URI, DIFF_LOCATION_ELT_NAME);
			
			IXArch context = getXArch();
			if(context != null){
				context.fireXArchEvent(
					new XArchEvent(this, 
					XArchEvent.CLEAR_EVENT,
					XArchEvent.ELEMENT_CHANGED,
					"diffLocation", oldElt,
					XArchUtils.getDefaultXArchImplementation().isContainedIn(xArch, this), true)
				);
			}
		}
		Element newChildElt = (Element)(((DOMBased)value).getDOMNode());
		newChildElt = DOMUtils.cloneAndRename(newChildElt, PladiffConstants.NS_URI, DIFF_LOCATION_ELT_NAME);
		((DOMBased)value).setDOMNode(newChildElt);
		
		synchronized(DOMUtils.getDOMLock(elt)){
			elt.appendChild(newChildElt);
			DOMUtils.order(elt, getSequenceOrder());
		}
		
		IXArch context = getXArch();
		if(context != null){
			context.fireXArchEvent(
				new XArchEvent(this, 
				XArchEvent.SET_EVENT,
				XArchEvent.ELEMENT_CHANGED,
				"diffLocation", value,
				XArchUtils.getDefaultXArchImplementation().isContainedIn(xArch, this))
			);
		}
	}
	
	public void clearDiffLocation(){
		IDiffLocation oldElt = getDiffLocation();
		DOMUtils.removeChildren(elt, PladiffConstants.NS_URI, DIFF_LOCATION_ELT_NAME);
		
		IXArch context = getXArch();
		if(context != null){
			context.fireXArchEvent(
				new XArchEvent(this, 
				XArchEvent.CLEAR_EVENT,
				XArchEvent.ELEMENT_CHANGED,
				"diffLocation", oldElt,
				XArchUtils.getDefaultXArchImplementation().isContainedIn(xArch, this))
			);
		}
	}
	
	public IDiffLocation getDiffLocation(){
		NodeList nl = DOMUtils.getChildren(elt, PladiffConstants.NS_URI, DIFF_LOCATION_ELT_NAME);
		if(nl.getLength() == 0){
			return null;
		}
		else{
			Element el = (Element)nl.item(0);
			IXArch de = getXArch();
			if(de != null){
				IXArchElement cachedXArchElt = de.getWrapper(el);
				if(cachedXArchElt != null){
					return (IDiffLocation)cachedXArchElt;
				}
			}
			
			Object o = makeDerivedWrapper(el, "DiffLocation");
			if(o != null){
				try{
					((edu.uci.isr.xarch.IXArchElement)o).setXArch(getXArch());
					if(de != null){
						de.cacheWrapper(el, ((edu.uci.isr.xarch.IXArchElement)o));
					}
					return (IDiffLocation)o;
				}
				catch(Exception e){}
			}
			DiffLocationImpl eltImpl = new DiffLocationImpl(el);
			eltImpl.setXArch(getXArch());
			if(de != null){
				de.cacheWrapper(el, ((edu.uci.isr.xarch.IXArchElement)eltImpl));
			}
			return eltImpl;
		}
	}
	
	public boolean hasDiffLocation(IDiffLocation value){
		IDiffLocation thisValue = getDiffLocation();
		IDiffLocation thatValue = value;
		
		if((thisValue == null) && (thatValue == null)){
			return true;
		}
		else if((thisValue == null) && (thatValue != null)){
			return false;
		}
		else if((thisValue != null) && (thatValue == null)){
			return false;
		}
		return thisValue.isEquivalent(thatValue);
	}

	public void addAdd(IAdd newAdd){
		if(!(newAdd instanceof DOMBased)){
			throw new IllegalArgumentException("Cannot handle non-DOM-based xArch entities.");
		}
		Element newChildElt = (Element)(((DOMBased)newAdd).getDOMNode());
		newChildElt = DOMUtils.cloneAndRename(newChildElt, PladiffConstants.NS_URI, ADD_ELT_NAME);
		((DOMBased)newAdd).setDOMNode(newChildElt);

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
				"add", newAdd,
				XArchUtils.getDefaultXArchImplementation().isContainedIn(xArch, this))
			);
		}
	}
		
	public void addAdds(Collection adds){
		for(Iterator en = adds.iterator(); en.hasNext(); ){
			IAdd elt = (IAdd)en.next();
			addAdd(elt);
		}
	}		
		
	public void clearAdds(){
		//DOMUtils.removeChildren(elt, PladiffConstants.NS_URI, ADD_ELT_NAME);
		Collection coll = getAllAdds();
		removeAdds(coll);
	}
	
	public void removeAdd(IAdd addToRemove){
		if(!(addToRemove instanceof DOMBased)){
			throw new IllegalArgumentException("Cannot handle non-DOM-based xArch entities.");
		}
		NodeList nl = DOMUtils.getChildren(elt, PladiffConstants.NS_URI, ADD_ELT_NAME);
		for(int i = 0; i < nl.getLength(); i++){
			Node n = nl.item(i);
			if(n == ((DOMBased)addToRemove).getDOMNode()){
				synchronized(DOMUtils.getDOMLock(elt)){
					elt.removeChild(n);
				}

				IXArch context = getXArch();
				if(context != null){
					context.fireXArchEvent(
						new XArchEvent(this, 
						XArchEvent.REMOVE_EVENT,
						XArchEvent.ELEMENT_CHANGED,
						"add", addToRemove,
						XArchUtils.getDefaultXArchImplementation().isContainedIn(xArch, this))
					);
				}

				return;
			}
		}
	}
	
	public void removeAdds(Collection adds){
		for(Iterator en = adds.iterator(); en.hasNext(); ){
			IAdd elt = (IAdd)en.next();
			removeAdd(elt);
		}
	}
	
	public Collection getAllAdds(){
		NodeList nl = DOMUtils.getChildren(elt, PladiffConstants.NS_URI, ADD_ELT_NAME);
		int nlLength = nl.getLength();
		ArrayList v = new ArrayList(nlLength);
		IXArch de = getXArch();
		for(int i = 0; i < nlLength; i++){
			Element el = (Element)nl.item(i);
			boolean found = false;
			if(de != null){
				IXArchElement cachedXArchElt = de.getWrapper(el);
				if(cachedXArchElt != null){
					v.add((IAdd)cachedXArchElt);
					found = true;
				}
			}
			if(!found){
				Object o = makeDerivedWrapper(el, "Add");	
				if(o != null){
					try{
						((edu.uci.isr.xarch.IXArchElement)o).setXArch(getXArch());
						if(de != null){
							de.cacheWrapper(el, ((edu.uci.isr.xarch.IXArchElement)o));
						}
						v.add((IAdd)o);
					}
					catch(Exception e){
						AddImpl eltImpl = new AddImpl((Element)nl.item(i));
						eltImpl.setXArch(getXArch());
						if(de != null){
							de.cacheWrapper(el, ((edu.uci.isr.xarch.IXArchElement)eltImpl));
						}
						v.add(eltImpl);
					}
				}
				else{
					AddImpl eltImpl = new AddImpl((Element)nl.item(i));
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

	public boolean hasAdd(IAdd addToCheck){
		Collection c = getAllAdds();
		
		for(Iterator en = c.iterator(); en.hasNext(); ){
			IAdd elt = (IAdd)en.next();
			if(elt.isEquivalent(addToCheck)){
				return true;
			}
		}
		return false;
	}
	
	public Collection hasAdds(Collection addsToCheck){
		Vector v = new Vector();
		for(Iterator en = addsToCheck.iterator(); en.hasNext(); ){
			IAdd elt = (IAdd)en.next();
			v.addElement(new Boolean(hasAdd(elt)));
		}
		return v;
	}
		
	public boolean hasAllAdds(Collection addsToCheck){
		for(Iterator en = addsToCheck.iterator(); en.hasNext(); ){
			IAdd elt = (IAdd)en.next();
			if(!hasAdd(elt)){
				return false;
			}
		}
		return true;
	}
	public void addRemove(IRemove newRemove){
		if(!(newRemove instanceof DOMBased)){
			throw new IllegalArgumentException("Cannot handle non-DOM-based xArch entities.");
		}
		Element newChildElt = (Element)(((DOMBased)newRemove).getDOMNode());
		newChildElt = DOMUtils.cloneAndRename(newChildElt, PladiffConstants.NS_URI, REMOVE_ELT_NAME);
		((DOMBased)newRemove).setDOMNode(newChildElt);

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
				"remove", newRemove,
				XArchUtils.getDefaultXArchImplementation().isContainedIn(xArch, this))
			);
		}
	}
		
	public void addRemoves(Collection removes){
		for(Iterator en = removes.iterator(); en.hasNext(); ){
			IRemove elt = (IRemove)en.next();
			addRemove(elt);
		}
	}		
		
	public void clearRemoves(){
		//DOMUtils.removeChildren(elt, PladiffConstants.NS_URI, REMOVE_ELT_NAME);
		Collection coll = getAllRemoves();
		removeRemoves(coll);
	}
	
	public void removeRemove(IRemove removeToRemove){
		if(!(removeToRemove instanceof DOMBased)){
			throw new IllegalArgumentException("Cannot handle non-DOM-based xArch entities.");
		}
		NodeList nl = DOMUtils.getChildren(elt, PladiffConstants.NS_URI, REMOVE_ELT_NAME);
		for(int i = 0; i < nl.getLength(); i++){
			Node n = nl.item(i);
			if(n == ((DOMBased)removeToRemove).getDOMNode()){
				synchronized(DOMUtils.getDOMLock(elt)){
					elt.removeChild(n);
				}

				IXArch context = getXArch();
				if(context != null){
					context.fireXArchEvent(
						new XArchEvent(this, 
						XArchEvent.REMOVE_EVENT,
						XArchEvent.ELEMENT_CHANGED,
						"remove", removeToRemove,
						XArchUtils.getDefaultXArchImplementation().isContainedIn(xArch, this))
					);
				}

				return;
			}
		}
	}
	
	public void removeRemoves(Collection removes){
		for(Iterator en = removes.iterator(); en.hasNext(); ){
			IRemove elt = (IRemove)en.next();
			removeRemove(elt);
		}
	}
	
	public Collection getAllRemoves(){
		NodeList nl = DOMUtils.getChildren(elt, PladiffConstants.NS_URI, REMOVE_ELT_NAME);
		int nlLength = nl.getLength();
		ArrayList v = new ArrayList(nlLength);
		IXArch de = getXArch();
		for(int i = 0; i < nlLength; i++){
			Element el = (Element)nl.item(i);
			boolean found = false;
			if(de != null){
				IXArchElement cachedXArchElt = de.getWrapper(el);
				if(cachedXArchElt != null){
					v.add((IRemove)cachedXArchElt);
					found = true;
				}
			}
			if(!found){
				Object o = makeDerivedWrapper(el, "Remove");	
				if(o != null){
					try{
						((edu.uci.isr.xarch.IXArchElement)o).setXArch(getXArch());
						if(de != null){
							de.cacheWrapper(el, ((edu.uci.isr.xarch.IXArchElement)o));
						}
						v.add((IRemove)o);
					}
					catch(Exception e){
						RemoveImpl eltImpl = new RemoveImpl((Element)nl.item(i));
						eltImpl.setXArch(getXArch());
						if(de != null){
							de.cacheWrapper(el, ((edu.uci.isr.xarch.IXArchElement)eltImpl));
						}
						v.add(eltImpl);
					}
				}
				else{
					RemoveImpl eltImpl = new RemoveImpl((Element)nl.item(i));
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

	public boolean hasRemove(IRemove removeToCheck){
		Collection c = getAllRemoves();
		
		for(Iterator en = c.iterator(); en.hasNext(); ){
			IRemove elt = (IRemove)en.next();
			if(elt.isEquivalent(removeToCheck)){
				return true;
			}
		}
		return false;
	}
	
	public Collection hasRemoves(Collection removesToCheck){
		Vector v = new Vector();
		for(Iterator en = removesToCheck.iterator(); en.hasNext(); ){
			IRemove elt = (IRemove)en.next();
			v.addElement(new Boolean(hasRemove(elt)));
		}
		return v;
	}
		
	public boolean hasAllRemoves(Collection removesToCheck){
		for(Iterator en = removesToCheck.iterator(); en.hasNext(); ){
			IRemove elt = (IRemove)en.next();
			if(!hasRemove(elt)){
				return false;
			}
		}
		return true;
	}
	public void addDiffPart(IDiffPart newDiffPart){
		if(!(newDiffPart instanceof DOMBased)){
			throw new IllegalArgumentException("Cannot handle non-DOM-based xArch entities.");
		}
		Element newChildElt = (Element)(((DOMBased)newDiffPart).getDOMNode());
		newChildElt = DOMUtils.cloneAndRename(newChildElt, PladiffConstants.NS_URI, DIFF_PART_ELT_NAME);
		((DOMBased)newDiffPart).setDOMNode(newChildElt);

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
				"diffPart", newDiffPart,
				XArchUtils.getDefaultXArchImplementation().isContainedIn(xArch, this))
			);
		}
	}
		
	public void addDiffParts(Collection diffParts){
		for(Iterator en = diffParts.iterator(); en.hasNext(); ){
			IDiffPart elt = (IDiffPart)en.next();
			addDiffPart(elt);
		}
	}		
		
	public void clearDiffParts(){
		//DOMUtils.removeChildren(elt, PladiffConstants.NS_URI, DIFF_PART_ELT_NAME);
		Collection coll = getAllDiffParts();
		removeDiffParts(coll);
	}
	
	public void removeDiffPart(IDiffPart diffPartToRemove){
		if(!(diffPartToRemove instanceof DOMBased)){
			throw new IllegalArgumentException("Cannot handle non-DOM-based xArch entities.");
		}
		NodeList nl = DOMUtils.getChildren(elt, PladiffConstants.NS_URI, DIFF_PART_ELT_NAME);
		for(int i = 0; i < nl.getLength(); i++){
			Node n = nl.item(i);
			if(n == ((DOMBased)diffPartToRemove).getDOMNode()){
				synchronized(DOMUtils.getDOMLock(elt)){
					elt.removeChild(n);
				}

				IXArch context = getXArch();
				if(context != null){
					context.fireXArchEvent(
						new XArchEvent(this, 
						XArchEvent.REMOVE_EVENT,
						XArchEvent.ELEMENT_CHANGED,
						"diffPart", diffPartToRemove,
						XArchUtils.getDefaultXArchImplementation().isContainedIn(xArch, this))
					);
				}

				return;
			}
		}
	}
	
	public void removeDiffParts(Collection diffParts){
		for(Iterator en = diffParts.iterator(); en.hasNext(); ){
			IDiffPart elt = (IDiffPart)en.next();
			removeDiffPart(elt);
		}
	}
	
	public Collection getAllDiffParts(){
		NodeList nl = DOMUtils.getChildren(elt, PladiffConstants.NS_URI, DIFF_PART_ELT_NAME);
		int nlLength = nl.getLength();
		ArrayList v = new ArrayList(nlLength);
		IXArch de = getXArch();
		for(int i = 0; i < nlLength; i++){
			Element el = (Element)nl.item(i);
			boolean found = false;
			if(de != null){
				IXArchElement cachedXArchElt = de.getWrapper(el);
				if(cachedXArchElt != null){
					v.add((IDiffPart)cachedXArchElt);
					found = true;
				}
			}
			if(!found){
				Object o = makeDerivedWrapper(el, "DiffPart");	
				if(o != null){
					try{
						((edu.uci.isr.xarch.IXArchElement)o).setXArch(getXArch());
						if(de != null){
							de.cacheWrapper(el, ((edu.uci.isr.xarch.IXArchElement)o));
						}
						v.add((IDiffPart)o);
					}
					catch(Exception e){
						DiffPartImpl eltImpl = new DiffPartImpl((Element)nl.item(i));
						eltImpl.setXArch(getXArch());
						if(de != null){
							de.cacheWrapper(el, ((edu.uci.isr.xarch.IXArchElement)eltImpl));
						}
						v.add(eltImpl);
					}
				}
				else{
					DiffPartImpl eltImpl = new DiffPartImpl((Element)nl.item(i));
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

	public boolean hasDiffPart(IDiffPart diffPartToCheck){
		Collection c = getAllDiffParts();
		
		for(Iterator en = c.iterator(); en.hasNext(); ){
			IDiffPart elt = (IDiffPart)en.next();
			if(elt.isEquivalent(diffPartToCheck)){
				return true;
			}
		}
		return false;
	}
	
	public Collection hasDiffParts(Collection diffPartsToCheck){
		Vector v = new Vector();
		for(Iterator en = diffPartsToCheck.iterator(); en.hasNext(); ){
			IDiffPart elt = (IDiffPart)en.next();
			v.addElement(new Boolean(hasDiffPart(elt)));
		}
		return v;
	}
		
	public boolean hasAllDiffParts(Collection diffPartsToCheck){
		for(Iterator en = diffPartsToCheck.iterator(); en.hasNext(); ){
			IDiffPart elt = (IDiffPart)en.next();
			if(!hasDiffPart(elt)){
				return false;
			}
		}
		return true;
	}
	public boolean isEquivalent(IDiffPart c){
		return (getClass().equals(c.getClass())) &&
			hasDiffLocation(c.getDiffLocation()) &&
			hasAllAdds(c.getAllAdds()) &&
			c.hasAllAdds(getAllAdds()) &&
			hasAllRemoves(c.getAllRemoves()) &&
			c.hasAllRemoves(getAllRemoves()) &&
			hasAllDiffParts(c.getAllDiffParts()) &&
			c.hasAllDiffParts(getAllDiffParts()) ;
	}

}