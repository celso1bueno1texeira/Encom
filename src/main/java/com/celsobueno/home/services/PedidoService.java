package com.celsobueno.home.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.celsobueno.home.domain.Pedido;
import com.celsobueno.home.repository.PedidoRepository;
import com.celsobueno.home.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!!! Id: " + id + "Tipo: " + Pedido.class.getName()));
		
		
		
		
		
	}

}
