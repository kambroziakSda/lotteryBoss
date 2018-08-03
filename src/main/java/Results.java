import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by krzysztof on 12.11.17.
 */
public class Results {

    public Response getLotteryResults(List<Integer> userNumbers) {

        return null;
    }

    /**
     * Implmentację tej metody można oprzeć na zwykłej pętli, lub API JAVA8 (stream, filter, collect, Collectors, toList())
     * W obu przypadkach przyda się metoda contains z interfejsu List
     * @param numbers
     * @param winningNumbers
     * @return
     */
    private boolean isSuccess(List<Integer> numbers, List<Integer> winningNumbers) {
        return false;
    }

}
