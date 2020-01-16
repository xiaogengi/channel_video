<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
      <title>播放大厅</title>
    <link type="text/css" rel="stylesheet" href="../css/style.css">
    <script src="/js/jquery.min.js"></script>
  </head>
<body>
<div style="height:100px;"></div>
<!-- 可删除 -->

<div class="like-content">
  <center>
    <div class="clearfix">
      <div class="guess-box">
        <ul id = "videoList">

            <#list page.data as list>
                <li class="guess-item">
                    <a href="video/getVideoById?id=${list.id}">
                        <p class="guess-item-text">${list.videoName}</p>
                        <img src="/getFile/${list.imgFile}" width="80%" height="70%">
                    </a>
                </li>
            </#list>

        </ul>
        <div class="guess-switch">
            <img src="/getFile/${userImgPath}" width="20px" height="20px">
            <input type="button" value="添加视频" onclick="addVideo()">
            <input type="button" value="更换头像" onclick="updateImg()">
            <font>当前第[ <font id = "page">${page.page}</font> ]页</font>&nbsp;
            <input type="button" value="上一页" onclick="page(1)">&nbsp;
            <input type="button" value="下一页" onclick="page(2)">&nbsp;
            <font>一共[ <font id = "pageCount">${page.pageCount}</font> ]页</font>
            <font>共有[ <font id = "dataSize">${page.dataSize}</font> ]个视频</font>
        </div>
      </div>
    </div>
  </center>
</div>
<script type="text/javascript">

    function updateImg() {
        location.href = "/updateImg";
    }

    function addVideo() {
        location.href = "/addVideo";
    }

    function page(type) {
        var page = document.getElementById("page").innerText;
        if(type == 1){
            page = Number(page) - 1;
        }else{
            page = Number(page) + 1;
        }

        if(page == 0){
            alert("当前就是第一页 🐲");
            return;
        }
        if(document.getElementById("pageCount").innerText < page){
            alert("当前是最后一页 🐯");
            return;
        }


        $.ajax({
            type:'get',
            url:"/video/pageHandler",
            data:{page:page},
            dataType:'json',
            success:function (data) {
                console.log(data)
                $("li").remove();
                document.getElementById("page").innerHTML = page;
                for (var i = 0; i < data.data.length; i++) {
                    $("#videoList").append(
                        ' <li class="guess-item">\n' +
                        '                    <a href="video/getVideoById?id='+ data.data[i].id +'">\n' +
                        '                        <p class="guess-item-text">'+ data.data[i].videoName +'</p>\n' +
                        '                        <img src="/getFile/'+ data.data[i].imgFile +'" width="80%" height="70%">\n' +
                        '                    </a>\n' +
                        '                </li>'
                    );
                }

            },
            error:function (data) {
                alert("网络异常！！！");
            }
        });

    }


</script>
</body>
</html>
