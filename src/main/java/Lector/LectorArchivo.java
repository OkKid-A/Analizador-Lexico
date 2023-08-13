package main.java.Lector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class LectorArchivo {

    private Reader lectorBase;
    private BufferedReader lectorBuff;

    public LectorArchivo() {
    }

    public char[] fetchFullText(String filePath){
        String leida = "";
        char[] leidaPartida = null;
        try {
            Path fileAsPath = Path.of(filePath);
            leida = Files.readString(fileAsPath);
            leidaPartida = leida.toCharArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return leidaPartida;
    }
}
