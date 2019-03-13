/* Student Id : 22312  Student No :  28111 statCode : 156375*/

/*Delete from Std_Postpone */
DELETE FROM STD_POSTPONE
WHERE
    STDNO  = 28111
  AND STDSTATCD = 156773
  AND FROMCCYRCD = 2017
  AND FROMSEMCD = 2;
  

  /* Delete from STD_GRADES */
DELETE FROM STD_GRADES
WHERE
STDNO = '28111'
AND CCYRCD = 2017
AND SEMCD = 2
AND SECTNO = 10
AND L_ABR_CRSNO = 'BIOL8001'
AND CRSNO = '17058';

DELETE FROM STD_GRADES
WHERE
STDNO = '28111'
AND CCYRCD = 2017
AND SEMCD = 2
AND SECTNO = 10
AND L_ABR_CRSNO = 'BIOL5600'
AND CRSNO = '19923';


/* Delete from TUITION_FEES_STD */
DELETE FROM TUITION_FEES_STD
WHERE
STDNO =  28111
  AND SECTCD = 187794
  AND SECTNO = 10;


  DELETE FROM TUITION_FEES_STD
WHERE
STDNO =  28111
  AND SECTCD = 187953
  AND SECTNO = 10;
  
  
/* Insert into SCHED_STD */
INSERT INTO SCHED_STD 
(STDNO,L_ABR_CRSNO,CRSNO,CRSTYPCD,SECTCD,SECTNO,HODAPROVALCD,CONDREGCD,ADVISAPROVALCD,AUDITFLAGCD,GRADECD,USRACCTCD)
VALUES
(
	28111,'BIOL8001',17058,38,187794,10,2,2,1,2,18,'s22312'
);

INSERT INTO SCHED_STD 
(STDNO,L_ABR_CRSNO,CRSNO,CRSTYPCD,SECTCD,SECTNO,HODAPROVALCD,CONDREGCD,ADVISAPROVALCD,AUDITFLAGCD,GRADECD,USRACCTCD)
VALUES
(
	28111,'BIOL5600',19923,1,187953,10,2,2,1,1,17,'MAZEN_PG'
);


/*************************************************************/

/*
 * Insert into postpone table
 */

	INSERT INTO STD_POSTPONE
		(
			  STDNO 
			, STDSTATCD 
			, FROMCCYRCD 
			, FROMSEMCD 
			, TOCCYRCD 
			, TOSEMCD 
			, PSTREASONCD 
			, OTHER_REASON 
			, POSTREQ_STATUSCD 
			, CREATE_DATE 
			, CREATE_USERNAME 
		)
		VALUES 
		(
			  28111
			, 156773
			, 2017
			, 2
			, 2017
			, 2
			, 4532
			, null
			, (
				SELECT
					CODES.SISCODECD	
				FROM
						SIS_CODES       CODES
					,   SIS_CODE_TYPES  TYPES
				WHERE
						CODES.SISCODETYPCD =  TYPES.SISCODETYPCD
					AND TYPES.SISCODETYPNM = 'APPROVAL_STATUS'
					AND CODES.L_ABR_CODE  = 'ACCPT'
			   )
			, SYSDATE
			, 'bbm' 
		) ;   



/*Insert into STD_GRADES */
REM INSERTING into STD_GRADES
SET DEFINE OFF;
Insert into STD_GRADES (STDNO,CCYRCD,SEMCD,L_ABR_CRSNO,CRSNO,SECTNO,GRADECD,GRADENTRYDTE,GRADUSRACCTCD,UPDDTE,CRSREGWITHDTE,CRSREGWITHCD,PREV_CCYRCD,PREV_SEMCD,PREV_L_ABR_CRSNO,GRADE_COMMENT) values (28111,2017,2,'BIOL8001',17058,10,18,to_date('23-MAY-17 13:09:07','DD-MON-RR HH24:MI:SS'),'e1298',to_date('24-DEC-17 12:09:00','DD-MON-RR HH24:MI:SS'),null,null,null,null,null,null);
Insert into STD_GRADES (STDNO,CCYRCD,SEMCD,L_ABR_CRSNO,CRSNO,SECTNO,GRADECD,GRADENTRYDTE,GRADUSRACCTCD,UPDDTE,CRSREGWITHDTE,CRSREGWITHCD,PREV_CCYRCD,PREV_SEMCD,PREV_L_ABR_CRSNO,GRADE_COMMENT) values (28111,2017,2,'BIOL5600',19923,10,17,to_date('23-MAY-17 13:58:03','DD-MON-RR HH24:MI:SS'),'e3297',to_date('23-MAY-17 13:58:03','DD-MON-RR HH24:MI:SS'),null,null,null,null,null,null);
		
		
		