/*Delete from T_REG_POSTPONE */
DELETE FROM T_REG_POSTPONE
WHERE
	STDNO= 77894
	AND STDSTATCD = 156454
	AND FROMCCYRCD = 2017
	AND FROMSEMCD = 2;

/*Delete from Std_Postpone */
DELETE FROM STD_POSTPONE
WHERE
    STDNO  = 77894
  AND STDSTATCD = 156454
  AND FROMCCYRCD = 2017
  AND FROMSEMCD = 2;
  

  /* Delete from STD_GRADES */
Delete from STD_GRADES
where
	stdno = 77894
	and ccyrcd= 2017
	AND semcd= 2;


/* Delete from TUITION_FEES_STD */
DELETE TUITION_FEES_STD WHERE STDNO=77894 AND L_ABR_CRSNO='CAMS6001' AND SECTCD=188265;
DELETE TUITION_FEES_STD WHERE STDNO=77894 AND L_ABR_CRSNO='MASF6002' AND SECTCD=188291;

  
  
/* Insert into SCHED_STD */
Insert into SCHED_STD (STDNO,L_ABR_CRSNO,CRSNO,CRSTYPCD,SECTCD,SECTNO,HODAPROVALCD,CONDREGCD,ADVISAPROVALCD,AUDITFLAGCD,GRADECD,USRACCTCD) values (77894,'CAMS6001',14756,1,188265,10,2,2,1,2,4,'s69555');

Insert into SCHED_STD (STDNO,L_ABR_CRSNO,CRSNO,CRSTYPCD,SECTCD,SECTNO,HODAPROVALCD,CONDREGCD,ADVISAPROVALCD,AUDITFLAGCD,GRADECD,USRACCTCD) values (77894,'MASF6002',14835,1,188291,10,2,2,1,2,2,'s69555');

Insert into SCHED_STD (STDNO,L_ABR_CRSNO,CRSNO,CRSTYPCD,SECTCD,SECTNO,HODAPROVALCD,CONDREGCD,ADVISAPROVALCD,AUDITFLAGCD,GRADECD,USRACCTCD) values (77894,'MASF6002',14835,2,188291,11,2,2,1,2,null,'s69555');
