package com.test.fs;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.URI;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;

@SpringBootApplication
@EnableSwagger2
public class App {

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }
  
  @Bean
  public FilterRegistrationBean registration(HiddenHttpMethodFilter filter) {
    FilterRegistrationBean registration = new FilterRegistrationBean(filter);
    registration.setEnabled(false);
    return registration;
  }


}
