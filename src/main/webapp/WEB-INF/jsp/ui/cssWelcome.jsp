<!--  
 * Project 				:	prjDPS
 * Organisation 		:	Sultan Qaboos University
 * Center				:	Center for Information System
 * Department 			:	Web & E-Services
 * Author				:	Bhabesh
 * 
 * FrameWork			:	Spring 3.2.3 (Annotation) Portlet
 * 
 * File Name			:	cssWelcome.jsp
 * 
 * Date of Creation		:	28-December-2016
 *  
 * Summary				:	cssWelcome
 *
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the SQU, CIS policy
 * you may not use this file except in compliance with the License.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */

-->
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>

<spring:message code="url.squ.cdn" var="urlCdn"/>
<c:url value="/ui/images/calendar.gif" var="imgCalendar"/>
<c:url value="/ui/ajax-loader.gif" var="imgAjaxLoader"/>	

<!-- ******************** CSS Declaration************************ --> 
<c:url value="${urlCdn}/bootstrap/3.3.6/dist/css/bootstrap.css" var="urlCssBootstrap"/>
<c:url value="${urlCdn}/bootstrap/3.3.6/dist/css/bootstrap-theme.min.css" var="urlCssBootstrapThemeMin"/>
<c:url value="${urlCdn}/jqueryui/1.11.4.custom/jquery-ui.css" var="urlCssJQueryUiCustom"/>
<c:url value="${urlCdn}/bootstrap-arabic/bootstrap-3-arabic-master/3.3.6/css/bootstrap-arabic.css" var="urlCssBootstrapArabic"/>
<c:url value="${urlCdn}/bootstrap-arabic/bootstrap-3-arabic-master/3.3.6/css/bootstrap-arabic-theme.css" var="urlCssBootstrapArabicTheme"/>


	<!-- ------------ data table css declaration -->
<c:url value="${urlCdn}/DataTables/1.10.11/DataTables-1.10.11/css/dataTables.bootstrap.min.css" var="urlCssDataTableBSMin"/>
<c:url value="${urlCdn}/DataTables/1.10.11/Responsive-2.0.2/css/responsive.bootstrap.min.css" var="urlCssDataTableResponsiveBSMin"/>
<c:url value="${urlCdn}/DataTables/1.10.11/RowReorder-1.1.1/css/rowReorder.bootstrap.min.css" var="urlCssDataTableRowReorderBSMin"/>
<!-- ******************** JS Declaration************************ -->
<c:url value="${urlCdn}/bootstrap/3.3.6/dist/js/bootstrap.min.js" var="urlJsBootStrapMin"/>
<c:url value="${urlCdn}/bootstrap/3.3.6/js/button.js" var="urlJsBootStrapButton"/>
<c:url value="${urlCdn}/bootstrap/3.3.6/js/modal.js" var="urlJsBootStrapModal"/>
<c:url value="${urlCdn}/bootstrap-arabic/bootstrap-3-arabic-master/3.3.6/js/bootstrap-arabic.js" var="urlJsBootstrapArabic"/>
<c:url value="${urlCdn}/jquery/1.11.3/jquery-1.11.3.min.js" var="urlJsJqueryMin"/>
<c:url value="${urlCdn}/jqueryui/1.11.4/jquery-ui.min.js" var="urlJsJqueryUIMin"/>
<c:url value="${urlCdn}/jqueryvalidation/1.13.1/jquery.validate.min.js" var="urlJsValidatorJquery"/>
<c:url value="${urlCdn}/jqueryvalidation/1.13.1/additional-methods.min.js" var="urlJsValidatorJqueryAddl"/>

	<!-- ------------ Data Table js declaration -->
