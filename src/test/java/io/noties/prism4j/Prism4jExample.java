package io.noties.prism4j;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author lihua.llh
 */
public class Prism4jExample {
  public static void main(String[] args) {
    String code = "# DEMO";
    final Prism4j prism4j = new Prism4j(new DefaultGrammarLocator());
    final Prism4j.Grammar grammar = prism4j.grammar("markdown");
    StringBuilder sb = new StringBuilder();
    if (grammar != null) {
      final List<Prism4j.Node> nodes = prism4j.tokenize(code, grammar);
      final AbsVisitor visitor = new AbsVisitor() {

        @Override
        protected void visitText(@NotNull Prism4j.Text text) {
          // raw text
          text.literal();
          sb.append(text.literal());
        }

        @Override
        protected void visitSyntax(@NotNull Prism4j.Syntax syntax) {
          // type of the syntax token
          sb.append("<span class=\"").append(syntax.type()).append("\">");
          visit(syntax.children());
          sb.append("</span>");
        }
      };
      visitor.visit(nodes);
    }
    System.out.println(sb);
  }
}
