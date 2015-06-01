<table	class="datagrid" 
	data-url="${ProjectPath}/fieldsController/indexdata.htm"  
	data-toolbar="#fields-toolbar" >
	<tr>
		<th data-field="id" data-hidden="true">序号</th>
	    <th data-field="columnname"  data-query="true" >列名</th> 
	    <th data-field="columncode"  >列编码</th> 
	    <th data-field="datatype"  data-url="../fieldsTypeController/view.htm?id={datatypeid}" >数据类型</th> 
	    <th data-field="defaultvalue"  >默认值</th> 
	    <th data-field="diccode"  >字典分类</th> 
	    <th data-field="foreignid"  >外键</th> 
	    <th data-field="tablecode"  >数据表名</th> 
	    <th data-field="columnlength"  >列长度</th> 
	    <th data-field="scale"  >保留位数</th> 
	    <th data-field="islist"  >列表页显示</th> 
	    <th data-field="isquery"  >可查询</th> 
	    <th data-field="istreefield"  >树型表操作列</th> 
	    <th data-field="isunique"  >不能重复</th> 
	    <th data-field="isnullable"  >允许为空</th> 
	    <th data-field="visiable"  >显示</th> 
	    <th data-field="inputtype"  >输入框类型</th> 
	</tr>
</table>

<div id="fields-toolbar" >
	<div class="toolbars">
		<div style="float:left;">
			<a href="javascript:void(0)" action="method:'query'" class="easyui-linkbutton" data-options="iconCls:'icon-search'" >查询</a>
			<a href="javascript:void(0)" action="method:'add',url:'../fieldsController/edit.htm'" class="easyui-linkbutton" data-options="iconCls:'icon-add'" >添加</a>
			<a href="javascript:void(0)" action="method:'edit',grid:'id',url:'../fieldsController/edit.htm'" class="easyui-linkbutton" iconCls="icon-edit"  >修改</a>
			<a href="javascript:void(0)" action="method:'view',grid:'id',url:'../fieldsController/view.htm'" class="easyui-linkbutton" iconCls="icon-view"  >查看</a>
			<a href="javascript:void(0)" action="method:'delete',grid:'id',url:'../fieldsController/delete.htm'" class="easyui-linkbutton" iconCls="icon-delete"  >删除</a>
		</div>
		<div style="float:right;">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-list"  >列表重设</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" action="method:'recycle'" iconCls="icon-recycle"   >回收站</a>
		</div>
	</div>
</div>