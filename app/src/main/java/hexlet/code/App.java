package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 0.0.1",
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable<Integer> {
    private static final int ERROR_CODE = 0;
    @Parameters(index = "0", description = "The name of file to be compared.")
    private String filePath1;
    @Parameters(index = "1", description = "The name of file to be compared.")
    private String filePath2;
    @Option(names = {"-f", "--format"}, defaultValue = "stylish", description = "output format [default: stylish]")
    private String format;

    @Override
    public Integer call() throws Exception {

        var difference = Differ.generate(filePath1, filePath2, format);
        System.out.println(difference);
        return ERROR_CODE;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
