<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 글쓰기</title>
</head>
<body>
	<form action="/board/write" method="post">
		<table>
			<tr>
				<td>title</td>
				<td><input type="text" name="title" /></td>
			</tr>
			<tr>
				<td>content</td>
				<td>
				<textarea rows="3" cols="10" name ="content">
				
				</textarea>
				</td>
			</tr>
		
			
			<tr>
				<td colspan="5"><input type="submit" value="글쓰기" /></td>
			</tr>
		</table>
	</form>
</body>
</html>