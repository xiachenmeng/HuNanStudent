<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head><meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><title>
	学生信息管理平台
</title>
	<link href="../../Style/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="../../Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" />
	<link href="../../Style/ks.css" rel="stylesheet" type="text/css" />
	<link href="../../css/mine.css" type="text/css" rel="stylesheet">
    <script src="../../Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="../../Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
    <script src="../../Script/jBox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
    <script src="../../Script/Common.js" type="text/javascript"></script>
    <script src="../../Script/Data.js" type="text/javascript"></script>
    
    
</head>
<body>

		<div class="div_head">
            <span>
                <span style="float:left">当前位置是：教务中心-》考试-》新增</span>
                <span style="float:right;margin-right: 8px;font-weight: bold">
                    <a style="text-decoration: none" href="javascript:history.back();">【返回】</a>
                </span>
            </span>
        </div>
</div>
<div class="cztable">
	<form action="add" method="post">
<table border="1" width="100%" class="table_a">
                <tr  width="120px;">
                    <td width="120px">角色名：<span style="color:red">*</span>：</td>
                    <td>
						<input type="text"  name="rolename" value="管理员" />
					</td>
                </tr>

                <tr  width="120px;">
                    <td>菜单资源<span style="color:red">*</span>：</td>
                    <td>

                        <script type="text/javascript">
                            //1.全选/反选
                            function aa(mid){
                                //1.1定位到当前复选框
                                var one=document.getElementById("one"+mid);
                                //1.2选择和他相关的二级菜单
                                var two=document.getElementsByClassName("two"+mid);
                                for(var i=0;i<two.length;i++){
                                    two[i].checked=one.checked;
                                }
                            }
                            function bb(mid){
                                var two=document.getElementsByClassName("two"+mid);
                                var flag=false;
                                for(var i=0;i<two.length;i++){
                                    if (two[i].checked==true){
                                    document.getElementById("one"+mid).checked=true;
                                    flag=true;
                                    break;
                                    }
                                }

                            if (flag==false){
                                document.getElementById("one"+mid).checked=false;
                            }
                            }

                        </script>

						<ul>
                            <c:forEach items="${menus}" var="m1">
                        	<li><input type="checkbox" name="menuid" onclick="aa(${m1.menuid})" id="one${m1.menuid}" value="${m1.menuid}" />${m1.menuname}

                            	<ul>
                                    <c:forEach items="${m1.secondmenus}" var="m2">
                                        <li>&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" onclick="bb(${m1.menuid})" class="two${m1.menuid}"  name="menuid" value="${m2.menuid}"  />${m2.menuname}</li>
                                    </c:forEach>
                                </ul>
                            </li>
                            </c:forEach>
                        </ul>
					</td>
                </tr>
                
                <tr>
                    <td>启用状态<span style="color:red">*</span>：</td>
                    <td>
                        <input type="radio" name="rolestate" checked value="1" />启用
                        <input type="radio" name="rolestate" value="0"/>禁用
                    </td>
                </tr>
				
				<tr width="120px">
					<td colspan="2" align="center">
						<input type="submit" value="添加" /> 
					</td> 
				</tr>
			</table>
	</form>
</div>

            </div>
        </div>
        
    </div>
</body>
</html>
