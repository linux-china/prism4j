package io.noties.prism4j;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Prism4jExample {
  public static void main(String[] args) {
    String language = "java";
    String code = "public class Hello { public static void main(String[] args) { System.out.println(\"Hello world!\"); } }";
    final Prism4j prism4j = new Prism4j(new DefaultGrammarLocator());
    final Prism4j.Grammar grammar = prism4j.grammar("java");
    StringBuilder sb = new StringBuilder();
    // add prism html structure
    sb.append(String.format("<pre class=\"language-%s\"><code class=\"language-%s\">\n", language, language));
    if (grammar != null) {
      final List<Prism4j.Node> nodes = prism4j.tokenize(code, grammar);
      final AbsVisitor visitor = new AbsVisitor() {

        @Override
        protected void visitText(@NotNull Prism4j.Text text) {
          // raw text
          sb.append(text.literal());
        }

        @Override
        protected void visitSyntax(@NotNull Prism4j.Syntax syntax) {
          // type of the syntax token
          final String tokenType = syntax.type();
          sb.append("<span class=\"token ").append(tokenType).append("\">");
          visit(syntax.children());
          sb.append("</span>");
        }
      };
      visitor.visit(nodes);
    }
    sb.append("\n</code></pre>");
    System.out.println(sb);
  }
}
