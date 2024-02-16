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
package com.obeo.loophole.extensionpoint.contribution;

import com.obeo.loophole.extensionpoint.definition.IAdditionalCustomCode;

/**
 * Sample contribution class to add code in custom classes.
 * 
 * @author Gabriel Jolly - Initial contribution
 */
public class CustomCodeGenerator implements IAdditionalCustomCode {

	@Override
	public boolean apply(String className, String customClassName) {
		return true;
	}

	@Override
	public void generateCode(String className, String customClassName, StringBuilder sb) {
		if (className.contains("ItemProvider")) {
			//model.edit custom code
			
		} else {
			//model custom code			
			sb.append("\t// CustomFields\n");
			sb.append("\tprivate boolean customBoolean;\n");
			sb.append("\n");

			sb.append("\t// CustomMethods\n");
			sb.append("\tpublic boolean getCustomBoolean() {\n");
			sb.append("\t\treturn customBoolean;\n");
			sb.append("\t}\n\n");

			sb.append("\tpublic void setCustomBoolean(boolean newCustomBoolean) {\n");
			sb.append("\t\tcustomBoolean = newCustomBoolean;\n");
			sb.append("\t}\n\n");
		}
	}
}
