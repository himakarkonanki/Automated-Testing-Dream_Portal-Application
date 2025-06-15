---

# 🚀 Dream Portal Selenium Automation using Java

This repository contains an Automation Testing framework built with **Selenium WebDriver** using **Java**, following best practices like **Page Object Model (POM)**. It integrates **TestNG** for test execution and report generation, **Log4j2** for structured logging, and **ExtentReports** for detailed HTML reporting.

---

## 📦 Dependencies

* **Selenium WebDriver** – For browser automation
* **TestNG** – For test annotations, execution, and reporting
* **Log4j2** – For logging application behavior
* **Apache Commons IO** – For file handling (e.g., screenshot saving)
* **ExtentReports (AventStack)** – For generating rich, interactive test reports

---

## 🧩 Project Structure

```
DreamPortalAutomation/
├── reports/                   # Auto-generated ExtentReports (.html)
├── screenshots/               # Captured screenshots
├── src/
│   ├── main/
│   │   └── resources/
│   │       └── log4j2.properties
│   └── test/
│       └── java/
│           ├── utils/
│           │   ├── Base.java
│           │   ├── WebDriverHelper.java
│           │   ├── LoggerHandler.java
│           │   ├── Report.java
│           │   └── ScreenshotUtil.java
│           │
│           ├── locators/
│           │   └── *.java
│           │
│           ├── pages/
│           │   ├── DreamPortalHomePage.java
│           │   ├── DreamsDiaryPage.java
│           │   └── DreamTotalPage.java
│           │
│           └── runner/
│               └── TestRunner.java
│
├── testng.xml                 # TestNG suite file
└── test-output/               # Contains default TestNG reports (e.g., emailable-report.html)
```

---

## 🔍 Folder & File Details

### ✅ `utils/`

* `Base.java`: Initializes WebDriver and browser config
* `WebDriverHelper.java`: Common WebDriver actions to avoid code duplication
* `LoggerHandler.java`: Centralized logging using Log4j2
* `Report.java`: Sets up and manages ExtentReports
* `ScreenshotUtil.java`: Captures and stores screenshots

### ✅ `locators/`

* Page-specific locators (organized per screen/page)

### ✅ `pages/`

* **DreamPortalHomePage.java**
* **DreamsDiaryPage.java**
* **DreamTotalPage.java**

> These classes contain the test logic tied to UI functionality and use locators + helpers

### ✅ `runner/`

* **TestRunner.java**: Executes test scenarios using TestNG annotations

  * `@BeforeMethod`, `@Test`, `@AfterMethod`

### ✅ Other Resources

* `log4j2.properties`: Config for logging
* `testng.xml`: TestNG configuration to group, prioritize and run tests
* `test-output/emailable-report.html`: Default TestNG HTML report

---

## 📝 Highlights

* 📄 **Page Object Model** structure
* 💬 Centralized **logging with Log4j2**
* 📸 **screenshot capture** 
* 📊 **ExtentReports** for professional reports
* 📧 Default TestNG **emailable-report.html**
* 🧼 Clean and reusable architecture

---

## 🚀 Getting Started

1. Clone the repository
2. Open in IntelliJ IDEA or Eclipse
3. Run `mvn clean install` to install dependencies
4. Configure WebDriver path if needed
5. Run tests using:

   * `TestRunner.java`, or
   * `testng.xml`

---

