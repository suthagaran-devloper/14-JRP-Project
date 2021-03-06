package com.suthan.dto;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data 
@Entity
@Table(name="CONTACT_DTLS")
public class Contact implements Serializable  {

	@Id
	@Column(name="CONTACT_ID")
	@SequenceGenerator(name="cid_seq_gen",
			sequenceName="CONTACT_ID_SEQ",
			allocationSize=1
			)
	
	@GeneratedValue(
			generator="cid_seq_gen",
			strategy=GenerationType.SEQUENCE
			)
	private Integer contactId;
	
	@Column(name="CONTACT_NAME")
	private String  contactName;
	
	@Column(name="CONTACT_EMAIL")
	private String  contactEmail;
	
	@Column(name="CONTACT_NUMBER")
	private Long contactNumber;

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	
	
	
	
//	/**
//	 * 
//	 */
//	//private static final long serialVersionUID = 1L;
//
//
//	private Integer contactId;
//	
//	
//	private String  contactName;
//	
//	
//	private String  contactEmail;
//	
//	
//	private Long contactNumber;
//	
//	
//	private Date createDate;
//	
//	
//	private Date updateDate;

}
