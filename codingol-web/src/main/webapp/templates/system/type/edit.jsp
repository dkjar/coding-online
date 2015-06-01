${extends("/base/formheader.jsp")}
<div class="container">
	<h2>添加字典信息</h2>
	<form codingform class="form-horizontal" >
		<input type="hidden"  class="form-control " name="id"  /> 
		<div class="table-responsive">
			<table class="table table-bordered formtable">
			    <tr>
					<td class="info">
						<label class="control-label"></label>
					</td>
					<td>
						<input type="text"  class="form-control " name="typegroupid" datatype="*" />
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">名称</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="name" datatype="*" />
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">编码</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="code" datatype="*" />
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">状态</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="status"  />
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">排序</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="order"  />
					</td>
				</tr>
			</table>
		</div>
	</form>
</div>
${extends("/base/formfooter.jsp")}
