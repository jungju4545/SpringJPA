<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정하기</title>
</head>
<body>

	<form action="/board/update/${id}" method="post">
		<table>
			<tr>
				<td>title</td>
				<td><input type="text" name="title" /></td>
			</tr>
			<tr>
				<td>content</td>
				<td>
				<textarea rows="20" cols="30" name ="content">
				
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