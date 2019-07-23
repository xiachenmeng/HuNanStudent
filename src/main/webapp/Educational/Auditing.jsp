<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学生信息管理平台</title>
<link href="../Style/StudentStyle.css" rel="stylesheet" type="text/css" />
<link href="../Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" />
<link href="../Style/ks.css" rel="stylesheet" type="text/css" />
<link href="../css/mine.css" type="text/css" rel="stylesheet">
<script src="../Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
<script src="../Script/jBox/jquery.jBox-2.3.min.js"
	type="text/javascript"></script>
<script src="../Script/jBox/i18n/jquery.jBox-zh-CN.js"
	type="text/javascript"></script>
<script src="../Script/Common.js" type="text/javascript"></script>
<script src="../Script/Data.js" type="text/javascript"></script>

<script>
	function del(){
		confirm("确认删除？");
	}

</script>



</head>
<body>
	
	<div class="div_head" style="width: 100%;text-align:center;">
		<span> <span style="float:left">当前位置是：教务中心-》班级审核</span> <span
			style="float:right;margin-right: 8px;font-weight: bold"> 
		</span>
		</span>
	</div>

	<div class="cztable">
		<div>
			
			<ul class="seachform1">
				<form action="/Educational/findall" method="post">
					<li>
						<label>班级编号</label>
						<input name="classnum" type="text" class="scinput1" value="${cnum}"/>&nbsp;&nbsp;
                        <label>班级名称</label>
						<input name="classname" type="text" class="scinput1" value="${cname}"/>&nbsp;&nbsp;
						<input  type="submit" class="scbtn" value="查询"/>&nbsp;
					</li>
						
				</form>
			</ul>
            <br/>
            
		<table class="table_a" border="1" width="100%">
                <tbody><tr style="font-weight: bold;">
                		<td align="center">序号</td>
                        <td >院系</td>
						<td width="">班级编号</td>
						<td width="">班级名称</td>
                        <td width="15%">班主任老师</td>						
                        <td width="15%">人数</td>
						<td width="15%">班级状态</td>
						<td width="15%">操作</td>  
                    </tr>


                     <c:forEach items="${pi.list}" var="cla">
					 <tr id="product1">
                     	<td align="center">${cla.classid}</td>
                        <td>${cla.department.departname}</td>
						<td>${cla.classnum}</td>
                        <td>${cla.classname}</td>
						<td>${cla.classteacher}</td>
                        <td>${cla.peoplecount}</td>
						<td>${cla.auditcount==1?'审核中':'复审'}</td>
						<td>
							<a href="updatestate/${cla.classid}/1">通过</a>&nbsp;
                            <a href="updatestate/${cla.classid}/0">驳回</a>&nbsp;
							<a href="../Educational/class/view.html">详细</a>
						</td>
                    </tr>
                    </c:forEach>

				
					
                    <tr>
                        <td colspan="20" style="text-align: center;">						
						<a style="text-decoration: none;" href="#">
							<a href="/Educational/findall?classname=${cname}&classnum=${cnum}"> 首页 </a>
							<a href="/Educational/findall?index=${pi.prePage==0?1:pi.prePage}&classname=${cname}&classnum=${cnum}"> 上一页 </a>
							<c:forEach begin="1" end="${pi.pages}" var="i">
								<a href="/Educational/findall?index=${i}&classname=${cname}&classnum=${cnum}">${i}</a>
							</c:forEach>
							<a href="/Educational/findall?index=${pi.nextPage==0?pi.pages:pi.nextPage}&classname=${cname}&classnum=${cnum}"> 下一页</a>
							<a href="/Educational/findall?index=${pi.pages}&classname=${cname}&classnum=${cnum}">尾页</a>
							共${pi.total}条
							每页显示 ${pi.pageNum}/${pi.pages} </a>
                        </td>
                    </tr>
                </tbody>
            </table>
	</div>

	</div>
	</div>

	</div>
</body>
</html>
