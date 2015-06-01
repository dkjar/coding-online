<${r'#'}include "/base/formheader.jsp" parse=true encoding="utf-8">
<div class="container">
	<h3 class="text-center">${description}</h3>
	<form codingform class="form-horizontal" >
		<#list hiddens as po>
		<#if po.visiable?? && po.visiable == 2 >
		<input type="hidden" class="form-control " name="${po.columncode}"  />
		</#if>
	    </#list>
		<div class="table-responsive">
			<table class="table table-bordered formtable">
				<#if parentColumn??>
			    <${r"@"}parentSelect name="${parentColumn.columncode}" url='../${entityName}Controller/select.htm'  map="${parentColumn.maps}"  ></${r"@"}parentSelect> 
			    </#if>
				<#assign x = 0>
				<#list views as po>
				<#assign i = 0>
				<#if x%colcount ==0 >
				<#if x==0>
			    <tr>
				</#if>
				<#if x!=0>
				</tr>
			    <tr>
				</#if>
			    </#if>
			    <#assign i = i + 1>
					<td class="info">
						<label class="control-label">${po.columnname}:</label>
					</td>
					<#if (x == count-1) && count gt colcount && i != colcount>
					<#assign colspan = (colcount - i) * 2 + 1>
					</#if>
					<td<#if colspan??> colspan="${colspan}"</#if>>
						<#if po.inputtype?? >
							<#if po.inputtype == 1>
						<input type="text"  class="form-control " name="${po.columncode}" <#if po.isnullable == 0>datatype="*"</#if> />
							<#elseif po.inputtype == 2>
								<#if po.diccode??>
						<${r"@"}dicSelect name="${po.columncode}" typeGroupCode="${po.diccode}" <#if po.isnullable == 0>extend='datatype="*"'</#if> ></${r"@"}dicSelect>
								</#if>
							<#elseif po.inputtype == 3>
								<#if po.tablecode?? && tableName !=po.tablecode >
						<${r"@"}tableSelect name="${po.columncode}" <#if selecttable??>url='../${selecttable.entityname?uncap_first}Controller/select.htm'  map="${po.maps }" </#if> <#if po.isnullable == 0>extend='datatype="*"'</#if>></${r"@"}tableSelect>
								</#if>
							<#elseif po.inputtype == 5>
								<#if po.tablecode??>
						<${r"@"}imageUpload name="${po.columncode}" title="${po.columnname}" <#if po.isnullable == 0>extend='datatype="*"'</#if>></${r"@"}imageUpload>
								</#if>
							</#if>
						<#else>
						<input type="text"  class="form-control " name="${po.columncode}" <#if po.isnullable == 0>datatype="*"</#if> />
						</#if>
					</td>
			    <#assign x = x + 1>
			    </#list>
			    </tr>
			</table>
		</div>
	</form>
</div>
<${r'#'}include "/base/formfooter.jsp" parse=true encoding="utf-8">