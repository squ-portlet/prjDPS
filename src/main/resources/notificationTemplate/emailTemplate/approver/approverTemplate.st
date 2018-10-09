<html>

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
</head>

<body>

<table style="width: 100%">
	<tr>
		<td>Dear $data.approver.roleNameEng$ [$data.approver.nameEng$], 
		$if(data.delegateeNameEn)$ <br><font color='red'>(Delegated by $data.delegateeNameEn$)</font> $endif$ 
			<br />Detail Status of&nbsp; application is mentioned below :  
</td>

		<td dir="rtl">الفاضل $data.approver.roleNameEng$ [$data.approver.nameEng$], 
			<br />أدناه حالة الطلب :  
</td>
	</tr>
	<tr>
		<td>
		
		<table style="width: 100%">
			<ul>

				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				
				<tr>
					<td><li>Service Name</li></td>
					<td>:</td>
					<td><strong>DPS</strong> </td>
				</tr>
				
				<tr>
					<td><li>Form Name</li> </td>
					<td>:</td>
					<td>&nbsp;<strong>$data.formNameEng$</strong> </td>
				</tr>
				<tr>
					<td><li>Student Name</li></td>
					<td>:</td>
					<td><strong>$data.student.personalDetail.name$</strong></td>
				</tr>
				<tr>
					<td><li>Student Id</li></td>
					<td>:</td>
					<td><strong>$data.student.personalDetail.id$</strong></td>
				</tr>
				<tr>
					<td><li>Student Email</li></td>
					<td>:</td>
					<td><strong>$data.student.personalDetail.email$</strong></td>
				</tr>
				<tr>
					<td><li>Student College</li></td>
					<td>:</td>
					<td><strong>$data.student.academicDetail.college$</strong></td>
				</tr>
				<tr>
					<td><li>Student Degree</li></td>
					<td>:</td>
					<td><strong>$data.student.academicDetail.degree$</strong></td>
				</tr>
				<tr>
					<td><li>Student Major</li></td>
					<td>:</td>
					<td><strong>$data.student.academicDetail.major$</strong></td>
				</tr>
				<tr>
					<td><li>List of Approvers</li></td>
					<td>:</td>
					<td><strong>$data.roles : {x | $x.sequenceNo$.$x.roleValue$ &nbsp;} $
					</strong></td>
				</tr>
				<tr>
					<td><li>Current Approver</li></td>
					<td>:</td>
					<td><strong>$data.approver.roleNameEng$</strong> </td>
				</tr>
				<tr>
					<td><li>Status</li></td>
					<td>:</td>
					<td><strong>$data.statusDescEng$</strong> </td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</ul>
		</table>
		<br></td>
		<td dir="rtl">
		
		<table style="width: 100%" align="right">
			
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				
				<tr>
					<td><li>اسم الخدمة</li></td>
					<td>:</td>
					<td>عمادة الدراسات العليا</td>
				</tr>
				
				<tr>
					<td><li>الاستمارة</li> </td>
					<td>:</td>
					<td>&nbsp;<strong>$data.formNameEng$</strong> </td>
				</tr>
				<tr>
					<td><li>اسم الطالب/ة</li></td>
					<td>:</td>
					<td><strong>$data.student.personalDetail.name$</strong></td>
				</tr>
				<tr>
					<td><li>الرقم الجامعي</li></td>
					<td>:</td>
					<td><strong>$data.student.personalDetail.id$</strong></td>
				</tr>
				<tr>
					<td><li>البريد الالكتروني</li></td>
					<td>:</td>
					<td><strong>$data.student.personalDetail.email$</strong></td>
				</tr>
				<tr>
					<td><li>الكلية</li></td>
					<td>:</td>
					<td><strong>$data.student.academicDetail.college$</strong></td>
				</tr>
				<tr>
					<td><li>البرنامج</li></td>
					<td>:</td>
					<td><strong>$data.student.academicDetail.degree$</strong></td>
				</tr>
				<tr>
					<td><li>التخصص</li></td>
					<td>:</td>
					<td><strong>$data.student.academicDetail.major$</strong></td>
				</tr>
				<tr>
					<td><li>قائمة الموافقات المطلوبة</li></td>
					<td>:</td>
					<td><strong>$data.roles : {x | $x.sequenceNo$.$x.roleValue$ &nbsp;} $
					</strong></td>
				</tr>
				<tr>
					<td><li>الموافقة الحالية</li></td>
					<td>:</td>
					<td><strong>$data.approver.roleNameEng$</strong> </td>
				</tr>
				<tr>
					<td><li>الحالة</li></td>
					<td>:</td>
					<td><strong>$data.statusDescEng$</strong> </td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>$if(data.pending)$
	(Note : <strong>You are requested to take necessary action as 
'$data.approver.roleNameEng$'</strong>)
$else$
	(Note : <em>This is for your information only. Action not needed.</em>)
$endif$</td>
		<td dir="rtl">$if(data.pending)$ (<strong>الرجاء اتخاذ ما يلزم حول الطلب 
		أعلاه&nbsp; 
'$data.approver.roleNameEng$'</strong>)
$else$
	(Note : هذه الرسالة للعلم فقط<em>. .</em>)
$endif$</td>
	</tr>
	<tr>
		<td><br>You can view the details at the following url : 
<a href="$data.serviceUrl$">$data.serviceUrl$</a></td>
		<td dir="rtl"><br>يمكنكم الاطلاع على التفاصيل من خلال الرابط&nbsp; : 
<a href="$data.serviceUrl$">$data.serviceUrl$</a></td>
	</tr>
	<tr>
		<td><br>with regards
<br />
<br />
Deanship of PostGraduate Studies<br />
Sultan Qaboos University<br />
		</td>
		<td dir="rtl"><br>مع تحيات <br />
<br />
		عمادة الدراسات العليا<br />
		جامعة السلطان قابوس<br />
		</td>
	</tr>
	<tr>
		<td><br>(<strong>N.B</strong>. <span class="auto-style3"><em>This is an autogenerated 
email. Please do not reply to this email</em></span>. )</td>
		<td dir="rtl"><br>(ملاحظة: هذه الرسالة تلقائية. الرجاء عدم الرد لهذا 
		العنوان)</td>
	</tr>
</table>
<p>
	&nbsp;</p>
<p>
	&nbsp;</p>
<p class="auto-style2">
&nbsp;</p>
<p class="auto-style2">&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>



</body>

</html>
