package com.FJNU.seed.config;

 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;
 import springfox.documentation.builders.ApiInfoBuilder;
 import springfox.documentation.builders.PathSelectors;
 import springfox.documentation.builders.RequestHandlerSelectors;
 import springfox.documentation.service.ApiInfo;
 import springfox.documentation.spi.DocumentationType;
 import springfox.documentation.spring.web.plugins.Docket;
 import springfox.documentation.swagger2.annotations.EnableSwagger2;

 @Configuration //声明该类为配置类
 @EnableSwagger2 //声明启动Swagger2
 public class SwaggerConfig {
   //配置了Swagger的Docket的bean实例
 @Bean
 public Docket createRestApi() {
 return new Docket(DocumentationType.SWAGGER_2)
// .host("172.18.131.22:8090")
 .apiInfo(apiInfo())
 .select()
 .apis(RequestHandlerSelectors.basePackage("com.FJNU.seed"))     //扫描的包路径
 .paths(PathSelectors.any())
 .build();
 }
  //配置Swagger信息=apiInfo
 private ApiInfo apiInfo() {
 return new ApiInfoBuilder()
 .title("服务:发布为daocke镜像,权限管理，用户管理，页面管理，日志 后台 APIs")   //文档说明
 .description("服务:发布为daocke镜像,权限管理，用户管理，页面管理，日志 后台")
 .version("1.0")   //文档版本说明
 .build();
 }
 }

