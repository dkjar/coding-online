<#include "/base/formheader.jsp" parse=true encoding="utf-8">
<div class="container">
	<h3 class="text-center">组织机构</h3>
	<form codingform class="form-horizontal" >
		<input type="hidden" class="form-control " name="id"  />
		<input type="hidden" class="form-control " name="pid"  />
		<input type="hidden" class="form-control " name="state"  />
		<input type="hidden" class="form-control " name="level"  />
		<div class="table-responsive">
			<table class="table table-bordered formtable">
			    <@parentSelect name="parentname" url='../departmentController/select.htm' title="部门"  map="pid:id,parentname:name,level:level"  ></@parentSelect> 
			    <tr>
					<td class="info">
						<label class="control-label">部门名称:</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="name" datatype="*" />
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">描述:</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="deptdesc"  />
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">图标:</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="depticon"  />
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">部门状态:</label>
					</td>
					<td>
						<input type="text"  class="form-control " name="deptstate"  />
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">顺序:</label>
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