package org.tact.base.mybatis.domain;

import java.io.Serializable;

public class Song implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String username;

	private String youtubelink;

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

	public String getYoutubelink() {
		return youtubelink;
	}

	public void setYoutubelink(String youtubelink) {
		this.youtubelink = youtubelink;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Song [id=" + id + ", username=" + username + ", youtubelink=" + youtubelink + ", comments=" + comments
				+ "]";
	}



}