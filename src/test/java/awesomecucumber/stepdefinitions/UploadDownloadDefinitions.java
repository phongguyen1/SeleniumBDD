package awesomecucumber.stepdefinitions;

import awesomecucumber.context.TestContext;
import awesomecucumber.factory.PageFactoryManager;
import awesomecucumber.pages.BrokenLinksPage;
import awesomecucumber.pages.UploadDownloadPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class UploadDownloadDefinitions {
    private final TestContext context;
    private final UploadDownloadPage uploadDownloadPage;
    public UploadDownloadDefinitions(TestContext context) {
        this.context = context;
        this.uploadDownloadPage = PageFactoryManager.getUploadDownloadPage(context.driver);
    }
    @Given("Go to upload and download page")
    public void goToUploadAndDownloadPage() {
        this.uploadDownloadPage.load("upload-download");
    }
    private final String downloadDirectoryPath = "C:\\Users\\ndphong1\\Downloads";

    @When("click button Download")
    public void clickButtonDownload() {
        this.uploadDownloadPage.clickDownloadBtn(downloadDirectoryPath);
    }

    @Then("download file's appeared in Downloads folder")
    public void downloadFileSAppearedInDownloadsFolder() throws InterruptedException {
        Assert.assertTrue(this.uploadDownloadPage.isFolderContainsDownloadedFile(downloadDirectoryPath));
    }

    private final String uploadFilePath = "C:\\Users\\ndphong1\\Downloads\\OUTPUT_TRAINNING.pdf";
    @And("upload file")
    public void uploadFile() {
        this.uploadDownloadPage.uploadFile(uploadFilePath);
    }

    @And("File's uploaded successfully")
    public void isFileSUploadedSuccessful() {
        Assert.assertTrue(this.uploadDownloadPage.isUploadFileTextContainsFileName(uploadFilePath));
    }
}
