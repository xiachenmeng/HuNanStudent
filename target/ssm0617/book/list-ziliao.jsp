<%@ page import="com.qf.util.BookEnum" %>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head><meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><title>
	学生信息管理平台
</title>
	<link href="../Style/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="../Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" />
	<link href="../Style/ks.css" rel="stylesheet" type="text/css" />
	<link href="../css/mine.css" type="text/css" rel="stylesheet">
    <script src="../Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="../Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
    <script src="../Script/jBox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
    <script src="../Script/Common.js" type="text/javascript"></script>
    <script src="../Script/Data.js" type="text/javascript"></script>
    
    <script src="../Script/Common.js" type="text/javascript"></script>
    <script type="text/javascript">
        function searchData(ctype, type) {
            if (type == "t") {
                var c = $("#cValue").val();
                window.location = 'StudentMaterial.aspx?ctype=' + ctype + "&cid=" + c;
            } else if (type == "c") {
                var t = $("#tValue").val();
                window.location = 'StudentMaterial.aspx?cid=' + ctype + "&ctype=" + t;
            }
        }
        //查询的填充
        $().ready(function () {
            var ctype = Request.QueryString("ctype");
            var cid = Request.QueryString("cid");
            if (ctype != null && ctype != "") {
                $("#tValue").val(ctype);
                $("#" + ctype).addClass("hover");
            } else {
                $("#tAll").addClass("hover");
            }
            if (cid != null && cid != "") {
                $("#cValue").val(cid);
                $("#" + cid).addClass("hover");
            } else {
                $("#cAll").addClass("hover");
            }
        });
    </script>
</head>
<body>

	<div class="div_head" style="width: 100%;text-align:center;">
            <span>
                <span style="float:left">当前位置是：学习中心-》资料中心</span>
                <span style="float:right;margin-right: 8px;font-weight: bold">
                	<a style="text-decoration: none" href="add">【上传】</a> &emsp;
                    <a style="text-decoration: none" href="javascript:history.back();">【返回】</a> &emsp;&emsp;
                </span>
            </span>
        </div>  


    <div class="feilei">
        <a href="#"><strong>资料中心</strong></a></div>
    <input type="hidden" id="cValue" value="" />
    <input type="hidden" id="tValue" value="" />
    <div class="fllist">
        <ul>
            <form action="/book/selectall?infotype=${infotype}" method="post">
           	<li>
            <strong>
            标题:&nbsp;&nbsp;
            </strong>
            <input type="text" name="infname" value="${infname}"/>&nbsp;&nbsp;
                <input type="submit" value="搜索" />
            </li>
            </form>
            <li><strong>类型：</strong><a href="/book/selectall" id="tAll" >全部</a>
                
                <a href="/book/selectall?infotype=复习资料&infname=${infname}" id="1" >
                    复习资料</a>
                
                <a href="/book/selectall?infotype=练习题&infname=${infname}" id="2" >
                    练习题</a>
                
                <a href="/book/selectall?infotype=内部资料&infname=${infname}" id="3" >
                    内部资料</a>
                
                <a href="/book/selectall?infotype=真题&infname=${infname}" id="4" >
                    真题</a>
                
            </li>
        </ul>
        <div class="cztable">
            <table width="100%" border="0" cellspacing="0" cellpadding="0" style="text-align:center;">
                <tr>
                <th width="6%">格式</th>
                    <th style="padding-left: 20px;">
                        资料名称
                    </th>
                    <th style="width: 15%; text-align: center;">
                        资料类型
                    </th>
                    <th style="width: 15%; text-align: center;">
                        更新时间
                    </th>
                    <th style="width: 15%; text-align: center;">
                        操作
                    </th>
                </tr>

                <c:forEach items="${pi.list}" var="inf" >
                <tr>
                <td><img src='../Images/FileIco/doc.gif' />${inf.filetype}</td>
                    <td class="xxleft">
                            ${inf.informationname}
                    </td>
                    <td>
                            ${inf.infotype.infotype}
                    </td>
                    <td>
                            <fmt:formatDate value="${inf.date}" pattern="yyyy-MM-dd"></fmt:formatDate>
                    </td>
                    <td>
                        <a href="findbyid?informationid=${inf.informationid}">详情</a>
                    <a href="findbyid2?informationid=${inf.informationid}">编辑</a>
                    </td>
                </tr>
                </c:forEach>

            </table>
            <div class='MainStyle'>
                <div class=''>
                <a href="/book/selectall?infname=${infname}&infotype=${infotype}">首页</a>
                </div>
                <div class=''>
                <a href="/book/selectall?infname=${infname}&index=${pi.prePage==0?1:pi.prePage}&infotype=${infotype}" target='_self'>上一页</a>
                </div>

                <c:forEach begin="1" end="${pi.pages}" var="i">
                <div class='NowItemStyle'>
                    <a href="/book/selectall?infname=${infname}&index=${i}&infotype=${infotype}" target='_self'>${i}</a>
                </div>
                </c:forEach>
                <div class=''>
                <a href="/book/selectall?infname=${infname}&index=${pi.nextPage==0?pi.pages:pi.nextPage}&infotype=${infotype}" target='_self'>下一页</a>
            </div><div class=''>
                <a href="/book/selectall?infname=${infname}&index=${pi.pages}&infotype=${infotype}" target='_self'>尾页</a>
            </div>
                <div class=''>总共<b>${pi.total}</b>条数据</div>
                <div class=''>每页<b><%=BookEnum.PAGE_SIZE.getValue()%></b>条数据</div>
                <div class=''><b>${pi.pageNum}</b>/${pi.pages}</div>
                <div class='SearchStyle'>
                    <input type='text' id='john_Page_Search' onkeydown="if(event.keyCode == 13){page_searchIndex();}"/>
                </div>
                <div class=''>
                <input type='button' value='Go' onclick="page_searchIndex()"/>
                </div></div>
            <script>
                function page_searchIndex(){
                    var searchText = document.getElementById('john_Page_Search');
                    var searchIndex=searchText!=null&&searchText.value != ''?parseInt(searchText.value):0;
                    if(searchIndex >0&&searchIndex<=${pi.pages}){
                        window.location="/book/selectall?infname=${infname}&infotype=${infotype}&index="+searchIndex;
                    }else{
                        alert('需要跳转的页码不能超出范围！');
                    }
                }
            </script>
        </div>
    </div>

            </div>
        </div>
        
    </div>
</body>
</html>
