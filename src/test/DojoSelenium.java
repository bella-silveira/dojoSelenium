package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DojoSelenium 
{
	private WebDriver firefoxDriver;
	
	@Before
	public void setUp(){
		firefoxDriver = new FirefoxDriver();
		firefoxDriver.get("http://www2.correios.com.br/sistemas/rastreamento/default.cfm");
	}
	
	@After
	public void tearDown(){
		firefoxDriver.quit();
	}
	
	@Test
	public void testeCodigoInvalido()
	{
		buscarPacote("huehue");
		
		WebElement content = firefoxDriver.findElement(By.className("content"));
		String textoEsperado = content.getText();
		Assert.assertTrue(textoEsperado.contains("Não é possível"));
	
	}

	@Test
	public void testeCodigoDePacoteEntregue()
	{
		buscarPacote("JH251237806BR");
		
		WebElement content = firefoxDriver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[2]/strong"));
		String textoEsperado = content.getText();
		Assert.assertTrue(textoEsperado.contains("Objeto entregue ao destinatário"));
	
	}
	
	
	
	public void buscarPacote(String codigo) {
		WebElement caixaDeTexto = firefoxDriver.findElement(By.id("objetos"));
		caixaDeTexto.sendKeys(codigo);
		
		WebElement botaoEnviar = firefoxDriver.findElement(By.id("btnPesq"));
		botaoEnviar.click();
	}
	
	
}
