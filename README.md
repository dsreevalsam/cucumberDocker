# MyTheresa

Repo contains tests based on Cucumber-selenium-testng, page object model.



Dockerfile specifies the steps to initialize a docker container, from which tests are initiated.

docker-compose YAML file define a selenium grid network with Chrome and Firefox browsers.It creates a service e2e-module which from which tests are triggered

It accepts BROWSER (chrome or firefox), HUB_HOST (ip address of hub), MODULE(testng xml file) and URL (test url) as parameters and can be adjusted.

healthcheck.sh checks if hub and nodes are ready, up and running before executing tests.


## To Run the Tests:
Pre Requisites: Docker has to be installed (https://docs.docker.com/engine/install/)
1. Clone the repo
2. Go to project root folder
3. Start/Run Docker engine
4. Note: If using a windows machine, uncomment the line containing: "RUN dos2unix healthcheck.sh"
5. Package the tests using: "mvn clean package -DskipTests"
6. Build docker image usign command: "docker build -t mytheresa/demo ."
7. run docker using docker-compose: "docker-compose up"
8. Use "docker-compose down" to shut down the network
9. Browsers and url can be changed by updating BROWSER and/or URL environment variables in docker-compose.yaml


## Tests

Feature: General Validations on Application Launch and Login
  Scenario: Launch website and check for js or url errors
    Given User launches MyTheresa
		This step launches mytheresa web portal
    Then Check if there are any javascript errors
		This step checks if there are any js errors. Currently this tes will only work when browser used is chrome
    And Visit all urls and Validate Status Codes
		This test gets all the url's from the home page and hits them using restassured and validates status code to be 2xx or 3xx
		
Feature: User Account
  Scenario: Validate user is able to login to MyTheresa
  	Given User launches MyTheresa
  	Then Login with email "test123@test123.com"
		This step is used to login to MyAccount using the provided email. Encrypted Password is fetch from the properties file and then decrypted
  	And Validate login was successful
		Validated header in next page to assert that login was successful

