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
 * File Name			:	UserIdUtil.java
 * Package Name			:	om.edu.squ.squportal.portlet.wireless.utility
 * Date of creation		:	Jan 05, 2017 
 * Date of modification :	
 * 
 * Summary				:	Utility for Student
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
package om.edu.squ.squportal.portlet.dps.utility;

import om.edu.squ.portal.common.EmpCommon;
import om.edu.squ.squportal.portlet.dps.bo.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ldap.core.LdapTemplate;

/**
 * @author Bhabesh
 *
 */
public class UserIdUtil
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	 public String getStudentId(String username) 
	  {

	    String userNamePart1 = new String();
	    String userNamePart2 = new String();
	    String userNamePart3 = new String();

	    String UserName = new String();
	    int    intStdID=0;
	    int    UserNamePart3Length =0; 
	    
	    if (username.startsWith("M8") && (username.length()==7))
	       username="M08"+username.substring(2);
	    
	     if (username.startsWith("D8") && (username.length()==7))
	       username="D08"+username.substring(2);
	      
	    if (username.startsWith("P8") && (username.length()==7))
	       username="P08"+username.substring(2);
	       
	    userNamePart1 = username.substring(0,2);
	    userNamePart2 = username.substring(2,4);
	    userNamePart3 = username.substring(4);
	   // intStdID= Integer.parseInt(userName);
	  
	   if (  (     (userNamePart2.equals("86")) 
	           ||  (userNamePart2.equals("87")) 
	           ||  (userNamePart2.equals("88")) 
	           ||  (userNamePart2.equals("89")) 
	          )
	          && ((userNamePart2.length()+userNamePart3.length())==6)
	      )
	      {
	          UserNamePart3Length= userNamePart3.length();
	          
	          for (int i=0; i<(7-UserNamePart3Length); i++)
	               UserName = "0"+UserName;
	          UserName = userNamePart2 + UserName + userNamePart3;
	      }
	    else
	        UserName= username.substring(1);
	     intStdID = Integer.parseInt(UserName);   
	     
	     UserName=intStdID+""; 
	     return UserName;
	  }// end getStudentId

	 
	 	/**
	 	 * 
	 	 * method name  : getUser
	 	 * @param strUserName
	 	 * @return
	 	 * UserIdUtil
	 	 * return type  : User
	 	 * 
	 	 * purpose		: Get user
	 	 *
	 	 * Date    		:	Jan 9, 2017 12:37:58 PM
	 	 */
		public User getUser(String strUserName)
		{
			User	user		=	new User();
			try
			{
			if (isStudentId(strUserName.toUpperCase()))
			  {
				  user.setUserId(getStudentId(strUserName));
				  user.setUserType(Constants.USER_TYPE_STUDENT);
			  }
			  else
			  {
				EmpCommon	empCommon	=	new EmpCommon();
				user.setUserId(empCommon.getEmployeeNumber(strUserName));
				user.setUserType(Constants.USER_TYPE_EMPLOYEE);
			  }
			}
			catch(NullPointerException nullEx)
			{
				logger.error("Error :: No valid user logged in :: ,{}", nullEx.getMessage());
			}
			return user;
		}
		
		
		
			
		/**
		 * 
		 * method name  : isStudentId
		 * @param strUserName
		 * @return
		 * UserIdUtil
		 * return type  : boolean
		 * 
		 * purpose		: Check whether the user is student 
		 *
		 * Date    		:	Aug 14, 2014 1:17:17 PM
		 */
		private boolean isStudentId(String strUserName)
		{
			if (
					strUserName.startsWith("S0") || strUserName.startsWith("U0") 
					||strUserName.startsWith("S1") || strUserName.startsWith("S2")// added on 25/08/2015 because to deal with students whose ids with no "S1 to S9"
					||strUserName.startsWith("S3") || strUserName.startsWith("S4")
					||strUserName.startsWith("S5") || strUserName.startsWith("S6")
					||strUserName.startsWith("S7") || strUserName.startsWith("S8")
					||strUserName.startsWith("S9") 
				     || strUserName.startsWith("M0") || strUserName.startsWith("M1")
				      || strUserName.startsWith("M2") || strUserName.startsWith("M3")
				      || strUserName.startsWith("M4")|| strUserName.startsWith("M5")
				      || strUserName.startsWith("M6") || strUserName.startsWith("M7")
				      || strUserName.startsWith("M8")|| strUserName.startsWith("M9")
				    ||  strUserName.startsWith("U1") // added on 09/09/2012 becuase to deal with students whose ids with no "U0" 
				    || strUserName.startsWith("V0")|| strUserName.startsWith("V1") // added on 12/09/2012 becuase to deal with students whose ids with no "P0" and "V0" 
				    || strUserName.startsWith("D0")  || strUserName.startsWith("D1")// added on 12/09/2012 becuase to deal with students whose ids with no "D0" amd "M0" 
				   || strUserName.startsWith("D2")  || strUserName.startsWith("D3")
				   || strUserName.startsWith("D4")  || strUserName.startsWith("D5")
				   || strUserName.startsWith("D6")  || strUserName.startsWith("D7")
				   || strUserName.startsWith("D8")  || strUserName.startsWith("D9")
				   || strUserName.startsWith("P0")|| strUserName.startsWith("P1")
				   || strUserName.startsWith("P2")|| strUserName.startsWith("P3")
				   || strUserName.startsWith("P4")|| strUserName.startsWith("P5")
				   || strUserName.startsWith("P6")|| strUserName.startsWith("P7")
				   || strUserName.startsWith("P8")|| strUserName.startsWith("P9")
				    
				   )
			{
				return true;
			}
			else
			{
				return false;
			}
			
		}

		
}
