<table	class="datagrid" 
	data-url="${ProjectPath}/roleController/indexdata.htm"  
	data-toolbar="#role-toolbar" >
	<tr>
		<th data-field="id" data-hidden="true">序号</th>
	    <th data-field="rolecode" data-query="true">角色编码</th>
	    <th data-field="rolename" data-query="true">角色名称</th>
	</tr>
</table>

<div id="role-toolbar" >
	<div class="toolbars">
		<div style="float:left;">
			<a href="javascript:void(0)" action="method:'query'" class="easyui-linkbutton" data-options="iconCls:'icon-search'" >查询</a>
			<a href="javascript:void(0)" action="method:'add',url:'../roleController/edit.htm'" class="easyui-linkbutton" data-options="iconCls:'icon-add'" >添加</a>
			<a href="javascript:void(0)" action="method:'edit',grid:'id',url:'../roleController/edit.htm'" class="easyui-linkbutton" iconCls="icon-edit"  >修改</a>
			<a href="javascript:void(0)" action="method:'view',grid:'id',url:'../roleController/view.htm'" class="easyui-linkbutton" iconCls="icon-view"  >查看</a>
			<a href="javascript:void(0)" action="method:'delete',grid:'id',url:'../roleController/delete.htm'" class="easyui-linkbutton" iconCls="icon-delete"  >删除</a>
			<a href="javascript:void(0)" action="method:'roleuser',url:'../roleController/roleuser.htm?roleid={id}'" class="easyui-linkbutton" data-options="iconCls:'icon-add'" >系统用户</a>
			<a href="javascript:void(0)" action="method:'rolefunction',url:'../roleController/rolefunction.htm?roleid={id}'" class="easyui-linkbutton" data-options="iconCls:'icon-add'" >系统菜单</a>
		</div>
		<div style="float:right;">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-list"  >列表重设</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" action="method:'recycle'" iconCls="icon-recycle"   >回收站</a>
		</div>
	</div>
</div>