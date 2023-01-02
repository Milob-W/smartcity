package com.briup.smartcity80.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.briup.smartcity80.web.controller"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(security())
                .securityContexts(securityContexts());
    }
    //swagger界面中显示的基本信息
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("智慧城市咨询云平台")
                .description("202020101 张三")
                .termsOfServiceUrl("http://www.briup.com")
                .version("1.0")
                .build();
    }
    private List<ApiKey> security() {
        return Collections.singletonList(
                new ApiKey("Authorization", "Authorization", "header")
        );
    }
    /**
     * 设置认证规则
     */
    private List<SecurityContext> securityContexts() {
        List<String> antPaths = new ArrayList<>(Arrays.asList("/auth/**"));
        return Collections.singletonList(
                SecurityContext.builder()
                        .securityReferences(defaultAuth())
                        .forPaths(antPathsCondition(antPaths))
                        .build()
        );
    }

    /**
     * 返回认证路径的条件
     */
    private Predicate<String> antPathsCondition(List<String> antPaths){
        List<Predicate<String>> list = new ArrayList<>();
        antPaths.forEach(path->list.add(PathSelectors.ant(path)));
        return Predicates.or(list);
    }

    /**
     * 设置认证的范围，以及认证的字段名称
     */
    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Collections.singletonList(
                new SecurityReference("Authorization", authorizationScopes));
    }

}
