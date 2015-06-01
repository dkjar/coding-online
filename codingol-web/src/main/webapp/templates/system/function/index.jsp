<table	class="treegrid" data-treefield="name" 
	data-url="${ProjectPath}/functionController/indexdata.htm"  
	data-toolbar="#function-toolbar" >
	<tr>
		<th data-field="id" data-hidden="true">序号</th>
	    <th data-field="pid"  data-hidden="true" >pid</th> 
	    <th data-field="name"  data-query="true" >菜单名称</th> 
	    <th data-field="functionurl"  >菜单路径</th> 
	    <th data-field="navicon"  >导航图标</th> 
	    <th data-field="icon"  >菜单图标</th> 
	    <th data-field="state"  data-hidden="true" >叶子</th> 
	</tr>
</table>

<div id="function-toolbar" >
	<div class="toolbars">
		<div style="float:left;">
			<a href="javascript:void(0)" action="method:'query'" class="easyui-linkbutton" data-options="iconCls:'icon-search'" >查询</a>
			<a href="javascript:void(0)" action="method:'add'" class="easyui-linkbutton" data-options="iconCls:'icon-add'" >添加</a>
			<a href="javascript:void(0)" action="method:'edit'" class="easyui-linkbutton" iconCls="icon-edit"  >修改</a>
			<a href="javascript:void(0)" action="method:'view'" class="easyui-linkbutton" iconCls="icon-view"  >查看</a>
			<a href="javascript:void(0)" action="method:'delete'" class="easyui-linkbutton" iconCls="icon-delete"  >删除</a>
			<a href="javascript:void(0)" action="method:'functionrole',url:'../functionController/functionrole.htm?functionid={id}'" class="easyui-linkbutton" data-options="iconCls:'icon-add'" >角色管理</a>
			<a href="javascript:void(0)" action="method:'functionbutton',url:'../functionController/functionbutton.htm?functionid={id}'" class="easyui-linkbutton" data-options="iconCls:'icon-add'" >菜单功能管理</a>
		</div>
		<div style="float:right;">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-list"  >列表重设</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" action="method:'recycle'" iconCls="icon-recycle"   >回收站</a>
		</div>
	</div>
</div>