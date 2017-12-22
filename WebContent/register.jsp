<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
  <meta charset="UTF-8">
  <title>Login Page | Amaze UI Example</title>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="format-detection" content="telephone=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="stylesheet" href="http://cdn.amazeui.org/amazeui/2.7.2/css/amazeui.css"/>
  <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.js"></script>
  <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
  <style>
    .header {
      text-align: center;
    }
    .header h1 {
      font-size: 200%;
      color: #333;
      margin-top: 30px;
    }
    .header p {
      font-size: 14px;
    }
    .a-hide{
      display: none;
    }
  </style>
</head>
<body>
<div class="header">
  <div class="am-g">
    <h1 class="am-article-title">山寨微博系统</h1>
  </div>
  <hr />
</div>
<div class="am-g">

  <div id="register">
    <div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">
      <h3>注册</h3>
      <hr>
      <form method="post" class="am-form" id="regForm" action="register.do">
        <label for="username">用户名:</label>
        <input type="text" name="username" id="username" value="" required>
        <br>
        <label for="password">密码:</label>
        <input type="password" name="password" id="password" value="" required>
        <br>
        <label for="confirm">确认密码:</label>
        <input type="password" name="confirm" id="confirm" value="" required equalTo="#password">
        <br>
        <div class="am-cf">
          <input type="submit" name="" value="注 册" class="am-btn am-btn-primary am-btn-sm am-fl" id="reg">
          <a href="login.jsp" class="am-btn am-btn-default am-btn-sm am-fr">登 录</a>
        </div>
      </form>
    </div>
  </div>

</div>

<script type="text/javascript">
  $("#regForm").validate();
</script>

</body>
</html>
