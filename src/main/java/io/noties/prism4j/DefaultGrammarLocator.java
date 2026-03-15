package io.noties.prism4j;

import io.noties.prism4j.Prism4j.Grammar;
import io.noties.prism4j.Prism4j.Token;
import io.noties.prism4j.languages.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class DefaultGrammarLocator implements GrammarLocator {

  public DefaultGrammarLocator() {
    this(false, null);
  }

  /**
   * Constructor to allow initialization of all languages before requesting them. If you do not
   * want to initialize them, please use {@link #DefaultGrammarLocator()}.
   *
   * @param initLanguages set this to true or use {@link #DefaultGrammarLocator()}
   * @param prism4j       the {@link Prism4j} object
   */
  public DefaultGrammarLocator(boolean initLanguages, @Nullable Prism4j prism4j) {
    if (initLanguages && prism4j != null) {
      for (String i : languages()) {
        grammar(prism4j, i);
      }
    }
  }

  @SuppressWarnings("ConstantConditions")
  private static final Grammar NULL =
    new Grammar() {
      @Override
      public @NotNull String name() {
        return null;
      }

      @Override
      public @NotNull List<Token> tokens() {
        return null;
      }
    };

  private final HashMap<String, Grammar> cache = new HashMap<>(100);

  @Nullable
  @Override
  public Grammar grammar(@NotNull Prism4j prism4j, @NotNull String language) {
    final String name = realLanguageName(language);
    Grammar grammar = cache.get(name);
    if (grammar != null) {
      if (NULL == grammar) {
        grammar = null;
      }
      return grammar;
    }

    grammar = obtainGrammar(prism4j, name);
    cache.put(name, Objects.requireNonNullElse(grammar, NULL));

    return grammar;
  }

  @NotNull
  protected String realLanguageName(@NotNull String name) {
    final String out;
    switch (name) {
      case "kt":
      case "kts":
        out = "kotlin";
        break;
      case "tex":
      case "context":
        out = "latex";
        break;
      case "ts":
        out = "typescript";
        break;
      case "js":
        out = "javascript";
        break;
      case "xml":
      case "html":
      case "mathml":
      case "svg":
        out = "markup";
        break;
      case "dotnet":
        out = "csharp";
        break;
      case "shell":
      case "sh":
        out = "bash";
        break;
      case "py":
        out = "python";
        break;
      case "yml":
        out = "yaml";
        break;
      case "webmanifest":
        out = "json";
        break;
      case "dockerfile":
        out = "docker";
        break;
      case "rb":
        out = "ruby";
        break;
      case "rs":
        out = "rust";
        break;
      case "objc":
        out = "objectivec";
        break;
      case "hs":
        out = "haskell";
        break;
      case "gv":
        out = "dot";
        break;
      case "vb":
      case "vba":
        out = "visual-basic";
        break;
      case "ps1":
      case "psd1":
      case "psm1":
        out = "powershell";
        break;
      case "proto":
        out = "protobuf";
        break;
      case "rbnf":
        out = "bnf";
        break;
      case "gitignore":
      case "hgignore":
      case "npmignore":
        out = "ignore";
        break;
      case "objectpascal":
        out = "pascal";
        break;
      case "sol":
        out = "solidity";
        break;
      case "g4":
        out = "antlr4";
        break;
      case "arm-asm":
        out = "armasm";
        break;
      case "aspx":
        out = "aspnet";
        break;
      case "m":
      case "matlab":
        out = "matlab";
        break;
      case "puml":
        out = "plant-uml";
        break;
      case "gawk":
        out = "awk";
        break;
      case "asppnet":
        out = "aspnet";
        break;
      case "matelab":
        out = "matlab";
        break;
      case "justfile":
        out = "just";
        break;
      default:
        out = name;
    }
    return out;
  }

  @Nullable
  protected Grammar obtainGrammar(@NotNull Prism4j prism4j, @NotNull String name) {
    final Grammar grammar;
    switch (name) {
      case "abap":
        grammar = Prism_abap.create(prism4j);
        break;
      case "abnf":
        grammar = Prism_abnf.create(prism4j);
        break;
      case "actionscript":
        grammar = Prism_actionscript.create(prism4j);
        break;
      case "ada":
        grammar = Prism_ada.create(prism4j);
        break;
      case "antlr4":
        grammar = Prism_antlr4.create(prism4j);
        break;
      case "apacheconf":
        grammar = Prism_apacheconf.create(prism4j);
        break;
      case "applescript":
        grammar = Prism_applescript.create(prism4j);
        break;
      case "armasm":
        grammar = Prism_armasm.create(prism4j);
        break;
      case "aspnet":
        grammar = Prism_aspnet.create(prism4j);
        break;
      case "awk":
        grammar = Prism_awk.create(prism4j);
        break;
      case "bash":
        grammar = Prism_bash.create(prism4j);
        break;
      case "basic":
        grammar = Prism_basic.create(prism4j);
        break;
      case "batch":
        grammar = Prism_batch.create(prism4j);
        break;
      case "bnf":
        grammar = Prism_bnf.create(prism4j);
        break;
      case "c":
        grammar = Prism_c.create(prism4j);
        break;
      case "clike":
        grammar = Prism_clike.create(prism4j);
        break;
      case "clojure":
        grammar = Prism_clojure.create(prism4j);
        break;
      case "cmake":
        grammar = Prism_cmake.create(prism4j);
        break;
      case "cobol":
        grammar = Prism_cobol.create(prism4j);
        break;
      case "cpp":
        grammar = Prism_cpp.create(prism4j);
        break;
      case "csharp":
        grammar = Prism_csharp.create(prism4j);
        break;
      case "csv":
        grammar = Prism_csv.create(prism4j);
        break;
      case "css":
        grammar = Prism_css.create(prism4j);
        break;
      case "css-extras":
        grammar = Prism_css_extras.create(prism4j);
        break;
      case "dart":
        grammar = Prism_dart.create(prism4j);
        break;
      case "diff":
        grammar = Prism_diff.create(prism4j);
        break;
      case "docker":
        grammar = Prism_docker.create(prism4j);
        break;
      case "dot":
        grammar = Prism_dot.create(prism4j);
        break;
      case "ebnf":
        grammar = Prism_ebnf.create(prism4j);
        break;
      case "editorconfig":
        grammar = Prism_editorconfig.create(prism4j);
        break;
      case "elixir":
        grammar = Prism_elixir.create(prism4j);
        break;
      case "erlang":
        grammar = Prism_erlang.create(prism4j);
        break;
      case "fortran":
        grammar = Prism_fortran.create(prism4j);
        break;
      case "fsharp":
        grammar = Prism_fsharp.create(prism4j);
        break;
      case "git":
        grammar = Prism_git.create(prism4j);
        break;
      case "go":
        grammar = Prism_go.create(prism4j);
        break;
      case "graphql":
        grammar = Prism_graphql.create(prism4j);
        break;
      case "groovy":
        grammar = Prism_groovy.create(prism4j);
        break;
      case "haskell":
        grammar = Prism_haskell.create(prism4j);
        break;
      case "haxe":
        grammar = Prism_haxe.create(prism4j);
        break;
      case "hcl":
        grammar = Prism_hcl.create(prism4j);
        break;
      case "http":
        grammar = Prism_http.create(prism4j);
        break;
      case "ignore":
        grammar = Prism_ignore.create(prism4j);
        break;
      case "ini":
        grammar = Prism_ini.create(prism4j);
        break;
      case "java":
        grammar = Prism_java.create(prism4j);
        break;
      case "javastacktrace":
        grammar = Prism_javastacktrace.create(prism4j);
        break;
      case "javascript":
        grammar = Prism_javascript.create(prism4j);
        break;
      case "json":
        grammar = Prism_json.create(prism4j);
        break;
      case "just":
        grammar = Prism_just.create(prism4j);
        break;
      case "json5":
        grammar = Prism_json5.create(prism4j);
        break;
      case "jsstacktrace":
        grammar = Prism_jsstacktrace.create(prism4j);
        break;
      case "jsx":
        grammar = Prism_jsx.create(prism4j);
        break;
      case "julia":
        grammar = Prism_julia.create(prism4j);
        break;
      case "kotlin":
        grammar = Prism_kotlin.create(prism4j);
        break;
      case "latex":
        grammar = Prism_latex.create(prism4j);
        break;
      case "lisp":
        grammar = Prism_lisp.create(prism4j);
        break;
      case "lua":
        grammar = Prism_lua.create(prism4j);
        break;
      case "makefile":
        grammar = Prism_makefile.create(prism4j);
        break;
      case "markdown":
        grammar = Prism_markdown.create(prism4j);
        break;
      case "markup":
        grammar = Prism_markup.create(prism4j);
        break;
      case "matlab":
        grammar = Prism_matlab.create(prism4j);
        break;
      case "mermaid":
        grammar = Prism_mermaid.create(prism4j);
        break;
      case "nasm":
        grammar = Prism_nasm.create(prism4j);
        break;
      case "nginx":
        grammar = Prism_nginx.create(prism4j);
        break;
      case "nix":
        grammar = Prism_nix.create(prism4j);
        break;
      case "objectivec":
        grammar = Prism_objectivec.create(prism4j);
        break;
      case "ocaml":
        grammar = Prism_ocaml.create(prism4j);
        break;
      case "pascal":
        grammar = Prism_pascal.create(prism4j);
        break;
      case "perl":
        grammar = Prism_perl.create(prism4j);
        break;
      case "php":
        grammar = Prism_php.create(prism4j);
        break;
      case "plant-uml":
        grammar = Prism_plant_uml.create(prism4j);
        break;
      case "plsql":
        grammar = Prism_plsql.create(prism4j);
        break;
      case "powershell":
        grammar = Prism_powershell.create(prism4j);
        break;
      case "properties":
        grammar = Prism_properties.create(prism4j);
        break;
      case "prolog":
        grammar = Prism_prolog.create(prism4j);
        break;
      case "protobuf":
        grammar = Prism_protobuf.create(prism4j);
        break;
      case "puppet":
        grammar = Prism_puppet.create(prism4j);
        break;
      case "python":
        grammar = Prism_python.create(prism4j);
        break;
      case "r":
        grammar = Prism_r.create(prism4j);
        break;
      case "regex":
        grammar = Prism_regex.create(prism4j);
        break;
      case "ruby":
        grammar = Prism_ruby.create(prism4j);
        break;
      case "rust":
        grammar = Prism_rust.create(prism4j);
        break;
      case "scala":
        grammar = Prism_scala.create(prism4j);
        break;
      case "solidity":
        grammar = Prism_solidity.create(prism4j);
        break;
      case "sql":
        grammar = Prism_sql.create(prism4j);
        break;
      case "swift":
        grammar = Prism_swift.create(prism4j);
        break;
      case "systemd":
        grammar = Prism_systemd.create(prism4j);
        break;
      case "toml":
        grammar = Prism_toml.create(prism4j);
        break;
      case "tsx":
        grammar = Prism_tsx.create(prism4j);
        break;
      case "typescript":
        grammar = Prism_typescript.create(prism4j);
        break;
      case "vbnet":
        grammar = Prism_vbnet.create(prism4j);
        break;
      case "visual-basic":
        grammar = Prism_visual_basic.create(prism4j);
        break;
      case "yaml":
        grammar = Prism_yaml.create(prism4j);
        break;
      case "zig":
        grammar = Prism_zig.create(prism4j);
        break;
      default:
        grammar = null;
    }
    return grammar;
  }

  @Override
  @NotNull
  public HashSet<String> languages() {
    final HashSet<String> set = new HashSet<>(150);
    set.add("abap");
    set.add("abnf");
    set.add("actionscript");
    set.add("ada");
    set.add("antlr4");
    set.add("apacheconf");
    set.add("applescript");
    set.add("armasm");
    set.add("aspnet");
    set.add("awk");
    set.add("bash");
    set.add("basic");
    set.add("batch");
    set.add("bnf");
    set.add("c");
    set.add("clike");
    set.add("clojure");
    set.add("cmake");
    set.add("cobol");
    set.add("cpp");
    set.add("csharp");
    set.add("csv");
    set.add("css");
    set.add("css-extras");
    set.add("dart");
    set.add("diff");
    set.add("docker");
    set.add("dot");
    set.add("ebnf");
    set.add("editorconfig");
    set.add("elixir");
    set.add("erlang");
    set.add("fortran");
    set.add("fsharp");
    set.add("git");
    set.add("go");
    set.add("graphql");
    set.add("groovy");
    set.add("haskell");
    set.add("haxe");
    set.add("hcl");
    set.add("http");
    set.add("ignore");
    set.add("ini");
    set.add("java");
    set.add("javastacktrace");
    set.add("javascript");
    set.add("json");
    set.add("json5");
    set.add("just");
    set.add("jsstacktrace");
    set.add("jsx");
    set.add("julia");
    set.add("kotlin");
    set.add("latex");
    set.add("lisp");
    set.add("lua");
    set.add("makefile");
    set.add("markdown");
    set.add("markup");
    set.add("matlab");
    set.add("mermaid");
    set.add("nasm");
    set.add("nginx");
    set.add("nix");
    set.add("objectivec");
    set.add("ocaml");
    set.add("pascal");
    set.add("perl");
    set.add("php");
    set.add("plant-uml");
    set.add("plsql");
    set.add("powershell");
    set.add("properties");
    set.add("prolog");
    set.add("protobuf");
    set.add("puppet");
    set.add("python");
    set.add("r");
    set.add("regex");
    set.add("ruby");
    set.add("rust");
    set.add("scala");
    set.add("solidity");
    set.add("sql");
    set.add("swift");
    set.add("systemd");
    set.add("toml");
    set.add("tsx");
    set.add("typescript");
    set.add("vbnet");
    set.add("visual-basic");
    set.add("yaml");
    set.add("zig");
    return set;
  }
}
