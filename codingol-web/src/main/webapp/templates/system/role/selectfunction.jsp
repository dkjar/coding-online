<#include "/base/childheader.jsp" parse=true encoding="utf-8">
<table	class="treegrid" data-treefield="name" data-singleselect="false"
	data-url="${ProjectPath}/roleController/selectfunctiondata.htm?roleid=${roleid}"  
	data-toolbar="#role-toolbar" >
	<tr>
		<th data-field="id" data-hidden="true">序号</th>
	    <th data-field="pid" data-hidden="true">pid</th>
	    <th data-field="name" data-query="true">菜单名称</th>
	    <th data-field="functionurl">菜单路径</th>
	    <th data-field="navicon">导航图标</th>
	    <th data-field="icon">菜单图标</th>
	</tr>
</table>

<div id="role-toolbar" >
	<div class="toolbars">
		<div style="float:left;">
			<a href="javascript:void(0)" action="method:'query'" class="easyui-linkbutton" data-options="iconCls:'icon-search'" >查询</a>
			<a href="javascript:void(0)" action="method:'view',grid:'id',url:'../functionController/view.htm'" class="easyui-linkbutton" iconCls="icon-view"  >查看</a>
			<b action="method:'ajax',grid:'id',url:'../roleController/addrolefunction.htm?roleid=${roleid}'"  class="select-button hidden">添加</b>
		</div>
	</div>
</div>
<#include "/base/footer.jsp" parse=true encoding="utf-8">