package chapter6.beans;

import java.io.Serializable;
import java.util.Date;

public class UserComment implements Serializable {

	private int id;
	private String text;
	private int messageId;
	private int userId;
	private Date createdDate;
	private String name;
	private Date updatedDate;
	private String account;

	public int getId() {
    	return id;
    }
    public void setId(int id) {
    	this.id = id;
    }

    public int getMessageId() {
    	return messageId;
    }
    public void setMessageId(int messageId) {
    	this.messageId = messageId;
    }

    public int getUserId() {
    	return userId;
    }
    public void setUserId(int userId) {
    	this.userId = userId;
    }

    public String getText() {
    	return text;
    }
    public void setText(String text) {
    	this.text = text;
    }

    public String getName() {
    	return name;
    }

    public void setName(String name) {
    	this.name = name;
    }

    public Date getCreatedDate() {
    	return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
    	this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
    	return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
    	this.updatedDate = updatedDate;
    }

    public String getAccount() {
    	return account;
    }

    public void setAccount(String account) {
    	this.account = account;
    }
}