<c:url value="${urlCdn}/DataTables/1.10.11/DataTables-1.10.11/js/jquery.dataTables.min.js" var="urlJsDataTableJQueryMin"/>
<c:url value="${urlCdn}/DataTables/1.10.11/DataTables-1.10.11/js/dataTables.bootstrap.min.js" var="urlJsDataTableBSMin"/>
<c:url value="${urlCdn}/DataTables/1.10.11/Responsive-2.0.2/js/dataTables.responsive.min.js" var="urlJsDataTableResponsiveMin"/>
<c:url value="${urlCdn}/DataTables/1.10.11/Responsive-2.0.2/js/responsive.bootstrap.min.js" var="urlJsDataTableResponsiveBSMin"/>
<c:url value="${urlCdn}/DataTables/1.10.11/RowReorder-1.1.1/js/dataTables.rowReorder.min.js" var="urlJsDataTableRowReorderBSMin"/>

<!-- ------------ HandleBars js declaration -->
<c:url value="${urlCdn}/handlebars/4.0.5/handlebars-v4.0.5.js" var="urlJsHandleBars"/>
<%-- <c:url value="${urlCdn}/handlebars/4.0.5/handlebars.runtime-v4.0.5.js" var="urlJsHandleBarsRunTime"/> --%>

<!-- ------------ cryptojs js declaration -->
<c:url value="${urlCdn}/cryptojs/3.1.2/rollups/aes.js" var="urlCryptoJsAES"/>
<c:url value="${urlCdn}/cryptojs/3.1.2/rollups/pbkdf2.js" var="urlCryptoJsPBKDF2"/>

<!-- ******************** CSS implementation************************ --> 
<c:if test="${rc.locale.language == 'en'}" > 
 <link rel="stylesheet" type="text/css" href="${urlCssBootstrap}" />
 <link rel="stylesheet" type="text/css" href="${urlCssBootstrapThemeMin}" />
</c:if>
<c:if test="${rc.locale.language == 'ar'}" >
 <link rel="stylesheet" type="text/css" href="${urlCssBootstrapArabic}" />
 <link rel="stylesheet" type="text/css" href="${urlCssBootstrapArabicTheme}" />
</c:if>
 <!-- link rel="stylesheet" type="text/css" href="${urlCssBootstrapMin}" /-->

<%--  <link rel="stylesheet" type="text/css" href="${urlCssJQueryUiCustom}" /> --%>


	<!-- ------------ datatable css implementation -->

 <link rel="stylesheet" type="text/css" href="${urlCssDataTableBSMin}" />
 <link rel="stylesheet" type="text/css" href="${urlCssDataTableResponsiveBSMin}" />
 <link rel="stylesheet" type="text/css" href="${urlCssDataTableRowReorderBSMin}" /> 
 
 <!-- ******************** JS implementation************************ --> 
  <script type="text/javascript" src="${urlJsJqueryMin}"></script>
 <c:if test="${rc.locale.language == 'en'}" > 
 	<script type="text/javascript" src="${urlJsBootStrapMin}"></script>
 </c:if>
 <c:if test="${rc.locale.language == 'ar'}" >
 	<script type="text/javascript" src="${urlJsBootstrapArabic}"></script> 
 </c:if>
 <script type="text/javascript" src="${urlJsBootStrapButton}"></script> 
<%--  <script type="text/javascript" src="${urlJsBootStrapModal}"></script>  --%>
 <script type="text/javascript" src="${urlJsJqueryUIMin}"></script>
 
 
 <script type="text/javascript" src="${urlJsValidatorJquery}"></script>
<script type="text/javascript" src="${urlJsValidatorJqueryAddl}"></script>

	<!-- ------------ datatable js implementation -->
<script type="text/javascript" src="${urlJsDataTableJQueryMin}"></script>
<script type="text/javascript" src="${urlJsDataTableBSMin}"></script>
<script type="text/javascript" src="${urlJsDataTableResponsiveMin}"></script>
<script type="text/javascript" src="${urlJsDataTableResponsiveBSMin}"></script>
<script type="text/javascript" src="${urlJsDataTableRowReorderBSMin}"></script>

	<!-- ------------ HandleBars js implementation -->
<script type="text/javascript" src="${urlJsHandleBars}"></script>
<script type="text/javascript" src="${urlJsHandleBarsRunTime}"></script>

	<!-- ------------ cryptojs js implementation -->
