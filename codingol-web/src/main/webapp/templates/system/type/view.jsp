${extends("/base/formheader.jsp")}
<div class="container">
	<h2>添加字典信息</h2>
	<form codingform class="form-horizontal" >
		<input type="hidden"  class="form-control " name="id"  /> 
		<div class="table-responsive">
			<table class="table table-bordered formtable">
			    <tr>
					<td class="info">
						<label class="control-label">:</label>
					</td>
					<td>
						<p class="form-control-static" name="typegroupid"></p>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">名称:</label>
					</td>
					<td>
						<p class="form-control-static" name="name"></p>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">编码:</label>
					</td>
					<td>
						<p class="form-control-static" name="code"></p>
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
						<label class="control-label">排序:</label>
					</td>
					<td>
						<p class="form-control-static" name="order"></p>
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
