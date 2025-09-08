//package pages;
//
//import org.openqa.selenium.*;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.*;
//
//import java.time.Duration;
//
//
//public class KeralaTourPage {
//
//    WebDriver driver;
//    Actions actions;
//    WebDriverWait wait;
//    JavascriptExecutor js;
//
//    public KeralaTourPage(WebDriver driver) {
//        this.driver = driver;
//        this.actions = new Actions(driver);
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//    }
//
//    // Locators
//    By holidayMenu = By.xpath("//*[@id='navbarDropdown']");
//    By shortBreaksKerala = By.xpath("//*[@id='navbarSupportedContent']/ul[1]/li[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[3]");
//    By keralaQuickKochi = By.xpath("//*[@id='package_detail_PKG008988']/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/h2[1]/a[1]");
//    By viewDetails = By.xpath("//*[@id='package_detail_PKG008988']/div[1]/div[2]/div[3]/div[2]/a[1]");
//    By calculatePrice = By.xpath("//button[text() = 'Calculate Package Price']");
//    By calculatePriceTab = By.xpath("//a[@class='nav-link pdp_calculate_price active']");
//  
//    By tourTypeDropdown = By.xpath("//div[@class='selectric-wrapper selectric-flight_schedule_selecttourTypeClass selectric-tourTypeClass']");
//    By standardTourType = By.xpath("//div[@class='selectric-wrapper selectric-flight_schedule_selecttourTypeClass selectric-tourTypeClass']");
//
//
//    By adultPlusBtn = By.xpath("//button[@class='btn btn-default btn-number plus'][@data-field=\"adults\"]");
//    By adultMinusBtn = By.xpath("//*[@id=\"selectRoomTravellers\"]/div[1]/div[2]/div[1]/div[1]/button[1]");
//  
//    By adultValue = By.xpath("//*[@id=\"selectRoomTravellers\"]/div[1]/div[2]/div[1]/div[1]/input[1]");
//
//   // By adultInput = By.xpath("//*[@id='selectRoomTravellers']/div[1]/div[2]/div[1]/div[1]/button[2]/span[1]");
//    By travelDate = By.xpath("//input[@id='tavelDate']");
//    By contactMobile = By.xpath("//input[@id='userMobileNo']");
//    By contactEmail = By.xpath("//*[@id='userEmailId']");
//   // By privacyPolicyCheckbox = By.xpath("//*[@id='contactDetails']/div[2]/p[2]");
//    By privacyPolicyCheckbox = By.xpath("//input[@type='checkbox' and @id='termsCond'] | //input[@type='checkbox']");
//
//    By calculatePackagePriceButton = By.xpath("//button[@id='pre-continueBtn']");
//    
//    By payFullAmountCheckbox = By.xpath("//*[@id='select-amount']/div[1]/div[1]/label[1]");
//    By continueButton = By.xpath("//button[text() = 'Continue'][@id='emailVerify']");
//    By loginEmail = By.xpath("//button[@id='emailVerify']");
//    By continueGuest = By.xpath("//button[@id=\"login-continueGuest\"]");
//
//    // Traveller 1
//    By travellerTitle1 = By.xpath("//*[@id='room1_adultTitle1']");
//    By travellerFirstName1 = By.xpath("//*[@id='room1_adultFName1']");
//    By travellerLastName1 = By.xpath("//*[@id='room1_adultLName1']");
//    By travellerDOB1 = By.xpath("//*[@id='room1_adultDOB1']");
//    By travellerMeal1 = By.xpath("//*[@id='room1_adultMealSelect1']");
//
//    // Traveller 2
//    By travellerTitle2 = By.xpath("//*[@id='room1_adultTitle2']");
//    By travellerFirstName2 = By.xpath("//*[@id='room1_adultFName2']");
//    By travellerLastName2 = By.xpath("//*[@id='room1_adultLName2']");
//    By travellerDOB2 = By.xpath("//*[@id='room1_adultDOB2']");
//    By travellerMeal2 = By.xpath("//*[@id='room1_adultMealSelect2']");
//
//    // Address
//    By addressTitle = By.xpath("//*[@id='title']");
//    By addressFirstName = By.xpath("//*[@id='fName-address']");
//    By addressLastName = By.xpath("//*[@id='lName-address']");
//    By addressLine = By.xpath("//*[@id='preContent']/div[2]/div[2]/div[1]/div[5]/div[1]/div[2]/div[1]/div[4]/div[1]/div[3]/form[1]/div[2]/textarea[1]");
//    By stateDropdown = By.xpath("//*[@id='gstState']");
//    By cityInput = By.xpath("//*[@id='city']");
//    By citySelect = By.xpath("//*[@id='ui-id-5']");
//    By pincode = By.xpath("//*[@id='pincode-address']");
//    By addressEmail = By.xpath("//*[@id='email']");
//    By addressMobile = By.xpath("//*[@id='mobile-no']");
//    By travellerContinue = By.xpath("//*[@id='traveller-continueBtn']");
//
//    // Payment
//    By creditCardTab = By.xpath("//*[@id='creditcardtab']");
//    By cardNumber = By.xpath("//*[@id='cardNumbercc']");
//    By expMonth = By.xpath("//*[@id='dcdmonDivcc']/div[1]/div[3]/div[1]/ul[1]/li[4]");
//    By expYear = By.xpath("//*[@id='dcdyrDivcc']/div[1]/div[3]/div[1]/ul[1]/li[4]");
//    By cvv = By.xpath("//*[@id='cvvNumbercc']");
//    By cardName = By.xpath("//*[@id='ccNameOnCard']");
//    By termsCheckbox = By.xpath("//*[@id='terms']");
//    By payNowButton = By.xpath("//*[@id='nbpay']");
//    By paymentFailedMessage = By.xpath("//*[text()='Payment Failed! Please retry with another Payment Mode']");
//
//    // JavaScript scroll utility
//    private void scrollIntoView(By locator) {
//        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//    }
//
//    private void clickElement(By locator) {
//        scrollIntoView(locator);
//        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
//    }
//
//    private void sendKeys(By locator, String text) {
//        scrollIntoView(locator);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
//    }
//
//    private void selectDropdown(By locator, String value) {
//        scrollIntoView(locator);
//        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//        Select select = new Select(element);
//        select.selectByVisibleText(value);
//    }
//
//    // Methods
//
//    public void hoverOnHolidayMenu() {
//        WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(holidayMenu));
//        actions.moveToElement(menu).perform();
//        clickElement(shortBreaksKerala);
//    }
//
//    public void clickKeralaQuickKochi() {
//        // Wait for container
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='package_detail_PKG008988']")));
//        
//        // Scroll to element
//        WebElement quickKochi = driver.findElement(keralaQuickKochi);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", quickKochi);
//        
//        // Click using JS to avoid overlay issues
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", quickKochi);
//
//        // Wait and click View Details
//        WebElement view = wait.until(ExpectedConditions.elementToBeClickable(viewDetails));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", view);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", view);
//    }
//
//
//
//    // ✅ Step 1: Handle popup
//    public void handlePopupIfPresent() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        try {
//            WebElement popupCloseBtn = wait.until(ExpectedConditions.presenceOfElementLocated(
//                By.xpath("//*[@id=\"wantUsPopup\"]/div[1]/div[1]/button[1]")));
//            if (popupCloseBtn.isDisplayed()) {
//                popupCloseBtn.click();
//                System.out.println("Popup closed successfully.");
//            }
//        } catch (Exception e) {
//            System.out.println("No popup appeared, continuing...");
//        }
//    }
//
//
//    public void clickCalculatePrice() {
//        try {
//            // Switch to iframe if present (replace with actual locator)
//            WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(
//                By.xpath("//iframe[contains(@src,'packageDetails')]"))); // adjust XPath as needed
//            driver.switchTo().frame(iframe);
//
//            // Wait for the Calculate Price tab
//            WebElement calculateTab = wait.until(ExpectedConditions.elementToBeClickable(calculatePriceTab));
//
//            // Scroll and click using JS
//            js.executeScript("arguments[0].scrollIntoView(true);", calculateTab);
//            js.executeScript("arguments[0].click();", calculateTab);
//
//            // Switch back to main content
//            driver.switchTo().defaultContent();
//        } catch (Exception e) {
//            System.out.println("Error clicking Calculate Price tab: " + e.getMessage());
//        }
//    }
//    public void selectTourType(String tourType) {
//        try {
//            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(tourTypeDropdown));
//            js.executeScript("arguments[0].click();", dropdown); // open dropdown using JS
//
//            if (tourType.equalsIgnoreCase("Standard")) {
//                WebElement standardOption = wait.until(ExpectedConditions.elementToBeClickable(standardTourType));
//                js.executeScript("arguments[0].click();", standardOption); // click option using JS
//            }
//            // You can add more options here if needed
//        } catch (Exception e) {
//            System.out.println("Error selecting tour type: " + e.getMessage());
//        }
//    }
//    public void setAdultCount(int count) {
//        try {
//            WebElement adultInput = wait.until(ExpectedConditions.visibilityOfElementLocated(adultValue));
//            int current = Integer.parseInt(adultInput.getAttribute("value"));
//
//            while (current < count) {
//                WebElement plus = wait.until(ExpectedConditions.elementToBeClickable(adultPlusBtn));
//                js.executeScript("arguments[0].click();", plus);
//                current++;
//            }
//            while (current > count) {
//                WebElement minus = wait.until(ExpectedConditions.elementToBeClickable(adultMinusBtn));
//                js.executeScript("arguments[0].click();", minus);
//                current--;
//            }
//        } catch (Exception e) {
//            System.out.println("Error setting adult count: " + e.getMessage());
//        }
//    }
//
//
//
//
//
//
//    public void selectTravelDate(String date) {
//        try {
//            // Split date into day, month, year (format: dd-MM-yyyy)
//            String[] parts = date.split("-");
//            String day = parts[0];
//            int month = Integer.parseInt(parts[1]) - 1; // 0-indexed
//            String year = parts[2];
//
//            // Click date input to open calendar
//            WebElement dateInput = wait.until(ExpectedConditions.elementToBeClickable(travelDate));
//            js.executeScript("arguments[0].scrollIntoView(true);", dateInput);
//            js.executeScript("arguments[0].click();", dateInput);
//
//            // Wait for date picker to appear
//            WebElement datePicker = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-datepicker-div")));
//
//            // Select year if dropdown exists
//            try {
//                Select yearSelect = new Select(datePicker.findElement(By.className("ui-datepicker-year")));
//                yearSelect.selectByVisibleText(year);
//            } catch (Exception e) {
//                System.out.println("Year dropdown not found, skipping...");
//            }
//
//            // Select month if dropdown exists
//            try {
//                Select monthSelect = new Select(datePicker.findElement(By.className("ui-datepicker-month")));
//                monthSelect.selectByIndex(month);
//            } catch (Exception e) {
//                System.out.println("Month dropdown not found, skipping...");
//            }
//
//            // Click the day
//            WebElement dayElement = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//div[@id='ui-datepicker-div']//a[text()='" + day + "']")));
//            js.executeScript("arguments[0].click();", dayElement);
//
//        } catch (Exception e) {
//            System.out.println("Error selecting travel date: " + e.getMessage());
//        }
//    }
//
//   // By calculatePackagePriceButton = By.xpath("//button[contains(text(),'Calculate Package Price')]");
//
//    public void clickCalculatePackagePriceButton() {
//        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(calculatePackagePriceButton));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
//    }
//
//
//
//
//    public void fillContactDetails(String mobile, String email) {
//        // Wait for the form container to appear after Calculate Price
//        By formContainer = By.id("pkgData");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(formContainer));
//
//        WebElement container = driver.findElement(formContainer);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", container);
//
//        // Wait and fill Mobile
//        wait.until(ExpectedConditions.elementToBeClickable(contactMobile));
//        WebElement mob = driver.findElement(contactMobile);
//        mob.clear();
//        mob.sendKeys(mobile);
//
//        // Wait and fill Email
//        wait.until(ExpectedConditions.elementToBeClickable(contactEmail));
//        WebElement em = driver.findElement(contactEmail);
//        em.clear();
//        em.sendKeys(email);
//
//        // Wait and click Privacy Policy
//        wait.until(ExpectedConditions.elementToBeClickable(privacyPolicyCheckbox));
//        WebElement policy = driver.findElement(privacyPolicyCheckbox);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", policy);
//
//        // Wait and click Calculate Package Price
//        wait.until(ExpectedConditions.elementToBeClickable(calculatePrice));
//        WebElement calcBtn = driver.findElement(calculatePrice);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", calcBtn);
//
//        // Wait and click Pay Full Amount checkbox
//        wait.until(ExpectedConditions.elementToBeClickable(payFullAmountCheckbox));
//        WebElement payFull = driver.findElement(payFullAmountCheckbox);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", payFull);
//
//        // Wait and click Continue
//        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
//        WebElement contBtn = driver.findElement(continueButton);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", contBtn);
//    }
//
//
//
//    public void loginGuest(String email) {
//        sendKeys(loginEmail, email);
//        clickElement(continueGuest);
//    }
//
//    public void fillTraveller1(String title, String fName, String lName, String dob, String meal) {
//        selectDropdown(travellerTitle1, title);
//        sendKeys(travellerFirstName1, fName);
//        sendKeys(travellerLastName1, lName);
//        sendKeys(travellerDOB1, dob);
//        selectDropdown(travellerMeal1, meal);
//    }
//
//    public void fillTraveller2(String title, String fName, String lName, String dob, String meal) {
//        selectDropdown(travellerTitle2, title);
//        sendKeys(travellerFirstName2, fName);
//        sendKeys(travellerLastName2, lName);
//        sendKeys(travellerDOB2, dob);
//        selectDropdown(travellerMeal2, meal);
//    }
//
//    public void fillAddress(String title, String fName, String lName, String addr, String state, String city, String pincodeVal, String email, String mobile) {
//        selectDropdown(addressTitle, title);
//        sendKeys(addressFirstName, fName);
//        sendKeys(addressLastName, lName);
//        sendKeys(addressLine, addr);
//        selectDropdown(stateDropdown, state);
//        sendKeys(cityInput, city);
//        clickElement(citySelect);
//        sendKeys(pincode, pincodeVal);
//        sendKeys(addressEmail, email);
//        sendKeys(addressMobile, mobile);
//        clickElement(travellerContinue);
//    }
//
//    public void fillPayment(String cardNum, String expM, String expY, String cvvNum, String cardHolder) {
//        clickElement(creditCardTab);
//        sendKeys(cardNumber, cardNum);
//        clickElement(expMonth);
//        clickElement(expYear);
//        sendKeys(cvv, cvvNum);
//        sendKeys(cardName, cardHolder);
//        clickElement(termsCheckbox);
//        clickElement(payNowButton);
//    }
//
//    public boolean isPaymentFailedMessageDisplayed() {
//        try {
//            scrollIntoView(paymentFailedMessage);
//            return driver.findElement(paymentFailedMessage).isDisplayed();
//        } catch (Exception e) {
//            return false;
//        }
//    }
//}
//
package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import utils.ElementUtil;
import java.time.Duration;


