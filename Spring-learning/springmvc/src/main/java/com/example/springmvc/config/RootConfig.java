package com.example.springmvc.config;

import java.util.regex.Pattern;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.core.type.filter.RegexPatternTypeFilter;

import com.example.springmvc.config.RootConfig.WebPackage;

@Configuration
@ComponentScan(basePackages={"com.example.springmvc"},
    excludeFilters={
        @Filter(type=FilterType.CUSTOM, value= RootConfig.WebPackage.class)
    })
public class RootConfig {//根配置
  public static class WebPackage extends RegexPatternTypeFilter {
    public WebPackage() {
      super(Pattern.compile("com.example.springmvc\\.web"));
    }    
  }
}
