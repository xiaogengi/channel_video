<html>
<head>
    <meta charset="UTF-8">
    <title>注册成功</title>
</head>
<body>
    <center>
       账号为：${account}
        <br>
        <input type="button" value="登陆" onclick="login()">
        <input type="hidden" value="${account}" id = "account">
        <input type="hidden" value="${userPass}" id = "userPass">
    </center>

    <script src="./js/jquery-3.4.1.js"></script>
    <script>

        function login(){
            $.ajax({
                type:'post',
                url:'login/login',
                data:{userAccount:$("#account").val(), userPass:$("#userPass").val(), type: 1},
                dataType:'json',
                success:function (data) {
                    alert(data.msg);
                    if(data.code == 200){
                        location.href = "/hi";
                    }
                },
                error:function (data) {
                    alert("网络异常！！");
                }
            });
        }


    </script>
</body>
</html>