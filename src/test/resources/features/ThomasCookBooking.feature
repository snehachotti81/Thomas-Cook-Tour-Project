Feature: ThomasCook Kerala Tour Booking

  Scenario Outline: Book Kerala Quick Kochi tour and verify Payment Failed
    Given I am on ThomasCook home page
    When I hover on Holiday menu and navigate to Short Breaks in Kerala
    And I click on "Kerala-Quick Kochi" view details
    And I scroll to Calculate Price and fill Tour Type "<tourType>" and Adult "<adult>"
    And I select Date of Travel "<travelDate>"
    And I fill Contact Details "<mobileNo>" and "<email>"
    And I accept Privacy Policy & Terms and click Calculate Package Price
    And I select Pay Full Amount and click Continue
    And I sign in with "<loginEmail>" and continue as guest
    And I fill Traveller 1 details "<title1>", "<firstName1>", "<lastName1>", "<dob1>", "<meal1>"
    And I fill Traveller 2 details "<title2>", "<firstName2>", "<lastName2>", "<dob2>", "<meal2>"
    And I fill Address details "<titleAdd>", "<firstNameAdd>", "<lastNameAdd>", "<address>", "<state>", "<city>", "<pincode>", "<emailAdd>", "<mobileAdd>"
    And I select Credit Card and fill payment details "<cardNo>", "<expMonth>", "<expYear>", "<cvv>", "<cardName>"
    Then I should see Payment Failed message

  Examples:
    | tourType | adult | travelDate | mobileNo   | email                   | loginEmail               | title1 | firstName1  | lastName1 | dob1       | meal1 | title2 | firstName2 | lastName2 | dob2       | meal2   | titleAdd | firstNameAdd | lastNameAdd | address | state  | city    | pincode | emailAdd       | mobileAdd | cardNo            | expMonth | expYear | cvv  | cardName    |
    | Standard | 2     | 18-09-2025 | 7463010075 | snehachhoti29@gmail.com | snehachhoti29@gmail.com  | Mrs    | Sneha       | Doe       | 01-01-1990 | Veg   | Ms     | Jane       | Doe       | 02-02-1992 | Non-Veg | Mr       | John         | Doe         | Street1 | Kerala | Kochi   | 682001  | john@mail.com  | 9876543210 | 4111111111111111 | 09       | 2025    | 123  | John Doe    |
