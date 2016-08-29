<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	<%--  <OBJECT id=WMP height=320 standby=Loading... width=332 classid=clsid:6BF52A52-394A-11D3-B153-00C04F79FAA6>
    	<PARAM NAME="URL" VALUE="${video.vedioname}">
    	
    </OBJECT>
    <object width="600px" height="495" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" >
    	<PARAM NAME="FlashVars" VALUE="iid=150156060">
    	<PARAM NAME="Movie" VALUE="${video.vedioname}">
    	<PARAM NAME="Src" VALUE="${video.vedioname}">
    </object>${video.vedioname} --%>

	<%-- 支持ie --%>
<%-- 	<object align=middle
		classid="CLSID:22d6f312-b0f6-11d0-94ab-0080c74c7e95" class=OBJECT
		id=MediaPlayer width=300 height=300>
		<param name=ShowStatusBar value=0>
		<param name=Filename value="${video.vedioname}">
		<embed type=application/x-oleobject
			codebase="http://activex.microsoft.com/activex/controls/mplayer/en/nsmp2inf.cab#Version=5,1,52,701">
		</embed>
	</object>
	ie支持
	<object id="WMPlay" width="640" height="480" classid="CLSID:22d6f312-b0f6-11d0-94ab-0080c74c7e95" 
		codebase="http://activex.microsoft.com/activex/controls/mplayer/en/nsmp2inf.cab#Version=6,4,5,715" 
		align="baseline" border="0" standby="Loading Microsoft Windows Media Player components..." type="application/x-oleobject">
	  <param name="invokeURLs" value="0">
	  <param name="FileName" value="${video.vedioname}">
	  <param name="ShowControls" value="1">
	  <param name="ShowPositionControls" value="0">
	  <param name="ShowAudioControls" value="1">
	  <param name="ShowTracker" value="1">
	  <param name="ShowDisplay" value="0">
	  <param name="ShowStatusBar" value="1">
	  <param name="AutoSize" value="1">
	  <param name="ShowGotoBar" value="0">
	  <param name="ShowCaptioning" value="0">
	  <param name="AutoStart" value="1">
	  <param name="PlayCount" value="0">
	  <param name="AnimationAtStart" value="0">
	  <param name="TransparentAtStart" value="0">
	  <param name="AllowScan" value="1">
	  <param name="EnableContextMenu" value="0">
	  <param name="ClickToPlay" value="0">
	  <param name="DefaultFrame" value="datawindow">
	</object> --%>
	
	<%--IE、谷歌支持 --%>
	<object classid = "clsid:E23FE9C6-778E-49D4-B537-38FCDE4887D8" width = "320" height="300" events ="True" id = "vlc2">
		<embed src = "${video.vedioname}" qtsrc = "rtsp://10.10.10.16/1_0_Motorola_1.sdp" width = "300"
height="300" autoplay = "true" controller = "true" volume="0" loop = "false "pluginspage =''>
	
	<%--IE支持 --%>
	<%-- <embed pluginspage="http://www.apple.com/quicktime/download/" src="${video.vedioname}" type="application/MPEG-4 Video File" wmode="transparent" autostart="True" loop="True" controller="True"/> --%>
</body>
</html>
