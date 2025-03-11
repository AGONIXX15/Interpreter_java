package org.miInterprete;

import java.util.ArrayList;
import java.util.Map;

public class Lexer {
  int line;
  int column;
  ArrayList<Token> Tokens;
  Token array[] = {
          new Token("EQUAL", new String[] { "==" }),
          new Token("NOT_EQUAL", new String[] { "!=" }),
          new Token("LESS_EQUAL", new String[] { "<=" }),
          new Token("GREATER_EQUAL", new String[] { ">=" }),
          new Token("LESS", new String[] { "<" }),
          new Token("GREATER", new String[] { ">" }),
          new Token("AND", new String[] { "and" }),
          new Token("OR", new String[] { "or", "||" }),
          new Token("NOT", new String[] {"!","not"}),
          new Token("DOUBLE_DOT", new String[] {"\\d+\\.{2}\\d+"}),
          new Token("FLOAT", new String[] {"\\d+\\.\\d+", "\\.\\d+"}),
          new Token("INTEGER", new String[]{"\\d+"}),
          new Token("BOOLEAN", new String[] {"true|false"}),
          new Token("STRING", new String[] {"\".*\"","'.*'"}),
          new Token("COMMA", new String[] {","}),
          new Token("NULL", new String[] {"null"}),
          new Token("IDENTIFIER", new String[] {"[a-zA-Z_]\\w*"}),
          new Token("PLUS_ASSIGN", new String[] {"\\+="}),
          new Token("DASH_ASSIGN", new String[] {"\\-="}),
          new Token("STAR_ASSIGN", new String[] {"\\*="}),
          new Token("SLASH_ASSIGN", new String[]{"\\/="}),
          new Token("ASSIGN", new String[]{"="}),
          new Token("DOUBLE_STAR", new String[]{"\\*\\*"}),
          new Token("PLUS", new String[]{"\\+"}),
          new Token("DASH", new String[]{"-"}),
          new Token("STAR", new String[]{"\\*"}),
          new Token("SLASH", new String[]{"\\/"}),
          new Token("LPAREN", new String[]{"("}),
          new Token("RPAREN", new String[]{")"}),
          new Token("NEWLINE", new String[]{"\\n"}),
          new Token("WHITESPACE", new String[] {"\\s+"})
  };

  Lexer() {
  }

  void parseLine(String line) {

    return;
  }
}
