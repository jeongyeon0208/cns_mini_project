package com.springmusic.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@OpenAPIDefinition(
        info = @Info(title = "LG CNS 실습 API 명세서",
                description = "LG CNS 실습 API 명세서 페이지입니다",
                version = "v1"),
        servers = {@Server(url = "/", description = "Default Server URL")})
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(
                new io.swagger.v3.oas.models.info.Info()
                        .title("LG CNS 실습 API 명세서")
                        .description("LG CNS 실습 API 명세서 페이지입니다")
                        .version("v1")
        );
    }

}
