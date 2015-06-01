<#include "/base/formheader.jsp" parse=true encoding="utf-8">
<div class="container">
	<h3 class="text-center">系统数据表</h3>
	<form codingform class="form-horizontal" >
		<div class="table-responsive">
			<table class="table table-bordered formtable">
			    <tr class="pid">
					<td class="info">
						<label class="control-label">上级模块名称:</label>
					</td>
					<td colspan="3">
						<p class="form-control-static"></p>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">上级菜单:</label>
					</td>
					<td>
						<p class="form-control-static" name="parentname"></p>
					</td>
					<td class="info">
						<label class="control-label">模块名称:</label>
					</td>
					<td>
						<p class="form-control-static" name="name"></p>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">模块编码:</label>
					</td>
					<td>
						<p class="form-control-static" name="code"></p>
					</td>
					<td class="info">
						<label class="control-label">所有父模块代码:</label>
					</td>
					<td>
						<p class="form-control-static" name="codedir"></p>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">数据表名:</label>
					</td>
					<td>
						<p class="form-control-static" name="tablename"></p>
					</td>
					<td class="info">
						<label class="control-label">数据实体名:</label>
					</td>
					<td>
						<p class="form-control-static" name="entityname"></p>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">编辑页面列数:</label>
					</td>
					<td>
						<p class="form-control-static" name="colcount"></p>
					</td>
					<td class="info">
						<label class="control-label">显示顺序:</label>
					</td>
					<td>
						<p class="form-control-static" name="tableorder"></p>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">叶子:</label>
					</td>
					<td>
						<@dicSelect name="state" typeGroupCode="treestate" type="view" ></@dicSelect>
					</td>
					<td class="info">
						<label class="control-label">是否缓存:</label>
					</td>
					<td>
						<@dicSelect name="iscache" typeGroupCode="yes" type="view" ></@dicSelect>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">同步菜单:</label>
					</td>
					<td>
						<@dicSelect name="isfunsync" typeGroupCode="yes" type="view" ></@dicSelect>
					</td>
					<td class="info">
						<label class="control-label">单选:</label>
					</td>
					<td colspan="3">
						<@dicSelect name="singleselect" typeGroupCode="yes" type="view" ></@dicSelect>
					</td>
			    </tr>
			</table>
		</div>
	</form>
</div>
<#include "/base/formfooter.jsp" parse=true encoding="utf-8">
