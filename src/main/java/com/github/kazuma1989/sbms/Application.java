
package com.github.kazuma1989.sbms;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.ComponentScan;

/**
 * アプリのエントリーポイント
 */
@SpringBootApplication
@ComponentScan(nameGenerator = FQCNBeanNameGenerator.class)
public class Application extends SpringBootServletInitializer {

    /**
     * bootRun タスクや、java -jar コマンドからアプリを起動するためのメソッド。
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * デプロイ可能な WAR を作成するための設定。
     *
     * cf.
     * https://docs.spring.io/spring-boot/docs/2.1.6.RELEASE/reference/htmlsingle/#howto-create-a-deployable-war-file
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
}

/**
 * Bean 名が重複しないよう、FQCN を bean 名に使う
 *
 * https://qiita.com/sinsengumi/items/655d9f3ff49646dfe61a
 */
class FQCNBeanNameGenerator extends AnnotationBeanNameGenerator {

    @Override
    protected String buildDefaultBeanName(BeanDefinition definition) {
        return definition.getBeanClassName();
    }
}
