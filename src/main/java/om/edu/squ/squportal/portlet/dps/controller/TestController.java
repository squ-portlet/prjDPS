/**
 * Project				:	prjLibrary
 * Organization			:	Sultan Qaboos University | Muscat | Oman
 * Centre				:	Centre for Information System
 * Department			:	Web & E-Services
 * 
 * Author				:	Bhabesh
 *
 * FrameWork			:	Spring 3.2.3 (Annotation) Portlet
 * 
 * File Name			:	TestController.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.controller
 * Date of creation		:	May 20, 2015  1:49:40 PM
 * Date of modification :	
 * 
 * Summary				:	
 *
 *
 * Copyright 2015 the original author or authors and Organization.
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
package om.edu.squ.squportal.portlet.dps.controller;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;

/**
 * @author Bhabesh
 *
 */
@Controller
@RequestMapping("VIEW")
public class TestController
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping
	private String welcome(PortletRequest request, Model model)
	{
		testActiviti();

		logger.info("driverClassName : "+PropsUtil.get("jdbc.default.driverClassName"));
		logger.info("url : "+PropsUtil.get("jdbc.default.url"));
		logger.info("username : "+PropsUtil.get("jdbc.default.username"));
		logger.info("password : "+PropsUtil.get("jdbc.default.password"));

		model.addAttribute("driverClassName", PropsUtil.get("jdbc.default.driverClassName"));
		model.addAttribute("url", PropsUtil.get("jdbc.default.url"));
		model.addAttribute("username", PropsUtil.get("jdbc.default.username"));
		model.addAttribute("password", PropsUtil.get("jdbc.default.password"));
			
		return "welcome";
	}
	
	
	private void testActiviti()
	{
		
		
	}
}
