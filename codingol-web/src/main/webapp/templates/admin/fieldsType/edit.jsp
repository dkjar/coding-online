<#include "/base/formheader.jsp" parse=true encoding="utf-8">
<div class="container">
	<h2>添加基础数据类型</h2>
	<form codingform class="form-horizontal" >
		<input type="hidden"  class="form-control " name="id"  /> 
		<div class="table-responsive">
			<table class="table table-bordered formtable">
			    <tr>
					<td class="info">
						<label class="control-label">类型名称:</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="name" datatype="*"  />
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">类型编码:</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="code" datatype="*" />
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">数据库类型:</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="type" datatype="*" />
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">状态:</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="status"  />
					</td>
				</tr>
			   
			</table>
		</div>
	</form>
</div>
<#include "/base/formfooter.jsp" parse=true encoding="utf-8">
