package com.projeto.teste.ProjetoTestes.service;

import com.projeto.teste.ProjetoTestes.model.Advogado;
import com.projeto.teste.ProjetoTestes.model.Processo;
import com.projeto.teste.ProjetoTestes.repository.AdvogadoRepository;
import com.projeto.teste.ProjetoTestes.repository.ProcessoRepository;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Log4j2
@Service
public class AdvogadoService {

    @Autowired
    AdvogadoRepository advogadoRepository;

    @Autowired
    ProcessoRepository processoRepository;

    public Advogado salvar(Advogado advogado){
        return advogadoRepository.save(advogado);
    }



    public List<Advogado> listarTodos(){
        return advogadoRepository.findAll();
    }

    public Advogado buscarPeloId(Long id){
        if(advogadoRepository.findById(id).isPresent()) {
            return advogadoRepository.findById(id).get();
        }else{
            return null;
        }

    }

    public Advogado vincularProcesso(Advogado advogado, Processo processo){



        advogado.getProcessos().add(processo);

        return advogadoRepository.save(advogado);
    }

    public Advogado atualizar(Long id, Advogado advogado){
        if(advogadoRepository.findById(id).isPresent()){
            return advogadoRepository.save(advogado);

        }else{
            return null;
        }

    }

    public boolean deletarPeloId(Long id){
        if(advogadoRepository.findById(id).isPresent()){
            advogadoRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}