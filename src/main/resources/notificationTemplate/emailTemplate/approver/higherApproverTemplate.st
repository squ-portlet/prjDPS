<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>Untitled 1</title>
</head>

<body>

<table style="width: 100%">
	<tr>
		<td  colspan="3">	Dear 

		$if(data.delegateeNameEn)$
			<font color="red">(Delegated) </font>
		$else$
			$data.approverHigher.roleNameEng$
		$endif$
			 [$data.approverHigher.nameEng$], 
		
		$if(data.delegateeNameEn)$ 
			<br><font color='red'>(Delegated by $data.delegateeNameEn$)</font> 
		$endif$ 
		<br />
		Detail Status of &nbsp; application is mentioned below :</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>Service Name </td>
		<td>:</td>
		<td> <strong>DPS</strong>
	</td>
	</tr>
	<tr>
		<td>Form Name</td>
		<td>:</td>
		<td> <strong>$data.formNameEng$</strong>
	</td>
	</tr>
	<tr>
		<td>Student Name&nbsp;&nbsp;</td>
		<td>:</td>
		<td> <strong>$data.student.personalDetail.nameEng$</strong></td>
	</tr>
	<tr>
		<td>Student Id</td>
		<td>:</td>
		<td> <strong>$data.student.personalDetail.id$</strong></td>
	</tr>
	<tr>
		<td>Student Email&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td>:</td>
		<td> <strong>$data.student.personalDetail.email$</strong></td>
	</tr>
	<tr>
		<td>Student College&nbsp;&nbsp;</td>
		<td>:</td>
		<td> <strong>$data.student.academicDetail.collegeEng$</strong></td>
	</tr>
	<tr>
		<td>Student Degree</td>
		<td>:</td>
		<td> <strong>$data.student.academicDetail.degreeEng$</strong></td>
	</tr>
	<tr>
		<td>Student Major&nbsp;&nbsp;</td>
		<td>:</td>
		<td><strong> $data.student.academicDetail.majorEng$</strong></td>
	</tr>
	<tr>
		<td>List of Approvers</td>
		<td>:</td>
		<td><strong>$data.roles : {x | $x.sequenceNo$.$x.roleValueEng$ &nbsp;} $</strong></td>
	</tr>
	<tr>
		<td>Previous Approver</td>
		<td>:</td>
		<td> 
			<strong>$data.approver.roleNameEng$</strong></td>
	</tr>
	<tr>
		<td>Status</td>
		<td>&nbsp;</td>
		<td> <strong>$data.statusDescEng$</strong> </td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td colspan="3">$if(data.accept)$

$else$
	$if(data.progress)$
		(Note : <strong>You are requested to take necessary action as 
'$data.approverHigher.roleNameEng$' </strong>)
	$else$
		(Note : <em>This is for your information only. Action not needed.</em>)
	$endif$
$endif$
</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td colspan="3">You can view the details at the following url : 
<a href="$data.serviceUrl$">$data.serviceUrl$</a></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td colspan="3">with regards
</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td colspan="3">Deanship of PostGraduate Studies<br />
Sultan Qaboos University<br />
Muscat | Oman</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td colspan="3">(<strong>N.B</strong>. <span class="auto-style3"><em>This is an autogenerated 
email. Please do not reply to this email</em></span>. )</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
</table>

<p>&nbsp;</p>


<table style="width: 100%" dir="rtl">
	<tr>
		<td  colspan="3">	الفاضل 
							$if(data.delegateeNameEn)$
								<font color="red"> (المخول) </font>
							$else$
								$data.approverHigher.roleNameAr$ 
							$endif$		
							[$data.approverHigher.nameAr$], 
							
							$if(data.delegateeNameEn)$ 
								<br><font color='red'>(خول بواسطة $data.delegateeNameAr$)</font> 
							$endif$	
							
							<br />
		أدناه حالة الطلب : </td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>اسم الخدمة </td>
		<td>:</td>
		<td>عمادة الدراسات العليا</td>
	</tr>
	<tr>
		<td>الاستمارة</td>
		<td>:</td>
		<td> <strong>$data.formNameAr$</strong>
	</td>
	</tr>
	<tr>
		<td>اسم الطالب/ة&nbsp;&nbsp;</td>
		<td>:</td>
		<td> <strong>$data.student.personalDetail.nameAr$</strong></td>
	</tr>
	<tr>
		<td>الرقم الجامعي</td>
		<td>:</td>
		<td> <strong>$data.student.personalDetail.id$</strong></td>
	</tr>
	<tr>
		<td>البريد الالكتروني&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td>:</td>
		<td> <strong>$data.student.personalDetail.email$</strong></td>
	</tr>
	<tr>
		<td>الكلية</td>
		<td>:</td>
		<td> <strong>$data.student.academicDetail.collegeAr$</strong></td>
	</tr>
	<tr>
		<td>البرنامج</td>
		<td>:</td>
		<td> <strong>$data.student.academicDetail.degreeAr$</strong></td>
	</tr>
	<tr>
		<td>التخصص&nbsp;&nbsp;</td>
		<td>:</td>
		<td><strong> $data.student.academicDetail.majorAr$</strong></td>
	</tr>
	<tr>
		<td>قائمة الموافقات المطلوبة</td>
		<td>:</td>
		<td><strong>$data.roles : {x | $x.sequenceNo$.$x.roleValueAr$ &nbsp;} $</strong></td>
	</tr>
	<tr>
		<td>الموافقة الحالية</td>
		<td>:</td>
		<td> 
			<strong>$data.approver.roleNameAr$</strong></td>
	</tr>
	<tr>
		<td>الحالة</td>
		<td>&nbsp;</td>
		<td> <strong>$data.statusDescAr$</strong> </td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td colspan="3">$if(data.accept)$ $else$ $if(data.progress)$ (باعتباركم 
		الجهة الأعلى إداريا الرجاء اتخاذ ما يلزم حول الطلب أعلاه.
'$data.approverHigher.roleNameAr$' ) $else$ (هذه 
		الرسالة للعلم فقط)
	$endif$
$endif$
</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td colspan="3">
		يمكنكم الاطلاع على التفاصيل من خلال الرابط: 
<a href="$data.serviceUrl$">$data.serviceUrl$</a></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td colspan="3">مع تحيات</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td colspan="3">عمادة الدراسات العليا<br />
		جامعة السلطان قابوس<br />
		</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td colspan="3" style="height: 23px">ملاحظة: هذه الرسالة تلقائية. الرجاء 
		عدم الرد لهذا العنوان. )</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
</table>



</body>

</html>
