package com.possenti.smart.configuration

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.regions.Regions
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AmazonConfiguration {

    companion object {
        const val ACCESS_KEY = "<KEY>"
        const val SECRET_KEY = "<SECRET>"
    }

    @Bean
    fun basicAwsCredencials() = BasicAWSCredentials(ACCESS_KEY, SECRET_KEY)

    @Bean
    fun amazonS3() = AmazonS3ClientBuilder
            .standard()
            .withRegion(Regions.SA_EAST_1)
            .withCredentials(AWSStaticCredentialsProvider(basicAwsCredencials()))
            .build()



}