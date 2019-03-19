package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.net.*;
import java.io.*;
import java.nio.file.*;
import java.util.Base64;

@SpringBootApplication
@EnableScheduling
public class Main{
    /**
     * main function, handled by springboot
     * @param args application args
     */
    public static void main(String[] args){
        SpringApplication.run(Main.class, args);
    }
}