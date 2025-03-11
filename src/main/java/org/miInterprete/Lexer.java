package org.miInterprete;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Lexer {
  int line;
  int column;
  ArrayList<TokenMatch> tokens;
  Token array[] = {
          new Token("EQUAL", new String[] { "==" }),
          new Token("NOT_EQUAL", new String[] { "!=" }),
          new Token("LESS_EQUAL", new String[] { "<=" }),
          new Token("GREATER_EQUAL", new String[] { ">=" }),
          new Token("LESS", new String[] { "<" }),
          new Token("GREATER", new String[] { ">" }),
          new Token("AND", new String[] { "and" }),
          new Token("OR", new String[] { "or", "\\|\\|" }),
          new Token("NOT", new String[] {"!","not"}),
          new Token("DOUBLE_DOT", new String[] {"\\d+\\.{2}\\d+"}),
          new Token("FLOAT", new String[] {"\\d+\\.\\d+", "\\.\\d+"}),
          new Token("INTEGER", new String[]{"\\d+"}),
          new Token("BOOLEAN", new String[] {"(true|false)"}),
          new Token("STRING", new String[] {"\".*\"","'.*'"}),
          new Token("COMMA", new String[] {","}),
          new Token("NULL", new String[] {"null"}),
          new Token("IDENTIFIER", new String[] {"[a-zA-Z_]\\w*"}),
          new Token("PLUS_ASSIGN", new String[] {"\\+="}),
          new Token("DASH_ASSIGN", new String[] {"-="}),
          new Token("STAR_ASSIGN", new String[] {"\\*="}),
          new Token("SLASH_ASSIGN", new String[]{"/="}),
          new Token("ASSIGN", new String[]{"="}),
          new Token("DOUBLE_STAR", new String[]{"\\*\\*"}),
          new Token("PLUS", new String[]{"\\+"}),
          new Token("DASH", new String[]{"-"}),
          new Token("STAR", new String[]{"\\*"}),
          new Token("SLASH", new String[]{"/"}),
          new Token("LPAREN", new String[]{"\\("}),
          new Token("RPAREN", new String[]{"\\)"}),
          new Token("NEWLINE", new String[]{"\\n"}),
          new Token("WHITESPACE", new String[] {"\\s+"})
  };

  public static void main(String[] args) {
    Lexer lexer = new Lexer();
  }

  Lexer() {
    this.line = 0;
    this.column = 0;
    this.tokens = new ArrayList<>();
  }

  void parse(String line){
    System.out.println(line.length());
    while (this.column < line.length()){
      TokenMatch token = parseLine(line);
      tokens.add(token);
    }
    this.column = 0;
  }

  TokenMatch parseLine(String line) {
    System.out.println(line);
    boolean matched = false;
    for(Token token: array){
      for(Pattern pattern: token.patterns){
        Matcher matcher = pattern.matcher(line);
        matcher.region(this.column,line.length());
        if(matcher.lookingAt()){
          String value = matcher.group();
          int copy_col = this.column;
          this.column += value.length();
          if(!token.type.equals("WHITESPACE")){
            return new TokenMatch(token.type, value, copy_col, this.line);
          } else if (token.type.equals("WHITESPACE")) {
            return parseLine(line);
          }
          matched = true;
          break;
        }
      }
      if (matched) break;
    }
    if (!matched){
      throw new RuntimeException(String.format("error de sintaxis en tu programa en linea %d, columna",this.line,this.column));
    }
    return null;
  }
}
