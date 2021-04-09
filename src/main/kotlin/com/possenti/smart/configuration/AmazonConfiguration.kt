package com.possenti.smart.configuration

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import com.possenti.smart.configuration.Keys.ACCESS_KEY
import com.possenti.smart.configuration.Keys.REGION
import com.possenti.smart.configuration.Keys.SECRETKEY
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

object Keys {
    const val ACCESS_KEY = "<ACCESS_KEY>"
    const val SECRETKEY = "<SECRETKEY>"
    const val REGION = "<REGION>"
}

@Configuration
class AmazonConfiguration {

    @Bean
    fun basicAwsCredencials() = BasicAWSCredentials(ACCESS_KEY, SECRETKEY)

    @Bean
    fun amazonS3() = AmazonS3ClientBuilder
            .standard()
            .withRegion(REGION)
            .withCredentials(AWSStaticCredentialsProvider(basicAwsCredencials()))
            .build()



}