public class KeralaTourPage {

    WebDriver driver;
    Actions actions;
    WebDriverWait wait;
    JavascriptExecutor js;
    private ElementUtil elementUtil;

    public KeralaTourPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Locators
    By holidayMenu = By.xpath("//*[@id='navbarDropdown']");
    By shortBreaksKerala = By.xpath("//*[@id='navbarSupportedContent']/ul[1]/li[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[3]");
    By keralaQuickKochi = By.xpath("//*[@id='package_detail_PKG008988']/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/h2[1]/a[1]");
    By viewDetails = By.xpath("//*[@id='package_detail_PKG008988']/div[1]/div[2]/div[3]/div[2]/a[1]");
  By calculatePriceTab=By.xpath("//a[@class='nav-link pdp_calculate_price active']");
    private By tourTypeDropdown = By.xpath("//select[@name='tourTypeClass']");
    private By adultPlusBtn = By.xpath("//button[@class='btn btn-default btn-number plus'][@data-field='adults']");
    private By adultValue = By.xpath("//input[@name='adults']");
    private By travelDate = By.id("tavelDate");

    private By contactMobile = By.id("userMobileNo");
    private By contactEmail = By.id("userEmailId");
    private By privacyPolicyCheckbox = By.id("termsCond");
    private By calculatePackagePriceButton = By.id("pre-continueBtn");
    private By payFullAmountCheckbox = By.xpath("//*[@id='select-amount']//label[1]");
    private By continueButton = By.id("emailVerify");
    private By continueGuest = By.id("login-continueGuest");

