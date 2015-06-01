<#include "/base/childheader.jsp" parse=true encoding="utf-8">
<table	class="datagrid" data-singleselect="false"
	data-url="${ProjectPath}/userController/selectroledata.htm?userid=${userid}"  
	data-toolbar="#user-toolbar" >
	<tr>
		<th data-field="id" data-hidden="true">序号</th>
	    <th data-field="rolecode" data-query="true">角色编码</th>
	    <th data-field="rolename" data-query="true">角色名称</th>
	</tr>
</table>

<div id="user-toolbar" >
	<div class="toolbars">
		<div style="float:left;">
			<a href="javascript:void(0)" action="method:'query'" class="easyui-linkbutton" data-options="iconCls:'icon-search'" >查询</a>
			<a href="javascript:void(0)" action="method:'view',grid:'id',url:'../roleController/view.htm'" class="easyui-linkbutton" iconCls="icon-view"  >查看</a>
			<b action="method:'ajax',grid:'id',url:'../userController/adduserrole.htm?userid=${userid}'"  class="select-button hidden">添加</b>
		</div>
	</div>
</div>
<#include "/base/footer.jsp" parse=true encoding="utf-8">