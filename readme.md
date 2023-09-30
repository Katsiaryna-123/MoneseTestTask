# How to start with running tests (MacOS)

## GENERATING TOKEN FOR API TEST

### This section provides instructions on how to start with api tests.

Step 1: Go to https://todoist.com/ and log in to your account.

Step 2: Go to Settings -> Integrations -> Developer tab.

Step 3: Generate a token, copy it.

Step 4: Open a terminal and store token as an environment variable.

#### Steps to store token using zshell:

1. Open terminal, enter "echo $SHELL". You'll see :/bin/zsh for zshell or :/bin/bash for bash.
2. Enter: "export TOKEN=placeYourTokenHere" >> ~/.zshrc
3. Confirm by entering: cat ~/.zshrc
4. Enter source ~/.zshrc
5. Check that token is set: env | grep "TOKEN"
6. Enter the same command in other terminal to make sure that variable is set permanently
7. Reboot your machine

Now RestAssuredConnector.java class knows your token, and you can run api tests.

## PASTE PATH TO APK

You will find apk file here: src/main/resources.

Copy absolute path of the apk and paste it as a capability "APP" in TodoistApplicationParameterResolver.java.

## INSTALLING APPIUM

### This section provides instructions on how to install Appium on your system.

#### Prerequisites:

Before installing Appium, ensure that you have the following prerequisites set up on your system:

Node.js and npm (Node Package Manager) installed.

Android Studio installed for device emulation (device data you will find in resources/config).

Android Home Path exported (for Android testing).

#### Follow these steps to install Appium:

Step 1: Install Node.js and npm

If you haven't already installed Node.js and npm, download and install.

Step 2: Install Appium

Open a terminal or command prompt and run the following command to install Appium globally:

npm install -g appium
This command will download and install Appium along with its dependencies.

Step 3: Install Appium Dependencies

Depending on your testing needs, you may need to install additional dependencies. For Android testing, you can install
UIAutomator2 Driver:

npm install -g appium-doctor # (Optional) Install Appium Doctor to check for dependencies.

npm install -g appium-uiautomator2-driver

Step 4: Verify Installation

To verify that Appium has been successfully installed, run the following command:

appium --version
You should see the installed Appium version displayed in the terminal.

Step 5: Start Appium Server

Before using Appium, start the Appium server by running the following command:

appium
The Appium server should now be running and ready to accept automation commands.

Step 6:
Install Appium Inspector (to collecting attributes from page) and connect your session to it.

1. Ensure that your Appium server is running.

2. Ensure that emulator is running.

3. Create a new Appium session by initiating a session request (you may just run test).

4. Once the session is created, you will see sessionId in console.

5. Open Appium Inspector and connect to the session using the sessionId you obtained in the previous step.

You can now interact with the device or emulator using the Appium Inspector interface for debugging and inspection.

## MAKE A REPORT

After test run completes write in terminal "allure serve" to generate report.