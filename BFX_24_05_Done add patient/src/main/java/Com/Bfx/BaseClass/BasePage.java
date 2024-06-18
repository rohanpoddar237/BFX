package Com.Bfx.BaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends Baseclass{

	// to read json data file
	public static String LoginPgTestDataPath = "src\\test\\resources\\TestData\\Loginpage\\LoginPage.json";
	public static String PatientPgTestDataPath = "src\\test\\resources\\TestData\\Patients\\Patient.json";
	public static String PackagePgTestDataPath = "src\\test\\resources\\TestData\\Packages\\Package.json";
	

	// WebDriver driver;
	public static WebDriver driver;

	Baseclass baseclassobj=new Baseclass();
	
	// main driver
	public BasePage() {
		this.driver = baseclassobj.driver;
		PageFactory.initElements(driver, this);
	}

	//// Calendar method

	public static void calendar(String calendarIconIndex, String year, String date) throws InterruptedException {
		driver.findElement(By.xpath(
				"(//button[@type=\"button\" and starts-with(@aria-label,'Choose date')])[" + calendarIconIndex + "]"))
				.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[contains(@aria-label,\"switch to\")]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()=" + year + "]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()=" + date + "]")).click();
		Thread.sleep(500);
	}

	public static void calendarWithDay(String calendarIconIndex, int year, String date, int month)
			throws InterruptedException {
		int selectYear = year - 1;
		driver.findElement(By.xpath(
				"(//button[@type=\"button\" and starts-with(@aria-label,'Choose date')])[" + calendarIconIndex + "]"))
				.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[contains(@aria-label,\"switch to\")]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()=" + selectYear + "]")).click();
		Thread.sleep(500);
		String actualMonth = driver.findElement(By.xpath("(//div[@aria-live=\"polite\"])[1]")).getText();

		if (actualMonth.equals("January")) {
			for (int i = 1; i < 12; i++) {
				Thread.sleep(100);
				driver.findElement(By.xpath("//button[@title=\"Next month\"]")).click();
			}
		} else if (actualMonth.equals("February")) {
			for (int i = 1; i < 11; i++) {
				Thread.sleep(100);
				driver.findElement(By.xpath("//button[@title=\"Next month\"]")).click();
			}
		}

		else if (actualMonth.equals("March")) {
			for (int i = 1; i < 10; i++) {
				Thread.sleep(100);
				driver.findElement(By.xpath("//button[@title=\"Next month\"]")).click();
			}
		}

		else if (actualMonth.equals("April")) {
			for (int i = 1; i < 9; i++) {
				Thread.sleep(100);
				driver.findElement(By.xpath("//button[@title=\"Next month\"]")).click();
			}
		}

		else if (actualMonth.equals("May")) {
			for (int i = 1; i < 8; i++) {
				Thread.sleep(100);
				driver.findElement(By.xpath("//button[@title=\"Next month\"]")).click();
			}
		}

		else if (actualMonth.equals("June")) {
			for (int i = 1; i < 7; i++) {
				Thread.sleep(100);
				driver.findElement(By.xpath("//button[@title=\"Next month\"]")).click();
			}
		}

		else if (actualMonth.equals("July")) {
			for (int i = 1; i < 6; i++) {
				Thread.sleep(100);
				driver.findElement(By.xpath("//button[@title=\"Next month\"]")).click();
			}
		} else if (actualMonth.equals("August")) {
			for (int i = 1; i < 5; i++) {
				Thread.sleep(100);
				driver.findElement(By.xpath("//button[@title=\"Next month\"]")).click();
			}
		} else if (actualMonth.equals("September")) {
			for (int i = 1; i < 4; i++) {
				Thread.sleep(100);
				driver.findElement(By.xpath("//button[@title=\"Next month\"]")).click();
			}
		} else if (actualMonth.equals("October")) {
			for (int i = 1; i < 3; i++) {
				Thread.sleep(100);
				driver.findElement(By.xpath("//button[@title=\"Next month\"]")).click();
			}
		} else if (actualMonth.equals("November")) {
			for (int i = 1; i < 2; i++) {
				Thread.sleep(100);
				driver.findElement(By.xpath("//button[@title=\"Next month\"]")).click();
			}
		} else if (actualMonth.equals("December")) {
			for (int i = 1; i < 1; i++) {
				Thread.sleep(100);
				driver.findElement(By.xpath("//button[@title=\"Next month\"]")).click();
			}
		}

		for (int i = 1; i <= month; i++) {
			Thread.sleep(100);
			driver.findElement(By.xpath("//button[@title=\"Next month\"]")).click();
		}
		Thread.sleep(100);
		driver.findElement(By.xpath("//button[text()=" + date + "]")).click();
		Thread.sleep(500);
	}

	public static void DateAndYearSelectWithPreviousMonth(String calendarIconIndex, String year, String date)
			throws InterruptedException {
		driver.findElement(By.xpath(
				"(//button[@type=\"button\" and starts-with(@aria-label,'Choose date')])[" + calendarIconIndex + "]"))
				.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[contains(@aria-label,\"switch to\")]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()=" + year + "]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@data-testid=\"ArrowLeftIcon\"]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()=" + date + "]")).click();
		Thread.sleep(500);
	}

	public static void calendarWithMonthSelect(String calendarIconIndex, String year, String month, String date)
			throws InterruptedException {
		driver.findElement(By.xpath(
				"(//button[@type=\"button\" and starts-with(@aria-label,'Choose date')])[" + calendarIconIndex + "]"))
				.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[contains(@aria-label,\"switch to\")]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()=" + year + "]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()=" + "'" + month + "'" + "]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()=" + date + "]")).click();
	}

	public static void calendarWithYearAndMonthSelect(String calendarIconIndex, String year, String month)
			throws InterruptedException {
		driver.findElement(By.xpath(
				"(//button[@type=\"button\" and starts-with(@aria-label,'Choose date')])[" + calendarIconIndex + "]"))
				.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()=" + year + "]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()=" + "'" + month + "'" + "]")).click();
	}

	public static void calendarWithYearAndMonthSelect1(String calendarIconIndex, String year, String month)
			throws InterruptedException {
		driver.findElement(By.xpath(
				"(//button[@type=\"button\" and starts-with(@aria-label,'Choose date')])[" + calendarIconIndex + "]"))
				.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()=" + year + "]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()=" + "'" + month + "'" + "]")).click();
	}

}
