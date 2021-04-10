package com.possenti.smart.utils

import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.model.CannedAccessControlList
import com.amazonaws.services.s3.model.PutObjectRequest
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile

@Component
class FileSaver (val amazonS3: AmazonS3) {

    companion object {
        const val BUCKET = "possenti-user"
    }

    fun write(file: MultipartFile) : String {
        amazonS3.putObject(
                PutObjectRequest(BUCKET, file.originalFilename, file.inputStream, null)
                        .withCannedAcl(CannedAccessControlList.PublicRead)
        )

        return amazonS3.getUrl(BUCKET, file.originalFilename).toExternalForm()
    }
}