import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.stream.Collectors;

/**
 * Created by krzysztof on 12.11.17.
 */
@Path("/numbers")
public class WinningNumbers {

    @Inject
    private NumberGenerator numberGenerator;

    @GET
    public Response getWinningNumbers() {
        String winningNumbers = numberGenerator.getWinningNumbers()
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        return Response
                .ok(winningNumbers)
                .build();

    }

}
