<#include "/base/childheader.jsp" parse=true encoding="utf-8">
<table	class="treegrid" data-treefield="name" data-singleselect="false"
	data-url="${ProjectPath}/roleController/selectfunctionbuttondata.htm?rfunctionid=${rfunctionid}&functionid=${functionid}"
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
			<a href="javascript:void(0)" action="method:'view',grid:'id',url:'../functionbuttonController/view.htm'" class="easyui-linkbutton" iconCls="icon-view"  >查看</a>
			<b action="method:'ajax',grid:'id',url:'../roleController/addrolefunctionbutton.htm?rfunctionid=${rfunctionid}'"  class="select-button hidden">添加</b>
		</div>
	</div>
</div>
<#include "/base/footer.jsp" parse=true encoding="utf-8">