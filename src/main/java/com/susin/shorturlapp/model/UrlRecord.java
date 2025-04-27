package com.susin.shorturlapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UrlRecord{
		@Id
		private Integer id;
		private String shortUrl;
		@Column(length = 1000)
		private String longUrl;
		
		public UrlRecord() {
			
		}
		public UrlRecord(Integer id, String shortUrl, String longUrl) {
			super();
			this.id = id;
			this.shortUrl = shortUrl;
			this.longUrl = longUrl;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getShortUrl() {
			return shortUrl;
		}
		public void setShortUrl(String shortUrl) {
			this.shortUrl = shortUrl;
		}
		public String getLongUrl() {
			return longUrl;
		}
		public void setLongUrl(String longUrl) {
			this.longUrl = longUrl;
		}
		@Override
		public String toString() {
			return "UrlRecord [id=" + id + ", shortUrl=" + shortUrl + ", longUrl=" + longUrl + "]";
		}
	
	
	

}