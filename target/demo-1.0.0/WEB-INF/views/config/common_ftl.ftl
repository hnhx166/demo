<#ftl strip_whitespace=true>
<#-- 页面公共ftl 引用处理 -->
<#macro top_menu index>
	<div class="navbar">
				<div class="navbar-inner">
					<div class="container">
						<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> 
							<span class="icon-bar"></span> 
							<span class="icon-bar"></span> 
							<span class="icon-bar"></span> 
						</a> 
						<a class="brand" href="javascript:void(0);">demo项目</a>
						<div class="nav-collapse">
							<#--
							<ul class="nav">
								<li class="${(index == 1)?string('active','')}">
									<a href="/">Dashboard</a>
								</li>
							</ul>
							<form class="navbar-search pull-left" action="">
								<input type="text" class="search-query span2" placeholder="Search" />
							</form>
							-->
							<ul class="nav pull-right">
								<#if adminToken?exists>
									<li class="brand">
										${adminToken.loginName}
									</li>
									<li>
										<a href="javascript:void(0);" onclick="logout();">Logout</a>
									</li>
								</#if>
							</ul>
							
						</div>
					</div>
				</div>
			</div>
</#macro>

	

<#macro left_menu index>
	<div class="span3" style="width:auto;">
		<div class="well" style="padding: 8px 0;">
			<ul class="nav nav-list">
				<li class="nav-header">
					香哥的测试项目
				</li>
				<li class="${(index == 1)?string('active','')}">
					<a href="/"><i class="icon-home"></i>首页</a>
				</li>
				<#--
				<li class="${(index == 2)?string('active','')}">
					<a href="/openlogin/index.vhtml"><i class="icon-home"></i>对外接口管理</a>
				</li>
				-->
				<li>
					<form id="outlog" action="/local/logout.vhtml" method="post">
					
					</form>
				</li>
			</ul>
		</div>
	</div>
</#macro>
 
<#--弹窗初始化参数js-->
<#macro js_common_config>
	
</#macro>
 
 