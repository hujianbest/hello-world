package com.hujian.springditest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CDPlayerConfig {

    @Bean
    public CompactDisc sgtPeppers() {
        return new SgtPeppers();
    }

    @Bean
    public CDPlayer cdplayer(CompactDisc compactdisc) {
        return new CDPlayer(compactdisc);
    }
}
