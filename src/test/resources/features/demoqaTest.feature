@run
Feature: Text Box Page
  Submit text box form
#    Scenario: Submit text box form
#      Given Go to Text Box Page
#      When I Fill Text Box Form
#      And Submit Text Box Form
#      Then Data visible under the form

#  Scenario: Click React on checkbox page
#    Given Go to Check box Page
#    And I Click Expand All Btn
#    When I Click React Checkbox
#    Then Corresponding input is Checked Or Half-checked

#    Radio button
#    @radioButton
#    Scenario Outline: Click Radio Button
#      Given Go to Radio Button Page
#      When Click "<radio_button_value>"
#      Then the text should be: You have selected "<radio_button_value>"
#      Examples:
#      |radio_button_value|
#      |yes               |
#      |impressive        |
#
##      Web Tables
#    Scenario: add new User
#      Given Go to Web tables page
#      When I Click Add Button
#      And my new user is
#        | firstName     | lastName      | email           | age | salary | department     |
#        | testFirstName | testLastName  | test@gmail.com  | 35  | 123456 | testDepartment |
#      And I fill the form
#      And I click submit
#      Then Tables has new data
#
#      Buttons
    @staging
    Scenario: go to Buttons page
      Given Go to Buttons page
      When I click "double click me" button
      And I click "right click me" button
      And I click "Click me" button
      Then Check Click Mess content
#
##      LinksPage
    @dev
  Scenario: go to Links page
    Given Go to Links page
    When I click "Home" Link
    Then Browser create a new tab url
    When I click "Created" link
    Then I got status 201
    When I click "Bad request" link
    Then I got status 400
