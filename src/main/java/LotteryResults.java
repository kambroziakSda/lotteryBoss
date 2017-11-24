import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by krzysztof on 12.11.17.
 */
@Path("/results")
public class LotteryResults {

    @Inject
    private NumberGenerator numberGenerator;

    @POST
    @Produces(MediaType.TEXT_PLAIN + "; charset=UTF-8")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getLotteryResults(LotteryParameters lotteryParameters) {
        List<Integer> winningNumbers = numberGenerator.getWinningNumbers();
        boolean isSuccess = isSuccess(lotteryParameters, winningNumbers);

        StringBuilder responseMessageBuilder = new StringBuilder();
        responseMessageBuilder
                .append("Level= ").append(lotteryParameters.getLevel())
                .append("\n")
                .append("Liczby wygrywające to:")
                .append(winningNumbers)
                .append("\n");

        if (isSuccess) {
            responseMessageBuilder.append("Wygrałeś milion!\n");
        } else {
            responseMessageBuilder.append("Niestety nie wygrałeś, spróbuj jeszcze raz!\n");
        }

        return Response
                .ok(responseMessageBuilder.toString())
                .build();
    }

    private boolean isSuccess(LotteryParameters lotteryParameters, List<Integer> winningNumbers) {
        return lotteryParameters
                .getUserNumbers()
                .stream()
                .filter(userNumber -> winningNumbers.contains(userNumber))
                .count() >= lotteryParameters.getLevel();
    }

}
