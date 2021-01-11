package com.multiTenantConfiguration.multiTenantConfiguration.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multiTenantConfiguration.multiTenantConfiguration.Dto.PatientDto;
import com.multiTenantConfiguration.multiTenantConfiguration.Service.PatientService;

/**
 * class PatientDetailsController
 * 
 * @author dinesh
 * @created date 04/11
 * @description used to map the end point url based on the http request
 */
@RestController
@RequestMapping("patients")
public class PatientDetailsController {
	
	/**
	 * patientService bean
	 */
	private final PatientService patientService;
	
	/**
	 * parameterized constructor
	 * 
	 * @param patientService
	 * @description used to add the dependencies
	 */
	@Autowired
	public PatientDetailsController(PatientService patientService) {
		this.patientService = patientService;
	}
	
	@GetMapping("")
	public List<PatientDto> getAllPatients() {
		return patientService.getAllPatientDetails();
	}
	
	@GetMapping("/{id}")
	public PatientDto getPatientById(@PathVariable Long id) {
		return patientService.getPatientById(id);
	}
	
	@PostMapping("")
	public PatientDto savePatient(@RequestBody PatientDto myPatient) {
		return patientService.savePatient(myPatient);
	}
	
	@DeleteMapping("/{id}")
	public void deletePatientById(@PathVariable Long id) {
		 patientService.deletePatient(id);
	}

}
