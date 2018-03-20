

说明

代码方式禁用session配置:
1、nosession.jar 放到tomcat lib目录下
2、修改tomcat conf下的context.xml文件 , 配置如下:
	<Manager className="com.vinux.api.center.core.session.SessionManager" />

