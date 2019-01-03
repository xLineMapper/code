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
package edu.uci.isr.xarch.versions;

import org.w3c.dom.*;

import edu.uci.isr.xarch.*;

import java.util.*;

/**
 * DOM-Based implementation of the IArchVersions interface.
 *
 * @author Automatically generated by xArch apigen.
 */
public class ArchVersionsImpl implements IArchVersions, DOMBased{
	
	public static final String XSD_TYPE_NSURI = VersionsConstants.NS_URI;
	public static final String XSD_TYPE_NAME = "ArchVersions";
	
	protected IXArch xArch;
	
	/** Tag name for componentTypeVersionGraphs in this object. */
	public static final String COMPONENT_TYPE_VERSION_GRAPH_ELT_NAME = "componentTypeVersionGraph";
	/** Tag name for connectorTypeVersionGraphs in this object. */
	public static final String CONNECTOR_TYPE_VERSION_GRAPH_ELT_NAME = "connectorTypeVersionGraph";
	/** Tag name for interfaceTypeVersionGraphs in this object. */
	public static final String INTERFACE_TYPE_VERSION_GRAPH_ELT_NAME = "interfaceTypeVersionGraph";

	
	protected Element elt;
	
	private static SequenceOrder seqOrd = new SequenceOrder(
		new QName[]{
			new QName(VersionsConstants.NS_URI, COMPONENT_TYPE_VERSION_GRAPH_ELT_NAME),
			new QName(VersionsConstants.NS_URI, CONNECTOR_TYPE_VERSION_GRAPH_ELT_NAME),
			new QName(VersionsConstants.NS_URI, INTERFACE_TYPE_VERSION_GRAPH_ELT_NAME)
		}
	);
	
