package com.susin.shorturlapp.service;

import java.util.Optional;
import java.util.random.RandomGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.susin.shorturlapp.dao.UrlShortRepository;
import com.susin.shorturlapp.model.UrlRecord;

@Service
public class UrlShortService {
	UrlShortRepository urlShortRepository;

	public UrlShortService(UrlShortRepository urlShortRepository) {
		super();
		this.urlShortRepository = urlShortRepository;
	}

	public String createShortUrl(String longUrl) {
		RandomGenerator rn = RandomGenerator.getDefault();
		StringBuilder sb = new StringBuilder(7);
		for(int  i =0; i<7; i++) {
			int index = rn.nextInt(longUrl.length());
			sb.append(longUrl.charAt(index));
		}
		
		UrlRecord urlRecord = new UrlRecord(1,sb.toString(),longUrl);
		urlShortRepository.save(urlRecord)	;			
		return sb.toString();	
		
	}

	public Optional<UrlRecord> fetchLongUrl(String shortUrl) {
		return urlShortRepository.findByShortUrl(shortUrl);
		
	}

	
}

