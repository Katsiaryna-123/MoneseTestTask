package helpers;


public class LogMultipartRequestsConnectorFacade implements Connector {

    Connector connector;

    public LogMultipartRequestsConnectorFacade(Connector connector) {
        this.connector = connector;
    }

    @Override
    public <T> ConnectorResponse<T> send(ConnectorRequest request) {
        return connector.send(request);
    }
}
