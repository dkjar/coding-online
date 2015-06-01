<table	class="datagrid" 
	data-url="../userController/indexdata.htm"  
	data-toolbar="#user-toolbar" >
	<tr>
		<th data-field="id" data-hidden="true">序号</th>
	    <th data-field="departmentid" data-hidden="true">departmentid</th>
	    <th data-field="departmentname" data-query="true" data-url="../departmentController/view.htm?id={departmentid}">部门名称</th>
	    <th data-field="realname" data-query="true">真实姓名</th>
	    <th data-field="name">姓名</th>
	    <th data-field="number" data-query="true">编号</th>
	    <th data-field="telephone">电话号码</th>
	    <th data-field="idc">身份证号</th>
	    <th data-field="sex">性别</th>
	</tr>
</table>

<div id="user-toolbar" >
	<div class="toolbars">
		<@toolbar functionid="${functionid}" ></@toolbar>
	</div>
</div>