## Prerequisites:

   - Java 8+ -> set $JAVA_HOME
   - Maven -> Set  $MAVEN_HOME
   - Intellij IDE/Eclipse
   
## How to:
   
- Clone the project from GitHub 
- Import the project

## To Run UI Tests:

- Open Terminal in IDE then run the below command:
   
 ` mvn clean install -Dcucumber.options="--tags @ui" `  

## To Run API Tests:
   
 ` mvn clean install -Dcucumber.options="--tags @api" ` 
 
#### NOTE:
Test scenarios were passed in my system and attached the screenshots under `/screenshots` folder
