package api.service;

import api.operations.OperationController;

public interface ApiRest {

    void start();
    void addResponse(String response, OperationController operationController);
}
