package com.multiTenantConfiguration.multiTenantConfiguration.Service;

import java.util.List;

import com.multiTenantConfiguration.multiTenantConfiguration.Dto.PatientDto;

/**
 * interface PatientService
 * 
 * @author dinesh
 * @created date 04/01
 * @description used to create the crud operations
 *
 */
public interface PatientService {
	
	/**
	 * function getAllPatientDetails
	 * 
	 * @param none
	 * @return Patient Details from Db
	 */
	public List<PatientDto> getAllPatientDetails();
	
	/**
	 * function getPatientById
	 * 
	 * @param patientid
	 * @return patient's Details of mentioned user id
	 */
	public PatientDto getPatientById(long patientid);
	
	/**
	 * function savePatient
	 * 
	 * @param myPatient
	 * @return saved Patient's Details from db
	 */
	public PatientDto savePatient(PatientDto myPatient);
	
	/**
	 * function deletePatient
	 * 
	 * @param Patientid
	 * @return none
	 */
	public void deletePatient(long Patientid);
	

}
