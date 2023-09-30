package androidcore;

import androidcore.applications.TodoistApplication;
import io.appium.java_client.android.AndroidDriver;
import lombok.SneakyThrows;
import org.junit.jupiter.api.extension.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

import static io.appium.java_client.remote.AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS;
import static io.appium.java_client.remote.MobileCapabilityType.*;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

public class TodoistApplicationParameterResolver implements ParameterResolver, AfterTestExecutionCallback {

    private final TodoistApplication app;

    @SneakyThrows
    public TodoistApplicationParameterResolver() {
        Properties properties = new Properties();
        FileInputStream config = new FileInputStream("src/main/resources/config");
        properties.load(config);
        config.close();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(PLATFORM_NAME, properties.getProperty("platform.name"));
        capabilities.setCapability(DEVICE_NAME, properties.getProperty("device.name"));
        capabilities.setCapability(PLATFORM_VERSION, properties.getProperty("platform.version"));
        capabilities.setCapability(UDID, properties.getProperty("udid"));
        capabilities.setCapability(NEW_COMMAND_TIMEOUT, properties.getProperty("command.timeout"));
        capabilities.setCapability(AUTO_GRANT_PERMISSIONS, Boolean.parseBoolean(properties.getProperty("auto.grant.permissions")));
        //change path here:
        capabilities.setCapability(APP, "/Users/katsiarynahaspadaryk/MoneseTestTask/src/main/resources/planner_0.3.5_Apkpure.apk");
        capabilities.setCapability(AUTOMATION_NAME, properties.getProperty("automation.name"));

        AndroidDriver driver = new AndroidDriver(new URL(properties.getProperty("appium.url")), capabilities);

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

    @Override
    public void afterTestExecution(ExtensionContext context) {
        app.close();
    }
}
