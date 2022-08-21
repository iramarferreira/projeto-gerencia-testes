package com.projeto.teste.ProjetoTestes.repository;

import com.projeto.teste.ProjetoTestes.model.Processo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessoRepository extends JpaRepository<Processo, Long> {
}
