<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Sample Test Form</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Sample Test Form
</h1>

<c:url var="addAction" value="/add" ></c:url>

<form:form action="${addAction}" commandName="person">
<table>
	<!--<c:if test="${!empty person.name}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>-->
	
	
	<input type="hidden" id="uniqueId" name="uniqueId" value=${uniqueId} }>
	
	<tr>
		<td>
			<form:label path="name">
				<spring:message text="Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="name" required="required"/>
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="date">
				<spring:message text="Date"/>
			</form:label>
		</td>
		<td>
			<form:input path="date" type="date" required="required"/>
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="country">
				<spring:message text="Country"/>
			</form:label>
		</td>
		<td>
			<select name="category">
			    <c:forEach items="${listCountry}" var="cate">
			        <option value="${cate.country}">${cate.country}</option>
			    </c:forEach>
			</select>
		</td>
	</tr>
	
	<tr>
		<td>
			<form:label path="state">
				<spring:message text="State"/>
			</form:label>
		</td>
		<td>
			<select name="state">
			    <c:forEach items="${listState}" var="category">
			        <option value="${category.state}">${category.state}</option>
			    </c:forEach>
			</select>
		</td>
	</tr>
	
	<tr>
		<td>
			<form:label path="city">
				<spring:message text="City"/>
			</form:label>
		</td>
		<td>
			<select name="category">
			    <c:forEach items="${listCity}" var="category">
			        <option value="${category.city}">${category.city}</option>
			    </c:forEach>
			</select>
		</td>
	</tr>
	
	
	<tr>
		<td>
			<form:label path="task">
				<spring:message text="Task"/>
			</form:label>
		</td>
		<td>
			<form:textarea path="task" rows="5" cols="30" required="required"/>
		</td>
	</tr>
	
	<tr>
		<td>
			<form:label path="remark">
				<spring:message text="Remark"/>
			</form:label>
		</td>
		<td>
			
			<form:textarea path="remark" rows="5" cols="30" required="required"/>
		</td>
	</tr>
	
	<tr>
		<td colspan="2">
			<c:if test="${!empty person.name}">
				<input type="submit"
					value="<spring:message text="Edit Person"/>" />
			</c:if>
			<c:if test="${empty person.name}">
				<input type="submit"
					value="<spring:message text="Add Person"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br></body>
</html>
