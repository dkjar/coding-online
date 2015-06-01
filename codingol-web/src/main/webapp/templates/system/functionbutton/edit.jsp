<#include "/base/formheader.jsp" parse=true encoding="utf-8">
<div class="container">
	<h3 class="text-center">菜单功能管理</h3>
	<form codingform class="form-horizontal" >
		<input type="hidden" class="form-control " name="id"  />
		<input type="hidden" class="form-control " name="pid"  />
		<input type="hidden" class="form-control " name="functionid"  />
		<input type="hidden" class="form-control " name="iconid"  />
		<input type="hidden" class="form-control " name="state"  />
		<div class="table-responsive">
			<table class="table table-bordered formtable">
			    <tr>
					<td class="info">
						<label class="control-label">按钮名称:</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="name"  />
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">事件:</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="action"  />
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">图标名称:</label>
					</td>
					<td>
						<@tableSelect name="iconname" url='../iconController/select.htm'  map="iconid:id,iconname:name,iconcode:style"  ></@tableSelect>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">图标编码:</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="iconcode"  />
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">按钮位置:</label>
					</td>
					<td>
						<@dicSelect name="side" typeGroupCode="sidetype"  ></@dicSelect>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">排序:</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="order"  />
					</td>
			    </tr>
			</table>
		</div>
	</form>
</div>
<#include "/base/formfooter.jsp" parse=true encoding="utf-8">