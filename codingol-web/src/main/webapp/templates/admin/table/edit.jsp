<#include "/base/formheader.jsp" parse=true encoding="utf-8">
<div class="container">
	<h3 class="text-center">系统数据表</h3>
	<form codingform class="form-horizontal" >
		<input type="hidden" class="form-control " name="id"  />
		<input type="hidden" class="form-control " name="pid"  />
		<div class="table-responsive">
			<table class="table table-bordered formtable">
			    <@parentSelect name="parentname" url='../tableController/select.htm'  map="pid:id,parentname:name"  ></@parentSelect> 
			    <tr>
					<td class="info">
						<label class="control-label">模块名称:</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="name"  />
					</td>
					<td class="info">
						<label class="control-label">模块编码:</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="code"  />
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">所有父模块代码:</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="codedir"  />
					</td>
					<td class="info">
						<label class="control-label">数据表名:</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="tablename"  />
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">数据实体名:</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="entityname"  />
					</td>
					<td class="info">
						<label class="control-label">编辑页面列数:</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="colcount"  />
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">显示顺序:</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="tableorder"  />
					</td>
					<td class="info">
						<label class="control-label">叶子:</label>
					</td>
					<td>
						<@dicSelect name="state" typeGroupCode="treestate"  ></@dicSelect>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">是否缓存:</label>
					</td>
					<td>
						<@dicSelect name="iscache" typeGroupCode="yes" extend='datatype="*"' ></@dicSelect>
					</td>
					<td class="info">
						<label class="control-label">同步菜单:</label>
					</td>
					<td>
						<@dicSelect name="isfunsync" typeGroupCode="yes"  ></@dicSelect>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">单选:</label>
					</td>
					<td colspan="3">
						<@dicSelect name="singleselect" typeGroupCode="yes"  ></@dicSelect>
					</td>
			    </tr>
			</table>
		</div>
	</form>
</div>
<#include "/base/formfooter.jsp" parse=true encoding="utf-8">