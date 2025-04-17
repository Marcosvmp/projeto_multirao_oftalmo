package com.multirao.oftalmo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multirao.oftalmo.models.Consultation;

public interface ConsultationRepository extends JpaRepository<Consultation,Long > {

}