	public ArchVersionsImpl(Element elt){
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
				ArchVersionsImpl cloneImpl = new ArchVersionsImpl(cloneElt);
				cloneImpl.setXArch(getXArch());
				return cloneImpl;
			}
			else if(depth == 1){
				Element cloneElt = (Element)elt.cloneNode(false);
				cloneElt = (Element)doc.importNode(cloneElt, true);
				ArchVersionsImpl cloneImpl = new ArchVersionsImpl(cloneElt);
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
				ArchVersionsImpl cloneImpl = new ArchVersionsImpl(cloneElt);
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
				if(!DOMUtils.hasXSIType(elt, "http://www.ics.uci.edu/pub/arch/xArch/versions.xsd", baseTypeName)){
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
		return IArchVersions.TYPE_METADATA;
	}

	public XArchInstanceMetadata getInstanceMetadata(){
		return new XArchInstanceMetadata(XArchUtils.getPackageTitle(elt.getNamespaceURI()));
	}
	public void addComponentTypeVersionGraph(IComponentTypeVersionGraph newComponentTypeVersionGraph){
		if(!(newComponentTypeVersionGraph instanceof DOMBased)){
			throw new IllegalArgumentException("Cannot handle non-DOM-based xArch entities.");
		}
		Element newChildElt = (Element)(((DOMBased)newComponentTypeVersionGraph).getDOMNode());
		newChildElt = DOMUtils.cloneAndRename(newChildElt, VersionsConstants.NS_URI, COMPONENT_TYPE_VERSION_GRAPH_ELT_NAME);
		((DOMBased)newComponentTypeVersionGraph).setDOMNode(newChildElt);

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
				"componentTypeVersionGraph", newComponentTypeVersionGraph,
				XArchUtils.getDefaultXArchImplementation().isContainedIn(xArch, this))
			);
		}
	}
		
	public void addComponentTypeVersionGraphs(Collection componentTypeVersionGraphs){
		for(Iterator en = componentTypeVersionGraphs.iterator(); en.hasNext(); ){
			IComponentTypeVersionGraph elt = (IComponentTypeVersionGraph)en.next();
			addComponentTypeVersionGraph(elt);
		}
	}		
		
	public void clearComponentTypeVersionGraphs(){
		//DOMUtils.removeChildren(elt, VersionsConstants.NS_URI, COMPONENT_TYPE_VERSION_GRAPH_ELT_NAME);
		Collection coll = getAllComponentTypeVersionGraphs();
		removeComponentTypeVersionGraphs(coll);
	}
	
	public void removeComponentTypeVersionGraph(IComponentTypeVersionGraph componentTypeVersionGraphToRemove){
		if(!(componentTypeVersionGraphToRemove instanceof DOMBased)){
			throw new IllegalArgumentException("Cannot handle non-DOM-based xArch entities.");
		}
		NodeList nl = DOMUtils.getChildren(elt, VersionsConstants.NS_URI, COMPONENT_TYPE_VERSION_GRAPH_ELT_NAME);
		for(int i = 0; i < nl.getLength(); i++){
			Node n = nl.item(i);
			if(n == ((DOMBased)componentTypeVersionGraphToRemove).getDOMNode()){
				synchronized(DOMUtils.getDOMLock(elt)){
					elt.removeChild(n);
				}

				IXArch context = getXArch();
				if(context != null){
					context.fireXArchEvent(
						new XArchEvent(this, 
						XArchEvent.REMOVE_EVENT,
						XArchEvent.ELEMENT_CHANGED,
						"componentTypeVersionGraph", componentTypeVersionGraphToRemove,
						XArchUtils.getDefaultXArchImplementation().isContainedIn(xArch, this))
					);
				}

				return;
			}
		}
	}
	
	public void removeComponentTypeVersionGraphs(Collection componentTypeVersionGraphs){
		for(Iterator en = componentTypeVersionGraphs.iterator(); en.hasNext(); ){
			IComponentTypeVersionGraph elt = (IComponentTypeVersionGraph)en.next();
			removeComponentTypeVersionGraph(elt);
		}
	}
	
	public Collection getAllComponentTypeVersionGraphs(){
		NodeList nl = DOMUtils.getChildren(elt, VersionsConstants.NS_URI, COMPONENT_TYPE_VERSION_GRAPH_ELT_NAME);
		int nlLength = nl.getLength();
		ArrayList v = new ArrayList(nlLength);
		IXArch de = getXArch();
		for(int i = 0; i < nlLength; i++){
			Element el = (Element)nl.item(i);
			boolean found = false;
			if(de != null){
				IXArchElement cachedXArchElt = de.getWrapper(el);
				if(cachedXArchElt != null){
					v.add((IComponentTypeVersionGraph)cachedXArchElt);
					found = true;
				}
			}
			if(!found){
				Object o = makeDerivedWrapper(el, "ComponentTypeVersionGraph");	
				if(o != null){
					try{
						((edu.uci.isr.xarch.IXArchElement)o).setXArch(getXArch());
						if(de != null){
							de.cacheWrapper(el, ((edu.uci.isr.xarch.IXArchElement)o));
						}
						v.add((IComponentTypeVersionGraph)o);
					}
					catch(Exception e){
						ComponentTypeVersionGraphImpl eltImpl = new ComponentTypeVersionGraphImpl((Element)nl.item(i));
						eltImpl.setXArch(getXArch());
						if(de != null){
							de.cacheWrapper(el, ((edu.uci.isr.xarch.IXArchElement)eltImpl));
						}
						v.add(eltImpl);
					}
				}
				else{
					ComponentTypeVersionGraphImpl eltImpl = new ComponentTypeVersionGraphImpl((Element)nl.item(i));
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

	public boolean hasComponentTypeVersionGraph(IComponentTypeVersionGraph componentTypeVersionGraphToCheck){
		Collection c = getAllComponentTypeVersionGraphs();
		
		for(Iterator en = c.iterator(); en.hasNext(); ){
			IComponentTypeVersionGraph elt = (IComponentTypeVersionGraph)en.next();
			if(elt.isEquivalent(componentTypeVersionGraphToCheck)){
				return true;
			}
		}
		return false;
	}
	
	public Collection hasComponentTypeVersionGraphs(Collection componentTypeVersionGraphsToCheck){
		Vector v = new Vector();
		for(Iterator en = componentTypeVersionGraphsToCheck.iterator(); en.hasNext(); ){
			IComponentTypeVersionGraph elt = (IComponentTypeVersionGraph)en.next();
			v.addElement(new Boolean(hasComponentTypeVersionGraph(elt)));
		}
		return v;
	}
		
	public boolean hasAllComponentTypeVersionGraphs(Collection componentTypeVersionGraphsToCheck){
		for(Iterator en = componentTypeVersionGraphsToCheck.iterator(); en.hasNext(); ){
			IComponentTypeVersionGraph elt = (IComponentTypeVersionGraph)en.next();
			if(!hasComponentTypeVersionGraph(elt)){
				return false;
			}
		}
		return true;
	}
	public IComponentTypeVersionGraph getComponentTypeVersionGraph(String id){
		NodeList nl = DOMUtils.getChildren(elt, VersionsConstants.NS_URI, COMPONENT_TYPE_VERSION_GRAPH_ELT_NAME);
		for(int i = 0; i < nl.getLength(); i++){
			
			IComponentTypeVersionGraph el = new ComponentTypeVersionGraphImpl((Element)nl.item(i));
			if(DOMUtils.objNullEq(id, el.getId())){
				Element domElt = (Element)nl.item(i);
				Object o = makeDerivedWrapper(domElt, "ComponentTypeVersionGraph");
				if(o != null){
					try{
						((edu.uci.isr.xarch.IXArchElement)o).setXArch(getXArch());
						return (IComponentTypeVersionGraph)o;
					}
					catch(Exception e){}
				}
				el.setXArch(getXArch());
				return el;
			}
		}
		return null;
	}
	
	public Collection getComponentTypeVersionGraphs(Collection ids){
		//If there is an ID that does not exist, it is simply ignored.
		//You can tell if this happened if ids.size() != returned collection.size().
		Vector v = new Vector();
		for(Iterator en = ids.iterator(); en.hasNext(); ){
			String elt = (String)en.next();
			IComponentTypeVersionGraph retElt = getComponentTypeVersionGraph(elt);
			if(retElt != null){
				v.addElement(retElt);
			}
		}
		return v;
	}	
	
	public void addConnectorTypeVersionGraph(IConnectorTypeVersionGraph newConnectorTypeVersionGraph){
		if(!(newConnectorTypeVersionGraph instanceof DOMBased)){
			throw new IllegalArgumentException("Cannot handle non-DOM-based xArch entities.");
		}
		Element newChildElt = (Element)(((DOMBased)newConnectorTypeVersionGraph).getDOMNode());
		newChildElt = DOMUtils.cloneAndRename(newChildElt, VersionsConstants.NS_URI, CONNECTOR_TYPE_VERSION_GRAPH_ELT_NAME);
		((DOMBased)newConnectorTypeVersionGraph).setDOMNode(newChildElt);

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
				"connectorTypeVersionGraph", newConnectorTypeVersionGraph,
				XArchUtils.getDefaultXArchImplementation().isContainedIn(xArch, this))
			);
		}
	}
		
	public void addConnectorTypeVersionGraphs(Collection connectorTypeVersionGraphs){
		for(Iterator en = connectorTypeVersionGraphs.iterator(); en.hasNext(); ){
			IConnectorTypeVersionGraph elt = (IConnectorTypeVersionGraph)en.next();
			addConnectorTypeVersionGraph(elt);
		}
	}		
		
	public void clearConnectorTypeVersionGraphs(){
		//DOMUtils.removeChildren(elt, VersionsConstants.NS_URI, CONNECTOR_TYPE_VERSION_GRAPH_ELT_NAME);
		Collection coll = getAllConnectorTypeVersionGraphs();
		removeConnectorTypeVersionGraphs(coll);
	}
	
	public void removeConnectorTypeVersionGraph(IConnectorTypeVersionGraph connectorTypeVersionGraphToRemove){
		if(!(connectorTypeVersionGraphToRemove instanceof DOMBased)){
			throw new IllegalArgumentException("Cannot handle non-DOM-based xArch entities.");
		}
		NodeList nl = DOMUtils.getChildren(elt, VersionsConstants.NS_URI, CONNECTOR_TYPE_VERSION_GRAPH_ELT_NAME);
		for(int i = 0; i < nl.getLength(); i++){
			Node n = nl.item(i);
			if(n == ((DOMBased)connectorTypeVersionGraphToRemove).getDOMNode()){
				synchronized(DOMUtils.getDOMLock(elt)){
					elt.removeChild(n);
				}

				IXArch context = getXArch();
				if(context != null){
					context.fireXArchEvent(
						new XArchEvent(this, 
						XArchEvent.REMOVE_EVENT,
						XArchEvent.ELEMENT_CHANGED,
						"connectorTypeVersionGraph", connectorTypeVersionGraphToRemove,
						XArchUtils.getDefaultXArchImplementation().isContainedIn(xArch, this))
					);
				}

				return;
			}
		}
	}
	
	public void removeConnectorTypeVersionGraphs(Collection connectorTypeVersionGraphs){
		for(Iterator en = connectorTypeVersionGraphs.iterator(); en.hasNext(); ){
			IConnectorTypeVersionGraph elt = (IConnectorTypeVersionGraph)en.next();
			removeConnectorTypeVersionGraph(elt);
		}
	}
	
	public Collection getAllConnectorTypeVersionGraphs(){
		NodeList nl = DOMUtils.getChildren(elt, VersionsConstants.NS_URI, CONNECTOR_TYPE_VERSION_GRAPH_ELT_NAME);
		int nlLength = nl.getLength();
		ArrayList v = new ArrayList(nlLength);
		IXArch de = getXArch();
		for(int i = 0; i < nlLength; i++){
			Element el = (Element)nl.item(i);
			boolean found = false;
			if(de != null){
				IXArchElement cachedXArchElt = de.getWrapper(el);
				if(cachedXArchElt != null){
					v.add((IConnectorTypeVersionGraph)cachedXArchElt);
					found = true;
				}
			}
			if(!found){
				Object o = makeDerivedWrapper(el, "ConnectorTypeVersionGraph");	
				if(o != null){
					try{
						((edu.uci.isr.xarch.IXArchElement)o).setXArch(getXArch());
						if(de != null){
							de.cacheWrapper(el, ((edu.uci.isr.xarch.IXArchElement)o));
						}
						v.add((IConnectorTypeVersionGraph)o);
					}
					catch(Exception e){
						ConnectorTypeVersionGraphImpl eltImpl = new ConnectorTypeVersionGraphImpl((Element)nl.item(i));
						eltImpl.setXArch(getXArch());
						if(de != null){
							de.cacheWrapper(el, ((edu.uci.isr.xarch.IXArchElement)eltImpl));
						}
						v.add(eltImpl);
					}
				}
				else{
					ConnectorTypeVersionGraphImpl eltImpl = new ConnectorTypeVersionGraphImpl((Element)nl.item(i));
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

	public boolean hasConnectorTypeVersionGraph(IConnectorTypeVersionGraph connectorTypeVersionGraphToCheck){
		Collection c = getAllConnectorTypeVersionGraphs();
		
		for(Iterator en = c.iterator(); en.hasNext(); ){
			IConnectorTypeVersionGraph elt = (IConnectorTypeVersionGraph)en.next();
			if(elt.isEquivalent(connectorTypeVersionGraphToCheck)){
				return true;
			}
		}
		return false;
	}
	
	public Collection hasConnectorTypeVersionGraphs(Collection connectorTypeVersionGraphsToCheck){
		Vector v = new Vector();
		for(Iterator en = connectorTypeVersionGraphsToCheck.iterator(); en.hasNext(); ){
			IConnectorTypeVersionGraph elt = (IConnectorTypeVersionGraph)en.next();
			v.addElement(new Boolean(hasConnectorTypeVersionGraph(elt)));
		}
		return v;
	}
		
	public boolean hasAllConnectorTypeVersionGraphs(Collection connectorTypeVersionGraphsToCheck){
		for(Iterator en = connectorTypeVersionGraphsToCheck.iterator(); en.hasNext(); ){
			IConnectorTypeVersionGraph elt = (IConnectorTypeVersionGraph)en.next();
			if(!hasConnectorTypeVersionGraph(elt)){
				return false;
			}
		}
		return true;
	}
	public IConnectorTypeVersionGraph getConnectorTypeVersionGraph(String id){
		NodeList nl = DOMUtils.getChildren(elt, VersionsConstants.NS_URI, CONNECTOR_TYPE_VERSION_GRAPH_ELT_NAME);
		for(int i = 0; i < nl.getLength(); i++){
			
			IConnectorTypeVersionGraph el = new ConnectorTypeVersionGraphImpl((Element)nl.item(i));
			if(DOMUtils.objNullEq(id, el.getId())){
				Element domElt = (Element)nl.item(i);
				Object o = makeDerivedWrapper(domElt, "ConnectorTypeVersionGraph");
				if(o != null){
					try{
						((edu.uci.isr.xarch.IXArchElement)o).setXArch(getXArch());
						return (IConnectorTypeVersionGraph)o;
					}
					catch(Exception e){}
				}
				el.setXArch(getXArch());
				return el;
			}
		}
		return null;
	}
	
	public Collection getConnectorTypeVersionGraphs(Collection ids){
		//If there is an ID that does not exist, it is simply ignored.
		//You can tell if this happened if ids.size() != returned collection.size().
		Vector v = new Vector();
		for(Iterator en = ids.iterator(); en.hasNext(); ){
			String elt = (String)en.next();
			IConnectorTypeVersionGraph retElt = getConnectorTypeVersionGraph(elt);
			if(retElt != null){
				v.addElement(retElt);
			}
		}
		return v;
	}	
	
	public void addInterfaceTypeVersionGraph(IInterfaceTypeVersionGraph newInterfaceTypeVersionGraph){
		if(!(newInterfaceTypeVersionGraph instanceof DOMBased)){
			throw new IllegalArgumentException("Cannot handle non-DOM-based xArch entities.");
		}
		Element newChildElt = (Element)(((DOMBased)newInterfaceTypeVersionGraph).getDOMNode());
		newChildElt = DOMUtils.cloneAndRename(newChildElt, VersionsConstants.NS_URI, INTERFACE_TYPE_VERSION_GRAPH_ELT_NAME);
		((DOMBased)newInterfaceTypeVersionGraph).setDOMNode(newChildElt);

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
				"interfaceTypeVersionGraph", newInterfaceTypeVersionGraph,
				XArchUtils.getDefaultXArchImplementation().isContainedIn(xArch, this))
			);
		}
	}
		
	public void addInterfaceTypeVersionGraphs(Collection interfaceTypeVersionGraphs){
		for(Iterator en = interfaceTypeVersionGraphs.iterator(); en.hasNext(); ){
			IInterfaceTypeVersionGraph elt = (IInterfaceTypeVersionGraph)en.next();
			addInterfaceTypeVersionGraph(elt);
		}
	}		
		
	public void clearInterfaceTypeVersionGraphs(){
		//DOMUtils.removeChildren(elt, VersionsConstants.NS_URI, INTERFACE_TYPE_VERSION_GRAPH_ELT_NAME);
		Collection coll = getAllInterfaceTypeVersionGraphs();
		removeInterfaceTypeVersionGraphs(coll);
	}
	
	public void removeInterfaceTypeVersionGraph(IInterfaceTypeVersionGraph interfaceTypeVersionGraphToRemove){
		if(!(interfaceTypeVersionGraphToRemove instanceof DOMBased)){
			throw new IllegalArgumentException("Cannot handle non-DOM-based xArch entities.");
		}
		NodeList nl = DOMUtils.getChildren(elt, VersionsConstants.NS_URI, INTERFACE_TYPE_VERSION_GRAPH_ELT_NAME);
		for(int i = 0; i < nl.getLength(); i++){
			Node n = nl.item(i);
			if(n == ((DOMBased)interfaceTypeVersionGraphToRemove).getDOMNode()){
				synchronized(DOMUtils.getDOMLock(elt)){
					elt.removeChild(n);
				}

				IXArch context = getXArch();
				if(context != null){
					context.fireXArchEvent(
						new XArchEvent(this, 
						XArchEvent.REMOVE_EVENT,
						XArchEvent.ELEMENT_CHANGED,
						"interfaceTypeVersionGraph", interfaceTypeVersionGraphToRemove,
						XArchUtils.getDefaultXArchImplementation().isContainedIn(xArch, this))
					);
				}

				return;
			}
		}
	}
	
	public void removeInterfaceTypeVersionGraphs(Collection interfaceTypeVersionGraphs){
		for(Iterator en = interfaceTypeVersionGraphs.iterator(); en.hasNext(); ){
			IInterfaceTypeVersionGraph elt = (IInterfaceTypeVersionGraph)en.next();
			removeInterfaceTypeVersionGraph(elt);
		}
	}
	
	public Collection getAllInterfaceTypeVersionGraphs(){
		NodeList nl = DOMUtils.getChildren(elt, VersionsConstants.NS_URI, INTERFACE_TYPE_VERSION_GRAPH_ELT_NAME);
		int nlLength = nl.getLength();
		ArrayList v = new ArrayList(nlLength);
		IXArch de = getXArch();
		for(int i = 0; i < nlLength; i++){
			Element el = (Element)nl.item(i);
			boolean found = false;
			if(de != null){
				IXArchElement cachedXArchElt = de.getWrapper(el);
				if(cachedXArchElt != null){
					v.add((IInterfaceTypeVersionGraph)cachedXArchElt);
					found = true;
				}
			}
			if(!found){
				Object o = makeDerivedWrapper(el, "InterfaceTypeVersionGraph");	
				if(o != null){
					try{
						((edu.uci.isr.xarch.IXArchElement)o).setXArch(getXArch());
						if(de != null){
							de.cacheWrapper(el, ((edu.uci.isr.xarch.IXArchElement)o));
						}
						v.add((IInterfaceTypeVersionGraph)o);
					}
					catch(Exception e){
						InterfaceTypeVersionGraphImpl eltImpl = new InterfaceTypeVersionGraphImpl((Element)nl.item(i));
						eltImpl.setXArch(getXArch());
						if(de != null){
							de.cacheWrapper(el, ((edu.uci.isr.xarch.IXArchElement)eltImpl));
						}
						v.add(eltImpl);
					}
				}
				else{
					InterfaceTypeVersionGraphImpl eltImpl = new InterfaceTypeVersionGraphImpl((Element)nl.item(i));
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

	public boolean hasInterfaceTypeVersionGraph(IInterfaceTypeVersionGraph interfaceTypeVersionGraphToCheck){
		Collection c = getAllInterfaceTypeVersionGraphs();
		
		for(Iterator en = c.iterator(); en.hasNext(); ){
			IInterfaceTypeVersionGraph elt = (IInterfaceTypeVersionGraph)en.next();
			if(elt.isEquivalent(interfaceTypeVersionGraphToCheck)){
				return true;
			}
		}
		return false;
	}
	
	public Collection hasInterfaceTypeVersionGraphs(Collection interfaceTypeVersionGraphsToCheck){
		Vector v = new Vector();
		for(Iterator en = interfaceTypeVersionGraphsToCheck.iterator(); en.hasNext(); ){
			IInterfaceTypeVersionGraph elt = (IInterfaceTypeVersionGraph)en.next();
			v.addElement(new Boolean(hasInterfaceTypeVersionGraph(elt)));
		}
		return v;
	}
		
	public boolean hasAllInterfaceTypeVersionGraphs(Collection interfaceTypeVersionGraphsToCheck){
		for(Iterator en = interfaceTypeVersionGraphsToCheck.iterator(); en.hasNext(); ){
			IInterfaceTypeVersionGraph elt = (IInterfaceTypeVersionGraph)en.next();
			if(!hasInterfaceTypeVersionGraph(elt)){
				return false;
			}
		}
		return true;
	}
	public IInterfaceTypeVersionGraph getInterfaceTypeVersionGraph(String id){
		NodeList nl = DOMUtils.getChildren(elt, VersionsConstants.NS_URI, INTERFACE_TYPE_VERSION_GRAPH_ELT_NAME);
		for(int i = 0; i < nl.getLength(); i++){
			
			IInterfaceTypeVersionGraph el = new InterfaceTypeVersionGraphImpl((Element)nl.item(i));
			if(DOMUtils.objNullEq(id, el.getId())){
				Element domElt = (Element)nl.item(i);
				Object o = makeDerivedWrapper(domElt, "InterfaceTypeVersionGraph");
				if(o != null){
					try{
						((edu.uci.isr.xarch.IXArchElement)o).setXArch(getXArch());
						return (IInterfaceTypeVersionGraph)o;
					}
					catch(Exception e){}
				}
				el.setXArch(getXArch());
				return el;
			}
		}
		return null;
	}
	
	public Collection getInterfaceTypeVersionGraphs(Collection ids){
		//If there is an ID that does not exist, it is simply ignored.
		//You can tell if this happened if ids.size() != returned collection.size().
		Vector v = new Vector();
		for(Iterator en = ids.iterator(); en.hasNext(); ){
			String elt = (String)en.next();
			IInterfaceTypeVersionGraph retElt = getInterfaceTypeVersionGraph(elt);
			if(retElt != null){
				v.addElement(retElt);
			}
		}
		return v;
	}	
	
	public boolean isEquivalent(IArchVersions c){
		return (getClass().equals(c.getClass())) &&
			hasAllComponentTypeVersionGraphs(c.getAllComponentTypeVersionGraphs()) &&
			c.hasAllComponentTypeVersionGraphs(getAllComponentTypeVersionGraphs()) &&
			hasAllConnectorTypeVersionGraphs(c.getAllConnectorTypeVersionGraphs()) &&
			c.hasAllConnectorTypeVersionGraphs(getAllConnectorTypeVersionGraphs()) &&
			hasAllInterfaceTypeVersionGraphs(c.getAllInterfaceTypeVersionGraphs()) &&
			c.hasAllInterfaceTypeVersionGraphs(getAllInterfaceTypeVersionGraphs()) ;
	}

}