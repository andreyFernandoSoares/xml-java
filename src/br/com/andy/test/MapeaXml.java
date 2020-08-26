package br.com.andy.test;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import br.com.andy.modelo.Produto;
import br.com.andy.modelo.Venda;

public class MapeaXml {
	public static void main(String[] args) throws Exception {
		JAXBContext jaxbContext = JAXBContext.newInstance(Venda.class);
		xmlParaObjeto(jaxbContext);
		objetoParaXml(jaxbContext);
	}

	private static void objetoParaXml(JAXBContext jaxbContext) throws Exception {
		Marshaller marshaller = jaxbContext.createMarshaller();
		
		Venda venda = new Venda();
		venda.setFormaDePagamento("Crediario");
		
		List<Produto> produtos = new ArrayList<>();
		produtos.add(new Produto("Livro de Java", 59.99));
		produtos.add(new Produto("Livro de C#", 59.99));
		produtos.add(new Produto("Livro de Xml", 59.99));
		venda.setProdutos(produtos);
		
		StringWriter write = new StringWriter();
		marshaller.marshal(venda, write);
		
		System.out.println(write.toString());
	}

	private static void xmlParaObjeto(JAXBContext jaxbContext) throws Exception {
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		Venda venda = (Venda) unmarshaller.unmarshal(new File("src/vendas.xml"));
		System.out.println(venda);
	}
}
