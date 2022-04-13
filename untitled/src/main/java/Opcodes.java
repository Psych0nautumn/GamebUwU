import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Opcodes {
    public static HashMap<String,instruction> Instructions;

    public static HashMap getInstructions() {


        // gets Json file from /home/autumn/IdeaProjects/untitled/src/main/java/
        Reader unprefixedJsonFile = null;
        Reader prefixedJsonFile = null;

        try {
            unprefixedJsonFile = Files.newBufferedReader(Paths.get("C:/Users/Autumn/Documents/untitled/src/main/java/unprefixed.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            prefixedJsonFile = Files.newBufferedReader(Paths.get("C:/Users/Autumn/Documents/untitled/src/main/java/prefixed.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //converts raw Json to HashMap of instructions
        Gson gson = new Gson();
        Type type = new TypeToken<HashMap<String, instruction>>() {
        }.getType();

        HashMap<String, instruction> prefixedInstructionMap = null;
        if (prefixedJsonFile != null) {
            prefixedInstructionMap = gson.fromJson(prefixedJsonFile, type);
        }

        HashMap<String, instruction> unprefixedInstructionMap = null;
        if (unprefixedJsonFile != null) {
            unprefixedInstructionMap = gson.fromJson(unprefixedJsonFile, type);
        }




        HashMap<String, HashMap<String, instruction>> allInstructions = new HashMap<String, HashMap<String, instruction>>();
        allInstructions.put("unprefixed", unprefixedInstructionMap);
        allInstructions.put("prefixed", prefixedInstructionMap);


        return allInstructions;
    }




    static class Operand {
        private boolean immediate;
        private String name;
        private int bytes;
        private int value;
        private String[] adjust = {"+", "-"};


    }


    static class instruction {
        public boolean immediate;
        public Operand[] operands = {};
        public int[] cycles = {};
        public int bytes = 2;
        public String mnemonic;
        public String comment = "";


    }


}
