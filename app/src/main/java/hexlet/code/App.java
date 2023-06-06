package hexlet.code;

//import hexlet.code.Differ;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import javax.annotation.processing.Generated;
import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 0.0.1",
        description = "Compares two configuration files and shows a difference.")
public class App implements Runnable {
    @Parameters(index = "0", description = "The name of file to be compared.")
    private String filePath1;
    @Parameters(index = "1", description = "The name of file to be compared.")
    private String filePath2;

//    @Option(names = {"-h",  "--help"}, description = "Show this help message and exit.",
//            names = {"-V", "--version"}, description = "Print version information and exit.")
//    private String help = "Show this help message and exit.";
//    private String version;
//    @Option(names = {"-V", "--version"}, description = "Print version information and exit.")
//    private String version;

    @Override
    public void run() {
        Differ.generate(filePath1, filePath2);
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

}