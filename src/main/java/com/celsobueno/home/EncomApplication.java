package com.celsobueno.home;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.celsobueno.home.domain.Categoria;
import com.celsobueno.home.domain.Cidade;
import com.celsobueno.home.domain.Cliente;
import com.celsobueno.home.domain.Endereco;
import com.celsobueno.home.domain.Estado;
import com.celsobueno.home.domain.Pagamento;
import com.celsobueno.home.domain.PagamentoComBoleto;
import com.celsobueno.home.domain.PagamentoComCartao;
import com.celsobueno.home.domain.Pedido;
import com.celsobueno.home.domain.Produto;
import com.celsobueno.home.domain.enums.EstadoPagamento;
import com.celsobueno.home.domain.enums.TipoCliente;
import com.celsobueno.home.repository.CategoriaRepository;
import com.celsobueno.home.repository.CidadeRepository;
import com.celsobueno.home.repository.ClienteRepository;
import com.celsobueno.home.repository.EnderecoRepository;
import com.celsobueno.home.repository.EstadoRepository;
import com.celsobueno.home.repository.PagamentoRepository;
import com.celsobueno.home.repository.PedidoRepository;
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
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PagamentoRepository pagamentoRepository;
	
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
		Estado est4 = new Estado(null, "Párana");
		Estado est5 = new Estado(null, "Santa Catarina");
		
		Cidade cd1 = new Cidade(null, "Uberlândia", est1);
		Cidade cd2 = new Cidade(null,  "Belo Horizonte", est1);
		Cidade cd3  = new Cidade(null, "Montes Claros", est1);
		Cidade cd4 = new Cidade(null, "Campo Grande", est3);
		Cidade cd5 = new Cidade(null, "Dourados", est3);
		Cidade cd6 = new Cidade(null, "Cambará", est4);
		Cidade cd7 = new Cidade(null, "Londrina", est4);
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
		
		Cliente cli1= new Cliente(null, "Maria Silva", "maria@gmail.com", "999999999-99", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("67996882111" , "6733505050"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "79083590", cli1, cd1);
		Endereco e2= new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, cd2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"),  cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 10:32"),  cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);

		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedido().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		

		
		}	
	
}
