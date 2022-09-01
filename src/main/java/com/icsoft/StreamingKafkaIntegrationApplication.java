package com.icsoft;

import com.icsoft.service.ProduceConsumeService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StreamingKafkaIntegrationApplication {

   /* public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(StreamingKafkaIntegrationApplication.class);
        ProduceConsumeService produceConsumeService = applicationContext.getBean(ProduceConsumeService.class);
        produceConsumeService.executeJob();
    }*/

    public static void main(String[] args) {
        SpringApplication.run(StreamingKafkaIntegrationApplication.class, args);
    }

/*
    @Bean
    CommandLineRunner commandLineRunner(ProduceConsumeService service) {
        return args -> service.executeJob();
    }
*/

    @Bean
    ApplicationRunner applicationRunner(ProduceConsumeService service) {
        return args -> service.executeJob();
    }
}
