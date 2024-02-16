/*******************************************************************************
 *  Copyright (c) 2024 Obeo. 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v20.html
 *   
 *   Contributors:
 *       Obeo - initial API and implementation
 *  
 *******************************************************************************/
package com.obeo.loophole.extensionpoint.definition;

/**
 * Interface to implement to contribute additional custom code.
 * 
 * @author Gabriel Jolly - Initial contribution
 */
public interface IAdditionalCustomCode {

	/**
	 * Check if the context is good.
	 * 
	 * @param className       Name of the class
	 * @param customClassName Name of the custom class
	 * @return true if the given class have additional custom code to provide, false
	 *         otherwise.
	 */
	public boolean apply(String className, String customClassName);

	/**
	 * Generate code to add in custom classes.
	 * 
	 * @param className       Name of the class
	 * @param customClassName Name of the custom class
	 * @param sb              StringBuilder to contribute
	 */
	public void generateCode(String className, String customClassName, StringBuilder sb);
}
