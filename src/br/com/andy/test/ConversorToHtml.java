package br.com.andy.test;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class ConversorToHtml {
	public static void main(String[] args) throws Exception {
		InputStream xsl = new FileInputStream("src/xmlToHtml.xsl");
		StreamSource xslSource = new StreamSource(xsl);
		
		InputStream dados = new FileInputStream("src/vendas.xml");
		StreamSource dadosSrc = new StreamSource(dados);
		
		Transformer transformer = TransformerFactory.newInstance().newTransformer(xslSource);
		StreamResult saida = new StreamResult("src/vendas.html");
		transformer.transform(dadosSrc, saida);
		
		System.out.println("Conversao Concluida");
	}
}
