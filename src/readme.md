GENERATING TOKEN FOR API TEST
This section provides instructions on how to start with api tests.

Step 1: Go to https://todoist.com/ and log in to your account.

Step 2: Go to Settings -> Integrations -> Developer tab.

Step 3: Generate a token, copy it.

Step 4: Store it in your system with name "TOKEN" so that class java/apicore/connectors/RestAssuredConnector.java will know about it.

Now RestAssuredConnector knows your token and you can run api tests.

INSTALLING APPIUM

This section provides instructions on how to install Appium on your system.

Prerequisites

Before installing Appium, ensure that you have the following prerequisites set up on your system:

Node.js and npm (Node Package Manager) installed.
Android Studio installed for device emulation.
Android Home Path exported (for Android testing).
Installation Steps
Follow these steps to install Appium:

Step 1: Install Node.js and npm

If you haven't already installed Node.js and npm, download and install.

Step 2: Install Appium

Open a terminal or command prompt and run the following command to install Appium globally:

npm install -g appium
This command will download and install Appium along with its dependencies.

Step 3: Install Appium Dependencies

Depending on your testing needs, you may need to install additional dependencies. For Android testing, you can install UIAutomator2 Driver:

npm install -g appium-doctor   # (Optional) Install Appium Doctor to check for dependencies.
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

2. In your test script, create a new Appium session by initiating a session request (you may just run test).

3. Once the session is created, you will see sessionId in console.

4. Open Appium Inspector and connect to the session using the sessionId you obtained in the previous step.

You can now interact with the device or emulator using the Appium Inspector interface for debugging and inspection.

MAKE A REPORT

After test run completes write in terminal "allure serve" to generate report.