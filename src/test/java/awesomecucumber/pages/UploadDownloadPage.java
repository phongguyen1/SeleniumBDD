package awesomecucumber.pages;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UploadDownloadPage extends BasePage {

    @FindBy(css = "a#downloadButton")
    private WebElement downloadBtn;
    @FindBy(css = "input#uploadFile")
    private WebElement uploadBtn;
    @FindBy(css = "p#uploadedFilePath")
    private WebElement uploadFileText;
    private int folderBeforeDownloadFileCount = 0;
    public UploadDownloadPage(WebDriver driver) {
        super(driver);
    }
    public void clickDownloadBtn(String downloadDirectoryPath) {
        File directory = new File(downloadDirectoryPath);
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) folderBeforeDownloadFileCount = files.length;
        }
        downloadBtn.click();
    }
    public void uploadFile(String filePath) {
        uploadBtn.sendKeys(filePath);
    }

    public Boolean isFolderContainsDownloadedFile(String downloadDirectoryPath) throws InterruptedException {
        boolean fileExists = false;
        Thread.sleep(5000);
        File directory = new File(downloadDirectoryPath);
        if (directory.exists() && directory.isDirectory()) {
            // Lấy danh sách các file trong thư mục
            File[] files = directory.listFiles();
            if (files != null) {
                fileExists = files.length > folderBeforeDownloadFileCount;
            }
        }

        return fileExists;
    }
    public Boolean isUploadFileTextContainsFileName(String uploadFilePath) {
        File file = new File(uploadFilePath);
        String fileName = file.getName();
        System.out.println("fileName " + fileName);
        System.out.println("uploadFileText " + getElementText(uploadFileText));
        return getElementText(uploadFileText).contains(fileName);
    }
}
