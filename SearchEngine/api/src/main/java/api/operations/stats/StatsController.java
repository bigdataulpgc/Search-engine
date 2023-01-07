package api.operations.stats;

import api.operations.Output;
import api.operations.OperationController;
import api.service.parameter.Parameters;

import java.util.HashMap;
import java.util.Map;

public class StatsController implements OperationController {

    private static final String NAME_PARAMETER = ":type";
    private static final Map<String, Stat> STAT_MAP = new HashMap<>(){{
       put("count", new CounterStat());
       put("proportion", new ProportionStat());
       put("countBy", new ParameterCounterStat());
       put("proportionBy", new ParameterProportionStat());
       put("titleWords", new TitleWords());
       put("maxWords", new MaxWordsStat());
    }};

    @Override
    public Output getResponse(Parameters parameters) {
        return STAT_MAP.get(parameters.parameters().remove(NAME_PARAMETER)).execute(parameters);
    }
}
