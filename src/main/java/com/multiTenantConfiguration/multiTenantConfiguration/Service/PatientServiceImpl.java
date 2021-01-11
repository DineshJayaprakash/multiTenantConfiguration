package com.multiTenantConfiguration.multiTenantConfiguration.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiTenantConfiguration.multiTenantConfiguration.Core.ThreadLocalStorage;
import com.multiTenantConfiguration.multiTenantConfiguration.Dto.PatientDto;
import com.multiTenantConfiguration.multiTenantConfiguration.Model.PatientDetails;
import com.multiTenantConfiguration.multiTenantConfiguration.Repository.PatientDetailsRepository;

@Service
public class PatientServiceImpl implements PatientService {

	private final PatientDetailsRepository patientOps;
	
	private final ModelMapper modelMapper;
	
	@Autowired
	public PatientServiceImpl(PatientDetailsRepository patientOps, ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
		this.patientOps = patientOps;
	}
	
	@Override
	public List<PatientDto> getAllPatientDetails() {
		List<PatientDetails> myUsersList = patientOps.findAll();
		Type listType = new TypeToken<List<PatientDto>>(){}.getType();
		List<PatientDto> myPatientDto = modelMapper.map(myUsersList, listType);
		return myPatientDto;
	}

	@Override
	public PatientDto getPatientById(long patientid) {
		Optional<PatientDetails> myUser = patientOps.findById(patientid);
		PatientDto myPatientDto = modelMapper.map(myUser, PatientDto.class);
		return myPatientDto;
	}

	@Override
	public PatientDto savePatient(PatientDto myPatient) {
		PatientDetails MyPatient = modelMapper.map(myPatient, PatientDetails.class);
//		if(ThreadLocalStorage.getTenantName() == null) {
//			MyPatient.setTenatName("tenant1");
//			
//		}
//		else {
//			MyPatient.setTenatName(ThreadLocalStorage.getTenantName());
//		}
		PatientDetails resp = patientOps.save(MyPatient);
		PatientDto myPatientDto = modelMapper.map(resp, PatientDto.class);
        return myPatientDto;
	}

	@Override
	public void deletePatient(long Patientid) {
		patientOps.deleteById(Patientid);
	}

}
