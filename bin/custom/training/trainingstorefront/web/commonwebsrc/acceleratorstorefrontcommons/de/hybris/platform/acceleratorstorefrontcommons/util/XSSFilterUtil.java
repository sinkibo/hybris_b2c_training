/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.acceleratorstorefrontcommons.util;


/**
 * Filters given string to prevent cross-site scripting
 */
public final class XSSFilterUtil
{

	private XSSFilterUtil()
	{
		//Utility classes, which are a collection of static members, are not meant to be instantiated
	}

	/**
	 *
	 * @param value
	 *           to be sanitized
	 * @return sanitized content
	 */
	public static String filter(final String value)
	{
		if (value == null)
		{
			return null;
		}
		String sanitized = value;
		// Simple characters
		sanitized = sanitized.replace("<", "&lt;").replace(">", "&gt;");
		sanitized = sanitized.replace("(", "&#40;").replace(")", "&#41;");
		sanitized = sanitized.replace("'", "&#39;");
		// RegEx pattern
		sanitized = sanitized.replaceAll("eval\\((.*)\\)", "");
		sanitized = sanitized.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
		return sanitized;
	}
}
