<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>

</head>
<body>

    <center>
        <a href="/login">login</a>
        <form id = "register-form">
            昵称：<input type="text" name = "userName"></br>
            性别：<input type="radio" value="0" name = "userSex">男 <input type="radio" name = "userSex" value="1">女</br>
            密码：<input type="password" name = "userPass" id = "userPass"></br>
            <input type="button" value="注册" onclick="registerUser()">
        </form>
    </center>

    <script src="./js/jquery-3.4.1.js"></script>
    <script>
        function registerUser(){
            $.ajax({
                type : 'post',
                data : $("#register-form").serialize(),
                dataType : 'json',
                url : 'login/register',
                success:function (data) {
                    alert(data.msg);
                    if(data.code == 200){
                        location.href = "registerSuccess?account=" + data.data.account + "&pass=" + data.data.pass;
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