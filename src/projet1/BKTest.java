package projet1;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BKTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mcassin\\Downloads\\chromedriver.exe");
		
		int codes = ' ';
		String reference = " ";
		String date = " ";
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Combien de tickets il faut remplir?");
		codes = sc.nextInt();
		// Partie demandant une saisie utilisateur commentée pour forcer le code restaurant du Burger King d'Alesia
		//System.out.println("Quelle est la référence du restaurant BK?");
		//reference = sc.next();
		reference = "20749";
		do{
			System.out.println("Quelle est la date sur le(s) ticket? (format dd/mm)");
		    sc.nextLine();
		    date = sc.next();
		  }while(!(date.matches("\\d{2}/\\d{2}")));
		
		for(int i = 0; i < codes; ++i) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.bkvousecoute.fr/");
		Thread.sleep(500);
		
		WebElement nextButton = driver.findElement(By.id("NextButton"));
		nextButton.click();
		Thread.sleep(500);
		
		WebElement referenceCode = driver.findElement(By.id("SurveyCode"));
		referenceCode.sendKeys(reference);
		WebElement visitDay = driver.findElement(By.id("InputDay"));
		Select dropdownDay = new Select(visitDay);
		WebElement visitMonth = driver.findElement(By.id("InputMonth"));
		Select dropdownMonth = new Select(visitMonth);
		dropdownDay.selectByValue(date.substring(0, 2));
		dropdownMonth.selectByValue(date.substring(3));
		WebElement visitHour = driver.findElement(By.id("InputHour"));
		Select dropdownHour = new Select(visitHour);
		dropdownHour.selectByValue("12");
		WebElement visitMinute = driver.findElement(By.id("InputMinute"));
		Select dropdownMinute = new Select(visitMinute);
		dropdownMinute.selectByValue("30");
		
		try {
		while(true) {
			driver.findElement(By.id("NextButton")).click();
			if (!(driver.findElement(By.id("NextButton")).isDisplayed())) break;
        } } catch (NoSuchElementException e) {
		WebElement validationCode = driver.findElement(By.className("ValCode"));
		String validationPhrase = validationCode.getText();
		System.out.println(validationPhrase);
        }
		}
	}

}
