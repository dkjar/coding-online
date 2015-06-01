<${r'#'}include "/base/childheader.jsp" parse=true encoding="utf-8">
<table	<#if treeField??>class="treegrid" data-treefield="${treeField}"<#else>class="datagrid"</#if>
	data-url="${r'$'}{ProjectPath}/${entityName?uncap_first}Controller/indexdata.htm"  
	data-toolbar="#${entityName?uncap_first}-toolbar" >
	<tr>
		<th data-field="id" data-hidden="true">序号</th>
	    <#list columns as po>
	    <#if (po.islist?? && po.islist >= 1) || (po.isquery?? && po.isquery == 1)>
	    <#if po.columncode?? && po.columncode !="id">
	    <th data-field="${po.columncode}"<#if po.isquery?? 
	    && po.isquery == 1> data-query="true"</#if><#if po.islist?? 
	    && po.islist == 2> data-hidden="true"</#if><#if po.listurl??> data-url="${po.listurl}"</#if><#if po.inputtype??
	    && po.inputtype==5>data-image="true"</#if>>${po.columnname}</th>
	    </#if>
	    </#if>
	    </#list>
	</tr>
</table>

<div id="${entityName?uncap_first}-toolbar" >
	<div class="toolbars">
		<div style="float:left;">
			<a href="javascript:void(0)" action="method:'query'" class="easyui-linkbutton" data-options="iconCls:'icon-search'" >查询</a>
			<a href="javascript:void(0)" action="method:'view',grid:'id',url:'${r"$"}{ProjectPath}/${entityName?uncap_first}Controller/view.htm'" class="easyui-linkbutton" iconCls="icon-view"  >查看</a>
			<b action="method:'select',grid:'id'"  class="select-button hidden">添加</b>
		</div>
	</div>
</div>
<${r'#'}include "/base/footer.jsp" parse=true encoding="utf-8">