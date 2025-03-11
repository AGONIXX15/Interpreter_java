package org.miInterprete;

public class TokenMatch {
    String type;
    String value;
    int column;
    int line;
    TokenMatch(String type, String value, int column, int line) {
        this.type = type;
        this.value = value;
        this.column = column;
        this.line = line;
    }

    public String toString(){
        return String.format("TokenMatch(type=%s, value=\"%s\", column=%d, line=%d)", type, value, column, line);
    }
}
