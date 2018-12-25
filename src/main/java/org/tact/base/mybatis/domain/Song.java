package org.tact.base.mybatis.domain;

import java.io.Serializable;

public class Song implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String username;

	private String youtube_link;

	private String comments;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getYoutube_link() {
		return youtube_link;
	}

	public void setYoutube_link(String youtube_link) {
		this.youtube_link = youtube_link;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Song [id=" + id + ", username=" + username + ", youtube_link=" + youtube_link + ", comments=" + comments
				+ "]";
	}

}