<#include "/base/header.jsp" parse=true encoding="utf-8">
  <body  class="easyui-layout" style="overflow-y: hidden">
		<div data-options="region:'north'" style="height:63px">
			<#include "/base/top.jsp" parse=true encoding="utf-8">
		</div>
		<div data-options="region:'west'" title="导航菜单" style="width:200px;">
			<#include "/system/menu.jsp" parse=true encoding="utf-8">
		</div>
		<div data-options="region:'center'" id="mainPanle">
			 <table class="datagrid" data-url="${ProjectPath}/systemController/indexdata.htm"  
			 		data-edit="${ProjectPath}/homeController/main.htm?id={id}">
				<tr>
					<th data-field="id" >序号</th>
					<th data-field="code" data-url="${ProjectPath}/homeController/main.htm?id={id}">编码</th>
					<th data-field="name">系统名称</th>
					<th data-field="packageName">包名</th>
					<th data-field="projectName">项目名称</th>
					<th data-field="ol-methods" data-edit="${ProjectPath}/homeController/main.htm?id={id}">操作</th>
				</tr>
			</table>
		</div>
<#include "/base/footer.jsp" parse=true encoding="utf-8">

