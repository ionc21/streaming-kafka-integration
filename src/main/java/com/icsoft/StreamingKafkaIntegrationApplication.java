package com.icsoft;

import com.icsoft.service.ProduceConsumeService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class StreamingKafkaIntegrationApplication {

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(StreamingKafkaIntegrationApplication.class);
        ProduceConsumeService produceConsumeService = applicationContext.getBean(ProduceConsumeService.class);
        produceConsumeService.executeJob();
    }
}
