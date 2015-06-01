<#include "/base/formheader.jsp" parse=true encoding="utf-8">
<div class="container">
	<h3 class="text-center">图标管理</h3>
	<form codingform class="form-horizontal" >
		<input type="hidden" class="form-control " name="id"  />
		<div class="table-responsive">
			<table class="table table-bordered formtable">
			    <tr>
					<td class="info">
						<label class="control-label">图标名称:</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="name" datatype="*" />
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">图标路径:</label>
					</td>
					<td>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">图标样式:</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="style" datatype="*" />
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">图标类型:</label>
					</td>
					<td>
						<@dicSelect name="icontype" typeGroupCode="icontype"  ></@dicSelect>
					</td>
			    </tr>
			</table>
		</div>
	</form>
</div>
<#include "/base/formfooter.jsp" parse=true encoding="utf-8">