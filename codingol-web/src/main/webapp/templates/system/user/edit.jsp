<#include "/base/formheader.jsp" parse=true encoding="utf-8">
<div class="container">
	<h3 class="text-center">系统用户</h3>
	<form codingform class="form-horizontal" >
		<input type="hidden" class="form-control " name="id"  />
		<input type="hidden" class="form-control " name="departmentid"  />
		<input type="hidden" class="form-control " name="employeeid"  />
		<div class="table-responsive">
			<table class="table table-bordered formtable">
			    <tr>
					<td class="info">
						<label class="control-label">部门名称:</label>
					</td>
					<td>
						<@tableSelect name="departmentname" url='../departmentController/select.htm'  map="departmentid:id,departmentname:name"  extend='datatype="*"'></@tableSelect>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">真实姓名:</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="realname"  />
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">姓名:</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="name"  />
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">编号:</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="number" datatype="*" />
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">email:</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="email"  />
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">电话号码:</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="telephone"  />
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">身份证号:</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="idc"  />
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">QQ:</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="qq"  />
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">性别:</label>
					</td>
					<td>
						<@dicSelect name="sex" typeGroupCode="sex"  ></@dicSelect>
					</td>
			    </tr>
			</table>
		</div>
	</form>
</div>
<#include "/base/formfooter.jsp" parse=true encoding="utf-8">