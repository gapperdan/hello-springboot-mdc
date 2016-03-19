package com.gapperdan.hsbmdc.bo;

public class Greeting {

	public Greeting(long id, String content, int points) {
		this.id = id;
		this.content = content;
		this.points = points;
	}

	private long id;
	private String content;
	private int points;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "{id:" + this.id + ",content:" + this.content + ",points:" + this.points +"}";
	}
}