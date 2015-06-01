<#include "/base/childheader.jsp" parse=true encoding="utf-8">
<table	class="datagrid"
	data-url="${ProjectPath}/iconController/indexdata.htm"  
	data-toolbar="#icon-toolbar" >
	<tr>
		<th data-field="id" data-hidden="true">序号</th>
	    <th data-field="name" data-query="true">图标名称</th>
	    <th data-field="iconpath" data-image="true">图标路径</th>
	    <th data-field="style">图标样式</th>
	    <th data-field="icontype">图标类型</th>
	</tr>
</table>

<div id="icon-toolbar" >
	<div class="toolbars">
		<div style="float:left;">
			<a href="javascript:void(0)" action="method:'query'" class="easyui-linkbutton" data-options="iconCls:'icon-search'" >查询</a>
			<a href="javascript:void(0)" action="method:'view',grid:'id',url:'${ProjectPath}/iconController/view.htm'" class="easyui-linkbutton" iconCls="icon-view"  >查看</a>
			<b action="method:'select',grid:'id'"  class="select-button hidden">添加</b>
		</div>
	</div>
</div>
<#include "/base/footer.jsp" parse=true encoding="utf-8">