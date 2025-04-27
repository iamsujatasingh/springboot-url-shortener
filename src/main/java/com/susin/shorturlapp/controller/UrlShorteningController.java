package com.susin.shorturlapp.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.susin.shorturlapp.model.UrlRecord;
import com.susin.shorturlapp.model.UrlRequest;
import com.susin.shorturlapp.service.UrlShortService;

@RestController
@RequestMapping("api")
public class UrlShorteningController {
	
	private UrlShortService urlShortService;
	
	public UrlShorteningController(UrlShortService urlShortService) {
		super();
		this.urlShortService = urlShortService;
	}

	/**
     * Create a short URL for the given long URL.
     * @param longUrl the original long URL
     * @return the shortened URL
     */
    @PostMapping("createShortUrl")
	public ResponseEntity<String>  createShortUrl(@RequestBody UrlRequest urlRequest){
		return new ResponseEntity<>(urlShortService.createShortUrl(urlRequest.getLongUrl()),HttpStatus.CREATED);
	
	}
    
    /**
     * Fetch and redirect to the long URL based on the provided short URL.
     * @param shortUrl the short URL key
     * @return HTTP 302 redirect to the long URL
     */
    @GetMapping("fetchLongUrl")
	public ResponseEntity<String>  fetchLongUrl(@RequestParam String shortUrl){
		Optional<UrlRecord> record =  urlShortService.fetchLongUrl(shortUrl);
		if (record.isPresent()) {
			HttpHeaders header = new HttpHeaders();
			header.setLocation(URI.create(record.get().getLongUrl()));
            return new ResponseEntity<>(header, HttpStatus.FOUND);
		}
		else {
            return ResponseEntity.notFound().build();
        }
	}
	
}
