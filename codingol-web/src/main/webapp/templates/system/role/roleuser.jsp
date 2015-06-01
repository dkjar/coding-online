<#include "/base/childheader.jsp" parse=true encoding="utf-8">
<table	class="datagrid" data-singleselect="false"
	data-url="${ProjectPath}/roleController/roleuserdata.htm?roleid=${roleid}"  
	data-toolbar="#role-toolbar" >
	<tr>
		<th data-field="id" data-hidden="true">序号</th>
	    <th data-field="departmentid" data-hidden="true">departmentid</th>
	    <th data-field="departmentname" data-query="true">部门名称</th>
	    <th data-field="realname" data-query="true">真实姓名</th>
	    <th data-field="name">姓名</th>
	    <th data-field="number" data-query="true">编号</th>
	    <th data-field="telephone">电话号码</th>
	    <th data-field="idc">身份证号</th>
	    <th data-field="sex">性别</th>
	</tr>
</table>

<div id="role-toolbar" >
	<div class="toolbars">
		<div style="float:left;">
			<a href="javascript:void(0)" action="method:'query'" class="easyui-linkbutton" data-options="iconCls:'icon-search'" >查询</a>
			<a href="javascript:void(0)" action="method:'addgrid',url:'../roleController/selectuser.htm?roleid=${roleid}'" class="easyui-linkbutton" data-options="iconCls:'icon-add'" >添加</a>
			<a href="javascript:void(0)" action="method:'view',grid:'id',url:'../userController/view.htm'" class="easyui-linkbutton" iconCls="icon-view"  >查看</a>
			<a href="javascript:void(0)" action="method:'delete',grid:'id',url:'../roleController/delroleuser.htm?roleid=${roleid}'" class="easyui-linkbutton" iconCls="icon-delete"  >删除</a>
		</div>
	</div>
</div>
<#include "/base/footer.jsp" parse=true encoding="utf-8">