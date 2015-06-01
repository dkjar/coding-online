
<table class="treegrid"
	data-url="${ProjectPath}/menuController/indexdata.htm"   data-treefield="functionname" data-singleselect="false" 
			data-toolbar="#toolbar"  >
	<tr>
		<th data-field="id"  data-checkbox="true">序号</th>
		<th data-field="functionname">菜单名称</th>
		<th data-field=funalias >子模块编码</th>
		<th data-field=tableName >表名</th>
		<th data-field=entityName >实体名</th>
		<th data-field="functionurl">菜单路径</th>
		<th data-field="functionorder">显示顺序</th>
		<th data-field="ol-methods" data-edit="${ProjectPath}/menuController/main.htm?id={id}">操作</th>
	</tr>
</table>

<div id="toolbar" style="padding:2px 5px;">
	<div style="padding:2px 5px;">
		<a href="javascript:void(0)" action="method:'add',url:'${ProjectPath}/menuController/edit.htm'"  class="easyui-linkbutton" data-options="iconCls:'icon-add'"  >添加</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit"  >修改</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-save" >保存</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-cut"  >剪切</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-remove"  >删除</a>
		
		<a href="javascript:void(0)" action="method:'ajax',grid:'id',url:'${ProjectPath}/publishController/publish.htm'" class="easyui-linkbutton" data-options="iconCls:'icon-add'" >发布</a>
	</div>
</div>
