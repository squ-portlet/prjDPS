--------------------------------------------------------
--  File created - Wednesday-January-09-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Trigger DPS_TRG_ADDL_ROLES_INSERT
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "DPSPROJECT"."DPS_TRG_ADDL_ROLES_INSERT" 
BEFORE INSERT ON DPS_ADDITIONAL_ROLES 
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW

/*
  Trigger Name : DPS_TRG_ADDL_ROLES_INSERT
  
  Summary : Insert non overlaping user and date for delegation

  Author : Bhabesh
  Create Date : 09-January-2019

  Need to check whether the whether delegated user acting as delegatee within the delagation period. This will cause a 
  nested delegation and create issue for delegated approval at nested level.
 
*/

DECLARE
  VAR_COUNT_REC_EXIST NUMBER;

BEGIN
  
  SELECT 
        COUNT(DAR_FROM_DATE)
           INTO VAR_COUNT_REC_EXIST
  FROM
    DPS_ADDITIONAL_ROLES
  WHERE
    :new.DAR_FROM_USERNAME = (
                              SELECT 
                                    DAR_TO_USERNAME
                              FROM
                                    DPS_ADDITIONAL_ROLES
                              WHERE
                                     (
                                            SYSDATE BETWEEN DAR_FROM_DATE
                                                    AND DAR_TO_DATE
                                          )
                                    AND DAR_TO_USERNAME = :new.DAR_FROM_USERNAME
                                AND ROWNUM < 2
                           );
                              
       IF(VAR_COUNT_REC_EXIST > 0) 
   THEN   
      RAISE_APPLICATION_ERROR(-20009,'Can not able to insert record to DPS_ADDITIONAL_ROLES because of overlapping use of delegation') ;
   END IF;   
END;
/
ALTER TRIGGER "DPSPROJECT"."DPS_TRG_ADDL_ROLES_INSERT" ENABLE;
