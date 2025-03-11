package org.miInterprete;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Token {
    String type;
    Pattern[] patterns;
    Token(String type, String[] patterns){
        // map the String[] patterns to an array of Pattern
        this.patterns = Arrays.stream(patterns).map(Pattern::compile).toArray(Pattern[]::new);
        this.type = type;
    }

    public String toString(){
        return "Token(type="+ type +", patterns="+ Arrays.toString(patterns) +")";
    }

}
