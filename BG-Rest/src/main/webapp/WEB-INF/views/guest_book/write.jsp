<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<form method="post">
		
			<table class="table">
				<tr>
					<td> 글쓴이 </td>
					<td> <input type="text" name="guest_writer" > </td>
				</tr>
				<tr>
					<td> 내용 </td>
					<td> <input type="text" name="guest_text"> </td>
				</tr>				
				<tr>
				<td> 사진 </td>
					<td> <input type="photo" name="guest_photo"> </td>
				</tr>
				<td> 주소 </td>
					<td> <input type="photo" name="guest_addr"> </td>
				</tr>
				<tr>
					<td colspan="2"> <input type="submit" value="로그인"> </td>
				</tr>
			</table>
		
		</form>



</body>
</html>