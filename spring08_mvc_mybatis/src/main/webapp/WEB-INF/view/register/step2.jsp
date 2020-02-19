<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="member.register"/></title>
</head>
<body>
	<h2><spring:message code="member.infoInput"/></h2>				<!-- 폼  error태그에 패스로 지정된 에러코드가 존재하면 에러코드에 해당하는 메시지를 출력한다. -->
	<form:form action="step3" commandName="formData">				<!-- 메시지를 찾을 때는 메시지리소스를 사용하므로 라벨 프로퍼티 파일에 에러코드에 대한 메시지를 다음과 같이 추가한다. -->
	<p>
		<label><spring:message code="email"/> : <br>
		<form:input path="email"/>
		<form:errors path="email" />
		</label>
	</p>
	<p>
		<label><spring:message code="name"/> : <br>
		<form:input path="name"/>
		<form:errors path="name" />
		</label>
	</p>
	<p>
		<label><spring:message code="password"/> : <br>
		<form:password path="password"/>
		<form:errors path="password" />
		</label>
	</p>
	<p>
		<label><spring:message code="password.confirm"/> : <br>
		<form:password path="confirmPassword"/>
		<form:errors path="confirmPassword" />
		</label>
	</p>
	<input type="submit" value="<spring:message code="register.btn"/>">
	</form:form>
</body>
</html>