package cn.bps.config;


import freemarker.template.utility.XmlEscape;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
@PropertySource("classpath:resolver/resolver.properties")
@ComponentScan("cn.bps.controller")
public class SpringConfiguration {

    @Value("${context-type}")
    private String contextType;

    @Value("${prefix}")
    private String prefix;

    @Value("${suffix.html}")
    private String htmlSuffix;

    @Value("${suffix.jsp}")
    private String jspSuffix;

    @Value("${encoding}")
    private String encoding;

    @Bean("htmlViewResolver")
    public FreeMarkerViewResolver getHtmlViewResolver(){
        FreeMarkerViewResolver freeMarkerViewResolver = new FreeMarkerViewResolver();
        freeMarkerViewResolver.setViewClass(FreeMarkerView.class);
        freeMarkerViewResolver.setContentType(contextType);
        freeMarkerViewResolver.setCache(true);
        freeMarkerViewResolver.setPrefix(prefix);
        freeMarkerViewResolver.setSuffix(htmlSuffix);
        freeMarkerViewResolver.setOrder(0);

        return freeMarkerViewResolver;
    }



    @Bean("freeMarkerConfig")
    public FreeMarkerConfigurer getFreeMarkerConfigurer(XmlEscape fmXmlEscape){
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setTemplateLoaderPath("/WEB-INF/");
        freeMarkerConfigurer.setDefaultEncoding(encoding);
        Map<String,Object> map = new HashMap<>();
        map.put("xml_escape",fmXmlEscape);
        freeMarkerConfigurer.setFreemarkerVariables(map);
//        Properties props = new Properties();
//        props.put("template_update_delay",3600);
//        freeMarkerConfigurer.setFreemarkerSettings(props);
        return  freeMarkerConfigurer;
    }

    @Bean("fmXmlEscape")
    public XmlEscape getXmlEscape(){
        return new XmlEscape();
    }



    @Bean("viewResolver")
    public InternalResourceViewResolver getViewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix(prefix);
        viewResolver.setSuffix(jspSuffix);
        return viewResolver;
    }


    @Bean("multipartResolver")
    public CommonsMultipartResolver getCommonsMultipartResolver(){
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setMaxInMemorySize(6000000);
        return commonsMultipartResolver;
    }


}
