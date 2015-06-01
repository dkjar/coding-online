${extends("/base/formheader.jsp")}
<div class="container">
	<h2>添加字典分类管理</h2>
	<form codingform class="form-horizontal" >
		<input type="hidden"  class="form-control " name="id"  /> 
		<div class="table-responsive">
			<table class="table table-bordered formtable">
			    <tr>
					<td class="info">
						<label class="control-label">分类名称</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="groupname" datatype="*" />
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">分类编码</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="groupcode" datatype="*" />
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
			    <tr>
					<td class="info">
						<label class="control-label">状态</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="status" datatype="*" />
					</td>
				</tr>
			</table>
		</div>
	</form>
</div>
${extends("/base/formfooter.jsp")}
