package om.edu.squ.squportal.portlet.dps.registration.dropw.service;

import java.util.List;
import java.util.Locale;

import om.edu.squ.squportal.portlet.dps.bo.Student;
import om.edu.squ.squportal.portlet.dps.registration.dropw.bo.DropWDTO;
import om.edu.squ.squportal.portlet.dps.registration.dropw.model.DropCourseModel;

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
	
	/**
	 * 
	 * method name  : setDropWCourse
	 * @param student
	 * @param dropCourseModel
	 * @param locale
	 * @return
	 * DropWService
	 * return type  : List<DropWDTO>
	 * 
	 * purpose		: Based upon students action display related courses opt for drop with w
	 *
	 * Date    		:	Apr 11, 2017 5:45:53 PM
	 */
	public List<DropWDTO> setDropWCourse(Student student, DropCourseModel dropCourseModel, Locale locale);
	
}
