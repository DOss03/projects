/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typewriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rajar
 */
public class Filereader {
    private final java.io.File file;

    public Filereader(final java.io.File file) {
        this.file = file;
    }

    public String getText() {
        String text = "";
        try {
            text = new String(Files.readAllBytes(file.toPath()));
        } catch (IOException ex) {
            Logger.getLogger(Filereader.class.getName()).log(Level.SEVERE, null, ex);
        }

        return text;
    }
}