    // Traveller 1
    private By travellerTitle1 = By.id("room1_adultTitle1");
    private By travellerFirstName1 = By.id("room1_adultFName1");
    private By travellerLastName1 = By.id("room1_adultLName1");
    private By travellerDOB1 = By.xpath("(//input[contains(@class,'dob')])[1]");
    private By travellerMeal1 = By.id("room1_adultMealSelect1");

    // Traveller 2
    private By travellerTitle2 = By.id("room1_adultTitle2");
    private By travellerFirstName2 = By.id("room1_adultFName2");
    private By travellerLastName2 = By.id("room1_adultLName2");
    private By travellerDOB2 = By.xpath("(//input[contains(@class,'dob')])[2]");
    private By travellerMeal2 = By.id("room1_adultMealSelect2");

    // Address
    private By addressTitle = By.id("title");
    private By addressFirstName = By.id("fName-address");
    private By addressLastName = By.id("lName-address");
    private By addressLine = By.xpath("//textarea[@placeholder='Address' and contains(@class,'frm_textarea')]");
    private By stateDropdown = By.id("gstState");
    private By cityInput = By.id("city");
    private By citySelect = By.xpath("//ul[@id='ui-id-1']/li[1]");
    private By pincode = By.id("pincode-address");
    private By addressEmail = By.id("email");
    private By addressMobile = By.id("mobile-no");
    private By travellerContinue = By.id("traveller-continueBtn");

