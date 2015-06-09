package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestePacoteInternacional {
	
	private WebDriver firefoxDriver;
	
	@Before
	public void setUp(){
		firefoxDriver = new FirefoxDriver();
		firefoxDriver.get("http://globaltracktrace.ptc.post/gtt.web/Search.aspx");
	}
	
	@After
	public void tearDown(){
		firefoxDriver.quit();
	}
	
	@Test
	public void testCodigoPedidoInternacional(){
		buscarPacote("EB101768450BR");
		WebDriverWait loadWait =  new WebDriverWait(firefoxDriver, 40);
		
		loadWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"resultsPanel\"]/table[1]")));
		
		WebElement tabelaRastreamento = firefoxDriver.findElement(By.xpath("//*[@id=\"resultsPanel\"]/table[1]"));

		Assert.assertNotNull(tabelaRastreamento);
		
	}
	
	public void buscarPacote(String codigo) {
		WebElement caixaDeTexto = firefoxDriver.findElement(By.id("txtItemID"));
		caixaDeTexto.sendKeys(codigo);
		
		WebElement botaoEnviar = firefoxDriver.findElement(By.id("btnSearch"));
		botaoEnviar.click();
	}

}
