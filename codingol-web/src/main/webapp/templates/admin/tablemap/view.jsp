<#include "/base/formheader.jsp" parse=true encoding="utf-8">
<div class="container">
	<h3 class="text-center">表映射关系</h3>
	<form codingform class="form-horizontal" >
		<div class="table-responsive">
			<table class="table table-bordered formtable">
			    <tr>
					<td class="info">
						<label class="control-label">主表名称:</label>
					</td>
					<td>
						<p class="form-control-static" name="tablename"></p>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">映射表名:</label>
					</td>
					<td>
						<p class="form-control-static" name="mapname"></p>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">中间表名:</label>
					</td>
					<td>
						<p class="form-control-static" name="middlename"></p>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">映射类型:</label>
					</td>
					<td>
						<@dicSelect name="maptype" typeGroupCode="mapping" type="view" ></@dicSelect>
					</td>
			    </tr>
			</table>
		</div>
	</form>
</div>
<#include "/base/formfooter.jsp" parse=true encoding="utf-8">