    // Payment
    private By creditCardTab = By.id("creditcardtab");
    private By cardNumber = By.id("cardNumbercc");
    private By expMonth = By.xpath("//*[@id='dcdmonDivcc']//li[4]");
    private By expYear = By.xpath("//*[@id='dcdyrDivcc']//li[4]");
    private By cvv = By.id("cvvNumbercc");
    private By cardName = By.id("ccNameOnCard");
    private By termsCheckbox = By.id("terms");
    private By payNowButton = By.id("nbpay");
    private By paymentFailedMessage = By.xpath("//*[text()='Payment Failed! Please retry with another Payment Mode']");

 // JavaScript scroll utility
 private void scrollIntoView(By locator) {
      WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
  }

  private void clickElement(By locator) {
      scrollIntoView(locator);
      wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
  }

  private void sendKeys(By locator, String text) {
      scrollIntoView(locator);
      wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
  }

  private void selectDropdown(By locator, String value) {
      scrollIntoView(locator);
      WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
      Select select = new Select(element);
      select.selectByVisibleText(value);
  }

  // Methods

  public void hoverOnHolidayMenu() {
      WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(holidayMenu));
      actions.moveToElement(menu).perform();
      clickElement(shortBreaksKerala);
     
  }

  public void clickKeralaQuickKochi() {
      // Wait for container
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='package_detail_PKG008988']")));
      
      // Scroll to element
      WebElement quickKochi = driver.findElement(keralaQuickKochi);
      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", quickKochi);
      
      // Click using JS to avoid overlay issues
      ((JavascriptExecutor) driver).executeScript("arguments[0].click();", quickKochi);

      // Wait and click View Details
      WebElement view = wait.until(ExpectedConditions.elementToBeClickable(viewDetails));
      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", view);
      ((JavascriptExecutor) driver).executeScript("arguments[0].click();", view);
  }



  // ✅ Step 1: Handle popup
  public void handlePopupIfPresent() {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
      try {
          WebElement popupCloseBtn = wait.until(ExpectedConditions.presenceOfElementLocated(
              By.xpath("//*[@id=\"wantUsPopup\"]/div[1]/div[1]/button[1]")));
          if (popupCloseBtn.isDisplayed()) {
              popupCloseBtn.click();
              System.out.println("Popup closed successfully.");
          }
      } catch (Exception e) {
          System.out.println("No popup appeared, continuing...");
      }
  }


  public void clickCalculatePrice() {
      try {
          // Switch to iframe if present (replace with actual locator)
          WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(
              By.xpath("//iframe[contains(@src,'packageDetails')]"))); // adjust XPath as needed
          driver.switchTo().frame(iframe);

          // Wait for the Calculate Price tab
          WebElement calculateTab = wait.until(ExpectedConditions.elementToBeClickable(calculatePriceTab));

          // Scroll and click using JS
          js.executeScript("arguments[0].scrollIntoView(true);", calculateTab);
          js.executeScript("arguments[0].click();", calculateTab);

          // Switch back to main content
          driver.switchTo().defaultContent();
      } catch (Exception e) {
          System.out.println("Error clicking Calculate Price tab: " + e.getMessage());
      }
  }
    public void selectTourType(String tourType) {
        elementUtil.selectByVisibleText(driver.findElement(tourTypeDropdown), tourType);
    }

    public void setAdultCount(int count) {
        WebElement adultInput = driver.findElement(adultValue);
        int current = Integer.parseInt(adultInput.getAttribute("value"));
        while (current < count) {
            elementUtil.click(driver.findElement(adultPlusBtn));
            current++;
        }
    }

    public void selectTravelDate(String date) {
        elementUtil.type(driver.findElement(travelDate), date);
    }

    public void fillContactDetails(String mobile, String email) {
        elementUtil.type(driver.findElement(contactMobile), mobile);
        elementUtil.type(driver.findElement(contactEmail), email);
        elementUtil.click(driver.findElement(privacyPolicyCheckbox));
        elementUtil.click(driver.findElement(calculatePackagePriceButton));
        elementUtil.click(driver.findElement(payFullAmountCheckbox));
        elementUtil.click(driver.findElement(continueButton));
    }

    public void continueAsGuest() {
        elementUtil.click(driver.findElement(continueGuest));
    }

    public void fillTraveller1(String title, String fName, String lName, String dob, String meal) {
        elementUtil.selectByVisibleText(driver.findElement(travellerTitle1), title);
        elementUtil.type(driver.findElement(travellerFirstName1), fName);
        elementUtil.type(driver.findElement(travellerLastName1), lName);
        elementUtil.type(driver.findElement(travellerDOB1), dob);
        elementUtil.selectByVisibleText(driver.findElement(travellerMeal1), meal);
    }

    public void fillTraveller2(String title, String fName, String lName, String dob, String meal) {
        elementUtil.selectByVisibleText(driver.findElement(travellerTitle2), title);
        elementUtil.type(driver.findElement(travellerFirstName2), fName);
        elementUtil.type(driver.findElement(travellerLastName2), lName);
        elementUtil.type(driver.findElement(travellerDOB2), dob);
        elementUtil.selectByVisibleText(driver.findElement(travellerMeal2), meal);
    }

    public void fillAddress(String title, String fName, String lName, String addr, String state, String city,
                            String pin, String email, String mobile) {
        elementUtil.selectByVisibleText(driver.findElement(addressTitle), title);
        elementUtil.type(driver.findElement(addressFirstName), fName);
        elementUtil.type(driver.findElement(addressLastName), lName);
        elementUtil.type(driver.findElement(addressLine), addr);
        elementUtil.selectByVisibleText(driver.findElement(stateDropdown), state);
        elementUtil.type(driver.findElement(cityInput), city);
        elementUtil.click(driver.findElement(citySelect));
        elementUtil.type(driver.findElement(pincode), pin);
        elementUtil.type(driver.findElement(addressEmail), email);
        elementUtil.type(driver.findElement(addressMobile), mobile);
        elementUtil.click(driver.findElement(travellerContinue));
    }

    public void fillPayment(String cardNum, String expM, String expY, String cvvNum, String holder) {
        elementUtil.click(driver.findElement(creditCardTab));
        elementUtil.type(driver.findElement(cardNumber), cardNum);
        elementUtil.click(driver.findElement(expMonth));
        elementUtil.click(driver.findElement(expYear));
        elementUtil.type(driver.findElement(cvv), cvvNum);
        elementUtil.type(driver.findElement(cardName), holder);
        elementUtil.click(driver.findElement(termsCheckbox));
        elementUtil.click(driver.findElement(payNowButton));
    }

    public boolean isPaymentFailedMessageDisplayed() {
        try {
            return driver.findElement(paymentFailedMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}

