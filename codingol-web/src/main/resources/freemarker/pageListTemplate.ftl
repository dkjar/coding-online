<table	<#if treeField??>class="treegrid" data-treefield="${treeField}"<#else>class="datagrid"</#if> <#if singleselect??&&singleselect==0>data-singleselect="false"</#if>
	data-url="${r'$'}{ProjectPath}/${entityName?uncap_first}Controller/indexdata.htm"  
	data-toolbar="#${entityName?uncap_first}-toolbar" >
	<tr>
		<th data-field="id" data-hidden="true">序号</th>
	    <#list columns as po>
	    <#if (po.islist?? && po.islist >= 1) || (po.isquery?? && po.isquery == 1)>
	    <#if po.columncode?? && po.columncode !="id">
	    <th data-field="${po.columncode}" <#if po.isquery??
	    && po.isquery == 1> data-query="true"</#if><#if po.islist??
	    && po.islist == 2> data-hidden="true"</#if><#if po.tablecode?? && po.inputtype?? && po.inputtype==3
	    && selecttable??> data-url="../${selecttable.entityname?uncap_first}Controller/view.htm?id={${po.foreignid}}"</#if><#if po.inputtype??
	    && po.inputtype==5>data-image="true"</#if> >${po.columnname}</th> 
	    </#if>
	    </#if>
	    </#list>
	</tr>
</table>

<div id="${entityName?uncap_first}-toolbar" >
	<div class="toolbars">
		 <${r"@"}toolbar functionid="${r'$'}{functionid}" ></${r"@"}toolbar>
	</div>
</div>