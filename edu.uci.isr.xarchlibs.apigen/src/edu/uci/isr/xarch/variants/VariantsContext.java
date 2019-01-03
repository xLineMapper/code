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
package edu.uci.isr.xarch.variants;

import java.util.*;

import edu.uci.isr.xarch.*;

import org.w3c.dom.*;

import edu.uci.isr.xarch.IXArch;
import edu.uci.isr.xarch.IXArchContext;

/**
 * The context object for the variants package.
 * This object is used to create objects that are used
 * in the variants namespace.
 *
 * @author Automatically Generated by xArch apigen
 */
public class VariantsContext implements IVariantsContext {

	protected static final String DEFAULT_ELT_NAME = "anonymousInstanceTag";
	protected Document doc;
	protected IXArch xArch;

	/**
	 * Create a new VariantsContext for the given
	 * IXArch object.
	 * @param xArch XArch object to contextualize in this namespace.
	 */
	public VariantsContext(IXArch xArch){
		if(!(xArch instanceof DOMBased)){
			throw new IllegalArgumentException("Cannot process non-DOM based xArch entities.");
		}
		Node docRootNode = ((DOMBased)xArch).getDOMNode();
		synchronized(DOMUtils.getDOMLock(docRootNode)){
			this.doc = docRootNode.getOwnerDocument();
			xArch.addSchemaLocation("http://www.ics.uci.edu/pub/arch/xArch/variants.xsd", "http://www.isr.uci.edu/projects/xarchuci/ext/variants.xsd");
			this.xArch = xArch;
		}
	}

	public IXArch getXArch(){
		return xArch;
	}
	
	protected Element createElement(String name){
		synchronized(DOMUtils.getDOMLock(doc)){
			return doc.createElementNS(VariantsConstants.NS_URI, name);
		}
	}

	public XArchTypeMetadata getTypeMetadata(){
		return IVariantsContext.TYPE_METADATA;
	}
	/**
	 * Create an IVariant object in this namespace.
	 * @return New IVariant object.
	 */
	public IVariant createVariant(){
		Element elt = createElement(DEFAULT_ELT_NAME);
		DOMUtils.addXSIType(elt, VariantImpl.XSD_TYPE_NSURI, VariantImpl.XSD_TYPE_NAME);
		VariantImpl newElt = new VariantImpl(elt);
		newElt.setXArch(this.getXArch());
		return newElt;
	}

	/**
	 * Brings an IVariant object created in another
	 * context into this context.
	 * @param value Object to recontextualize.
	 * @return <code>value</code> object in this namespace.
	 */
	public IVariant recontextualizeVariant(IVariant value){
		if(!(value instanceof DOMBased)){
			throw new IllegalArgumentException("Cannot process non-DOM based xArch entities.");
		}
		Element elt = (Element)((DOMBased)value).getDOMNode();

		elt = DOMUtils.cloneAndRename(elt, doc, VariantsConstants.NS_URI, elt.getLocalName());
		//elt = DOMUtils.cloneAndRename(elt, VariantsConstants.NS_URI, elt.getTagName());

		//Removed next line because it causes an illegal character DOM exception
		//elt.setPrefix(null);

		((DOMBased)value).setDOMNode(elt);
		((IXArchElement)value).setXArch(this.getXArch());
		return value;
	}

	/**
	 * Create an edu.uci.isr.xarch.options.IGuard object in this namespace.
	 * @return New edu.uci.isr.xarch.options.IGuard object.
	 */
	public edu.uci.isr.xarch.options.IGuard createGuard(){
		Element elt = createElement(DEFAULT_ELT_NAME);
		DOMUtils.addXSIType(elt, edu.uci.isr.xarch.options.GuardImpl.XSD_TYPE_NSURI, edu.uci.isr.xarch.options.GuardImpl.XSD_TYPE_NAME);
		edu.uci.isr.xarch.options.GuardImpl newElt = new edu.uci.isr.xarch.options.GuardImpl(elt);
		newElt.setXArch(this.getXArch());
		return newElt;
	}

	/**
	 * Brings an edu.uci.isr.xarch.options.IGuard object created in another
	 * context into this context.
	 * @param value Object to recontextualize.
	 * @return <code>value</code> object in this namespace.
	 */
	public edu.uci.isr.xarch.options.IGuard recontextualizeGuard(edu.uci.isr.xarch.options.IGuard value){
		if(!(value instanceof DOMBased)){
			throw new IllegalArgumentException("Cannot process non-DOM based xArch entities.");
		}
		Element elt = (Element)((DOMBased)value).getDOMNode();

		elt = DOMUtils.cloneAndRename(elt, doc, VariantsConstants.NS_URI, elt.getLocalName());
		//elt = DOMUtils.cloneAndRename(elt, VariantsConstants.NS_URI, elt.getTagName());

		//Removed next line because it causes an illegal character DOM exception
		//elt.setPrefix(null);

		((DOMBased)value).setDOMNode(elt);
		((IXArchElement)value).setXArch(this.getXArch());
		return value;
	}

