import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by krzysztof on 12.11.17.
 */
@Singleton
@Startup
public class NumberGenerator {

    private List<Integer> winningNumbers;

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(NumberGenerator.class);

    @PostConstruct
    public void postConstruct() {

        winningNumbers = drawWinningNumbers();
        logger.info("Wylosowano: "+ winningNumbers);
    }

    private List<Integer> drawWinningNumbers() {
        List<Integer> nummbers = new Random()
                .ints(6, 1, 50)
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toList());
        nummbers.sort(Integer::compareTo);
        return nummbers;


    }

    public List<Integer> getWinningNumbers() {
        return Collections.unmodifiableList(winningNumbers);
    }


}
