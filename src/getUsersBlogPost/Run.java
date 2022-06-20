package getUsersBlogPost;

import com.fasterxml.jackson.core.JsonProcessingException;

public class Run {
    public static void main(String[] args) throws JsonProcessingException {
        ReadJSONFile readJSONFile = new ReadJSONFile();
        readJSONFile.read(FilePath.JSONFILE.value);
    }
}
