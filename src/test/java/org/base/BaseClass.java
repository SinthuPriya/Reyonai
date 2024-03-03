package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.time.Duration;
import java.util.Properties;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	
	public WebDriver getDriver(String browserName) {
		switch(browserName) {
		case "Chrome":
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		break;
		
		case "FireFox":
	    WebDriverManager.firefoxdriver().setup();
	    driver = new FirefoxDriver();
	    break;
	    
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
			
		case "ie":
			
			WebDriverManager.iedriver().setup();
			driver= new InternetExplorerDriver();
			break;
			
			default:
				
				System.out.println("invalid browser");
				break;
			
				}
		return driver;
		
	}
	
	public byte[] screenshot() {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		byte[] b =screenshot.getScreenshotAs(OutputType.BYTES);
		return b;
		
	}
	
	public void elementclear(WebElement element) {
		element.clear();
	}
	
	public void maximize() {
		driver.manage().window().maximize();
	}
	
	public void implicitwait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	}
	
	public WebElement findElement(String id) {
		
		WebElement findElement = driver.findElement(By.id(id));
		return findElement;
		}
		public WebElement FindLocatorByName(String name) {
		
		WebElement findElement = driver.findElement(By.name(name));
		return findElement;
		}
	
	public WebElement FindLocatorByClassName(String Classname) {
		
		WebElement findElement = driver.findElement(By.className(Classname));
		return findElement;
		
	}
	
	public void clearText(WebElement e) {
		e.clear();
	}
   
	public void setTextJs(WebElement element, String data) {
		JavascriptExecutor executor =(JavascriptExecutor)driver;
		executor.executeScript("arguments[0].setAttribute.('value',"+data+")", element);
		
	}
	
	public void keyPress(int keycode) throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(keycode);
	}
	public void navigatetoUrl(String url) {
		driver.navigate().to(url);
		
	}
	
	public void refresh() {
		driver.navigate().refresh();
	}
	public void navigateForward() {
		driver.navigate().forward();
	}
	public void navigateBack() {
		
		driver.navigate().back();
		
	}
	
	public void mouseover(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}
	
	public void dragdrop(WebElement sourse, WebElement destination) {
		
		Actions actions = new Actions(driver);
		actions.dragAndDrop(sourse, destination);
	}
	
	public void RightClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}
	
	public void doubleClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element);
		
	}
	
	public void keyUpActions(WebElement element, CharSequence key) {
		
		Actions actions = new Actions(driver);
		actions.keyDown(element, key).perform();
		
		
	}
	
	public String printText(WebElement element) {
		
		String text = element.getText();
		
		return text;
		

	}
	public void loadurl(String url) {
		
		driver.get(url);
		
	}
	
	public void setText(WebElement e, String data) {
		elementclear(e);
		e.sendKeys(data);
	}
	public void btnclick(WebElement e) {
		e.click();
	}
	public void selectoptionByText(WebElement element, String text) {
		
		Select s= new Select(element);
		s.selectByVisibleText(text);
		
	}
	public void selectByAttribute(WebElement element, String Value) {
		Select s = new Select(element);
		s.selectByVisibleText(Value);
	}
	
	public void takesscreenshot(String imagename) throws IOException {
		TakesScreenshot takesscreenshot =(TakesScreenshot)driver;
		File source = takesscreenshot.getScreenshotAs(OutputType.FILE);
		File destination = new File("D:\\New folder"+imagename+".png");
		FileUtils.copyFile(source, destination);
			}
	public void simpleAlert() {
		driver.switchTo().alert().accept();
	}
	public void releaseKey(int keycode) throws AWTException {
		
		Robot robot = new Robot();
		robot.keyRelease(keycode);
		
	}
	
	public String getText(WebElement E) {
		String text = E.getText();
		return text;
	}
	
	public void selectByIndex(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
		
	}
	
	public String getAttributeValue(WebElement e, String Attribute) {
		String attribute = e.getAttribute(Attribute);
		return attribute;
	}
	
	

	}


