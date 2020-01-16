<html>
<head>
    <meta charset="UTF-8">
    <title>update user img</title>
</head>
<body>
<center>
    <form id = "login-form">
        上传新头像：<input type="file" name = "userImg" id = "userImg"></br>
        <input type="button" value="修改头像" onclick="updateUserImg()">
    </form>
</center>

<script src="../js/jquery-3.4.1.js"></script>
<script>
    function updateUserImg(){

        var userImg = document.getElementById("userImg").files;
        if(userImg == null || userImg == ''){alert("新头像不可为空！！"); return}

        console.log(userImg[0])
        var data = new FormData();
        data.append("userImg",userImg[0]);

        $.ajax({
            type : 'post',
            data : data,
            dataType : 'json',
            processData:false,
            contentType:false,
            url : '/user/updateUserImg',
            success:function (data) {
                if(data.code == 200){
                    alert(data.msg);
                    location.href = "/hi";
                }else{
                    alert("更换失败，请稍候重试！！");
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