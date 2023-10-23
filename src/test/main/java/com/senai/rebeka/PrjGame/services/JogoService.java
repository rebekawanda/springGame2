package com.senai.rebeka.PrjGame.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.senai.rebeka.PrjGame.entities.Jogo;
import com.senai.rebeka.PrjGame.repositories.JogoRepository;
import java.util.Optional;

@Service
public class JogoService {
	private final JogoRepository jogoRepository;

	public JogoService(JogoRepository jogoRepository) {
		this.jogoRepository = jogoRepository;
	}
	//preparando as buscas por id
			public Jogo getJogoById(Long id) {
				return jogoRepository.findById(id).orElse(null);
			}
			//preparando a busca geral	
			public  List<Jogo> getAllJogos(){
				return jogoRepository.findAll();
			}
			//salvando o Jogo	
			public Jogo saveJogo(Jogo jogo) {
				return jogoRepository.save(jogo);		
			}
			//excluindo o Jogo	
			public void deleteJogo(Long id){
				jogoRepository.deleteById(id);	
			}	
			// fazendo o update do jogo com o optional
			public Jogo updateJogo(Long id, Jogo novoJogo) {
		        Optional<Jogo> jogoOptional = jogoRepository.findById(id);
		        if (jogoOptional.isPresent()) {
		        	Jogo jogoExistente = jogoOptional.get();
		           	jogoExistente.setName(novoJogo.getName());
		        	jogoExistente.setPlataform(novoJogo.getPlataform());          
		            return jogoRepository.save(jogoExistente); 
		        } else {
		            return null; 
		        }
		    }

}
