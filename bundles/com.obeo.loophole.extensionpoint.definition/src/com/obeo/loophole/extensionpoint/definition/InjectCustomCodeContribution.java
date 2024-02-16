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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.e4.core.di.annotations.Execute;

/**
 * Entry point of the code contribution.
 * 
 * @author Gabriel Jolly - Initial contribution
 */
public class InjectCustomCodeContribution {
	private static final String INJECT_CUSTOM_CODE_ID = "com.obeo.loophole.extensionpoint.definition.injectCustomCode";

	@Execute
	public void execute(IExtensionRegistry registry, String className, String customClassName, StringBuilder sb) {
		IConfigurationElement[] config = registry.getConfigurationElementsFor(INJECT_CUSTOM_CODE_ID);
		try {
			for (IConfigurationElement e : config) {
				System.out.println("Evaluating extension");
				final Object o = e.createExecutableExtension("class");
				if (o instanceof IAdditionalCustomCode) {
					IAdditionalCustomCode additionalCustomCode = (IAdditionalCustomCode) o;
					if (additionalCustomCode.apply(className, customClassName)) {
						additionalCustomCode.generateCode(className, customClassName, sb);
					}
				}
			}
		} catch (CoreException ex) {
			System.out.println(ex.getMessage());
		}
	}

	/**
	 * Allow to contribute additional custom code.
	 * 
	 * @param className       Name of the class to contribute
	 * @param customClassName Name of the custom class to contribute
	 * @param sb              {@link StringBuilder} to contribute
	 */
	public static void addGeneratedCode(String className, String customClassName, StringBuilder sb) {
		new InjectCustomCodeContribution().execute(Platform.getExtensionRegistry(), className, customClassName, sb);
	}
}