<script type="text/javascript" src="${urlCryptoJsAES}"></script>
<script type="text/javascript" src="${urlCryptoJsPBKDF2}"></script>

	 <c:if test="${rc.locale.language == 'en'}" >
		 <c:set var="glphiconNext">
		 	<span class="glyphicon glyphicon-triangle-right" aria-hidden="true" ></span>
		 </c:set>
		 <c:set var="glphiconBack">
	 		<span class="glyphicon glyphicon-triangle-left" aria-hidden="true" ></span>
	 	</c:set>
		 
 	</c:if>
 	<c:if test="${rc.locale.language == 'ar'}" >
 		 <c:set var="glphiconNext">
	 		<span class="glyphicon glyphicon-triangle-left" aria-hidden="true" ></span>
	 	</c:set>
		 <c:set var="glphiconBack">
		 	<span class="glyphicon glyphicon-triangle-right" aria-hidden="true" ></span>
		 </c:set>	 	
 	</c:if>
<style>

.error {
    color:red !important;
}


/* For Liferay */
.aui .popover{
	background-color: #434a54;
}  

/* Liferay modal form */
.aui .modal {
height: inherit;
right:30%;
/*left:30%;*/
left:inherit;
width: 50%;
overflow-y: hidden;
border-color:transparent;
background-color:transparent;
}


@media (max-width: @screen-xs-min) {
  .modal-xs { width: @modal-sm; }
  .modal-sm {width: 350px;}
}



.modal-dialog {
  max-width: @modal-md;
  width: 100%;
}

.modal-sm {
  max-width: @modal-sm;
  height: 20%;
}

.modal-md {
  max-width: @modal-sm;
  height: 20%;
}

.modal-lg {
  max-width: @modal-lg;
}


.verticaltext {
    transform: rotate(-90deg);
    transform-origin: right, top;
    -ms-transform: rotate(-90deg);
    -ms-transform-origin:right, top;
    -webkit-transform: rotate(-90deg);
    -webkit-transform-origin:right, top;
    position: absolute; 
    color: #ed217c;
}

.input-xs, select.input-xs {
  height: 20px;
  line-height: 20px;
}

</style>

