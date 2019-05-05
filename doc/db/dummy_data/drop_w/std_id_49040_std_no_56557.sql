/*
 Insert into TUITION_FEES_STD
 */
Insert into TUITION_FEES_STD (L_ABR_CRSNO,STDNO,CREDITS,FEE,WITHDRAWEN,UPDATEDATE,USRACCTCD,SECTNO,SECTCD,STDSTATUSCD,TUITIONCD) values ('INFO6510',56557,3,225,null,to_date('16-JAN-17 10:54:37','DD-MON-RR HH24:MI:SS'),'s49040',10,190537,155071,null);
Insert into TUITION_FEES_STD (L_ABR_CRSNO,STDNO,CREDITS,FEE,WITHDRAWEN,UPDATEDATE,USRACCTCD,SECTNO,SECTCD,STDSTATUSCD,TUITIONCD) values ('INFO6610',56557,3,225,null,to_date('16-JAN-17 10:54:23','DD-MON-RR HH24:MI:SS'),'s49040',10,190534,155071,null);
Insert into TUITION_FEES_STD (L_ABR_CRSNO,STDNO,CREDITS,FEE,WITHDRAWEN,UPDATEDATE,USRACCTCD,SECTNO,SECTCD,STDSTATUSCD,TUITIONCD) values ('INFO7101',56557,0,350,null,to_date('16-JAN-17 10:56:22','DD-MON-RR HH24:MI:SS'),'s49040',70,190544,155071,null);


/*
 Insert into SCHED_STD
 */
Insert into SCHED_STD (STDNO,L_ABR_CRSNO,CRSNO,CRSTYPCD,SECTCD,SECTNO,HODAPROVALCD,CONDREGCD,ADVISAPROVALCD,AUDITFLAGCD,GRADECD,USRACCTCD) values (56557,'INFO6510',13984,1,190537,10,2,2,1,2,3,'s49040');
Insert into SCHED_STD (STDNO,L_ABR_CRSNO,CRSNO,CRSTYPCD,SECTCD,SECTNO,HODAPROVALCD,CONDREGCD,ADVISAPROVALCD,AUDITFLAGCD,GRADECD,USRACCTCD) values (56557,'INFO6510',13984,4,190537,11,2,2,1,2,null,'s49040');
Insert into SCHED_STD (STDNO,L_ABR_CRSNO,CRSNO,CRSTYPCD,SECTCD,SECTNO,HODAPROVALCD,CONDREGCD,ADVISAPROVALCD,AUDITFLAGCD,GRADECD,USRACCTCD) values (56557,'INFO6610',13982,1,190534,10,2,2,1,2,4,'s49040');
Insert into SCHED_STD (STDNO,L_ABR_CRSNO,CRSNO,CRSTYPCD,SECTCD,SECTNO,HODAPROVALCD,CONDREGCD,ADVISAPROVALCD,AUDITFLAGCD,GRADECD,USRACCTCD) values (56557,'INFO6610',13982,4,190534,11,2,2,1,2,null,'s49040');
Insert into SCHED_STD (STDNO,L_ABR_CRSNO,CRSNO,CRSTYPCD,SECTCD,SECTNO,HODAPROVALCD,CONDREGCD,ADVISAPROVALCD,AUDITFLAGCD,GRADECD,USRACCTCD) values (56557,'INFO7101',15022,41,190544,70,2,2,1,2,20,'s49040');


/*
 -- Back up for STD_GRADES
 
Insert into STD_GRADES (STDNO,CCYRCD,SEMCD,L_ABR_CRSNO,CRSNO,SECTNO,GRADECD,GRADENTRYDTE,GRADUSRACCTCD,UPDDTE,CRSREGWITHDTE,CRSREGWITHCD,PREV_CCYRCD,PREV_SEMCD,PREV_L_ABR_CRSNO,GRADE_COMMENT) values (56557,2017,2,'INFO7101',15022,70,20,to_date('18-MAY-17 12:16:36','DD-MON-RR HH24:MI:SS'),'e6194',to_date('18-MAY-17 12:16:36','DD-MON-RR HH24:MI:SS'),null,null,null,null,null,null);
Insert into STD_GRADES (STDNO,CCYRCD,SEMCD,L_ABR_CRSNO,CRSNO,SECTNO,GRADECD,GRADENTRYDTE,GRADUSRACCTCD,UPDDTE,CRSREGWITHDTE,CRSREGWITHCD,PREV_CCYRCD,PREV_SEMCD,PREV_L_ABR_CRSNO,GRADE_COMMENT) values (56557,2017,2,'INFO6610',13982,10,4,to_date('23-MAY-17 11:06:23','DD-MON-RR HH24:MI:SS'),'e2346',to_date('23-MAY-17 11:06:23','DD-MON-RR HH24:MI:SS'),null,null,null,null,null,null);
Insert into STD_GRADES (STDNO,CCYRCD,SEMCD,L_ABR_CRSNO,CRSNO,SECTNO,GRADECD,GRADENTRYDTE,GRADUSRACCTCD,UPDDTE,CRSREGWITHDTE,CRSREGWITHCD,PREV_CCYRCD,PREV_SEMCD,PREV_L_ABR_CRSNO,GRADE_COMMENT) values (56557,2017,2,'INFO6510',13984,10,3,to_date('23-MAY-17 15:33:10','DD-MON-RR HH24:MI:SS'),'e4173',to_date('23-MAY-17 15:33:10','DD-MON-RR HH24:MI:SS'),null,null,null,null,null,null);

*/