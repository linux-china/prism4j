# Prism4j

Simplified Java clone of [prism-js](https://github.com/PrismJS/prism). No rendering, no themes,
no hooks, no plugins. But still _a_ language parsing. Primary aim of this library is to provide a _tokenization_ strategy of arbitrary syntaxes for later processing. Works on Android (great with [Markwon](https://github.com/noties/Markwon) - markdown display library). 

## Core

Core module `prism4j` is a lightweight module that comes with API (no language definitions).

[![prism4j](https://img.shields.io/maven-central/v/io.noties/prism4j.svg?label=prism4j)](http://search.maven.org/#search|ga|1|g%3A%22io.noties%22%20AND%20a%3A%22prism4j%22)
       
GAV: 
```
implementation "io.noties:prism4j:${prism_version}"
```

Java Example:

```
final Prism4j prism4j = new Prism4j(new DefaultGrammarLocator());
final Grammar grammar = prism4j.grammar("json");
if (grammar != null) {
    final List<Node> nodes = prism4j.tokenize(code, grammar);
    final AbsVisitor visitor = new AbsVisitor() {
            @Override
            protected void visitText(@NonNull Prism4j.Text text) {
                // raw text
                text.literal();
            }

            @Override
            protected void visitSyntax(@NonNull Prism4j.Syntax syntax) {
                // type of the syntax token
                syntax.type();
                visit(syntax.children());
            }
        };
    visitor.visit(nodes);
}
```


And language definition:

```java
import static java.util.regex.Pattern.CASE_INSENSITIVE;
import static java.util.regex.Pattern.compile;
import static io.noties.prism4j.Prism4j.grammar;
import static io.noties.prism4j.Prism4j.pattern;
import static io.noties.prism4j.Prism4j.token;

@Aliases("jsonp")
public class Prism_json {

  @NonNull
  public static Prism4j.Grammar create(@NonNull Prism4j prism4j) {
    return grammar(
      "json",
      token("property", pattern(compile("\"(?:\\\\.|[^\\\\\"\\r\\n])*\"(?=\\s*:)", CASE_INSENSITIVE))),
      token("string", pattern(compile("\"(?:\\\\.|[^\\\\\"\\r\\n])*\"(?!\\s*:)"), false, true)),
      token("number", pattern(compile("\\b0x[\\dA-Fa-f]+\\b|(?:\\b\\d+\\.?\\d*|\\B\\.\\d+)(?:[Ee][+-]?\\d+)?"))),
      token("punctuation", pattern(compile("[{}\\[\\]);,]"))),
      token("operator", pattern(compile(":"))),
      token("boolean", pattern(compile("\\b(?:true|false)\\b", CASE_INSENSITIVE))),
      token("null", pattern(compile("\\bnull\\b", CASE_INSENSITIVE)))
    );
  }
}
```

Currently, it supports:

* abap
* abnf
* actionscript
* ada
* antlr4
* apacheconf
* applescript
* armasm
* asppnet
* awk
* bash
* nushell
* basic
* batch
* bnf
* c
* clike
* clojure
* cmake
* cobol
* cpp
* csharp
* css
* css-extras
* csv
* dart
* diff
* docker
* dot
* ebnf
* editorconfig
* elixir
* erlang
* fortran
* fsharp
* git
* go
* graphql
* groovy
* haxe
* haskell
* hcl
* http
* ignore
* ini
* java
* javascript
* javastacktrace
* json
* json5
* jsstacktrace
* jsx
* julia
* kotlin
* lisp
* lua
* makefile
* markdown
* markup
* matelab
* mermaid
* nasm
* nginx
* nix
* objectivec
* ocaml
* pascal
* perl
* php
* plant-uml
* plsql
* powershell
* prolog
* properties
* protobuf
* puppet
* python
* r
* regex
* ruby
* rust
* scala
* solidity
* sql
* swift
* systemd
* toml
* tsx
* typescript
* vbnet
* visual-basic
* yaml
* zig
