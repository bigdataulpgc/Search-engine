package api.operations;


import api.service.parameter.Parameters;

public interface OperationController {

    Output getResponse(Parameters parameters);
}
