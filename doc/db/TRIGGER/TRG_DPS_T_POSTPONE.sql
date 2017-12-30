create or replace TRIGGER TRG_DPS_T_POSTPONE 
BEFORE UPDATE OF POSTREQ_STATUSCD ON T_REG_POSTPONE 
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
/*
  Trigger Name : TRG_DPS_T_POSTPONE
  
  Summary : Insert into STD_POSTPONE table on final acceptance by the higher approver

  Author : Bhabesh
  Create Date : 30-December-2017

  Need to check whether the final approval is accepted or rejected. Postpone data will be inserted after approval acceptance only.

*/

DECLARE

VAR_STATUSCD VARCHAR2(8);

BEGIN
  
  SELECT
                                      CODES.L_ABR_CODE
                                     INTO VAR_STATUSCD
			                       FROM
			                               SIS_CODES       CODES
			                           ,   SIS_CODE_TYPES  TYPES
			                       WHERE
			                               CODES.SISCODETYPCD 	=  TYPES.SISCODETYPCD
			                           AND TYPES.SISCODETYPNM 	= 'APPROVAL_STATUS'
			                           AND CODES.SISCODECD  	= :new.POSTREQ_STATUSCD;
 
   IF(VAR_STATUSCD = 'ACCPT') 
   THEN
    
       	INSERT INTO STD_POSTPONE
		(
			 STDNO 
			, STDSTATCD 
			, FROMCCYRCD 
			, FROMSEMCD 
			, TOCCYRCD 
			, TOSEMCD
      , COMMNT
			, PSTREASONCD
      , USRACCTCD
      , UPDDTE
    )
    		VALUES 
		(
        :new.STDNO
			, :new.STDSTATCD
			, :new.FROMCCYRCD
			, :new.FROMSEMCD
			, :new.TOCCYRCD
			, :new.TOSEMCD
      , :new.COMMNT
			, :new.PSTREASONCD
      , :new.USRACCTCD
      , :new.UPDDTE
    );
    
  END IF;
  exception
    when others then
    RAISE_APPLICATION_ERROR(-20009,'Can not able to insert record to STD_POSTPONE for DPS Postpone Service') ;
END;