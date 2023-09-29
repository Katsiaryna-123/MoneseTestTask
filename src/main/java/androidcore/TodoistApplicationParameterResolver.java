package androidcore;

import androidcore.applications.TodoistApplication;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.SneakyThrows;
import org.junit.jupiter.api.extension.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.SessionId;

import java.io.FileInputStream;
import java.net.URL;
import java.util.Objects;
import java.util.Properties;

public class TodoistApplicationParameterResolver implements ParameterResolver, AfterTestExecutionCallback {

    private final TodoistApplication app;

    @SneakyThrows
    public TodoistApplicationParameterResolver() {
        Properties properties = new Properties();
        FileInputStream config = new FileInputStream("src/main/resources/config");
        properties.load(config);
        config.close();

        String apkFilePath = Objects.requireNonNull(getClass().getClassLoader().getResource("planner_0.3.5_Apkpure.apk"))
                .getFile();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, properties.getProperty("platform.name"));
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, properties.getProperty("device.name"));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, properties.getProperty("platform.version"));
        capabilities.setCapability(MobileCapabilityType.UDID, properties.getProperty("udid"));
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, properties.getProperty("command.timeout"));
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, Boolean.parseBoolean(properties.getProperty("auto.grant.permissions")));

        //   capabilities.setCapability(MobileCapabilityType.APP, properties.getProperty(apkFilePath));
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/katsiarynahaspadaryk/Desktop/todoist/planner_0.3.5_Apkpure.apk");

        capabilities.setCapability("automationName", properties.getProperty("automation.name"));

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
