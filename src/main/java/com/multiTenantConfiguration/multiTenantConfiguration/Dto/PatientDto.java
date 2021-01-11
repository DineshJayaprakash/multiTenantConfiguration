package com.multiTenantConfiguration.multiTenantConfiguration.Dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * class CustomerDto
 * 
 * @author dinesh
 * @description customer dto to restrict the datas visibility to end users
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {
	
    /**
     * id of the patient
     */
	private Long patientId;
	
	/**
	 * name of the patient
	 */
	private String patientName;
	
	/**
	 * mobile of the patient
	 */
	private String patientMobile;
	
	/**
	 * adress of the patient
	 */
	private String patientAdress;
	
//	/**
//	 * tenent of data
//	 */
//	private String tenatName;

}
