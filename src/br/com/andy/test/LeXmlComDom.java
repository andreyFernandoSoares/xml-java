package br.com.andy.test;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import br.com.andy.modelo.Produto;

public class LeXmlComDom {

	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(true);
		factory.setNamespaceAware(true);
		factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
		
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/vendas.xml");
		NodeList formasDePagamento = document.getElementsByTagName("formaDePagamento");
		Element venda = document.getDocumentElement();
		String moeda = venda.getAttribute("moeda");
		System.out.println(moeda);
		
		String exp = "/venda/produtos/produto[contains(nome, 'Livro')]";
		XPath path = javax.xml.xpath.XPathFactory.newInstance().newXPath();
		XPathExpression expression = path.compile(exp);
		
		NodeList produtos = (NodeList) expression.evaluate(document, XPathConstants.NODESET);
		
		Element forma = (Element) formasDePagamento.item(0);
		String formaDePagamento = forma.getTextContent();
		System.out.println(formaDePagamento);
		
		for (int i = 0; i < produtos.getLength(); i++) {
			Element produto = (Element) produtos.item(i);
			Produto prod = new Produto(produto.getElementsByTagName("nome").item(0).getTextContent(), 
					Double.parseDouble(produto.getElementsByTagName("preco").item(0).getTextContent()));
			System.out.println(prod);
		}
	}
}
