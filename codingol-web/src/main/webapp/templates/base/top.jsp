<div class="topbg">
    <div class="topleft">
		<a href="loginController.htm?main" target="_parent"><div class="logo"></div><div class="toptitle">管理系统</div></a>
    </div> 
    <div class="system" id="nav">
    	<#list funs as f>
   		<div class="item" data-toggle="tooltip" title="${f.name}" data-id="${f.id}">
			<img  src="${f.navicon}">
		</div>
		</#list>
	</div>
    <div class="topright"></div> 
	<div class="topinfo"> 
		<div class="user">
			<a href="javascript:void(0);" onclick="easyLoad('baseEmployeeController.htm?viewindex')"    >
			<span>admin</span>
			</a>
		</div>
		<ul>
			<li><a href="javascript:void(0);" onclick="easyLoad('loginController.htm?password')"  >密码修改</a></li>
			<li><a href="../homeController/quit.htm"  >退出</a></li>
		</ul> 
	</div> 
</div> 
