<#include "/base/formheader.jsp" parse=true encoding="utf-8">
<div class="container">
	<h3 class="text-center">系统用户</h3>
	<form codingform class="form-horizontal" >
		<div class="table-responsive">
			<table class="table table-bordered formtable">
			    <tr>
					<td class="info">
						<label class="control-label">部门名称:</label>
					</td>
					<td>
						<p class="form-control-static" name="departmentname"></p>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">真实姓名:</label>
					</td>
					<td>
						<p class="form-control-static" name="realname"></p>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">姓名:</label>
					</td>
					<td>
						<p class="form-control-static" name="name"></p>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">编号:</label>
					</td>
					<td>
						<p class="form-control-static" name="number"></p>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">email:</label>
					</td>
					<td>
						<p class="form-control-static" name="email"></p>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">电话号码:</label>
					</td>
					<td>
						<p class="form-control-static" name="telephone"></p>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">身份证号:</label>
					</td>
					<td>
						<p class="form-control-static" name="idc"></p>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">QQ:</label>
					</td>
					<td>
						<p class="form-control-static" name="qq"></p>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">性别:</label>
					</td>
					<td>
						<@dicSelect name="sex" typeGroupCode="sex" type="view" ></@dicSelect>
					</td>
			    </tr>
			</table>
		</div>
	</form>
</div>
<#include "/base/formfooter.jsp" parse=true encoding="utf-8">
