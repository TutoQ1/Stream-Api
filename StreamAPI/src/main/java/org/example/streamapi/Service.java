package org.example.streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Service {
    List<String> list = new ArrayList<>();

    public void validate(String string) throws Exception {
        if (string == null || string.isEmpty() || !string.matches("[a-zA-Z]+")) {
            throw new Exception("VALOR INVALIDO, SOLO STRINGS");
        }
        if (list.stream().anyMatch(s -> s.equals(string))){
            throw new RuntimeException("valor repetido");
        }
    }
    public void validate1(String string) throws Exception {
        if (string == null || string.isEmpty() || !string.matches("[a-zA-Z]+")) {
            throw new Exception("VALOR INVALIDO, SOLO STRINGS");
        }
    }

    public void add(String string){
        list.add(string);
    }

    public int amount(){
        return list.size();
    }

    public List<String> show() {
        return list;
    }
    public void delete(String string){
        list.removeIf(String -> String.equals(string));
    }
    public void edit(String oldVal, String newVal){
       list = list.stream().map(s -> s.equals(oldVal)?newVal:s).collect(Collectors.toList());
    }
}
