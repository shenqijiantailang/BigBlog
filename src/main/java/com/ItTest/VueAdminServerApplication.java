package com.ItTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class VueAdminServerApplication
{
    public static void main( String[] args )
    {
        double a = -0.5;
//        float b =  -0.5;
        SpringApplication.run(VueAdminServerApplication.class,args);
        System.out.println(Math.ceil(a));
        System.out.println(Math.ceil(new Float(-0.5)));
    }
}
