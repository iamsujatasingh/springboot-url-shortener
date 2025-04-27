package com.susin.shorturlapp.model;

import jakarta.persistence.Column;

public class UrlRequest {
	@Column(length = 1000)
	private String longUrl;

	public String getLongUrl() {
		return longUrl;
	}

	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}
}
