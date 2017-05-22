
import java.io.*;
import java.util.regex.Pattern;

public class Crep {
    private String word;
    private String fileName;

    public Crep(String word, String fileName) {
        this.word = word;
        this.fileName = fileName;
    }

    public String paramR() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            final Pattern p = Pattern.compile(word);
            StringBuilder str = new StringBuilder();
            while (line != null) {
                if (p.matcher(line).find()) str.append(line).append("\n");
                line = br.readLine();
            }
            return str.deleteCharAt(str.lastIndexOf("\n")).toString();
        }
    }

    public String paramV() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            StringBuilder str = new StringBuilder();
            while (line != null) {
                if (!line.contains(word)) str.append(line).append("\n");
                line = br.readLine();
            }
            return str.deleteCharAt(str.lastIndexOf("\n")).toString();
        }
    }

    public String paramI() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            StringBuilder str = new StringBuilder();
            while (line != null) {
                if (line.toLowerCase().contains(word.toLowerCase())) str.append(line).append("\n");
                line = br.readLine();
            }
            return str.deleteCharAt(str.lastIndexOf("\n")).toString();
        }
    }
}
