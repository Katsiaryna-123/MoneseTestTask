package tags.owners;

import io.qameta.allure.Link;
import io.qameta.allure.Owner;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Owner("Katsiaryna Haspadaryk")
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Link(name = "Owner", url = "https://www.linkedin.com/in/katsiaryna-haspadaryk-751bb9194/")
public @interface OwnerKatsia {
}
