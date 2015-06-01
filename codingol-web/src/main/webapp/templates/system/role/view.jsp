<#include "/base/formheader.jsp" parse=true encoding="utf-8">
<div class="container">
	<h3 class="text-center">角色管理</h3>
	<form codingform class="form-horizontal" >
		<div class="table-responsive">
			<table class="table table-bordered formtable">
			    <tr>
					<td class="info">
						<label class="control-label">角色编码:</label>
					</td>
					<td>
						<p class="form-control-static" name="rolecode"></p>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">角色名称:</label>
					</td>
					<td>
						<p class="form-control-static" name="rolename"></p>
					</td>
			    </tr>
			</table>
		</div>
	</form>
</div>
<#include "/base/formfooter.jsp" parse=true encoding="utf-8">
