package com.multiTenantConfiguration.multiTenantConfiguration.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * class PatientDetails
 * 
 * @author dinesh
 * @created date 04/01
 * @description used to create the database table
 *
 */
@Entity
@Table(name="patientdetails")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="patientid")
	private Long patientId;
	
	@Column(name="patientname")
	private String patientName;
	
	@Column(name="patientmobile")
	private String patientMobile;
	
	@Column(name="patientadress")
	private String patientAdress;
	
//	@Column(name="tenatname")
//	private String tenatName;

}
