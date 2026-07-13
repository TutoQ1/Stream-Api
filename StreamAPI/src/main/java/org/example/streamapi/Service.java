package org.example.streamapi;

import java.util.ArrayList;
import java.util.List;

public class Service {
    List<String> list = new ArrayList<>();

    public void add(String string) throws Exception {
        if (string == null || string.isEmpty() || !string.matches("[a-zA-Z]+")) {
            throw new Exception("VALOR INVALIDO, SOLO STRINGS");
        }
        list.add(string);
    }

    public List<String> show() {
        return list.stream().sorted(String::compareTo).toList();
    }
}
