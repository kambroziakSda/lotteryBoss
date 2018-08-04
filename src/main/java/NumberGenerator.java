import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by krzysztof on 12.11.17.
 */
@Singleton
@Startup
public class NumberGenerator {

    private static final Logger logger = Logger.getLogger(NumberGenerator.class);

    private List<Integer> winningNumbers;

    /**
     * W implementacji tej metody można posłużyć się klasą java.util.Random
     *
     * @return
     */
    private List<Integer> drawWinningNumbers() {
        return new Random().ints(6, 1, 50)
                .mapToObj(Integer::valueOf)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }

    @PostConstruct
    public void generateNumbersOnStart() {
        winningNumbers = drawWinningNumbers();
        logger.info("Liczby wygrywające: "+winningNumbers);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
