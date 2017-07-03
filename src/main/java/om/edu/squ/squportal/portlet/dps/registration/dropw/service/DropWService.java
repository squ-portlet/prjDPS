package om.edu.squ.squportal.portlet.dps.registration.dropw.service;

import java.util.List;
import java.util.Locale;

import om.edu.squ.squportal.portlet.dps.bo.Employee;
import om.edu.squ.squportal.portlet.dps.bo.Student;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NoDBRecordException;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NotSuccessFulDBUpdate;
import om.edu.squ.squportal.portlet.dps.registration.dropw.bo.DropWDTO;
import om.edu.squ.squportal.portlet.dps.registration.dropw.model.DropCourseModel;

public interface DropWService
{
	/**
	 * 
	 * method name  : getCourseList
	 * @param student
	 * @param locale
	 * @return
	 * DropWDBImpl
	 * return type  : List<DropWDTO>
	 * 
	 * purpose		: Get list of courses for drop
	 *
	 * Date    		:	Mar 30, 2017 8:20:37 AM
	 */
	public List<DropWDTO> getCourseList(Student student, Locale locale);
	
	/**
	 * 
	 * method name  : setDropWCourseAdd
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
	public List<DropWDTO> setDropWCourseAdd(Student student, DropCourseModel dropCourseModel, Locale locale);
	
	/**
	 * 
	 * method name  : getDropWCourses
	 * @param student
	 * @param locale
	 * @return
	 * DropWServiceImpl
	 * return type  : List<DropWDTO>
	 * 
	 * purpose		: get details of the courses opt to be dropped
	 *
	 * Date    		:	Apr 12, 2017 4:50:19 PM
	 */
	public List<DropWDTO>  getDropWCourses(Student student, Locale locale);
	
	/**
	 * 
	 * method name  : getDropWForApprovers
	 * @param roleType
	 * @param employee
	 * @param locale
	 * @return
	 * DropWDBImpl
	 * return type  : List<DropWDTO>
	 * 
	 * purpose		: Get List of student records for courses to be dropped 
	 *
	 * Date    		:	Apr 17, 2017 8:24:28 PM
	 * @throws NoDBRecordException 
	 */
	public List<DropWDTO> getDropWForApprovers(String roleType, Employee employee, Locale locale) throws NoDBRecordException;
	
	/**
	 * 
	 * method name  : setDropWCourseUpdate
	 * @param dropWDTO
	 * @param locale TODO
	 * @return
	 * DropWDBImpl
	 * return type  : int
	 * 
	 * purpose		: update approver's action in drop w
	 *
	 * Date    		:	May 2, 2017 10:59:22 AM
	 * @throws NotSuccessFulDBUpdate 
	 */
	public List<DropWDTO> setDropWCourseUpdate(DropWDTO dropWDTO, Locale locale) throws NotSuccessFulDBUpdate;
	
	/**
	 * 
	 * method name  : isRuleStudentComplete
	 * @param studentNo
	 * @param stdStatCode
	 * @return
	 * DropWServiceImpl
	 * return type  : boolean
	 * 
	 * purpose		: Rule for Droping the course with W
	 *
	 * Date    		:	May 17, 2017 3:11:11 PM
	 */
	public boolean isRuleStudentComplete(String studentNo, String stdStatCode);
	
}
