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
    @Path("/winning")
    public Response getWinningNumbers() {
        /*
        Aby przerobić listę Integer'ow którą dotaniemy z numberGeneratora można
        wykorzystać API z z java8 (stream(), collect, Colectors, joining)
         */
        String winningNumbers = numberGenerator.getWinningNumbers()
                .stream()
                .map(element->String.valueOf(element))
                .collect(Collectors.joining(", "));

        return Response
                .ok(winningNumbers)
                .build();

    }

}
