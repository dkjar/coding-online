${extends("/base/formheader.jsp")}
<div class="container">
	<h2>添加字典分类管理</h2>
	<form codingform class="form-horizontal" >
		<input type="hidden"  class="form-control " name="id"  /> 
		<div class="table-responsive">
			<table class="table table-bordered formtable">
			    <tr>
					<td class="info">
						<label class="control-label">分类名称:</label>
					</td>
					<td>
						<p class="form-control-static" name="groupname"></p>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">分类编码:</label>
					</td>
					<td>
						<p class="form-control-static" name="groupcode"></p>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">排序:</label>
					</td>
					<td>
						<p class="form-control-static" name="order"></p>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">状态:</label>
					</td>
					<td>
						<p class="form-control-static" name="status"></p>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">创建时间:</label>
					</td>
					<td>
						<p class="form-control-static" name="createdate"></p>
					</td>
				</tr>
			</table>
		</div>
	</form>
</div>
${extends("/base/formfooter.jsp")}