	/**
	 * Create an edu.uci.isr.xarch.instance.IXMLLink object in this namespace.
	 * @return New edu.uci.isr.xarch.instance.IXMLLink object.
	 */
	public edu.uci.isr.xarch.instance.IXMLLink createXMLLink(){
		Element elt = createElement(DEFAULT_ELT_NAME);
		DOMUtils.addXSIType(elt, edu.uci.isr.xarch.instance.XMLLinkImpl.XSD_TYPE_NSURI, edu.uci.isr.xarch.instance.XMLLinkImpl.XSD_TYPE_NAME);
		edu.uci.isr.xarch.instance.XMLLinkImpl newElt = new edu.uci.isr.xarch.instance.XMLLinkImpl(elt);
		newElt.setXArch(this.getXArch());
		return newElt;
	}

	/**
	 * Brings an edu.uci.isr.xarch.instance.IXMLLink object created in another
	 * context into this context.
	 * @param value Object to recontextualize.
	 * @return <code>value</code> object in this namespace.
	 */
	public edu.uci.isr.xarch.instance.IXMLLink recontextualizeXMLLink(edu.uci.isr.xarch.instance.IXMLLink value){
		if(!(value instanceof DOMBased)){
			throw new IllegalArgumentException("Cannot process non-DOM based xArch entities.");
		}
		Element elt = (Element)((DOMBased)value).getDOMNode();

		elt = DOMUtils.cloneAndRename(elt, doc, VariantsConstants.NS_URI, elt.getLocalName());
		//elt = DOMUtils.cloneAndRename(elt, VariantsConstants.NS_URI, elt.getTagName());

		//Removed next line because it causes an illegal character DOM exception
		//elt.setPrefix(null);

		((DOMBased)value).setDOMNode(elt);
		((IXArchElement)value).setXArch(this.getXArch());
		return value;
	}

	/**
	 * Create an IVariantComponentType object in this namespace.
	 * @return New IVariantComponentType object.
	 */
	public IVariantComponentType createVariantComponentType(){
		Element elt = createElement(DEFAULT_ELT_NAME);
		DOMUtils.addXSIType(elt, VariantComponentTypeImpl.XSD_TYPE_NSURI, VariantComponentTypeImpl.XSD_TYPE_NAME);
		VariantComponentTypeImpl newElt = new VariantComponentTypeImpl(elt);
		newElt.setXArch(this.getXArch());
		return newElt;
	}

	/**
	 * Brings an IVariantComponentType object created in another
	 * context into this context.
	 * @param value Object to recontextualize.
	 * @return <code>value</code> object in this namespace.
	 */
	public IVariantComponentType recontextualizeVariantComponentType(IVariantComponentType value){
		if(!(value instanceof DOMBased)){
			throw new IllegalArgumentException("Cannot process non-DOM based xArch entities.");
		}
		Element elt = (Element)((DOMBased)value).getDOMNode();

		elt = DOMUtils.cloneAndRename(elt, doc, VariantsConstants.NS_URI, elt.getLocalName());
		//elt = DOMUtils.cloneAndRename(elt, VariantsConstants.NS_URI, elt.getTagName());

		//Removed next line because it causes an illegal character DOM exception
		//elt.setPrefix(null);

		((DOMBased)value).setDOMNode(elt);
		((IXArchElement)value).setXArch(this.getXArch());
		return value;
	}

	/**
	 * Promote an object of type <code>edu.uci.isr.xarch.types.IComponentType</code>
	 * to one of type <code>IVariantComponentType</code>.  xArch APIs
	 * are structured in such a way that a regular cast is not possible
	 * to change interface types, so casting must be done through these
	 * promotion functions.  If the <code>edu.uci.isr.xarch.types.IComponentType</code>
	 * object wraps a DOM element that is the base type, then the 
	 * <code>xsi:type</code> of the base element is promoted.  Otherwise, 
	 * it is left unchanged.
	 *
	 * This function also emits an <CODE>XArchEvent</CODE> with type
	 * PROMOTE_TYPE.  The source for this events is the pre-promoted
	 * IXArchElement object (should no longer be used), and the
	 * target is the post-promotion object.  The target name is
	 * the name of the interface class that was the target of the
	 * promotion.
	 * 
	 * @param value Object to promote.
	 * @return Promoted object.
	 */
	public IVariantComponentType promoteToVariantComponentType(
	edu.uci.isr.xarch.types.IComponentType value){
		if(!(value instanceof DOMBased)){
			throw new IllegalArgumentException("Cannot process non-DOM based xArch entities.");
		}
		Element elt = (Element)((DOMBased)value).getDOMNode();

		if(DOMUtils.hasXSIType(elt, 
			edu.uci.isr.xarch.types.ComponentTypeImpl.XSD_TYPE_NSURI,
			edu.uci.isr.xarch.types.ComponentTypeImpl.XSD_TYPE_NAME)){

				DOMUtils.addXSIType(elt, VariantComponentTypeImpl.XSD_TYPE_NSURI, 
					VariantComponentTypeImpl.XSD_TYPE_NAME);
		}
		VariantComponentTypeImpl newElt = new VariantComponentTypeImpl(elt);
		newElt.setXArch(this.getXArch());

		xArch.fireXArchEvent(
			new XArchEvent(value, 
			XArchEvent.PROMOTE_EVENT,
			XArchEvent.ELEMENT_CHANGED,
			IVariantComponentType.class.getName(), newElt,
			XArchUtils.getDefaultXArchImplementation().isContainedIn(xArch, newElt))
		);

		return newElt;
	}

