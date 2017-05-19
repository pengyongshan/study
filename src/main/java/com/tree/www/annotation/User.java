package com.tree.www.annotation;

import java.io.Serializable;

@Persistent(table = "t_user")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4331612517935459931L;

	@Id(column = "user_id", type = "integer", generator = "identity")
	private int id;

	@Property(column = "password", type = "string")
	private String password;

	@Property(column = "user_name", type = "string")
	private String username;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
