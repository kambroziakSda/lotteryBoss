import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Created by krzysztof on 12.11.17.
 */
@Path("/numbers")
public class WinningNumbers {

    
    private NumberGenerator numberGenerator;

    @GET
    public Response getWinningNumbers() {
        String winningNumbers = "";

        return Response
                .ok(winningNumbers)
                .build();

    }

}
