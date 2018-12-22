package services;

import java.util.Map;

public class CommandExecutorService {

    public static boolean isCommandValide(String command){
        return "-w".equals(command) || "-c".equals(command);
    }

    public static Map<String, Long> executeCommand(String command, String text, String token){
        if(!isCommandValide(command))
            throw new IllegalArgumentException("Unsupported command: " + command);
        if("-w".equals(command))
            return WordsCounterService.countWords(text, token);
        if("-c".equals(command))
            return WordsCounterService.countChars(text, token);
        return null;
    }
}
