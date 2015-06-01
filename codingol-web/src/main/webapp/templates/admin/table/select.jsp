<#include "/base/childheader.jsp" parse=true encoding="utf-8">
<table	class="treegrid" data-treefield="name"
	data-url="${ProjectPath}/tableController/indexdata.htm"  
	data-toolbar="#table-toolbar" >
	<tr>
		<th data-field="id" data-hidden="true">序号</th>
	    <th data-field="pid" data-hidden="true">父id</th>
	    <th data-field="parentname">上级菜单</th>
	    <th data-field="name" data-query="true">模块名称</th>
	    <th data-field="code">模块编码</th>
	    <th data-field="codedir">所有父模块代码</th>
	    <th data-field="tablename">数据表名</th>
	    <th data-field="entityname">数据实体名</th>
	    <th data-field="colcount" data-hidden="true">编辑页面列数</th>
	    <th data-field="state" data-hidden="true">叶子</th>
	    <th data-field="iscache">是否缓存</th>
	    <th data-field="isfunsync">同步菜单</th>
	    <th data-field="singleselect">单选</th>
	</tr>
</table>

<div id="table-toolbar" >
	<div class="toolbars">
		<div style="float:left;">
			<a href="javascript:void(0)" action="method:'query'" class="easyui-linkbutton" data-options="iconCls:'icon-search'" >查询</a>
			<a href="javascript:void(0)" action="method:'view',grid:'id',url:'${ProjectPath}/tableController/view.htm'" class="easyui-linkbutton" iconCls="icon-view"  >查看</a>
			<b action="method:'select',grid:'id'"  class="select-button hidden">添加</b>
		</div>
	</div>
</div>
<#include "/base/footer.jsp" parse=true encoding="utf-8">