### Spring框架集成项目
#### 环境搭建
创建pom.xml内容如下:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
		<java.version>1.8</java.version>
		<maven.compiler.source>8</maven.compiler.source>
		<maven.compiler.target>8</maven.compiler.target>
	</properties>

	<groupId>com.sifei.seed</groupId>
	<artifactId>java-spring</artifactId>
	<version>1.0.0</version>
	<packaging>jar</packaging>

	<dependencies>
	</dependencies>

	<repositories>
		<repository>
			<id>aliyunmaven</id>
			<url>https://maven.aliyun.com/repository/public</url>
		</repository>
	</repositories>
</project>
```

创建应用主入口，内容如下:
```java
public class Application {
  public static void main(String[] args) {
    System.out.println("Hello world!");
  }
}
```

#### 增加集成Spring MVC框架
修改pom.xml内容，增加spring依赖如下:
```xml
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.6.3</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<dependencies>
		<!-- thymeleaf 模板引擎 -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-thymeleaf</artifactId>
		</dependency>
		<!-- web -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<!-- test 单元测试 -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<!-- Junit依赖 -->
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>
```

修改Applicaton类，进行spring框架的启动引导:
```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

新增GreetingController类:
```java
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
}
```

新增src/main/resources/templates/greeting.html渲染模板文件:
```html
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head> 
    <title>Getting Started: Serving Web Content</title> 
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
    <p th:text="'Hello, ' + ${name} + '!'" />
</body>
</html>
```

参考资料: [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)

#### 通过JDBC Template连接MySQL数据库
修改pom.xml内容，增加MySQL数据库驱动依赖如下:
```xml
	<dependencies>
		<!-- Spring JDBC 的依赖包，使用 spring-boot-starter-jdbc 或 spring-boot-starter-data-jpa 将会自动获得HikariCP依赖 -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-jdbc</artifactId>
		</dependency>
		<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
		</dependency>
	</dependencies>
```

新增数据模型src/main/java/com/sifei/seed/model/AppSecondHand.java:
```java
import java.util.Date;

public class AppSecondHand {
    private Long goodsid;
    private Long userid;
    private String title;
    private String content;
    private String avatar;
    private Integer status;
    private Date createTime;
    private Date updateTime;
    public Long getGoodsid() {
        return goodsid;
    }
    public void setGoodsid(Long goodsid) {
        this.goodsid = goodsid;
    }
    public Long getUserid() {
        return userid;
    }
    public void setUserid(Long userid) {
        this.userid = userid;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getAvatar() {
        return avatar;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
```

新增数据操作类src/main/java/com/sifei/seed/model/AppSecondHandDao.java:
```java
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class AppSecondHandDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public List<AppSecondHand> getSecodeHandGoodsList() {
        final String sql = "select goodsid,userid,title,content,avatar,status from app_second_hand";
        List<AppSecondHand> secondHandGoodsList = jdbcTemplate.query(sql, new AppSecondHandMapper());
        return secondHandGoodsList;
    }

    public AppSecondHand getSecodeHandGoodsByGoodsid(final String goodsid) {
        final String sql = "select goodsid,userid,title,content,avatar,status from app_second_hand where goodsid='" + goodsid + "' limit 1";
        List<AppSecondHand> secondHandGoodsList = jdbcTemplate.query(sql, new AppSecondHandMapper());
        if (secondHandGoodsList == null || secondHandGoodsList.isEmpty()) {
            return null;
        }
        return secondHandGoodsList.get(0);
    }

    class AppSecondHandMapper implements RowMapper<AppSecondHand> {
        @Override
        public AppSecondHand mapRow(ResultSet rs, int rowNum) throws SQLException {
            AppSecondHand secondHandGoods = new AppSecondHand();
            secondHandGoods.setGoodsid(rs.getLong("goodsid"));
            secondHandGoods.setUserid(rs.getLong("userid"));
            secondHandGoods.setTitle(rs.getString("title"));
            secondHandGoods.setContent(rs.getString("content"));
            secondHandGoods.setAvatar(rs.getString("avatar"));
            secondHandGoods.setStatus(rs.getInt("status"));
            return secondHandGoods;
        }
    }
}
```

新增src/main/resources/application.properties项目配置文件:
```properties
spring.datasource.url=jdbc:mysql://172.18.130.2:3306/test_school?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
spring.datasource.password=sifeiorgan
spring.datasource.username=sifeiorgan
#spring.datasource.type
#更多细微的配置可以通过下列前缀进行调整
#spring.datasource.hikari
#spring.datasource.tomcat
#spring.datasource.dbcp2
```

通过单元测试验证数据库连接。
新增src/test/java/com/sifei/seed/TestJdbcTemplate.java文件:
```java
import java.util.List;

import com.sifei.seed.model.AppSecondHand;
import com.sifei.seed.model.AppSecondHandDao;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TestJdbcTemplate {
    @Autowired
    private AppSecondHandDao appSecondHandDao;

    @Test
    public void testGetSecodeHandGoodsList() throws Exception {
        List<AppSecondHand> secondHandGoodsList = appSecondHandDao.getSecodeHandGoodsList();
        System.out.println(secondHandGoodsList);
        Assert.assertNotNull(secondHandGoodsList);
    }

    @Test
    public void testGetSecodeHandGoodsByGoodsid() throws Exception {
        AppSecondHand secondHandGoods = appSecondHandDao.getSecodeHandGoodsByGoodsid("1647604759209");
        System.out.println(secondHandGoods);
        Assert.assertNotNull(secondHandGoods);
    }
}
```

参考资料: [Accessing Relational Data using JDBC with Spring](https://spring.io/guides/gs/relational-data-access/)
参考资料: [Spring boot 使用JdbcTemplate访问数据库](https://www.jb51.net/article/139650.htm)


#### 在HTTP数据接口中打通数据库数据
新增接口控制器AppSecondHandController.java:
```java
import java.util.List;

import com.sifei.seed.model.AppSecondHand;
import com.sifei.seed.model.AppSecondHandDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppSecondHandController {
    @Autowired // 通过框架自动注入对象
    private AppSecondHandDao appSecondHandDao;

	@GetMapping("/appsecondhand") // 绑定接口地址
    @ResponseBody // 将返回值序列化为应答内容
    public List<AppSecondHand> getAppSecondGoodsList() {
        List<AppSecondHand> secondHandGoodsList = appSecondHandDao.getSecodeHandGoodsList();
        return secondHandGoodsList;
    }

	@GetMapping("/appsecondhand/{goodsid}") // 绑定接口地址，支持获取地址参数
    @ResponseBody // 将返回值序列化为应答内容
    public AppSecondHand getAppSecondGoodsByGoodsid(
        @PathVariable String goodsid // 从接口地址获取请求参数
        ) {
        AppSecondHand secondHandGoods = appSecondHandDao.getSecodeHandGoodsByGoodsid(goodsid);
        return secondHandGoods;
    }
}
```

运行程序后，可以通过地址 http://localhost:8080/appsecondhand/ 访问接口数据。
