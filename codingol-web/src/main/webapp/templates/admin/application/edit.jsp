 <#include "/base/formheader.jsp" parse=true encoding="utf-8">
<div class="container">
	<h2>添加項目</h2>
	<form codingform class="form-horizontal" >
		<input type="hidden"  class="form-control " name="id"  />
		<input type="hidden"  class="form-control " name="status"  />
		<div class="table-responsive">
			<table class="table table-bordered formtable">
				<tr>
					<td class="info">
						<label class="control-label">系统名称</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="appname" datatype="*"/>
					</td>
				</tr>
				<tr>
					<td class="info">
						<label class=" control-label">系统路径</label>
					</td>
					<td>
						<input type="text" class="form-control" name="appurl" datatype="*"  />
					</td>
				</tr>
			</table>
		</div>
	</form>
</div>
<#include "/base/formfooter.jsp" parse=true encoding="utf-8">
