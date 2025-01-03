# Selenium QA Task

This repository contains a Selenium-based test case implemented in Java 17 for validating key functionalities on the [Insider](https://useinsider.com/) website and 
API testing; using “pet” endpoints from "https://petstore.swagger.io/" for CRUD operations incluade positive and negative tests.
The project is structured according to the Page Object Model (POM) design pattern and includes ExtentReports for detailed test reporting.

## Task Overview

The test case covers the following scenarios:

1. **Home Page Validation**:  
   Verifies that the Insider home page is successfully opened.

2. **Navigation to Careers Page**:  
   - Selects the "Company" menu from the navigation bar and navigates to the "Careers" page.  
   - Verifies that the **Locations**, **Teams** (Find your calling), and **Life at Insider** sections are visible.

3. **Filtering QA Jobs**:  
   - Navigates to [Insider Careers QA](https://useinsider.com/careers/quality-assurance/) page.  
   - Clicks "See all QA jobs" and filters jobs by **Location: Istanbul, Turkey** and **Department: Quality Assurance**.  
   - Ensures the presence of filtered job listings.

4. **Job Listing Validation**:  
   Confirms that all filtered job listings have:  
   - `Position`: Includes "Quality Assurance"  
   - `Department`: "Quality Assurance"  
   - `Location`: "Istanbul, Turkey"

5. **View Role Redirection**:  
   Verifies that clicking the "View Role" button redirects to the Lever Application form.

6. **API TEST / CRUD Operations**
 
      a. **Create a Pet (POST /pet)**  
             Adds a new pet to the store with specific attributes and verifies that the pet is created successfully.

      b. **Retrieve a Pet by ID (GET /pet/{petId})**  
             Fetches the pet details using its ID and ensures the returned data matches the expected values.

      c. **Update a Pet (PUT /pet)**  
             Updates an existing pet's attributes and validates the changes in the response.

      d. **Delete a Pet (DELETE /pet/{petId})**  
             Deletes a pet using its ID and confirms the deletion is successful.

      e. **Retrieve a Deleted Pet (GET /pet/{petId})**  
             Attempts to retrieve a pet that has been deleted and ensures the API responds with an appropriate error message.

      f. **Create a Pet with Invalid Data (POST /pet)**  
             Tries to create a pet using invalid data and verifies that the API rejects the request with an error.

## Requirements and Implementation Details

- **Programming Language**: Java 17  
- **Testing Framework**: Selenium WebDriver  
- **Reporting Tool**: ExtentReports  
- **Build Tool**: Maven  
- **Browser Support**: Chrome and Firefox (parametrically configurable)  
- **Screenshot on Failure**: Implemented, capturing screenshots for failed steps.  
- **POM Compliance**: The test case is structured using the Page Object Model.

## Setup and Usage

### Prerequisites
- Java 17 or later installed on your system.
- Maven installed for dependency management.
- WebDriver executables for Chrome and Firefox installed and added to your PATH.

### Dependency Installation
All required dependencies are managed through Maven. The dependencies, including ExtentReports, are defined in the `pom.xml` file:

### test output

Screenshots: Saved in the screenshots directory for failed steps.
Test Reports: ExtentReports are generated in the reports directory.

### Parameters

Browser: Change the browser type in Configuration Properties (chrome or firefox).
