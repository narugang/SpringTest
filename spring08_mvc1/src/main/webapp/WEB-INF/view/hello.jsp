<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Hello Spring</title>
</head>
<body>
인사 : ${greeting} <!-- 컨트롤러의 model 클래스는 view까지 영향력을 행사한다. 그래서 el태그로 사용이 가능하다. -->
</body>
</html>