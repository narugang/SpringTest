<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Hello</title>
</head>
<!-- HelloController에서 hello()메서드가  반환하는 이름이 hello였다. 그리고 jsp파일의 이름이 hello.jsp이다.
	hello()메서드가 반환하는 문자열은 뷰 이름이라고 한다. 뷰 이름은 뷰 페이지로 구현한 파일을 찾을 때 사용되는 이름이고 기본 접미사로 .jsp를 사용한다.-->
<body>
인사말 : ${greeting}
</body>
</html>