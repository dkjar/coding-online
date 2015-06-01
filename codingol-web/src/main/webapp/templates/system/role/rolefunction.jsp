<#include "/base/childheader.jsp" parse=true encoding="utf-8">
<table	class="treegrid" data-treefield="name" data-singleselect="false"
	data-url="${ProjectPath}/roleController/rolefunctiondata.htm?roleid=${roleid}"  
	data-toolbar="#role-toolbar" >
	<tr>
		<th data-field="id" data-hidden="true">序号</th>
	    <th data-field="pid" data-hidden="true">pid</th>
	    <th data-field="state" data-hidden="true">pid</th>
	    <th data-field="name" data-query="true">菜单名称</th>
	    <th data-field="functionurl">菜单路径</th>
	    <th data-field="navicon">导航图标</th>
	    <th data-field="icon">菜单图标</th>
	</tr>
</table>

<div id="role-toolbar" >
	<div class="toolbars">
		<div style="float:left;">
			<a href="javascript:void(0)" action="method:'query'" class="easyui-linkbutton" data-options="iconCls:'icon-search'" >查询</a>
			<a href="javascript:void(0)" action="method:'addgrid',url:'../roleController/selectfunction.htm?roleid=${roleid}'" class="easyui-linkbutton" data-options="iconCls:'icon-add'" >添加</a>
			<a href="javascript:void(0)" action="method:'view',grid:'id',url:'../functionController/view.htm'" class="easyui-linkbutton" iconCls="icon-view"  >查看</a>
			<a href="javascript:void(0)" action="method:'delete',grid:'id',url:'../roleController/delrolefunction.htm?roleid=${roleid}'" class="easyui-linkbutton" iconCls="icon-delete"  >删除</a>
			<a href="javascript:void(0)" action="method:'rolefunction',url:'../roleController/rolefunctionbutton.htm?roleid=${roleid}&functionid={id}'" class="easyui-linkbutton" data-options="iconCls:'icon-add'" >菜单功能权限</a>
		</div>
	</div>
</div>
<#include "/base/footer.jsp" parse=true encoding="utf-8">