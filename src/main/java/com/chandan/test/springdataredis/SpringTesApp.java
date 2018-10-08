package com.chandan.test.springdataredis;

import com.chandan.test.springdataredis.dao.StudentRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by chandan on 6/4/18.
 */
public class SpringTesApp {
   public static void main(String[] args) {
      ApplicationContext context = new FileSystemXmlApplicationContext("application-context.xml");
      //StudentRepository studentRepository = (StudentRepository)context.getBean("studentRepository");
      System.out.println("Context Loaded");
   }
}