
<table class="datagrid"
	data-url="${ProjectPath}/systemController/indexdata.htm"  data-toolbar="#toolbar" >
	<tr>
		<th data-field="id">序号</th>
		<th data-field="code"
			data-url="${ProjectPath}/homeController/main.htm?id={id}">编码</th>
		<th data-field="name">系统名称1</th>
		<th data-field="packageName">包名</th>
		<th data-field="projectName">项目名称</th>
		<th data-field="ol-methods"
			data-edit="${ProjectPath}/homeController/main.htm?id={id}">操作</th>
	</tr>
</table>

<div id="toolbar" style="padding:2px 5px;">
	<div style="padding:2px 5px;">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" >添加</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit"  >修改</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-save"  >保存</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-cut"  >剪切</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-remove"  >删除</a>
		<a href="javascript:void(0)" codingol="method:'add',url:'${ProjectPath}/homeController/main.htm'" class="easyui-linkbutton" data-options="iconCls:'icon-add'" >发布</a>
	</div>
</div>