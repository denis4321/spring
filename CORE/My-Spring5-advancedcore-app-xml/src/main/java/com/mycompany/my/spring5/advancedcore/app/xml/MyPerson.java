/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.advancedcore.app.xml;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyPerson {

    private String name;
    private int age;
    
   
    public void init(){
        System.out.println("MyPerson.init()");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
