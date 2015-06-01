<#include "/base/formheader.jsp" parse=true encoding="utf-8">
<div class="container">
	<h3 class="text-center">系统菜单</h3>
	<form codingform class="form-horizontal" >
		<input type="hidden" class="form-control " name="id"  />
		<input type="hidden" class="form-control " name="pid"  />
		<div class="table-responsive">
			<table class="table table-bordered formtable">
			    <tr class="pid">
					<td class="info">
						<label class="control-label">上级菜单名称:</label>
					</td>
					<td >
						<p class="form-control-static"></p>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">菜单名称:</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="name" datatype="*" />
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">菜单路径:</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="functionurl"  />
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">导航图标:</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="navicon"  />
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">菜单图标:</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="icon"  />
					</td>
			    </tr>
			</table>
		</div>
	</form>
</div>
<#include "/base/formfooter.jsp" parse=true encoding="utf-8">