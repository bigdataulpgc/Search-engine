package api.service;


import api.operations.ErrorOutput;
import api.operations.Output;
import api.operations.OperationController;
import api.service.parameter.Parameters;
import api.service.parameter.ParametersGetter;
import spark.Request;
import java.util.HashMap;
import static utils.JsonUtil.json;
import static spark.Spark.*;

public class GutenbergApiRest implements ApiRest {

    private static final HashMap<String, OperationController> responseMap = new HashMap<>();
    private static final ParametersGetter parameterGetter = new ParametersGetter();

    @Override
    public void addResponse(String response, OperationController operationController){
        responseMap.put(response, operationController);
    }

    @Override
    public void start(){

        get("/documents/:words", (request, res) -> {
            Output output = getResponse(responseMap.get("documents"), request);
            if (output != null) {
                return output;
            }
            res.status(400);
            return new ErrorOutput("There are not books for the given words");
        }, json());


        get("/stats/:type", (request, res) -> {
            Output output = getResponse(responseMap.get("stats"), request);
            if (output != null) {
                return output;
            }
            res.status(400);
            return new ErrorOutput("Stat not found");
        }, json());

        after((req, res) -> res.type("application/json"));

    }

    private static Output getResponse(OperationController operationController, Request request) {
        Parameters parameters = parameterGetter.getParameters(request);
        return operationController.getResponse(parameters);
    }
}
