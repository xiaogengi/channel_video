<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>

</head>
<body>

    <center>
        <a href="/login">login</a>
        <form id = "register-form">
            昵称：<input type="text" name = "userName" id = "userName"></br>
            头像：<input type="file" id = "userImg"></br>
            性别：<input type="radio" value="0" name = "userSex" checked>男 <input type="radio" name = "userSex" value="1">女</br>
            密码：<input type="password" name = "userPass" id = "userPass"></br>
            <input type="button" value="注册" onclick="registerUser()">
        </form>
    </center>

    <script src="./js/jquery-3.4.1.js"></script>
    <script>
        function registerUser(){


            var userName = $("#userName").val();
            if(userName == null || userName == ''){alert("昵称不可为空");return}

            var userImg = $("#userImg").val();
            if(userImg == null || userImg == ''){alert("头像不可为空");return}

            var userPass = $("#userPass").val();
            if(userPass == null || userPass == ''){alert("密码不可为空");return}



            var data = new FormData();
            data.append("userImg",document.getElementById("userImg").files[0]);
            data.append("userName", userName);
            data.append("userPass", userPass);
            data.append("userSex", $('input[name="userSex"]').filter(':checked').val());

            $.ajax({
                type : 'post',
                data : data,
                processData:false,
                contentType:false,
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