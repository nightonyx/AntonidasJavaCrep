
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

import java.io.IOException;


public class CrepLauncher {
    @Option(name = "-v", usage = "Вывод не соответствия")
    public static boolean v;

    @Option(name = "-i", usage = "Игнорируем регистр слов")
    public static boolean i;

    @Option(name = "-r", usage = "Задаём регулярное выражение")
    public static boolean r;

    @Argument(required = true, metaVar = "word", usage = "Задаём регуляреное слово")
    public static String word;

    @Argument(required = true, metaVar = "inputname", index = 1, usage = "Имя входного файла")
    public static String fileName;

    public static void main(String[] args) throws IOException {
        new CrepLauncher().launch(args);
    }

    public void launch(String[] args) {
//        CrepLauncher crepLauncher = new CrepLauncher();
        CmdLineParser parser = new CmdLineParser(this);

        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("crep [-paramV] [-paramI] [-paramR]");
            parser.printUsage(System.err);
            return;
        }
        Crep crep = new Crep(word, fileName);
        try {
            if (r) System.out.println(crep.paramR());
            if (v) System.out.println(crep.paramV());
            if (i) System.out.println(crep.paramI());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
