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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.claim.entity.Photographer;
import com.claim.entity.Photo;
import com.claim.repository.PhotographerRepository;
import com.claim.repository.PhotoRepository;
import com.claim.service.SendMail;

@CrossOrigin(origins= {"*"}, maxAge=4800, allowCredentials = "false")
@RestController
public class PhotographerController {

	@Autowired
	private PhotographerRepository photographerRepository;
	
	@Autowired
	private SendMail sendMail;
	

	@Autowired
	private PhotoRepository photoRepository;
	
	
	
	
	
	
	@RequestMapping(value="/photographer/findByName",  
			produces= MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.GET)	
	public ResponseEntity<List<Photographer>>findByName(String userName) {
		this.photographerRepository.findByName(userName);
		
		List <Photographer> photographer = this.photographerRepository.findByName(userName);
		//System.out.println("PHOTO=" + photographer.get(0).getFirstName());
		
		return new ResponseEntity<>(photographer, HttpStatus.OK);
		
	}


	@RequestMapping(value = "/photographer/save", 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.POST)
	public void submitPhotographerDetails(@RequestBody Photographer photographer) {
		this.photographerRepository.save(photographer);
		this.sendMail.send(photographer.getEmail(), "Welcome", "Thank you for joining, you are now ready to start displaying your work!");
		
	}
	
	

	@PostMapping(value="/photographer/login")
	public ResponseEntity<Photographer> login(@RequestBody Photographer p) {
		Photographer photographer= this.photographerRepository.login(p.getUserName(), p.getPassword());
		if(photographer==null) {
			return new ResponseEntity<>(photographer, HttpStatus.UNAUTHORIZED);
		}
			return new ResponseEntity<>(photographer, HttpStatus.OK);
	
				
		
	}
	
	@PostMapping(value = "/photographer/upload/profile/{email}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity uploadFile(@RequestParam MultipartFile file, @PathVariable("email")String email) {
		Optional<Photographer> photographerdb =this.photographerRepository.findById(email);
		Photographer photographer = photographerdb.get();
		try {
			photographer.setProfile(file.getBytes());
			this.photographerRepository.save(photographer);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
        return new ResponseEntity<>(photographer, HttpStatus.OK);
    }

	//@RequestParam String aboutMe, @PathVariable("email")String email)
	
	@RequestMapping(value = "/photographer/profile/update", 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.POST)
	@ResponseBody
	 public ResponseEntity<Photographer> submitPhotographerAboutMe(@RequestBody Photographer photographer) {
		System.out.println("ADDING ABOUT ME" + photographer.getEmail() + " >>>>" + photographer.getAboutMe());
		Optional<Photographer> photographerAbout =this.photographerRepository.findById(photographer.getEmail());
		Photographer photographer1 = photographerAbout.get();
		photographer1.setAboutMe(photographer.getAboutMe());
		System.out.println(photographer1.getEmail());
		System.out.println("+++++++++++++");
		this.photographerRepository.save(photographer1);
        return ResponseEntity.ok().build();
    }
	
	@RequestMapping(value="/photographer/findById", 
			produces= MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.GET)
	
	public ResponseEntity<Optional<Photographer>>findById(String email) {
		this.photographerRepository.findById(email);
		Optional <Photographer> photographer = this.photographerRepository.findById(email);
		return new ResponseEntity<>(photographer, HttpStatus.OK);
	}
	

	

	
	
}
