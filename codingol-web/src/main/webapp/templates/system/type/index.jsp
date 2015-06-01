<table class="datagrid" data-url="${ProjectPath}/typeController/indexdata.htm"  data-toolbar="#type-toolbar" >
	<tr>
		<th data-field="id" data-hidden="true">序号</th>
	    <th data-field="typegroupid"></th>
	    <th data-field="name">名称</th>
	    <th data-field="code">编码</th>
	    <th data-field="status">状态</th>
	    <th data-field="order">排序</th>
	    <th data-field="createdate">创建时间</th>
	</tr>
</table>

<div id="type-toolbar" style="padding:2px 5px;height:28px;">
	<div style="float:left;">
		<a href="javascript:void(0)" action="method:'query'" class="easyui-linkbutton" data-options="iconCls:'icon-search'" >查询</a>
		<a href="javascript:void(0)" action="method:'add',url:'${ProjectPath}/typeController/edit.htm'" class="easyui-linkbutton" data-options="iconCls:'icon-add'" >添加</a>
		<a href="javascript:void(0)" action="method:'edit',grid:'id',url:'${ProjectPath}/typeController/edit.htm'" class="easyui-linkbutton" iconCls="icon-edit"  >修改</a>
		<a href="javascript:void(0)" action="method:'view',grid:'id',url:'${ProjectPath}/typeController/view.htm'" class="easyui-linkbutton" iconCls="icon-view"  >查看</a>
		<a href="javascript:void(0)" action="method:'delete',grid:'id',url:'${ProjectPath}/typeController/delete.htm'" class="easyui-linkbutton" iconCls="icon-delete"  >删除</a>
	</div>
	<div style="float:right;">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-list"  >列表重设</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" action="method:'recycle'" iconCls="icon-recycle"   >回收站</a>
	</div>
</div>