<%@ page import="java.util.List" %>
<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="templates/header.jsp"%>
<%@include file="templates/sidebar.jsp"%>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=1.2&ak=ZFra3LYWoS5BRU11s8DFw1GG"></script>
<link rel="stylesheet" href="/OCare/Assets/CSS/homepage.css">
<div class="main_content">
    <div class="search">
        <div class="ui input" style="display: inline-block;">
            <input placeholder="查找老人..." type="text" style="width:500px" id="input_name">
        </div>
        <button class="ui teal button" onclick="FindOlder()" style="display: inline-block;"><i class="search icon"></i></button>
    </div>

    <div class="monitor" id="container"></div>
</div>

<script src="/OCare/Assets/JS/jquery-2.1.4.js"></script>
<script type="text/javascript">
    //***********************地图初始化****************************
    var map, geoc, point1;
    //    function loadScript() {
    //        var script = document.createElement("script");
    //        script.type = "text/javascript";
    //        script.src = "http://api.map.baidu.com/api?v=1.2&ak=ZFra3LYWoS5BRU11s8DFw1GG&callback=init";
    //        document.head.appendChild(script);
    //    }
    map = new BMap.Map("container");
    point1 = new BMap.Point(116.404, 39.915);
    map.centerAndZoom(point1, 14);
    geoc = new BMap.Geocoder();
    var option = {
        type: BMAP_NAVIGATION_CONTROL_LARGE,
        anchor: BMAP_ANCHOR_BOTTOM_RIGHT,
        offset: new BMap.Size(0, 5)
    };
    map.addControl(new BMap.NavigationControl(option));
    RefreshCondition();

    <%--var points = [];--%>
    <%--var markers = [];--%>
    <%--var infoWindows = [];--%>

    <%--<c:forEach items="${Elders}" var="elder" varStatus="status">--%>
    <%--var point = new BMap.Point(${elder.getLatitude()}, ${elder.getLongtitude()});--%>
    <%--points.push(point);--%>
    <%--var marker = new BMap.Marker(points[${status.index}]);--%>
    <%--markers.push(marker);--%>
    <%--markers[0].setAnimation(BMAP_ANIMATION_BOUNCE);--%>
    <%--map.addOverlay(markers[${status.index}]);--%>
    <%--var infoWindow = new BMap.InfoWindow("<div style='width: 320px'><h4 style='margin:0 0 5px 0;padding:0.2em 0'>于子涵</h4>" +--%>
    <%--"<img style='float:right;margin:4px' id='imgDemo' src='./images/testIcon.jpg' width='90' height='100' title='老人头像'/>" +--%>
    <%--"<p style='margin:0;line-height:1.5;font-size:13px'>老人联系电话:<span>13500000000000</span></p>" +--%>
    <%--"<p style='margin:0;line-height:1.5;font-size:13px'>老人监护人联系电话:<span>13500000000000</span></p>" +--%>
    <%--"<p style='margin:0;line-height:1.5;font-size:13px'>老人状态:<span>" + "${elder.getStatus()}" + "</span></p>" +--%>
    <%--"<p style='margin:0;line-height:1.5;font-size:13px'>老人当前地址:<span>上海XXX区XXX路XX号</span></p>" +--%>
    <%--"<p style='margin:0;line-height:1.5;font-size:13px'>老人外出原因:<span>看病</span></p>" +--%>
    <%--"<p style='margin:0;line-height:1.5;font-size:13px'><a href='#' style='text-decoration: none'>查看详情 >>></a> </p>" +--%>
    <%--"</div>");--%>
    <%--infoWindows.push(infoWindow);--%>
    <%--markers[${status.index}].addEventListener("mouseover", function () {--%>
    <%--this.openInfoWindow(infoWindows[${status.index}]);--%>
    <%--});--%>
    <%--</c:forEach>--%>
    <%--map.setViewport(points);--%>

    <%----%>
    <%--window.onload = loadScript;--%>

    // ******************实时刷新老人位置********************

    //定义一个点集
    var new_points = [];
    //var new_markers = [];
    //var new_infoWindows = [];


    //根据老人身份证号查找老人并且显示zai地图中心
    function FindOlder(){
        //alert($("#input_name").val());
        $.ajax({
            url:"/OCare/app/map/getElderPresentLocationById",
            data:{elderId:$("#input_name").val()},
            dataType:"json",
            success:function(data){
                // alert(data.latitude);//测试pass
                var result_point = new BMap.Point(data.latitude, data.longtitude);
                map.centerAndZoom(result_point, 15);
                clearInterval(getIntervalId);

            }
        })
    }

    var getIntervalId = setInterval("RefreshCondition()", 5000);


    function RefreshCondition() {

        $.ajax({
            url: "/OCare/app/map/allEldersPresentLocationInfo",
        })



        $.ajax({
            url: "/OCare/app/map/allEldersPresentLocationInfo",
            type: "GET",
            // async: false, //同步执行
            dataType: "json",
            success: function (data) {
                //定义一个点的集合
                new_points = [];
                //清楚所有覆盖物
                map.clearOverlays();

                for (var i = 0; i < data.resultNum; i++) {
                    //alert(data[i].elder_status);
                    //获取点
                    var p = new BMap.Point(data.result[i].latitude, data.result[i].longtitude);
                    //定义一个表示点的实际地址的变量
                    var adress = "暂时无法获得";
                    //将点加入点集
                    new_points.push(p);
                    //定义标注物
                    var m = new BMap.Marker(p);
                    //将标注物加入地图
                    map.addOverlay(m);
                    //设置老人有紧急情况时的状态表示
                    if (data.result[i].status == 1) {
                        m.setAnimation(BMAP_ANIMATION_BOUNCE);
                    }

                    //？逆地址解析(无法修改外部变量)
                    geoc.getLocation(p, function (rs) {
                        var addComp = rs.addressComponents;
                        adress = addComp.province + addComp.city + addComp.district + addComp.street + addComp.streetNumber;
                        // alert(adress);
                        // alert(addComp.province + ", " + addComp.city + ", " + addComp.district + ", " + addComp.street + ", " + addComp.streetNumber);

                    });
                    //初始化信息窗口内容
                    var info = new BMap.InfoWindow("<div style='width: 320px'><h4 style='margin:0 0 5px 0;padding:0.2em 0'>---</h4>" +
                            "<img style='float:right;margin:4px' id='imgDemo' src='../Assets/Images/testIcon.jpg' width='90' height='100' title='老人头像'/>" +
                            "<p style='margin:0;line-height:1.5;font-size:13px'>老人联系电话:<span>-</span></p>" +
                            "<p style='margin:0;line-height:1.5;font-size:13px'>老人监护人联系电话:<span>-</span></p>" +
                            "<p style='margin:0;line-height:1.5;font-size:13px'>老人状态:<span>" + data.result[i].status + "</span></p>" +
                            "<p style='margin:0;line-height:1.5;font-size:13px'>老人当前地址:<span>" + adress + "</span></p>" +
                            "<p style='margin:0;line-height:1.5;font-size:13px'>老人外出原因:<span>-</span></p>" +
                            "<p style='margin:0;line-height:1.5;font-size:13px'><a href='#' style='text-decoration: none'>查看详情 >>></a> </p>" +
                            "</div>");

                    //给标注物增加信息窗口
                    m.addEventListener("mouseover", function () {
                        this.openInfoWindow(info);
                    });
                }
                map.setViewport(new_points);
            }

        })
    }
</script>
<%@include file="templates/footer.jsp"%>