package org.erp.gescom.domain;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Authority")
public class Authority implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@Size(max = 50)
	@Id
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o){
			return true;
		}
		if(o == null || getClass() != o.getClass()){
			return false;
		}
		
		Authority authority = (Authority) o;
		return !(name != null ? !name.equals(authority.name) : authority.name != null);
	}
	
	 @Override
	    public int hashCode() {
	        return name != null ? name.hashCode() : 0;
	    }

	    @Override
	    public String toString() {
	        return "Authority{" +
	            "name='" + name + '\'' +
	            "}";
	    }
	
	
	

}
