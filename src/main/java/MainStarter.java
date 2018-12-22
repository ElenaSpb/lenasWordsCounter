import java.io.IOException;
import java.util.Map;
import services.CommandExecutorService;
import services.FileService;

public class MainStarter {

    public static void main(String[] args) {
        String fileName, subStrings, command, content;
        if(args.length >= 3) {
            fileName = args[0];
            subStrings = args[1];
            command = args[2];
            System.out.println("filename=" + fileName + " subStrings=" + subStrings + " command=" + command);
        }
        else {
            System.out.println("Please enter fileName subStrings command");
            System.out.println("Example: java –jar scraper.jar sample.txt state,New –v –w –c –e");
            return;
        }

        try {
            content = FileService.getContent(fileName);
        } catch (IOException e) {
            System.out.println("Error while reading this file");
            e.printStackTrace();
            return;
        }

        Map<String, Long> result = CommandExecutorService.executeCommand(command, content, subStrings);
        System.out.println("Count of " + subStrings + " in file = " + result);
    }


}
