package org.miInterprete;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Token {
    String type;
    Pattern[] patterns;
    private String value;
    Token(String type, String[] patterns){
        // map the String[] patterns to an array of Pattern
        this.patterns = Arrays.stream(patterns).map(x -> Pattern.compile(Pattern.quote(x))).toArray(Pattern[]::new);
        this.type = type;
    }

    void setValue(String value){
        this.value = value;
    }

    String getValue(){
        return this.value;
    }
}
