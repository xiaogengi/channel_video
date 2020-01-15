<html>
<head>
    <meta charset="UTF-8">
    <title>login</title>
</head>
<body>
<center>
    <font color="#a52a2a">if you do not have an account,please register <a href="/register">register</a></font>
    <form id = "login-form">
        账号：<input type="text" name="userAccount" id="userAccount"><br>
        密码：<input type="password" name = "userPass" id = "userPass"></br>
        <input type="button" value="登陆" onclick="login()">
    </form>
</center>

<script src="../js/jquery-3.4.1.js"></script>
<script>
    function login(){
        $.ajax({
            type : 'post',
            data : $("#login-form").serialize()+"&type=2",
            dataType : 'json',
            url : '/login/login',
            success:function (data) {
                alert(data.msg);
                if(data.code == 200){
                    location.href = "/hi";
                }
            },
            error:function (data) {
                alert('网络异常！！！');
            }
        });
    }

</script>

</body>
</html>