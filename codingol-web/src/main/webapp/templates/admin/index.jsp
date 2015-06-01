${extends("/base/header.httl")}

<!--#set(List<com.dragon.codingol.domain.system.SystemUserEntity> users)-->
	
			<!--#if(users)-->
			<table  class="table table-striped table-bordered table-hover table-condensed"  >
				<tr>
					<th>序号</th>
					<th>用户名</th>
					<th>真实姓名</th>
					<th>员工工号</th>
					<th>邮箱</th>
					<th>身份证号</th>
					<th>电话号码</th>
				</tr>
				<!--#for(com.dragon.codingol.domain.system.SystemUserEntity user : users)-->
				<tr>
					<td>${for.count}</td>
					<td>${user.name}</td>
					<td>${user.realname}</td>
					<td>${user.number}</td>
					<td>${user.email}</td>
					<td>${user.idc}</td>
					<td>${user.telephone}</td>
				</tr>
				<!--#end-->
			</table>
			<!--#end-->
${extends("/base/footer.httl")}





<table data-url="${ProjectPath}/systemController/indexdata.htm"  bootstraptable  data-height="499">
					<thead>
						<tr>
							<th data-field="id" data-visible="false">序号</th>
							<th data-field="code" data-link="${ProjectPath}/homeController/main.htm?id={id}&code={code}" >编码</th>
							<th data-field="name">系统名称</th>
							<th data-field="packageName">包名</th>
							<th data-field="projectName">项目名称</th> 
						</tr>
					</thead>
				</table>

				
					<table jqGrid data-height="400" data-url="${ProjectPath}/systemController/indexdata.htm">
					<tr>
						<th data-name="id" data-key="true">序号</th>
						<th data-name="code" data-url="${ProjectPath}/homeController/main.htm?id={id}" >编码</th>
						<th data-name="name">系统名称</th>
						<th data-name="packageName">包名</th>
						<th data-name="projectName">项目名称</th> 
					</tr>
				</table>
				
				<table jqGrid data-height="430" data-url="${ProjectPath}/homeController/maindata.htm">
					<tr>
						<th data-name="id" data-key="true">序号</th>
						<th data-name="name">用户名</th>
						<th data-name="realname">真实姓名</th>
						<th data-name="number">员工工号</th>
						<th data-name="email">邮箱</th>
						<th data-name="idc">身份证号</th>
						<th data-name="telephone">电话号码</th>
					</tr>
				</table>