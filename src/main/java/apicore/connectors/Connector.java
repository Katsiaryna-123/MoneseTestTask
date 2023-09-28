package apicore.connectors;

public interface Connector {
    <T> ConnectorResponse<T> send(ConnectorRequest request);
}
