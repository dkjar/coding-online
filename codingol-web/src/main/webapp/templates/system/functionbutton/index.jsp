<table	class="treegrid" data-treefield="name" 
	data-url="${ProjectPath}/functionbuttonController/indexdata.htm"  
	data-toolbar="#functionbutton-toolbar" >
	<tr>
		<th data-field="id" data-hidden="true">序号</th>
	    <th data-field="pid"  data-hidden="true" >pid</th> 
	    <th data-field="functionid"  data-hidden="true" >菜单id</th> 
	    <th data-field="name"  data-query="true" >按钮名称</th> 
	    <th data-field="action"  >事件</th> 
	    <th data-field="iconname"  data-url="../iconController/view.htm?id={iconid}" >图标名称</th> 
	    <th data-field="iconcode"  >图标编码</th> 
	    <th data-field="side"  >按钮位置</th> 
	    <th data-field="state"  data-hidden="true" >叶子</th> 
	    <th data-field="order"  >排序</th> 
	</tr>
</table>

<div id="functionbutton-toolbar" >
	<div class="toolbars">
		 <@toolbar functionid="${functionid}" ></@toolbar>
	</div>
</div>