/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.jpa.data.main;

import com.mycompany.my.spring5.jpa.data.config.MyJpaDataConfig;
import com.mycompany.my.spring5.jpa.data.model.Singer;
import com.mycompany.my.spring5.jpa.data.service.SingerService;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MyJpaDataConfig.class);
        SingerService singerService = ctx.getBean(SingerService.class);
        Singer singer = new Singer();
        singer.setAge(1);
        singer.setName("Singer1");
        Singer singer2 = new Singer();
        singer2.setAge(2);
        singer2.setName("Singer2");
        Singer singer3 = new Singer();
        singer3.setAge(3);
        singer3.setName("Singer3");
        singerService.save(singer);
        singerService.save(singer2);
        singerService.save(singer3);
        System.out.println("--------------AFTER save-------------");
        List<Singer> list = singerService.findAll();
        for (Singer item : list) {
            System.out.println("\t"+item);
        }
        System.out.println("--------------AFTER find all-------------");
        list = singerService.findByName("Singer1");
        for (Singer item : list) {
            System.out.println("\t"+item);
        }
        
    }

}
