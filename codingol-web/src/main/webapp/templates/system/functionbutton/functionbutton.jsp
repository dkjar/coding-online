<#include "/base/childheader.jsp" parse=true encoding="utf-8">
<table	class="treegrid" data-treefield="name" 
	data-url="${ProjectPath}/functionbuttonController/indexdata.htm?functionid=${functionid}"
	data-toolbar="#functionbutton-toolbar" >
	<tr>
		<th data-field="id" data-hidden="true">序号</th>
	    <th data-field="pid" data-hidden="true">pid</th>
	    <th data-field="functionid" data-hidden="true">菜单id</th>
	    <th data-field="name" data-query="true">按钮名称</th>
	    <th data-field="action">事件</th>
	    <th data-field="iconname">图标名称</th>
	    <th data-field="iconcode">图标编码</th>
	    <th data-field="state" data-hidden="true">叶子</th>
	</tr>
</table>

<div id="functionbutton-toolbar" >
	<div class="toolbars">
		<div style="float:left;">
			<a href="javascript:void(0)" action="method:'query'" class="easyui-linkbutton" data-options="iconCls:'icon-search'" >查询</a>
			<a href="javascript:void(0)" action="method:'add',url:'../functionbuttonController/edit.htm?functionid=${functionid}'" class="easyui-linkbutton" data-options="iconCls:'icon-add'" >添加</a>
			<a href="javascript:void(0)" action="method:'edit',grid:'id',url:'../functionbuttonController/edit.htm'" class="easyui-linkbutton" iconCls="icon-edit"  >修改</a>
			<a href="javascript:void(0)" action="method:'view',grid:'id',url:'../functionbuttonController/view.htm'" class="easyui-linkbutton" iconCls="icon-view"  >查看</a>
			<a href="javascript:void(0)" action="method:'delete',grid:'id',url:'../functionbuttonController/delete.htm'" class="easyui-linkbutton" iconCls="icon-delete"  >删除</a>
		</div>
		<div style="float:right;">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-list"  >列表重设</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" action="method:'recycle'" iconCls="icon-recycle"   >回收站</a>
		</div>
	</div>
</div>
<#include "/base/footer.jsp" parse=true encoding="utf-8">