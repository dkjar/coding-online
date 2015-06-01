<table	class="treegrid" data-treefield="name" 
	data-url="${ProjectPath}/departmentController/indexdata.htm"  
	data-toolbar="#department-toolbar" >
	<tr>
		<th data-field="id" data-hidden="true">序号</th>
	    <th data-field="pid"  data-hidden="true" >父id</th> 
	    <th data-field="name"  data-query="true" >部门名称</th> 
	    <th data-field="deptdesc"  >描述</th> 
	    <th data-field="depticon"  >图标</th> 
	    <th data-field="state"  data-hidden="true" >叶子</th> 
	    <th data-field="deptstate"  >部门状态</th> 
	</tr>
</table>

<div id="department-toolbar" >
	<div class="toolbars">
		<div style="float:left;">
			<a href="javascript:void(0)" action="method:'query'" class="easyui-linkbutton" data-options="iconCls:'icon-search'" >查询</a>
			<a href="javascript:void(0)" action="method:'add',url:'../departmentController/edit.htm'" class="easyui-linkbutton" data-options="iconCls:'icon-add'" >添加</a>
			<a href="javascript:void(0)" action="method:'edit',grid:'id',url:'../departmentController/edit.htm'" class="easyui-linkbutton" iconCls="icon-edit"  >修改</a>
			<a href="javascript:void(0)" action="method:'view',grid:'id',url:'../departmentController/view.htm'" class="easyui-linkbutton" iconCls="icon-view"  >查看</a>
			<a href="javascript:void(0)" action="method:'delete',grid:'id',url:'../departmentController/delete.htm'" class="easyui-linkbutton" iconCls="icon-delete"  >删除</a>
			<a href="javascript:void(0)" action="method:'departmentuser',url:'../departmentController/departmentuser.htm?departid={id}'" class="easyui-linkbutton" data-options="iconCls:'icon-add'" >部门管理员</a>
		</div>
		<div style="float:right;">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-list"  >列表重设</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" action="method:'recycle'" iconCls="icon-recycle"   >回收站</a>
		</div>
	</div>
</div>