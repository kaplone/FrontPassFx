package fr.acelys.frontpassfx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class PassCaller {

    public String passCall(int count, int length){
        URLConnection connection = null;
        try {
            connection = new URL("http://localhost:8080/PASS_STRENGTH/pass/" + length + "/" + count).openConnection();
            InputStream is = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }







}
