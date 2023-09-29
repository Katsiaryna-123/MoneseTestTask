package apicore;


import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum Method {
    GET("GET"),
    POST("POST");

    final String value;
}
