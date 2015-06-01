<#include "/base/childheader.jsp" parse=true encoding="utf-8">
<table	class="treegrid" data-treefield="name"
	data-url="${ProjectPath}/departmentController/indexdata.htm"  
	data-toolbar="#department-toolbar" >
	<tr>
		<th data-field="id" data-hidden="true">序号</th>
	    <th data-field="pid" data-hidden="true">父id</th>
	    <th data-field="name" data-query="true">部门名称</th>
	    <th data-field="deptdesc">描述</th>
	    <th data-field="depticon">图标</th>
	    <th data-field="state" data-hidden="true">叶子</th>
	    <th data-field="deptstate">部门状态</th>
	</tr>
</table>

<div id="department-toolbar" >
	<div class="toolbars">
		<div style="float:left;">
			<a href="javascript:void(0)" action="method:'query'" class="easyui-linkbutton" data-options="iconCls:'icon-search'" >查询</a>
			<a href="javascript:void(0)" action="method:'view',grid:'id',url:'${ProjectPath}/departmentController/view.htm'" class="easyui-linkbutton" iconCls="icon-view"  >查看</a>
			<b action="method:'select',grid:'id'"  class="select-button hidden">添加</b>
		</div>
	</div>
</div>
<#include "/base/footer.jsp" parse=true encoding="utf-8">