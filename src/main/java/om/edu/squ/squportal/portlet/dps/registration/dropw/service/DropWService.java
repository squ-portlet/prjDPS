package om.edu.squ.squportal.portlet.dps.registration.dropw.service;

import java.util.List;
import java.util.Locale;

import om.edu.squ.squportal.portlet.dps.registration.dropw.bo.DropWDTO;

public interface DropWService
{
	/**
	 * 
	 * method name  : getCourseList
	 * @param studentId
	 * @param locale
	 * @return
	 * DropWDBImpl
	 * return type  : List<DropWDTO>
	 * 
	 * purpose		: Get list of courses for drop
	 *
	 * Date    		:	Mar 30, 2017 8:20:37 AM
	 */
	public List<DropWDTO> getCourseList(String studentId, Locale locale);
}
