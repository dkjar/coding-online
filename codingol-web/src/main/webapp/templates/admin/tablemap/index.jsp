<table	class="datagrid" 
	data-url="${ProjectPath}/tablemapController/indexdata.htm"  
	data-toolbar="#tablemap-toolbar" >
	<tr>
		<th data-field="id" data-hidden="true">序号</th>
	    <th data-field="tablename"  data-query="true" data-url="../tableController/view.htm?id={tableid}" >主表名称</th> 
	    <th data-field="mapname"  data-url="../tableController/view.htm?id={mapid}" >映射表名</th> 
	    <th data-field="middlename"  data-url="../tableController/view.htm?id={middleid}" >中间表名</th> 
	    <th data-field="maptype"  >映射类型</th> 
	</tr>
</table>

<div id="tablemap-toolbar" >
	<div class="toolbars">
		 <@toolbar functionid="${functionid}" ></@toolbar>
	</div>
</div>