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
				<#if treeField??>
			    <tr class="pid">
					<td class="info">
						<label class="control-label">上级${treeField.columnname}:</label>
					</td>
					<td <#if colcount?? && colcount gt 1>colspan="${colcount*2-1}"</#if>>
						<p class="form-control-static"></p>
					</td>
				</tr>
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
						<p class="form-control-static" name="${po.columncode}"></p>
							<#elseif po.inputtype == 2>
								<#if po.diccode??>
						<${r"@"}dicSelect name="${po.columncode}" typeGroupCode="${po.diccode}" type="view" ></${r"@"}dicSelect>
								</#if>
							<#elseif po.inputtype == 3>
								<#if po.tablecode??>
						<p class="form-control-static" name="${po.columncode}"></p>
								</#if>
							</#if>
						<#else>
						<p class="form-control-static" name="${po.columncode}"></p>
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