	/**
	 * Create an IVariantConnectorType object in this namespace.
	 * @return New IVariantConnectorType object.
	 */
	public IVariantConnectorType createVariantConnectorType(){
		Element elt = createElement(DEFAULT_ELT_NAME);
		DOMUtils.addXSIType(elt, VariantConnectorTypeImpl.XSD_TYPE_NSURI, VariantConnectorTypeImpl.XSD_TYPE_NAME);
		VariantConnectorTypeImpl newElt = new VariantConnectorTypeImpl(elt);
		newElt.setXArch(this.getXArch());
		return newElt;
	}

	/**
	 * Brings an IVariantConnectorType object created in another
	 * context into this context.
	 * @param value Object to recontextualize.
	 * @return <code>value</code> object in this namespace.
	 */
	public IVariantConnectorType recontextualizeVariantConnectorType(IVariantConnectorType value){
		if(!(value instanceof DOMBased)){
			throw new IllegalArgumentException("Cannot process non-DOM based xArch entities.");
		}
		Element elt = (Element)((DOMBased)value).getDOMNode();

		elt = DOMUtils.cloneAndRename(elt, doc, VariantsConstants.NS_URI, elt.getLocalName());
		//elt = DOMUtils.cloneAndRename(elt, VariantsConstants.NS_URI, elt.getTagName());

		//Removed next line because it causes an illegal character DOM exception
		//elt.setPrefix(null);

		((DOMBased)value).setDOMNode(elt);
		((IXArchElement)value).setXArch(this.getXArch());
		return value;
	}

	/**
	 * Promote an object of type <code>edu.uci.isr.xarch.types.IConnectorType</code>
	 * to one of type <code>IVariantConnectorType</code>.  xArch APIs
	 * are structured in such a way that a regular cast is not possible
	 * to change interface types, so casting must be done through these
	 * promotion functions.  If the <code>edu.uci.isr.xarch.types.IConnectorType</code>
	 * object wraps a DOM element that is the base type, then the 
	 * <code>xsi:type</code> of the base element is promoted.  Otherwise, 
	 * it is left unchanged.
	 *
	 * This function also emits an <CODE>XArchEvent</CODE> with type
	 * PROMOTE_TYPE.  The source for this events is the pre-promoted
	 * IXArchElement object (should no longer be used), and the
	 * target is the post-promotion object.  The target name is
	 * the name of the interface class that was the target of the
	 * promotion.
	 * 
	 * @param value Object to promote.
	 * @return Promoted object.
	 */
	public IVariantConnectorType promoteToVariantConnectorType(
	edu.uci.isr.xarch.types.IConnectorType value){
		if(!(value instanceof DOMBased)){
			throw new IllegalArgumentException("Cannot process non-DOM based xArch entities.");
		}
		Element elt = (Element)((DOMBased)value).getDOMNode();

		if(DOMUtils.hasXSIType(elt, 
			edu.uci.isr.xarch.types.ConnectorTypeImpl.XSD_TYPE_NSURI,
			edu.uci.isr.xarch.types.ConnectorTypeImpl.XSD_TYPE_NAME)){

				DOMUtils.addXSIType(elt, VariantConnectorTypeImpl.XSD_TYPE_NSURI, 
					VariantConnectorTypeImpl.XSD_TYPE_NAME);
		}
		VariantConnectorTypeImpl newElt = new VariantConnectorTypeImpl(elt);
		newElt.setXArch(this.getXArch());

		xArch.fireXArchEvent(
			new XArchEvent(value, 
			XArchEvent.PROMOTE_EVENT,
			XArchEvent.ELEMENT_CHANGED,
			IVariantConnectorType.class.getName(), newElt,
			XArchUtils.getDefaultXArchImplementation().isContainedIn(xArch, newElt))
		);

		return newElt;
	}


}

