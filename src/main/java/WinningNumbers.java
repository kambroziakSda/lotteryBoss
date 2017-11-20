import javax.ws.rs.GET;
import javax.ws.rs.core.Response;

/**
 * Created by krzysztof on 12.11.17.
 */
public class WinningNumbers {

    
    private NumberGenerator numberGenerator;

    @GET
    public Response getWinningNumbers() {
        /*
        Aby przerobić listę Integer'ow którą dotaniemy z numberGeneratora można
        wykorzystać API z z java8 (stream(), collect, Colectors, joining)
         */
        String winningNumbers = "";

        return Response
                .ok(winningNumbers)
                .build();

    }

}
