package com.demo.login;

public class Users {
  private long ID;
  private String PASS;

	public Users(long ID, String PASS ) {
	super();
	this.ID = ID;
	this.PASS = PASS;
}
public long getID() {
	return ID;
}
public String getPASS() {
	return PASS;
}
}
