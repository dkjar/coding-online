<#include "/base/childheader.jsp" parse=true encoding="utf-8">
<table	class="treegrid" data-treefield="name" data-singleselect="false"
	data-url="${ProjectPath}/userController/selectdepartmentdata.htm?userid=${userid}"  
	data-toolbar="#user-toolbar" >
	<tr>
		<th data-field="id" data-hidden="true">序号</th>
	    <th data-field="pid" data-hidden="true">父id</th>
	    <th data-field="name" data-query="true">部门名称</th>
	    <th data-field="deptdesc">描述</th>
	    <th data-field="depticon">图标</th>
	    <th data-field="deptstate">部门状态</th>
	</tr>
</table>

<div id="user-toolbar" >
	<div class="toolbars">
		<div style="float:left;">
			<a href="javascript:void(0)" action="method:'query'" class="easyui-linkbutton" data-options="iconCls:'icon-search'" >查询</a>
			<a href="javascript:void(0)" action="method:'view',grid:'id',url:'../departmentController/view.htm'" class="easyui-linkbutton" iconCls="icon-view"  >查看</a>
			<b action="method:'ajax',grid:'id',url:'../userController/adduserdepartment.htm?userid=${userid}'"  class="select-button hidden">添加</b>
		</div>
	</div>
</div>
<#include "/base/footer.jsp" parse=true encoding="utf-8">