<script>

    var getLocalization = function () {
                var localizationobj = {};
                //localizationobj.pagerGoToPageString = "اذهب:";
                localizationobj.pagerGoToPageString='<spring:message code="localizationobj.pagerGoToPageString"/>';
                localizationobj.pagerShowRowsString = '<spring:message code="localizationobj.pagerShowRowsString"/>';
                localizationobj.pagerRangeString = ' <spring:message code="localizationobj.pagerRangeString"/> ';
                localizationobj.pagerNextButtonString = '<spring:message code="localizationobj.pagerNextButtonString"/>';
                localizationobj.pagerFirstButtonString = '<spring:message code="localizationobj.pagerFirstButtonString"/>';
                localizationobj.pagerLastButtonString = '<spring:message code="localizationobj.pagerLastButtonString"/>';
                localizationobj.pagerPreviousButtonString = '<spring:message code="localizationobj.pagerPreviousButtonString"/>';
                localizationobj.sortAscendingString = '<spring:message code="localizationobj.sortAscendingString"/>';
                localizationobj.sortDescendingString = '<spring:message code="localizationobj.sortDescendingString"/>';
                localizationobj.sortRemoveString = '<spring:message code="localizationobj.sortRemoveString"/>';
                localizationobj.emptydatastring = '<spring:message code="localizationobj.emptydatastring"/>';
                localizationobj.firstDay = 1;
                localizationobj.percentSymbol = "%";
                localizationobj.currencySymbol = "€";
                localizationobj.currencySymbolPosition = '<spring:message code="localizationobj.currencySymbolPosition"/>';
                localizationobj.decimalSeparator = ".";
                localizationobj.thousandsSeparator = ",";
                var days = {
                    // full day names
                    names: [
		                    "Sonntag", 
		                    "Montag", 
		                    "Dienstag", 
		                    "Mittwoch", 
		                    "Donnerstag", 
		                    "Freitag", 
		                    "Samstag"
		                    ],
                    // abbreviated day names
                    namesAbbr: [
	                    		"Sonn", 
	                    		"Mon", 
	                    		"Dien", 
	                    		"Mitt", 
	                    		"Donn", 
	                    		"Fre", 
	                    		"Sams"
                    		],
                    // shortest day names
                    namesShort: [
	                    		"So", 
	                    		"Mo", 
	                    		"Di", 
	                    		"Mi", 
	                    		"Do", 
	                    		"Fr", 
	                    		"Sa"
                    		]
                };
                localizationobj.days = days;
                var months = {
                    // full month names (13 months for lunar calendards -- 13th month should be "" if not lunar)
                    names: [
                    		"Januar", 
                    		"Februar", 
                    		"März", 
                    		"April", 
                    		"Mai", 
                    		"Juni", 
                    		"Juli", 
                    		"August", 
                    		"September", 
                    		"Oktober", 
                    		"November", 
                    		"Dezember", 
                    		""
                    		],
                    // abbreviated month names
                    namesAbbr: [
                    			"Jan", 
                    			"Feb", 
                    			"Mär", 
                    			"Apr", 
                    			"Mai", 
                    			"Jun", 
                    			"Jul", 
                    			"Aug", 
                    			"Sep", 
                    			"Oct", 
                    			"Nov", 
                    			"Dez", 
                    			""
                    		   ]
                };
                var patterns = {
                    d: "dd.MM.yyyy",
                    D: "dddd, d. MMMM yyyy",
                    t: "HH:mm",
                    T: "HH:mm:ss",
                    f: "dddd, d. MMMM yyyy HH:mm",
                    F: "dddd, d. MMMM yyyy HH:mm:ss",
                    M: "dd MMMM",
                    Y: "MMMM yyyy"
                }
                localizationobj.patterns = patterns;
                localizationobj.months = months;
                return localizationobj;
            };


</script>
<script>
	/*
	*	Initializing cryptojs in UI 
	*/


		var AesUtil = function(keySize, iterationCount) {
			  this.keySize = keySize / 32;
			  this.iterationCount = iterationCount;
			};

			AesUtil.prototype.generateKey = function(salt, passPhrase) {
			  var key = CryptoJS.PBKDF2(
			      passPhrase, 
			      CryptoJS.enc.Hex.parse(salt),
			      { keySize: this.keySize, iterations: this.iterationCount });
			  return key;
			};

			AesUtil.prototype.encrypt = function(salt, iv, passPhrase, plainText) {
			  var key = this.generateKey(salt, passPhrase);
			  var encrypted = CryptoJS.AES.encrypt(
			      plainText,
			      key,
			      { iv: CryptoJS.enc.Hex.parse(iv) });
			  return encrypted.ciphertext.toString(CryptoJS.enc.Base64);
			};

			AesUtil.prototype.decrypt = function(salt, iv, passPhrase, cipherText) {
			  var key = this.generateKey(salt, passPhrase);
			  var cipherParams = CryptoJS.lib.CipherParams.create({
			    ciphertext: CryptoJS.enc.Base64.parse(cipherText)
			  });
			  var decrypted = CryptoJS.AES.decrypt(
			      cipherParams,
			      key,
			      { iv: CryptoJS.enc.Hex.parse(iv) });
			  return decrypted.toString(CryptoJS.enc.Utf8);
			};		
	

			/* ****** encryption - cryptojs - implementation in UI ****** */
			var iterationCount = ${cryptoIterationCount};
			var keySize = ${cryptoKeySize};
			
			var passphrase = '${cryptoPassPhrase}';

			var four = CryptoJS.lib.WordArray.random(128/8).toString(CryptoJS.enc.Hex);
			var salt = CryptoJS.lib.WordArray.random(128/8).toString(CryptoJS.enc.Hex);

			var aesUtil = new AesUtil(keySize, iterationCount);
			/* **************************** */			
			
</script>
