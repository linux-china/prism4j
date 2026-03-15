Prism4j
==========

Simplified Java clone of prism-js. No rendering, no themes, no hooks, no plugins. But still a language parsing.
Primary aim of this library is to provide a tokenization strategy of arbitrary syntaxes for later processing.

# Migration

If language name is `xxx`:

- JavaScript implementation: `components/prism-xxx.js`
- Java implementation: `src/main/java/io/noties/prism4j/languages/Prism_xxx.java`
- Language registration: `src/main/java/io/noties/prism4j/DefaultGrammarLocator.java`

Please refer language's JavaScript implementation, and create or update Java implementation.

     
# languages

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
