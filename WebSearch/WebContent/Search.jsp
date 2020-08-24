<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GoogleSearch</title>
</head>
<body style = "background-image: url('https://i.imgur.com/GNm9anG.png');background-size: cover;background-position:5% 5%;background-repeat:no-repeat;" >
 <div style="text-align:center;
   position: absolute;
   top: 50%;
   left: 50%;
   margin: -10px 0 0 -200px;"><br>
   <form action='${requestUri}' method='get'>
  <input type='text' name='keyword' placeholder = '請輸入關鍵字'style="width:330px;height:23px;font-size:13px;"/>
  <input type='submit' value='中文搜尋'style="width:100px;height:30px;font-size:12px;border:3px white double;background-color:#C2C2FF" />
  </form>
  <form action = 'TestProject2.jsp'>
  <br><input type='submit' value='切換語言'style="width:100px;height:30px;font-size:12px;border:3px white double;background-color:#C2C2FF" />
  </form>
   </div>

</body>
</html>