package com.celsobueno.home.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.celsobueno.home.domain.Cliente;
import com.celsobueno.home.repository.ClienteRepository;
import com.celsobueno.home.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!!! Id: " + id + "Tipo: " + Cliente.class.getName()));
			
	}

}
