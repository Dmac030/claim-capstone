package com.claim.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.claim.entity.Photo;
import com.claim.entity.Photographer;
import com.claim.repository.PhotoRepository;
import com.claim.repository.PhotographerRepository;

@CrossOrigin
@RestController
public class PhotoController {
	

		@Autowired
		private PhotographerRepository photographerRepository;

		@Autowired
		private PhotoRepository photoRepository;
		
		
		

		
		
		@PostMapping(value = "/photographer/upload/portfolio/{email}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	    public ResponseEntity uploadFile1(@RequestParam MultipartFile file, @PathVariable("email")String email) {
			Optional<Photographer> photodb=this.photographerRepository.findById(email);
			Photographer photographer = photodb.get();
			try {
				Photo photo= new Photo();
				photo.setPhotographer(photographer);
				photo.setPortfolioPhoto(file.getBytes());
				this.photoRepository.save(photo);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	        return new ResponseEntity<>( HttpStatus.OK);
	    }
		
		
		
		
		
		
		
		@RequestMapping(value="/photo/findAllByEmail",  
				produces= MediaType.APPLICATION_JSON_VALUE,
				method=RequestMethod.GET)
		public ResponseEntity<List<Photo>>findAll(String email) {
			
			List <Photo> photos = this.photoRepository.findByEmail(email);
			
			return new ResponseEntity<>(photos, HttpStatus.OK);
			
		}
		
		
		
		
		
		
		
		
		
		
		
	}		

