import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        Map<String, Opcodes.instruction> instructions;
        instructions = Opcodes.getInstructions();

        Loader.loadRom();
    }


}
