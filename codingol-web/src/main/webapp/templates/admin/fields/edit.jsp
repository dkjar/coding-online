<#include "/base/formheader.jsp" parse=true encoding="utf-8">
<div class="container">
	<h3 class="text-center">系统数据列</h3>
	<form codingform class="form-horizontal" >
		<input type="hidden" class="form-control " name="id"  />
		<input type="hidden" class="form-control " name="tableid"  />
		<input type="hidden" class="form-control " name="datatypeid"  />
		<div class="table-responsive">
			<table class="table table-bordered formtable">
			    <tr>
					<td class="info">
						<label class="control-label">列名:</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="columnname" datatype="*" />
					</td>
					<td class="info">
						<label class="control-label">列编码:</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="columncode"  />
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">数据类型:</label>
					</td>
					<td>
						<@tableSelect name="datatype" url='../fieldsTypeController/select.htm'  map="datatypeid:code,datatype:name"  extend='datatype="*"'></@tableSelect>
					</td>
					<td class="info">
						<label class="control-label">默认值:</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="defaultvalue"  />
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">字典分类:</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="diccode"  />
					</td>
					<td class="info">
						<label class="control-label">外键:</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="foreignid"  />
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">数据表名:</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="tablecode"  />
					</td>
					<td class="info">
						<label class="control-label">列长度:</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="columnlength"  />
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">保留位数:</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="scale"  />
					</td>
					<td class="info">
						<label class="control-label">列表页显示:</label>
					</td>
					<td>
						<@dicSelect name="islist" typeGroupCode="yes"  ></@dicSelect>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">可查询:</label>
					</td>
					<td>
						<@dicSelect name="isquery" typeGroupCode="yes"  ></@dicSelect>
					</td>
					<td class="info">
						<label class="control-label">树型表操作列:</label>
					</td>
					<td>
						<@dicSelect name="istreefield" typeGroupCode="yes"  ></@dicSelect>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">不能重复:</label>
					</td>
					<td>
						<@dicSelect name="isunique" typeGroupCode="yes"  ></@dicSelect>
					</td>
					<td class="info">
						<label class="control-label">允许为空:</label>
					</td>
					<td>
						<@dicSelect name="isnullable" typeGroupCode="yes"  ></@dicSelect>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">显示:</label>
					</td>
					<td>
						<@dicSelect name="visiable" typeGroupCode="yes" extend='datatype="*"' ></@dicSelect>
					</td>
					<td class="info">
						<label class="control-label">输入框类型:</label>
					</td>
					<td>
						<@dicSelect name="inputtype" typeGroupCode="input" extend='datatype="*"' ></@dicSelect>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">顺序:</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="order"  />
					</td>
					<td class="info">
						<label class="control-label">映射关系:</label>
					</td>
					<td colspan="3">
						<input type="text"  class="form-control " name="maps"  />
					</td>
			    </tr>
			</table>
		</div>
	</form>
</div>
<#include "/base/formfooter.jsp" parse=true encoding="utf-8">