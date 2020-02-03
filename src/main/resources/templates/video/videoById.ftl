<html xmlns="http://www.w3.org/1999/html">
	<head>
	<meta charset="utf-8">
	<title>播放中。。。</title>
	<link href="/css/video-js.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="/css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="/css/vicons-font.css" />
	<link rel="stylesheet" type="text/css" href="/css/base.css" />
	<link rel="stylesheet" type="text/css" href="/css/buttons.css" />
	<!--[if IE]>
	<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
	<style>
body {
	background-color: #191919
}
.m {
	width: 960px;
	height: 600px;
	margin-left: auto;
	margin-right: auto;
	margin-top: 20px;
}
</style>
	</head>

	<body>
    <div class="m">
      <video id="my-video" class="video-js" controls preload="auto" width="960" height="600" data-setup="{}">
        <source src="/getFile/${result.videoPath}"<#--${result.videoPath}--> type="video/mp4">
    	<source src="http://vjs.zencdn.net/v/oceans.webm" type="video/webm">
    	<source src="http://vjs.zencdn.net/v/oceans.ogv" type="video/ogg">
        <p class="vjs-no-js"> To view this video please enable JavaScript, and consider upgrading to a web browser that <a href="http://videojs.com/html5-video-support/" target="_blank">supports HTML5 video</a> </p>
      </video>
      <script src="/js/video.min.js"></script>
		<script src="https://code.jquery.com/jquery-3.0.0.min.js"></script>
      <script type="text/javascript">
		  //设置中文
		  videojs.addLanguage('zh-CN', {
			  "Play": "播放",
			  "Pause": "暂停",
			  "Current Time": "当前时间",
			  "Duration": "时长",
			  "Remaining Time": "剩余时间",
			  "Stream Type": "媒体流类型",
			  "LIVE": "直播",
			  "Loaded": "加载完毕",
			  "Progress": "进度",
			  "Fullscreen": "全屏",
			  "Non-Fullscreen": "退出全屏",
			  "Mute": "静音",
			  "Unmute": "取消静音",
			  "Playback Rate": "播放速度",
			  "Subtitles": "字幕",
			  "subtitles off": "关闭字幕",
			  "Captions": "内嵌字幕",
			  "captions off": "关闭内嵌字幕",
			  "Chapters": "节目段落",
			  "Close Modal Dialog": "关闭弹窗",
			  "Descriptions": "描述",
			  "descriptions off": "关闭描述",
			  "Audio Track": "音轨",
			  "You aborted the media playback": "视频播放被终止",
			  "A network error caused the media download to fail part-way.": "网络错误导致视频下载中途失败。",
			  "The media could not be loaded, either because the server or network failed or because the format is not supported.": "视频因格式不支持或者服务器或网络的问题无法加载。",
			  "The media playback was aborted due to a corruption problem or because the media used features your browser did not support.": "由于视频文件损坏或是该视频使用了你的浏览器不支持的功能，播放终止。",
			  "No compatible source was found for this media.": "无法找到此视频兼容的源。",
			  "The media is encrypted and we do not have the keys to decrypt it.": "视频已加密，无法解密。",
			  "Play Video": "播放视频",
			  "Close": "关闭",
			  "Modal Window": "弹窗",
			  "This is a modal window": "这是一个弹窗",
			  "This modal can be closed by pressing the Escape key or activating the close button.": "可以按ESC按键或启用关闭按钮来关闭此弹窗。",
			  ", opens captions settings dialog": ", 开启标题设置弹窗",
			  ", opens subtitles settings dialog": ", 开启字幕设置弹窗",
			  ", opens descriptions settings dialog": ", 开启描述设置弹窗",
			  ", selected": ", 选择",
			  "captions settings": "字幕设定",
			  "Audio Player": "音频播放器",
			  "Video Player": "视频播放器",
			  "Replay": "重播",
			  "Progress Bar": "进度小节",
			  "Volume Level": "音量",
			  "subtitles settings": "字幕设定",
			  "descriptions settings": "描述设定",
			  "Text": "文字",
			  "White": "白",
			  "Black": "黑",
			  "Red": "红",
			  "Green": "绿",
			  "Blue": "蓝",
			  "Yellow": "黄",
			  "Magenta": "紫红",
			  "Cyan": "青",
			  "Background": "背景",
			  "Window": "视窗",
			  "Transparent": "透明",
			  "Semi-Transparent": "半透明",
			  "Opaque": "不透明",
			  "Font Size": "字体尺寸",
			  "Text Edge Style": "字体边缘样式",
			  "None": "无",
			  "Raised": "浮雕",
			  "Depressed": "压低",
			  "Uniform": "均匀",
			  "Dropshadow": "下阴影",
			  "Font Family": "字体库",
			  "Proportional Sans-Serif": "比例无细体",
			  "Monospace Sans-Serif": "单间隔无细体",
			  "Proportional Serif": "比例细体",
			  "Monospace Serif": "单间隔细体",
			  "Casual": "舒适",
			  "Script": "手写体",
			  "Small Caps": "小型大写字体",
			  "Reset": "重启",
			  "restore all settings to the default values": "恢复全部设定至预设值",
			  "Done": "完成",
			  "Caption Settings Dialog": "字幕设定视窗",
			  "Beginning of dialog window. Escape will cancel and close the window.": "开始对话视窗。离开会取消及关闭视窗",
			  "End of dialog window.": "结束对话视窗"
			});

			var myPlayer = videojs('my-video');
			videojs("my-video").ready(function(){
				var myPlayer = this;
				//myPlayer.play();
			});




			  
		</script> 
    </div>



	<center>
		<div>
			<font id = "loginMsg" color="#4682b4">{ ${result.userName} }已进入房间
			<input type="button" value="返回播放大厅" onclick="videoHall()">
			<input id="hiddenId" value="${result.userId}" style="display: none">
			<input id="videoId" value="${result.videoId}" style="display: none">
			<input id="hiddenName" value="${result.userName}" style="display: none">
			<input type="button" value="同步播放" onclick="syncVideo(0)">
			<div id = "messages" style="width: 80%;height: 140px;color: #ffcc66;overflow-y:auto;border: 1px solid #999">
			</div>
		</div>
		<div>
			<textarea rows="3" cols="20" id="content"></textarea>
			<br>
			<input type="button" value="gogogo" onclick="SubMessage()" />
		</div>
	</center>
	<script type="text/javascript">

		function videoHall() {
			location.href = "/hi"
		}

		var webSocket =
				new WebSocket('ws://120.9.185.46:8000/MessageWebsocket/'+document.getElementById("videoId").value);
