package br.com.fiap.hospital.agendamentos.repositories;

import br.com.fiap.hospital.agendamentos.entities.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long> {

}
