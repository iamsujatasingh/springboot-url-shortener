package com.susin.shorturlapp.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.susin.shorturlapp.model.UrlRecord;

@Repository
public interface UrlShortRepository  extends JpaRepository<UrlRecord, Integer>{

	Optional<UrlRecord> findByShortUrl(String shortUrl);
	
	

}
