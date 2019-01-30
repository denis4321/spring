/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app01.conversion.ch02.convertor;

import com.app01.conversion.ch01.propertyeditor.Singer;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.convert.converter.Converter;

/**
 *
 * @author Denys.Prokopiuk
 */
@PropertySource("classpath:com/app01/conversion/ch02/convertor/ch02convertor.properties")
@Configuration
@ComponentScan(basePackages = "com.app01.conversion.ch02.convertor")
public class AppConfig {

    @Value("${date.format.pattern}")
    private String dateFormatPattern;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public Singer john(@Value("${countrySinger.firstName}") String firstName,
            @Value("${countrySinger.lastName}") String lastName,
            @Value("${countrySinger.personalSite}") URL personalSite,
            @Value("${countrySinger.birthDate}") DateTime birthDate)
            throws Exception {
        Singer singer = new Singer();
        singer.setFirstName(firstName);
        singer.setLastName(lastName);
        singer.setPersonalSite(personalSite);
        singer.setBirthDate(birthDate);
        return singer;
    }

    @Bean
    public ConversionServiceFactoryBean conversionService() {
        ConversionServiceFactoryBean conversionServiceFactoryBean = new ConversionServiceFactoryBean();
        Set<Converter> convs = new HashSet<>();
        convs.add(converter());
        conversionServiceFactoryBean.setConverters(convs);
        conversionServiceFactoryBean.afterPropertiesSet();
        return conversionServiceFactoryBean;
    }

    @Bean
    StringToDateTimeConverter converter() {
        StringToDateTimeConverter conv = new StringToDateTimeConverter();
        conv.setDatePattern(dateFormatPattern);
        conv.init();
        return conv;
    }

}
