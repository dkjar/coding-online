
<table class="datagrid"
	data-url="${ProjectPath}/appController/indexdata.htm"  data-toolbar="#toolbar" >
	<tr>
		<th data-field="id" data-hidden="true">序号</th>
		<th data-field="appname"
			data-url="${ProjectPath}/homeController/main.htm?id={id}">子系统名称</th>
		<th data-field="apporder">序号</th>
		<th data-field="appurl">路径</th>
		<th data-field="ol-methods"
			data-edit="${ProjectPath}/homeController/main.htm?id={id}">操作</th>
	</tr>
</table>

<div id="toolbar" style="padding:2px 5px;">
	<div style="padding:2px 5px;">
		<a href="javascript:void(0)" codingol="method:'add',url:'${ProjectPath}/appController/edit.htm'" class="easyui-linkbutton" data-options="iconCls:'icon-add'" >添加</a>
		<a href="javascript:void(0)" codingol="method:'edit',url:'${ProjectPath}/appController/edit.htm?id=1'" class="easyui-linkbutton" iconCls="icon-edit"  >修改</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-save"  >保存</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-cut"  >剪切</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-remove"  >删除</a>
		<a href="javascript:void(0)" codingol="method:'ajax',url:'${ProjectPath}/publishController/publish.htm'" class="easyui-linkbutton" data-options="iconCls:'icon-add'" >发布</a>
	</div>
</div>