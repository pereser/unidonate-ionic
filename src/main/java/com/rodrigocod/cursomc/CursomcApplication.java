package com.rodrigocod.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rodrigocod.cursomc.domain.Categoria;
import com.rodrigocod.cursomc.domain.Produto;
import com.rodrigocod.cursomc.repositories.CategoriaRepository;
import com.rodrigocod.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Alimentos");
		Categoria cat2 = new Categoria(null, "Bebidas");
		
		Produto p1 = new Produto(null, "Feijao", 2.00);
		Produto p2 = new Produto(null, "Arroz", 8.00);
		Produto p3 = new Produto(null, "Tomate", 1.20);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2 ,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
	}

}
