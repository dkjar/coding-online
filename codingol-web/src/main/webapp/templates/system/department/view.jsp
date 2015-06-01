<#include "/base/formheader.jsp" parse=true encoding="utf-8">
<div class="container">
	<h3 class="text-center">组织机构</h3>
	<form codingform class="form-horizontal" >
		<div class="table-responsive">
			<table class="table table-bordered formtable">
			    <tr class="pid">
					<td class="info">
						<label class="control-label">上级部门名称:</label>
					</td>
					<td >
						<p class="form-control-static"></p>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">上级部门:</label>
					</td>
					<td>
						<p class="form-control-static" name="parentname"></p>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">部门名称:</label>
					</td>
					<td>
						<p class="form-control-static" name="name"></p>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">描述:</label>
					</td>
					<td>
						<p class="form-control-static" name="deptdesc"></p>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">图标:</label>
					</td>
					<td>
						<p class="form-control-static" name="depticon"></p>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">部门状态:</label>
					</td>
					<td>
						<p class="form-control-static" name="deptstate"></p>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">顺序:</label>
					</td>
					<td>
						<p class="form-control-static" name="order"></p>
					</td>
			    </tr>
			</table>
		</div>
	</form>
</div>
<#include "/base/formfooter.jsp" parse=true encoding="utf-8">
