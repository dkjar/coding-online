 ${extends("/base/header.jsp")}
<body  class="easyui-layout" style="overflow-y: hidden">
		<div data-options="region:'north'" style="height:50px"></div>
		<div data-options="region:'south'" style="height:50px;"></div>
		<div data-options="region:'center',border:0">
			 <table class="datagrid" data-url="${ProjectPath}/systemController/indexdata.htm"  >
				<tr>
					<th data-field="id" >序号</th>
					<th data-field="code" data-url="${ProjectPath}/homeController/main.htm?id={id}">编码</th>
					<th data-field="name">系统名称</th>
					<th data-field="packageName">包名</th>
					<th data-field="projectName">项目名称</th>
					<th data-field="path">目录</th>
					<th data-field="opt" data-edit="${ProjectPath}/homeController/main.htm?id={id}">操作</th>
				</tr>
			</table>
			
			<div id="tb" style="padding:2px 5px;">
				Date From: <input class="easyui-datebox" style="width:110px">
				To: <input class="easyui-datebox" style="width:110px">
				Language: 
				<select class="easyui-combobox" panelHeight="auto" style="width:100px">
					<option value="java">Java</option>
					<option value="c">C</option>
					<option value="basic">Basic</option>
					<option value="perl">Perl</option>
					<option value="python">Python</option>
				</select>
				<a href="#" class="easyui-linkbutton" iconCls="icon-search">Search</a>
				<div style="padding:2px 5px;">
					<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" >添加</a>
					<a href="#" class="easyui-linkbutton" iconCls="icon-edit"  >修改</a>
					<a href="#" class="easyui-linkbutton" iconCls="icon-save"  >保存</a>
					<a href="#" class="easyui-linkbutton" iconCls="icon-cut"  >剪切</a>
					<a href="#" class="easyui-linkbutton" iconCls="icon-remove"  >删除</a>
				</div>
			</div>
		</div>
${extends("/base/footer.jsp")}


