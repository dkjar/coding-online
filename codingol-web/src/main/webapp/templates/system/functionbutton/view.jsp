<#include "/base/formheader.jsp" parse=true encoding="utf-8">
<div class="container">
	<h3 class="text-center">菜单功能管理</h3>
	<form codingform class="form-horizontal" >
		<div class="table-responsive">
			<table class="table table-bordered formtable">
			    <tr class="pid">
					<td class="info">
						<label class="control-label">上级按钮名称:</label>
					</td>
					<td >
						<p class="form-control-static"></p>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">按钮名称:</label>
					</td>
					<td>
						<p class="form-control-static" name="name"></p>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">事件:</label>
					</td>
					<td>
						<p class="form-control-static" name="action"></p>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">图标名称:</label>
					</td>
					<td>
						<p class="form-control-static" name="iconname"></p>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">图标编码:</label>
					</td>
					<td>
						<p class="form-control-static" name="iconcode"></p>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">按钮位置:</label>
					</td>
					<td>
						<@dicSelect name="side" typeGroupCode="sidetype" type="view" ></@dicSelect>
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
			</table>
		</div>
	</form>
</div>
<#include "/base/formfooter.jsp" parse=true encoding="utf-8">
