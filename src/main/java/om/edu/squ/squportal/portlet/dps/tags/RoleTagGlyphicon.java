/**
 * Project				:	prjDPS
 * Organization			:	Sultan Qaboos University | Muscat | Oman
 * Centre				:	Centre for Information System
 * Department			:	Web & E-Services
 * 
 * Author				:	Bhabesh
 *
 * FrameWork			:	Spring 4.0.8 (Annotation) Portlet
 * 
 * File Name			:	RoleTagGlyphicon.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.tags
 * Date of creation		:	Mar 5, 2017  4:13:00 PM
 * Date of modification :	
 * 
 * Summary				:	Custom tag to show bootstrap glyphicon upon approve, reject etc
 *
 *
 * Copyright 2017 the original author or authors and Organization.
 *
 * Licensed under the SQU, CIS policy
 * you may not use this file except in compliance with the License.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * 
 */
package om.edu.squ.squportal.portlet.dps.tags;

/**
 * @author Bhabesh
 *
 */
public class RoleTagGlyphicon
{
	private RoleTagGlyphicon(){}
	
	public static String showIkon(String approveValue)
	{
		String result 	= null;
		switch(approveValue)
		{
			case	"Y" :
				result =  "<font color='green'><span class='glyphicon glyphicon-ok' aria-hidden='true'></span></font>";
				break;
			case	"N" :
				result =  "<font color='red'><span class='glyphicon glyphicon-remove' aria-hidden='true'></span></font>";
				break;
			case	"NA" :
				result =  "<span class='glyphicon glyphicon-ban-circle' aria-hidden='true'></span>";
				break;
			default :
				result =  "<span class='glyphicon glyphicon-ban-circle' aria-hidden='true'></span>";
				break;
		}
		
		
		return result;
	}
}
