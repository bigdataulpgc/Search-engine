package api.operations.stats;

import api.operations.ErrorOutput;
import api.operations.Output;
import api.service.parameter.Parameters;
import utils.database.QueryDatabase;
import utils.database.QueryMetadataDatabase;

import java.util.Map;

public class ParameterCounterStat implements Stat{

    private static final String PARAMETER_NAME = "by";
    private static final QueryDatabase QUERY_DATABASE = new QueryMetadataDatabase("/home/search-engine/disk/datamart/SQLite/gutenbergMetadata.db");


    @Override
    public Output execute(Parameters parameters) {

        String parameter = parameters.parameters().get(PARAMETER_NAME);
        Map<String, Integer> booksByParameter = QUERY_DATABASE.query(parameter);
        return generateOutput(booksByParameter);
    }

    private Output generateOutput(Map<String, Integer> booksByParameter) {
        if (booksByParameter.keySet().isEmpty()) return new ErrorOutput("We have no the parameter required on the database");
        else {
            StatOutput response = new StatOutput();
            for(String value: booksByParameter.keySet()) response.addResult(value, booksByParameter.get(value));
            return response;
        }
    }
}
