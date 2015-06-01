<#include "/base/formheader.jsp" parse=true encoding="utf-8">
<div class="container">
	<h3 class="text-center">系统数据列</h3>
	<form codingform class="form-horizontal" >
		<div class="table-responsive">
			<table class="table table-bordered formtable">
			    <tr>
					<td class="info">
						<label class="control-label">列名:</label>
					</td>
					<td>
						<p class="form-control-static" name="columnname"></p>
					</td>
					<td class="info">
						<label class="control-label">列编码:</label>
					</td>
					<td>
						<p class="form-control-static" name="columncode"></p>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">数据类型:</label>
					</td>
					<td>
						<p class="form-control-static" name="datatype"></p>
					</td>
					<td class="info">
						<label class="control-label">默认值:</label>
					</td>
					<td>
						<p class="form-control-static" name="defaultvalue"></p>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">字典分类:</label>
					</td>
					<td>
						<p class="form-control-static" name="diccode"></p>
					</td>
					<td class="info">
						<label class="control-label">外键:</label>
					</td>
					<td>
						<p class="form-control-static" name="foreignid"></p>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">数据表名:</label>
					</td>
					<td>
						<p class="form-control-static" name="tablecode"></p>
					</td>
					<td class="info">
						<label class="control-label">列长度:</label>
					</td>
					<td>
						<p class="form-control-static" name="columnlength"></p>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">保留位数:</label>
					</td>
					<td>
						<p class="form-control-static" name="scale"></p>
					</td>
					<td class="info">
						<label class="control-label">列表页显示:</label>
					</td>
					<td>
						<@dicSelect name="islist" typeGroupCode="yes" type="view" ></@dicSelect>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">可查询:</label>
					</td>
					<td>
						<@dicSelect name="isquery" typeGroupCode="yes" type="view" ></@dicSelect>
					</td>
					<td class="info">
						<label class="control-label">树型表操作列:</label>
					</td>
					<td>
						<@dicSelect name="istreefield" typeGroupCode="yes" type="view" ></@dicSelect>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">不能重复:</label>
					</td>
					<td>
						<@dicSelect name="isunique" typeGroupCode="yes" type="view" ></@dicSelect>
					</td>
					<td class="info">
						<label class="control-label">允许为空:</label>
					</td>
					<td>
						<@dicSelect name="isnullable" typeGroupCode="yes" type="view" ></@dicSelect>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">显示:</label>
					</td>
					<td>
						<@dicSelect name="visiable" typeGroupCode="yes" type="view" ></@dicSelect>
					</td>
					<td class="info">
						<label class="control-label">输入框类型:</label>
					</td>
					<td>
						<@dicSelect name="inputtype" typeGroupCode="input" type="view" ></@dicSelect>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">顺序:</label>
					</td>
					<td>
						<p class="form-control-static" name="order"></p>
					</td>
					<td class="info">
						<label class="control-label">映射关系:</label>
					</td>
					<td colspan="3">
						<p class="form-control-static" name="maps"></p>
					</td>
			    </tr>
			</table>
		</div>
	</form>
</div>
<#include "/base/formfooter.jsp" parse=true encoding="utf-8">
