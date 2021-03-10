主要实现功能：springmvc + servlet3.0 使用全注解的方式，启用springmvc,注册viewResolver，静态资源处理，拦截器

注意事项：
    1.将静态资源放在resources目录（classpath）下的static文件夹下，访问报404
       错误一： jsp中引用静态资源  <img src="<%=path%>/static/img/fileupload.jpg">
        注意添加<%=path%>，加入项目根路径访问
       错误二：浏览器访问：http://localhost:8080/springmvc_annotation/static/h.js,由于错误的配置了静态资源映射导致,应该如下配置
       /**
         * /**的意思是所有文件，包括文件夹中的子文件
         * /*是所有文件，不包含子文件
         * /是web项目的根目录
         * @param registry
         *   //两个*表示以/assets开始的任意层级的路径都可以访问得到图片，如 <img src="<%=path%>/static/img/fileupload.jpg">
         *   //一个*表示只可以访问assets目录下的图片文件
         */
       registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
