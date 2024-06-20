package com.cow.cow_mvc_practice.Image.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;

@Service
@Transactional
public class ImageUploadServiceImpl implements ImageUploadService {
	private final AmazonS3Client s3Client;

	@Autowired
	public ImageUploadServiceImpl(AmazonS3Client s3Client) {
		this.s3Client = s3Client;
	}

	@Value("${s3.bucket}")
	private String bucket;

	public String upload(MultipartFile image) throws IOException {
		String originalFileName = image.getOriginalFilename();
		String fileName = changeFileName(originalFileName);

		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentType(image.getContentType());
		metadata.setContentLength(image.getSize());

		s3Client.putObject(bucket, fileName, image.getInputStream(), metadata);

		return s3Client.getUrl(bucket, fileName).toString();
	}

	private String changeFileName(String originalFileName) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		return originalFileName + "_" + LocalDateTime.now().format(formatter);
	}
}
