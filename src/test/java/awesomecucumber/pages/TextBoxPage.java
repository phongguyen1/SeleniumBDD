package awesomecucumber.pages;

import awesomecucumber.domainobjects.User;
import awesomecucumber.utils.CSVUltis;
import awesomecucumber.utils.PDFUtils;
import awesomecucumber.utils.XLSXUtils;
import org.apache.commons.csv.CSVRecord;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.csv.CSVParser;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import static awesomecucumber.constants.FrameworkConstants.PDF;
import static awesomecucumber.constants.FrameworkConstants.CSV;
import static awesomecucumber.constants.FrameworkConstants.EXCEL;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class TextBoxPage extends BasePage {
    private static final Logger logger = LogManager.getLogger();
    @FindBy(css = "button#submit")
    private WebElement SubmitBtn;
    @FindBy(css = "input#userName")
    private WebElement UserNameInput;
    @FindBy(css = "input#userEmail")
    private WebElement UserEmailInput;
    @FindBy(css = "textarea#currentAddress")
    private WebElement CurrentAddressInput;
    @FindBy(css = "textarea#permanentAddress")
    private WebElement PermanentAddressInput;
    @FindBy(css = "#output")
    private WebElement output;
    private String pdfFileContent;
    private CSVParser csvFileParser;
    private User currentUser;
    private Sheet sheetContent;

    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    public void clickSubmit () {
        click(SubmitBtn);
    }
    public void fillTextBoxForm() {
        clearAndSendKeys(this.UserNameInput, "Nguyen Dinh Phong"); // FullName
        clearAndSendKeys(this.UserEmailInput, "phong@gmail.com"); // Email
        clearAndSendKeys(this.CurrentAddressInput, "Hanoi"); // Email
        clearAndSendKeys(this.PermanentAddressInput, "Vietnam"); // Email
    }
    public void fillTextBoxForm(User user) {
        clearAndSendKeys(this.UserNameInput, user.getFullName()); // FullName
        clearAndSendKeys(this.UserEmailInput, user.getEmail()); // Email
        clearAndSendKeys(this.CurrentAddressInput, user.getCurrentAddress()); // Email
        clearAndSendKeys(this.PermanentAddressInput, user.getPermanentAddress()); // Email
    }
    public String getOutput() {
        return getElementText(output);
    }
    public void readDataFromFile(String fileType, String filePath) throws IOException {
        switch (fileType) {
            case PDF:
                pdfFileContent = PDFUtils.getPDFContent(filePath);
                break;
            case EXCEL:
                sheetContent = XLSXUtils.getSheetFromFilePath(filePath);
                break;
            default:
                csvFileParser = CSVUltis.readDataFromCsv(filePath);
                break;
        }
    }
    public void fillCsvDataToForm() {
        for (CSVRecord record : csvFileParser) {
            currentUser = new User(
                    record.get("First Name"),
                    record.get("Last Name"),
                    record.get("Email"),
                    1,
                    1,
                    "test",
                    record.get("Current Address"),
                    record.get("Permanent Address")
            );
        }
        fillTextBoxForm(currentUser);
    }
    public void fillXlsxDataToForm() {
        currentUser = new User();
        Iterator<Row> rowIterator = sheetContent.iterator();
        if (rowIterator.hasNext()) {
            rowIterator.next();
        }
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            String firstName = row.getCell(0).getStringCellValue();
            String lastName = row.getCell(1).getStringCellValue();
            String email = row.getCell(2).getStringCellValue();
            String currentAddress = row.getCell(3).getStringCellValue();
            String permanentAddress = row.getCell(4).getStringCellValue();
            currentUser.setFirstName(firstName);
            currentUser.setLastName(lastName);
            currentUser.setEmail(email);
            currentUser.setCurrentAddress(currentAddress);
            currentUser.setPermanentAddress(permanentAddress);
        }
        fillTextBoxForm(currentUser);
    }
    public String getDataFromPDFFile() {
        return pdfFileContent;
    }
    public void fillFormWithDataFromFile() {
        fillTextBoxForm(currentUser);
    }
}
