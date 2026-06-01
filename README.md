# Gist Automation Testing

Automation testing untuk fitur CRUD GitHub Gist menggunakan Selenium WebDriver dan Page Object Model (POM).

## Tech Stack

- Java 17
- Selenium WebDriver
- TestNG
- Gradle
- Allure Report
- Page Object Model (POM)

## Test Coverage

| Test Case | Status |
|------------|---------|
| Login GitHub | ✅ Passed |
| Create Public Gist | ✅ Passed |
| Edit Existing Gist | ✅ Passed |
| Delete Existing Gist | ✅ Passed |

## Run Project

### Clone Repository

```bash
git clone https://github.com/adindanimas/gist-automation.git
cd gist-automation
```

### Setup Credentials

Buat file `src/test/resources/config.properties`

```properties
github.username=YOUR_USERNAME
github.password=YOUR_PASSWORD
```

### Run Test

```bash
./gradlew test
```

### Generate Allure Report

```bash
./gradlew allureReport
./gradlew allureServe
```

## Notes

- Menggunakan Page Object Model (POM)
- Test flow: Login → Create → Edit → Delete
- Screenshot otomatis saat test gagal
- All test passed (4/4)

## Author

**Adinda Nimas**  
QA Engineer