#
##    Broken Links Page
#  Scenario: test image
#    Given Go to Broken Links - Images
#    Then validImage is valid
#    And inValidImage is inValid
#    And validLink is valid
#    And inValidLink is inValid
#
##    upload and download
#  Scenario: test upload and download page
#    Given Go to upload and download page
#    When click button Download
#    And upload file
#    Then download file's appeared in Downloads folder
#    And File's uploaded successfully
#
##    Dynamic properties
#  Scenario: test dynamic properties page
#    Given Go to dynamic properties page
#    When wait for 5s
#    Then check text random Id
#    And 1st button enabled
#    And 2nd button change color
#    And 3rd button appear
#
##    Practice Form page
#  Scenario: test Practice form page
#    Given Go to Practice form page
#    When I fill student registration form
#      | firstName     | lastName      | email               | gender | mobile     | dateOfBirth | subjects            | hobbies       | picture                                         | currentAddress      | state | city  |
#      | testFirstName | testLastName  | testEmail@gmail.com | Female |1234567890  | 18 Jan 1992 | Maths, Arts, Hindi  | Sports, Music | C:\\Users\\ndphong1\\Downloads\\sampleFile.jpeg | testCurrentAddress  | NCR   | Delhi |
#    And I Click submit
#    Then Show modal
#    And Data is correct
#
##    Browser Window
#  Scenario: test Browser Window 1
#    Given go to Browser Window
#    When click "New Tab" button
#    Then New tab is presented
#
#  Scenario: test Browser Window 2
#    Given go to Browser Window
#    When click "New Window" button
#    Then New window is presented
#
##    Alert
#  Scenario: test Alert Page click Button to see alert
#    Given go to Alert Page
#    When click Button to see alert
#    Then Alert's appeared
#
#  Scenario: test Alert Page click Button to see confirm box
#    Given go to Alert Page
#    When click Button to see confirm box
#    Then text confirm box show correctly
#
#  Scenario Outline: test Alert Page click Button to see prompt box
#    Given go to Alert Page
#    When click Button to see prompt box
#    And fill the input "<testName>"
#    Then text prompt box show correctly "<testName>"
#    Examples:
#    |testName       |
#    |thisIsTestName |
#
#    #Iframe
#  Scenario: test Frames page
#    Given go to Frames page
#    Then the text should be: "This is a sample page"
#
#    #nestedFrame page
#  Scenario: test Nested Frames page
#    Given go to Nested Frame page
#    When check parent Iframe
#    And check child Iframe
#    Then parent frame text should be: "Parent frame"
#    And child frame text should be: "Child Iframe"
#
#    # read File pdf
#  Scenario: Reading data from pdf file to fill text-box form
#    Given Go to Text Box Page
#    When I read data from "pdf" file: "D:\Projects\MasterSeleniumFramework_BDD\src\test\resources\TestDataPdf.pdf"
#    Then Data should contains "TestFirst"
#
#    # read File csv
#  Scenario: Reading data from csv file to fill text-box form
#    Given Go to Text Box Page
#    When I read data from "csv" file: "D:\Projects\MasterSeleniumFramework_BDD\src\test\resources\TestDataCsv.csv"
#    And Fill csv data to form
#    And Submit Text Box Form
#    Then Data from csv visible under the form
#
##    read xlsx file
#  Scenario: Reading data from xlsx file to fill text-box form
#    Given Go to Text Box Page
#    When I read data from "xlsx" file: "D:\Projects\MasterSeleniumFramework_BDD\src\test\resources\TestDataXlsx.xlsx"
#    And Fill excel data to form
#    And Submit Text Box Form
#    Then Data from csv visible under the form
#
#    # modal dialogs
#  Scenario: Check modal is appeared
#    Given Go to modal dialogs page
#    When click on button
#    Then modal dialogs appeared
#
##    Accordian page
#  Scenario: Test Accordian Page
#    Given go to accordian page
#    When click on 2nd accordian title
#    Then accordian 2nd content appreared
#
##    Auto complete Page
#  Scenario: Test Auto Complete page
#    Given go to auto complete page
#    When Add Black And Aqua value on multiple input
#    Then input value have Black And Aqua
#
##    DatePicker
#  Scenario: Test DatePicker page
#    Given go to date picker page
#    When Fill date picker input
#    Then input is correct
#
##    Slider
#  Scenario: Test Slider Page
#    Given go to Slider page
#    When drag input to value 2
#    Then input Value is 2
##    Progress Bar
#  Scenario: Test ProgressBar
#    Given go to Progress Bar page
#    When click start button
#    And wait until Reset button appeared
#    Then Progress Bar is 100%
#
#    #Tabs page
#  Scenario: Test Tab Page
#    Given go to Tabs Page
#    When click Origin Tab Link
#    Then Origin Tab Content has class active
#
#    #Tool Tips page
#  Scenario: Test Tool Tips page
#    Given go to Tool Tips page
#    When hover Btn
#    Then Tool tip appeared
#
#    #menu
#  Scenario: Test Menu page
#    Given go to Menu page
#    When hover Main item 2
#    And hover sub sub list
#    Then Sub sub item appeared
#
#    #Sortable Page
##  List
#  Scenario: Test Sortable Page list
#    Given go to Sortable Page
#    When move One to between three and four "list"
#    Then the order should be start with two three four one "list"
#
#    #  Grid
#  Scenario: Test Sortable Page grid
#    Given go to Sortable Page
#    When click to grid button
#    And move One to between three and four "grid"
#    Then the order should be start with two three four one "grid"
#
#    #  Grid
#  Scenario: Test resizable Page
#    Given go to resizable Page
#    When Resize element width: "450", height: "250"
#    Then Element is resized
#
##    droppable
#  Scenario: Test drag and drop Page
#    Given go to Droppable Page
#    When Drag element to Drop element
#    Then Element is drop successfully
#
#    #dragabble
#  Scenario: Test draggable Page
#    Given go to draggable Page
#    When Drag element to offsetX: "800", offsetY: "500"
#    Then Element is Drag successfully offsetX: "800", offsetY: "500"

