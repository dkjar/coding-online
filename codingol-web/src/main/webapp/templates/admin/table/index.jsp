<table	class="treegrid" data-treefield="name" 
	data-url="${ProjectPath}/tableController/indexdata.htm"  
	data-toolbar="#table-toolbar" >
	<tr>
		<th data-field="id" data-hidden="true">序号</th>
	    <th data-field="pid"  data-hidden="true" >父id</th> 
	    <th data-field="name"  data-query="true" >模块名称</th> 
	    <th data-field="code"  >模块编码</th> 
	    <th data-field="codedir"  >所有父模块代码</th> 
	    <th data-field="tablename"  >数据表名</th> 
	    <th data-field="entityname"  >数据实体名</th> 
	    <th data-field="colcount"  data-hidden="true" >编辑页面列数</th> 
	    <th data-field="state"  data-hidden="true" >叶子</th> 
	    <th data-field="iscache"  >是否缓存</th> 
	    <th data-field="isfunsync"  >同步菜单</th> 
	    <th data-field="singleselect"  >单选</th> 
	</tr>
</table>

<div id="table-toolbar" >
	<div class="toolbars">
		<div style="float:left;">
			<a href="javascript:void(0)" action="method:'query'" class="easyui-linkbutton" data-options="iconCls:'icon-search'" >查询</a>
			<a href="javascript:void(0)" action="method:'addchild'" class="easyui-linkbutton" data-options="iconCls:'icon-add'" >添加</a>
			<a href="javascript:void(0)" action="method:'editchild'" class="easyui-linkbutton" iconCls="icon-edit"  >修改</a>
			<a href="javascript:void(0)" action="method:'view'" class="easyui-linkbutton" iconCls="icon-view"  >查看</a>
			<a href="javascript:void(0)" action="method:'delete'" class="easyui-linkbutton" iconCls="icon-delete"  >删除</a>
			<a href="javascript:void(0)" action="method:'fields',url:'../tableController/fields.htm?tableid={id}'" class="easyui-linkbutton" data-options="iconCls:'icon-add'" >系统数据列</a>
		</div>
		<div style="float:right;">
			<a href="javascript:void(0)" action="method:'ajax',grid:'id',url:'../tableController/initcolumn.htm'" class="easyui-linkbutton" iconCls="icon-view"  >列初始化</a>
			<a href="javascript:void(0)" action="method:'ajax',grid:'id',url:'../publishController/publish.htm'" class="easyui-linkbutton" data-options="iconCls:'icon-add'" >发布</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-list"  >列表重设</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" action="method:'recycle'" iconCls="icon-recycle"   >回收站</a>
		</div>
	</div>
</div>