package api.service.parameter;

import spark.Request;

import java.util.Map;
import java.util.Set;

public class ParametersGetter {

    public Parameters getParameters(Request request){
        Parameters parameters = new Parameters();
        addPathParameter(parameters, request.params());
        addQueryParameters(parameters, request);
        return parameters;
    }

    private void addPathParameter(Parameters parameters, Map<String, String> request) {
        request.keySet().stream()
                .forEach(key -> parameters.addParameter(key, request.get(key)));
    }

    private void addQueryParameters(Parameters parameters, Request request) {
        for (String queryParam: request.queryParams()) {
            System.out.println(queryParam);
            parameters.addParameter(queryParam, request.queryParams(queryParam));
        }
    }
}
