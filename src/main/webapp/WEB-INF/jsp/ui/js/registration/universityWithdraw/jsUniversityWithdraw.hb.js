<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script id="hbStudentWelcome" type="text/x-handlebars-template">
<div class="col-md-10">
<div class="panel panel-primary">

  <div class="panel-body">
    <form class="form-horizontal" role="form">
      <div class="form-group">
        <div class="col-sm-2">
          <label for="reason" class="control-label"><spring:message code="prop.dps.university.withdraw.reason.select"/></label>
        </div>
        <div class="col-sm-8">
          
          <select id="reason" class="form-control">
          	<option ></option>
          	{{#each .}}
          		<option value='{{code}}'>{{value}}</option>
          	{{/each}}
          </select>
          
        </div>
      </div>
      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <button type="submit" class="btn btn-default"><spring:message code="prop.dps.university.withdraw.button.submit"/></button>
        </div>
      </div>
    </form>
  </div>
  <div class="panel-footer"><spring:message code="prop.dps.university.withdraw.note"/></div>
</div>
</div>
</script>

