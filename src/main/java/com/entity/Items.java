package com.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Items ")
public class Items  implements Serializable { 
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Items_id")
    private int Items_id;  

	public int getItems_id() {
		return Items_id;
	}

	public void setItems_id(int items_id) {
		Items_id = items_id;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="Items_name")
        private String Items_name;
	
	public String getItems_name() {
		return Items_name;
	}

	public void setItems_name(String items_name) {
		Items_name = items_name;
	}

	@Column(name="Items_no")	
	private String email;
	
}  
