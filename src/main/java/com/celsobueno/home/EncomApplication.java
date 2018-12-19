package com.celsobueno.home;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.celsobueno.home.domain.Categoria;
import com.celsobueno.home.domain.Produto;
import com.celsobueno.home.repository.CategoriaRepository;
import com.celsobueno.home.repository.ProdutoRepository;

@SpringBootApplication
public class EncomApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(EncomApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null,  "Informática");
		Categoria cat2 = new Categoria(null,  "Escritório");
		Categoria cat3 = new Categoria(null,  "Papelaria");	
		
		Produto p1 = new Produto( null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto( null, "Cartolina", 2.00);
		Produto p4 = new Produto(null, "Mouse", 80.00);
		Produto p5 = new Produto( null, "Clip", 2000.00);
		Produto p6= new Produto(null, "Grapo", 800.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p4));
		cat2.getProdutos().addAll(Arrays.asList( p2, p3, p5, p6));
		cat3.getProdutos().addAll(Arrays.asList(p3, p5, p6));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat3));
		p4.getCategorias().addAll(Arrays.asList(cat1));
		p5.getCategorias().addAll(Arrays.asList(cat3));
		p6.getCategorias().addAll(Arrays.asList(cat3));
		
		
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6));
		}	
	
}
