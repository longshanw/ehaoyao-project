<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link href="<%=request.getContextPath()%>/media/css/style.css" rel="stylesheet">
<style type="text/css">
#buy_table thead tr th{font-size:14px;background-color: #f9f9f9;}
input.item_input {height: 30px;}
</style>	
<script type="text/javascript">
function gotoPage(pageno){
	var pageSize = $("#curPageSize").val().trim();
	var totalRecords = $("#totalRecords").val().trim();
	var actionName = $("#actionName").val().trim();
	var userId = $("#memberCode").val();
	$.ajax({
		type: "POST",
		url:"<%=request.getContextPath()%>/"+actionName+"?method=getUserCollection",
        dataType: "html",
        data: {pageno:pageno,pageSize:pageSize,recTotal:totalRecords,userId:userId},
        success: function(data){
       		$("#cardDiv").parent().html(data);
        },
        error: function(){
        	$("#cardDiv").parent().html("");
        }
	});	
}
function gotoPageSize(pageSize){
	$("#curPageSize").val(pageSize);
	gotoPage($("#curPage").val());
}
//查询
function queryBuy(){
	gotoPage(1);
}
</script>
<div id="cardDiv" style="min-width: 700px;">
	<form id="dataForm" name="dataForm" action="" class="form-horizontal" role="form" method="post">
		<input type="hidden" id="curPage" name="pageno" value="${pageno}"/>
		<input type="hidden" id="curPageSize" name="pageSize" value="${pageSize}"/>
		<input type="hidden" id="totalRecords" name="totalRecords" value="${recTotal}"/>
		<input type="hidden" id="actionName" name="actionName" value="${actionName}"/>
		<div style="clear:both;"></div>
	</form>
	<table id="buy_table" class="table table-bordered">
		<%-- <caption><span style="font-size: 17px;font-weight: bold;">消费记录</span></caption> --%>
		<thead>
			<tr>
				<th>ID</th>
				<th>商品名称</th>
				<th>主商品编码</th>
				<th>主商品名称</th>
				<th>规格</th>
				<th>售价</th>
				<th>生产厂家</th>
			</tr>
		</thead>
		<tbody id="tb_body">
			<c:forEach items="${ucls}" varStatus="status" var="uc">
			<tr>
				<td>${uc.id }</td>
				<td>${uc.mealName }</td>
				<td>${uc.mainSku}</td>
				<td>${uc.title }</td>
				<td>${uc.mealNormName }</td>
				<td>${uc.mealPrice }</td>
				<td>${uc.factory}</td>
			</tr>
			</c:forEach>
			<c:if test="${ucls==null || fn:length(ucls)<=0}">
				<tr>
					<td colspan="7" style="height:80px;text-align: center;vertical-align: middle;font-size:14px;font-weight: bold;">暂无数据！</td>
				</tr>
			</c:if>
		</tbody>
	</table>
	<ul class="pager">
		<%@ include file="/WEB-INF/view/common/page.jspf" %>
	</ul>
</div>