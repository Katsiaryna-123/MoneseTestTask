package parameterresolvers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.SessionId;
import android.applications.TodoistApplication;

import java.net.MalformedURLException;
import java.net.URL;

public class TodoistApplicationParameterResolver implements ParameterResolver {

    private final TodoistApplication app;

    public TodoistApplicationParameterResolver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 2 API 33");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);

        capabilities.setCapability(MobileCapabilityType.APP, "/Users/katsiarynahaspadaryk/Desktop/todoist/planner_0.3.5_Apkpure.apk");

        capabilities.setCapability("automationName", "UiAutomator2");

        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/"), capabilities);
        System.out.println("Session started successfully.");
        SessionId sessionId = driver.getSessionId();
        String sessionID = sessionId.toString();
        System.out.println("Session ID: " + sessionID);

        System.out.println("hello Katsenka");

        app = new TodoistApplication(driver);
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType() == TodoistApplication.class;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return app;
    }
}
