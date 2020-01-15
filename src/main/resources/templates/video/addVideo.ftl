<html>
<head>
    <meta charset="UTF-8">
    <title>上传视频</title>
</head>
<body>
<center>
    <form id = "add-video-form" ENCTYPE="multipart/form-data">
        视频名称：<input type="text" name="videoName" id="videoName"><br>
        视频封面：<input type="file" name = "imgFile" id = "imgFile"></br>
        视频：<input type="file" name = "videoFile" id = "videoFile"></br>
        <input type="button" value="上传视频" onclick="uploadVideo()">
    </form>
</center>

<script src="./js/jquery-3.4.1.js"></script>
<script>


    var uploadStatus = true;

    function uploadVideo(){

        var videoName = $("#videoName").val();
        if(videoName == null || videoName == ""){alert("视频名称不可为空"); return;}

        var imgFile = $("#imgFile").val();
        if(imgFile == null || imgFile == ""){alert("视频封面不可为空"); return;}

        var videoFile = $("#videoFile").val();
        if(videoFile == null || videoFile == ""){alert("视频不可为空"); return;}

        if(!uploadStatus){
            alert(document.getElementById("videoName").value + " - - - 正在上传中");
            return;
        }
        uploadStatus = false;
        var imgFiles = document.getElementById("imgFile").files;
        var videoFile = document.getElementById("videoFile").files;
        var data = new FormData();
        data.append("imgFile", imgFiles[0]);
        data.append("videoFile", videoFile[0]);
        data.append("videoName", document.getElementById("videoName").value);
        $.ajax({
            type : 'post',
            data : data,
            processData:false,
            contentType:false,
            dataType : 'json',
            url : 'video/addVideo',
            success:function (data) {
               alert(data.msg);
               uploadStatus = true;
               if(data.code == 200){
                   location.href = "/hi";
                }
            },
            error:function (data) {
                uploadStatus = true;
                alert('网络异常！！！');
            }
        });
    }

</script>

</body>
</html>