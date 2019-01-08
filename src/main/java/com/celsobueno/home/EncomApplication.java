package com.celsobueno.home;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.celsobueno.home.domain.Categoria;
import com.celsobueno.home.domain.Cidade;
import com.celsobueno.home.domain.Estado;
import com.celsobueno.home.domain.Produto;
import com.celsobueno.home.repository.CategoriaRepository;
import com.celsobueno.home.repository.CidadeRepository;
import com.celsobueno.home.repository.EstadoRepository;
import com.celsobueno.home.repository.ProdutoRepository;

@SpringBootApplication
public class EncomApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;

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
		
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		Estado est3 = new Estado(null, "Mato Grosso do Sul");
		Estado est4 = new Estado(null, "Parana");
		Estado est5 = new Estado(null, "Santa Catarina");
		
		Cidade cd1 = new Cidade(null, "Uberlandia", Estado.getId(est1));
		Cidade cd2 = new Cidade(null,  "Belo Horizonte", est1);
		Cidade cd3  = new Cidade(null, "Montes Claros", est1);
		Cidade cd4 = new Cidade(null, "Campo Grande", est3);
		Cidade cd5 = new Cidade(null, "Dorados", est3);
		Cidade cd6 = new Cidade(null, "Cambará", est4);
		Cidade cd7 = new Cidade(null, "Londrina", est1);
		Cidade cd8 = new Cidade(null, "Blumenau", est5);
		Cidade cd9= new Cidade(null, "São Paulo", est2);
		Cidade cd10 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll	(Arrays.asList(cd1, cd2, cd3));	
		est2.getCidades().addAll	(Arrays.asList(cd9, cd10));	
		est3.getCidades().addAll	(Arrays.asList(cd4, cd5));	
		est4.getCidades().addAll	(Arrays.asList(cd6, cd7));
		est5.getCidades().addAll	(Arrays.asList(cd8));	
		
		estadoRepository.saveAll(Arrays.asList(est1, est2, est3, est4 ,est5));
		cidadeRepository.saveAll(Arrays.asList(cd1, cd2, cd3, cd4 ,cd5, cd6 ,cd7,cd8 ,cd9, cd10));
		}	
	
}
