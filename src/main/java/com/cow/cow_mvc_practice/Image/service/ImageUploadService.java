package com.cow.cow_mvc_practice.Image.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface ImageUploadService {
	String upload(MultipartFile image) throws IOException;
}
