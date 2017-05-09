package au.com.fx.converter.ui.console;

import au.com.fx.converter.service.FxConversionService;
import au.com.fx.converter.ui.handler.ExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.regex.Pattern;

/**
 * @author senthurshanmugalingm.
 * @see FxConsole
 */

public class FxConsoleImpl implements FxConsole {

    private static Pattern inputPattern = Pattern.compile("[A-Z]{3}\\s+\\d*(\\.\\d+)?+\\s+in+\\s[A-Z]{3}");
    private BufferedReader reader;

    @Autowired
    private FxConversionService fxConversionService;

    @Autowired
    private ExceptionHandler exceptionHandler;

    @Override
    public void startConsole() {
        printBanner();

        while (true) {
            System.out.println("Please Type in '<Base Currency> <Amount> in <Term Currency>' to get Exchange Rate or Type EXIT to close application.");
            String consoleInput = readLine();

            if (consoleInput.equals("EXIT")) {
                System.out.println("Have a Nice Day !!!");
                break;
            }

            if (inputPattern.matcher(consoleInput).matches()) {
                System.out.println(getExchangeRate(consoleInput));
            } else {
                System.out.println("Invalid Input! ");
            }
        }
    }

    private void printBanner() {
        System.out.println("|--------------------------------------------------|");
        System.out.println("|-----------------  FX CONVERTER ------------------|");
        System.out.println("|--------------------------------------------------|");
    }

    private String readLine() {
        String consoleInput = "";
        try {
            consoleInput = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return consoleInput;
    }

    private String getExchangeRate(String consoleInput) {
        String result;
        try {
            String[] values = consoleInput.split("\\s+");
            BigDecimal convertedRate = fxConversionService.convert(values[0], values[3], new BigDecimal(values[1]));
            result = String.format("%1s %2s = %3s %4s", values[0], values[1], values[3], convertedRate.toPlainString());

        } catch (RuntimeException e) {
            result = exceptionHandler.translate(e);
        }
        return result;
    }

    @PostConstruct
    private void initReader() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @PreDestroy
    private void destroyReader() {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
