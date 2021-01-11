package com.multiTenantConfiguration.multiTenantConfiguration.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multiTenantConfiguration.multiTenantConfiguration.Model.PatientDetails;

public interface PatientDetailsRepository extends JpaRepository<PatientDetails, Long> {

}