//                new WebSocket('ws://6mx9hud.hn3.mofasuidao.cn/MessageWebsocket/'+document.getElementById("videoId").value);

        //错误通知
		webSocket.onerror = function(event) {
			onError(event)
		};

		//消息通知
		webSocket.onmessage = function(event) {
			onMessage(event)
		};

		//建立连接通知
		webSocket.onopen = function(event) {
			onOpen(event)
		};

		//关闭连接通知
		webSocket.onclose = function(event) {
			onClose(event)
		};

		// 服务器通知页面
		function onMessage(event) {

			var data = JSON.parse(event.data);
			if(data.key == "videoStatus"){
				// 视频状态处理
				videoStatusFun(data.content);
			}else if(data.key == 'message'){
				//消息处理
				document.getElementById('messages').innerHTML += '<br />' + data.content;
				Bottom()
			}else if(data.key == 'videoTime'){
				//同步播放时间
				syncVideoTime(data.content);
			}else if(data.key == 'syncUserCount'){
				//当时视频观看人数
				syncUserCount(data.content);
			}

		}

		//查询当前房间几个人 如果一个人无法播放 同时返回那个用户在线


		var countStatus = false;
		function syncUserCount(data) {
			//俩人的时候才能开始播放
			if(data >= 2){
				countStatus = true;
				return;
			}
			alert("最少俩人才可以播放！！");
			countStatus = false;
			myPlayer.pause();
		}




		//同步播放时间
		function syncVideoTime(time) {
			if(!countStatus){return;}
			myPlayer.currentTime(time);
		}


		//视频播放状态处理  0暂停  1播放
		function videoStatusFun(status) {
			// 房间中俩人才执行
			if(!countStatus){return;}
			if(status == 0){
				myPlayer.pause();
				// 如果是播放 我也播放
			}else if (status == 1){
				myPlayer.play();
			}
		}





		function onOpen(event) {
			document.getElementById('messages').innerHTML = 'Connection established';
		}

		function onError(event) {
			alert(event);
		}

		function onClose(event) {
			alert(event);
		}




		//视频状态  监听
		var myPlayer = videojs('my-video');
		videojs("my-video").ready(function(){
			var myPlayer = this;
			//myPlayer.play();
		});

		videojs('my-video', {}, function() {
			this.on('pause', function() {
				//暂停状态同步后台
				statusSync(0);
			});
			this.on('play',function () {
				//播放状态同步后台
				statusSync(1);
			})
		})

// ---------------------------------  请求后台  -----------------------------------------

		//同步播放进度
		function syncVideo(type) {
			if(!countStatus){return;}
			var text = {
				"key":'videoTime',
				"content":{
					"type": type,
					"time": myPlayer.currentTime(),
					"userId": $("#hiddenId").val()
				}
			};
			webSocket.send(JSON.stringify(text));
		}

		//获取播放进度：
		setInterval(function () {
			if(!countStatus){return;}
			syncVideo(1);
		},500);

		// 播放状态同步到后台
		function statusSync(status){
			var text = {
				"key":'video',
				"content":{
					"status":status
				}
			};
			webSocket.send(JSON.stringify(text));
		}

		// 发送消息
		function SubMessage() {
			if(!countStatus){ alert("当前只有你一个人看视频，喊个人一起吧"); return;}
			var text = document.getElementById('content').value;
			if(text == null || text == ''){
				return;
			}

			var txt = {
				"key":'message',
				"content":{
					"userName":$("#hiddenName").val(),
					"msg":text,
					"userId": $("#hiddenId").val()
				}
			};
			document.getElementById("content").value = '';
			txt = JSON.stringify(txt);
			webSocket.send(txt);
		}

		//滚动条默认底部
		function Bottom() {
			var msg = document.getElementById("messages");
			msg.scrollTop = msg.scrollHeight;
		}



		document.onkeydown = function(e){
			if(e.keyCode == 13){
				SubMessage();
			}
		}

	</script>
</body>
</html>
