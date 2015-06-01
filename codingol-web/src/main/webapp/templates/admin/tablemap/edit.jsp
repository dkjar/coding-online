<#include "/base/formheader.jsp" parse=true encoding="utf-8">
<div class="container">
	<h3 class="text-center">表映射关系</h3>
	<form codingform class="form-horizontal" >
		<input type="hidden" class="form-control " name="id"  />
		<input type="hidden" class="form-control " name="tableid"  />
		<input type="hidden" class="form-control " name="mapid"  />
		<input type="hidden" class="form-control " name="middleid"  />
		<div class="table-responsive">
			<table class="table table-bordered formtable">
			    <tr>
					<td class="info">
						<label class="control-label">主表名称:</label>
					</td>
					<td>
						<@tableSelect name="tablename" url='../tableController/select.htm'  map="tableid:id,tablename:name"  ></@tableSelect>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">映射表名:</label>
					</td>
					<td>
						<@tableSelect name="mapname" url='../tableController/select.htm'  map="mapid:id,mapname:name"  ></@tableSelect>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">中间表名:</label>
					</td>
					<td>
						<@tableSelect name="middlename" url='../tableController/select.htm'  map="middleid:id,middlename:name"  ></@tableSelect>
					</td>
				</tr>
			    <tr>
					<td class="info">
						<label class="control-label">映射类型:</label>
					</td>
					<td>
						<@dicSelect name="maptype" typeGroupCode="mapping"  ></@dicSelect>
					</td>
			    </tr>
			</table>
		</div>
	</form>
</div>
<#include "/base/formfooter.jsp" parse=true encoding="utf-8">