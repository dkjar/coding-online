<${r'#'}include "/base/childheader.jsp" parse=true encoding="utf-8">
<table	<#if treeField??>class="treegrid" data-treefield="${treeField}"<#else>class="datagrid"</#if> <#if singleselect??&&singleselect==0>data-singleselect="false"</#if>
	data-url="${r'$'}{ProjectPath}/${entityName?uncap_first}Controller/indexdata.htm<#if fcolumn??>?${fcolumn.columncode}=${r"$"}{${fcolumn.columncode}}</#if>"
	data-toolbar="#${entityName?uncap_first}-toolbar" >
	<tr>
		<th data-field="id" data-hidden="true">序号</th>
	    <#list columns as po>
	    <#if (po.islist?? && po.islist >= 1) || (po.isquery?? && po.isquery == 1)>
	    <#if po.columncode?? && po.columncode !="id">
	    <th data-field="${po.columncode}"<#if po.isquery?? && po.isquery == 1> data-query="true"</#if><#if po.islist?? && po.islist == 2> data-hidden="true"</#if><#if po.tablecode??&&selecttable??> data-url="../${selecttable.entityname?uncap_first}Controller/view.htm?id={${po.foreignid}}"</#if>>${po.columnname}</th>
	    </#if>
	    </#if>
	    </#list>
	</tr>
</table>

<div id="${entityName?uncap_first}-toolbar" >
	<div class="toolbars">
		<div style="float:left;">
			<a href="javascript:void(0)" action="method:'query'" class="easyui-linkbutton" data-options="iconCls:'icon-search'" >查询</a>
			<a href="javascript:void(0)" action="method:'add',url:'../${entityName?uncap_first}Controller/edit.htm<#if fcolumn??>?${fcolumn.columncode}=${r"$"}{${fcolumn.columncode}}</#if>'" class="easyui-linkbutton" data-options="iconCls:'icon-add'" >添加</a>
			<a href="javascript:void(0)" action="method:'edit',grid:'id',url:'../${entityName?uncap_first}Controller/edit.htm'" class="easyui-linkbutton" iconCls="icon-edit"  >修改</a>
			<a href="javascript:void(0)" action="method:'view',grid:'id',url:'../${entityName?uncap_first}Controller/view.htm'" class="easyui-linkbutton" iconCls="icon-view"  >查看</a>
			<a href="javascript:void(0)" action="method:'delete',grid:'id',url:'../${entityName?uncap_first}Controller/delete.htm'" class="easyui-linkbutton" iconCls="icon-delete"  >删除</a>
			<#list manys as m>
			<a href="javascript:void(0)" action="method:'add',url:'../${entityName?uncap_first}Controller/${entityName?uncap_first}${m.table.entityname?uncap_first}.htm?${m.fcolumn.columncode}={id}'" class="easyui-linkbutton" data-options="iconCls:'icon-add'" >${m.table.name}</a>
			</#list>
		</div>
		<div style="float:right;">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-list"  >列表重设</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" action="method:'recycle'" iconCls="icon-recycle"   >回收站</a>
		</div>
	</div>
</div>
<${r'#'}include "/base/footer.jsp" parse=true encoding="utf-8">