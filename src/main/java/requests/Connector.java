package requests;

public interface Connector {
    <T> ConnectorResponse<T> send(ConnectorRequest request);
}
