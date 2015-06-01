<table	class="datagrid" 
	data-url="${ProjectPath}/iconController/indexdata.htm"  
	data-toolbar="#icon-toolbar" >
	<tr>
		<th data-field="id" data-hidden="true">序号</th>
	    <th data-field="name"  data-query="true" >图标名称</th> 
	    <th data-field="iconpath" data-image="true" >图标路径</th> 
	    <th data-field="style"  >图标样式</th> 
	    <th data-field="icontype"  >图标类型</th> 
	</tr>
</table>

<div id="icon-toolbar" >
	<div class="toolbars">
		<div style="float:left;">
			<a href="javascript:void(0)" action="method:'query'" class="easyui-linkbutton" data-options="iconCls:'icon-search'" >查询</a>
			<a href="javascript:void(0)" action="method:'add',url:'../iconController/edit.htm'" class="easyui-linkbutton" data-options="iconCls:'icon-add'" >添加</a>
			<a href="javascript:void(0)" action="method:'edit',grid:'id',url:'../iconController/edit.htm'" class="easyui-linkbutton" iconCls="icon-edit"  >修改</a>
			<a href="javascript:void(0)" action="method:'view',grid:'id',url:'../iconController/view.htm'" class="easyui-linkbutton" iconCls="icon-view"  >查看</a>
			<a href="javascript:void(0)" action="method:'delete',grid:'id',url:'../iconController/delete.htm'" class="easyui-linkbutton" iconCls="icon-delete"  >删除</a>
		</div>
		<div style="float:right;">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-list"  >列表重设</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" action="method:'recycle'" iconCls="icon-recycle"   >回收站</a>
		</div>
	</div>
</div>