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
public class Results {

    @Inject
    private NumberGenerator numberGenerator;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN+";charset=utf8")
    public Response getLotteryResults(LotteryBossParameters lotteryBossParameters) {
        List<Integer> winningNumbers = numberGenerator.getWinningNumbers();
        boolean isSuccess = isSuccess(lotteryBossParameters.getRandomNumbers(), winningNumbers, lotteryBossParameters.getLevel());
        StringBuilder responseBuilder = new StringBuilder("Liczby wygrywajace to: " + winningNumbers);
        if (isSuccess) {
            responseBuilder.append("Brawo! Wygrałeś milion!");
        } else {
            responseBuilder.append("Niestety nie wygrałeś, spróbuj ponownie");
        }
        return Response.ok(responseBuilder.toString()).build();
    }

    /**
     * Implmentację tej metody można oprzeć na zwykłej pętli, lub API JAVA8 (stream, filter, collect, Collectors, toList())
     * W obu przypadkach przyda się metoda contains z interfejsu List
     *
     * @param numbers
     * @param winningNumbers
     * @param level
     * @return
     */
    private boolean isSuccess(List<Integer> numbers, List<Integer> winningNumbers, Integer level) {
        int counter = 0;
        for (Integer winningNumber : winningNumbers) {
            if (numbers.contains(winningNumber)) {
                counter++;
            }
        }
        return counter >= level;

/*        return winningNumbers.stream()
                .filter(winningNumber -> numbers.contains(winningNumber))
                .count() > 0;*/
    }

}
