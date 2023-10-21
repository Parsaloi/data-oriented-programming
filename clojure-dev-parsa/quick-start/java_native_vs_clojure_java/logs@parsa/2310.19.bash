Clojure 1.11.1
user=> (def visitors (atom #{}))
#'user/visitors
user=> (defn yello 
"Writes yello message to *out*. Calls me by username. Knows if I have been here before."
[username]
(swap! visitors conj username)
(str "Yello, " username))
#'user/yello
user=> (yello "Parsa")
"Yello, Parsa"
user=> (yello "Loi")
"Yello, Loi"
user=> (yello "Clojurian Parsaloi")
"Yello, Clojurian Parsaloi"
user=> @visitors
#{"Clojurian Parsaloi" "Loi" "Parsa"}
user=> (println("Atoms and all other Clojure reference types are safe for multiple threads and processors. Better yet, this safety comes without any need for locks, which are notoriously tricky to use"))
Execution error (ClassCastException) at user/eval145 (REPL:1).
class java.lang.String cannot be cast to class clojure.lang.IFn (java.lang.String is in module java.base of loader 'bootstrap'; clojure.lang.IFn is in unnamed module of loader 'app')
user=> (println "Atoms and all other Clojure reference types are safe for multiple threads and processors. Better yet, this safety comes without any need for locks, which are notoriously tricky to use")
Atoms and all other Clojure reference types are safe for multiple threads and processors. Better yet, this safety comes without any need for locks, which are notoriously tricky to use
nil
user=> (require 'clojure.java.io)
nil
user=> (System/currentTimeMillis())
Syntax error (IllegalArgumentException) compiling . at (REPL:1:1).
No matching method currentTimeMillis found taking 1 args for class java.lang.System
user=> (System/currentTimeMillis)
1697725363602
user=> (System/getProperty)
Syntax error (IllegalArgumentException) compiling . at (REPL:1:1).
No matching method getProperty found taking 0 args for class java.lang.System
user=> (System/getProperties)
{"java.specification.version" "17", "sun.jnu.encoding" "UTF-8", "java.class.path" "src:/home/parsa/.m2/repository/org/clojure/clojure/1.11.1/clojure-1.11.1.jar:/home/parsa/.m2/repository/org/clojure/core.specs.alpha/0.2.62/core.specs.alpha-0.2.62.jar:/home/parsa/.m2/repository/org/clojure/spec.alpha/0.3.218/spec.alpha-0.3.218.jar", "java.vm.vendor" "GraalVM Community", "sun.arch.data.model" "64", "java.vendor.url" "https://www.graalvm.org/", "user.timezone" "Africa/Nairobi", "clojure.basis" "/home/parsa/.clojure/.cpcache/2839024066.basis", "java.vm.specification.version" "17", "os.name" "Linux", "sun.java.launcher" "SUN_STANDARD", "user.country" "US", "sun.boot.library.path" "/home/parsa/.sdkman/candidates/java/17.0.8-graalce/lib", "sun.java.command" "clojure.main", "jdk.debug" "release", "sun.cpu.endian" "little", "user.home" "/home/parsa", "user.language" "en", "sun.stderr.encoding" "UTF-8", "java.specification.vendor" "Oracle Corporation", "java.version.date" "2023-07-18", "java.home" "/home/parsa/.sdkman/candidates/java/17.0.8-graalce", "file.separator" "/", "java.vm.compressedOopsMode" "32-bit", "jdk.internal.vm.ci.enabled" "true", "line.separator" "\n", "sun.stdout.encoding" "UTF-8", "java.vm.specification.vendor" "Oracle Corporation", "java.specification.name" "Java Platform API Specification", "sun.management.compiler" "HotSpot 64-Bit Tiered Compilers", "java.runtime.version" "17.0.8+7-jvmci-23.0-b15", "user.name" "parsa", "path.separator" ":", "os.version" "6.5.5-1-MANJARO", "java.runtime.name" "OpenJDK Runtime Environment", "file.encoding" "UTF-8", "java.vm.name" "OpenJDK 64-Bit Server VM", "java.vendor.version" "GraalVM CE 17.0.8+7.1", "java.vendor.url.bug" "https://github.com/oracle/graal/issues", "java.io.tmpdir" "/tmp", "java.version" "17.0.8", "user.dir" "/home/parsa/Documents/creatorp/mini-projects/data-oriented-programming/clojure-dev-parsa/quick-start/java_native_vs_clojure_java", "os.arch" "amd64", "java.vm.specification.name" "Java Virtual Machine Specification", "native.encoding" "UTF-8", "java.library.path" "/usr/java/packages/lib:/usr/lib64:/lib64:/lib:/usr/lib", "java.vm.info" "mixed mode, sharing", "java.vendor" "GraalVM Community", "java.vm.version" "17.0.8+7-jvmci-23.0-b15", "sun.io.unicode.encoding" "UnicodeLittle", "java.class.version" "61.0"}
user=> (doc str)
-------------------------
clojure.core/str
([] [x] [x & ys])
  With no args, returns the empty string. With one arg x, returns
  x.toString().  (str nil) returns the empty string. With more than
  one arg, returns the concatenation of the str values of the args.
nil
user=> (find-doc "reduce")
-------------------------
clojure.core.protocols/CollReduce
  Protocol for collection types that can implement reduce faster than
  first/next recursion. Called by clojure.core/reduce. Baseline
  implementation defined in terms of Iterable.
-------------------------
clojure.core.protocols/IKVReduce
  Protocol for concrete associative types that can reduce themselves
   via a function of key and val faster than first/next recursion over map
   entries. Called by clojure.core/reduce-kv, and has same
   semantics (just different arg order).
-------------------------
clojure.core.protocols/InternalReduce
  Protocol for concrete seq types that can reduce themselves
   faster than first/next recursion. Called by clojure.core/reduce.
-------------------------
clojure.core.protocols/interface-or-naive-reduce
([coll f val])
  Reduces via IReduceInit if possible, else naively.
-------------------------
clojure.core.protocols/naive-seq-reduce
([s f val])
  Reduces a seq, ignoring any opportunities to switch to a more
  specialized implementation.
-------------------------
clojure.core/areduce
([a idx ret init expr])
Macro
  Reduces an expression across an array a, using an index named idx,
  and return value named ret, initialized to init, setting ret to the 
  evaluation of expr at each step, returning ret.
-------------------------
clojure.core/eduction
([xform* coll])
  Returns a reducible/iterable application of the transducers
  to the items in coll. Transducers are applied in order as if
  combined with comp. Note that these applications will be
  performed every time reduce/iterator is called.
-------------------------
clojure.core/ensure-reduced
([x])
  If x is already reduced?, returns it, else returns (reduced x)
-------------------------
clojure.core/reduce
([f coll] [f val coll])
  f should be a function of 2 arguments. If val is not supplied,
  returns the result of applying f to the first 2 items in coll, then
  applying f to that result and the 3rd item, etc. If coll contains no
  items, f must accept no arguments as well, and reduce returns the
  result of calling f with no arguments.  If coll has only 1 item, it
  is returned and f is not called.  If val is supplied, returns the
  result of applying f to val and the first item in coll, then
  applying f to that result and the 2nd item, etc. If coll contains no
  items, returns val and f is not called.
-------------------------
clojure.core/reduce-kv
([f init coll])
  Reduces an associative collection. f should be a function of 3
  arguments. Returns the result of applying f to init, the first key
  and the first value in coll, then applying f to that result and the
  2nd key and value, etc. If coll contains no entries, returns init
  and f is not called. Note that reduce-kv is supported on vectors,
  where the keys will be the ordinals.
-------------------------
clojure.core/reduced
([x])
  Wraps x in a way such that a reduce will terminate with the value x
-------------------------
clojure.core/reduced?
([x])
  Returns true if x is the result of a call to reduced
-------------------------
clojure.core/reductions
([f coll] [f init coll])
  Returns a lazy seq of the intermediate values of the reduction (as
  per reduce) of coll by f, starting with init.
-------------------------
clojure.core/require
([& args])
  Loads libs, skipping any that are already loaded. Each argument is
  either a libspec that identifies a lib, a prefix list that identifies
  multiple libs whose names share a common prefix, or a flag that modifies
  how all the identified libs are loaded. Use :require in the ns macro
  in preference to calling this directly.

  Libs

  A 'lib' is a named set of resources in classpath whose contents define a
  library of Clojure code. Lib names are symbols and each lib is associated
  with a Clojure namespace and a Java package that share its name. A lib's
  name also locates its root directory within classpath using Java's
  package name to classpath-relative path mapping. All resources in a lib
  should be contained in the directory structure under its root directory.
  All definitions a lib makes should be in its associated namespace.

  'require loads a lib by loading its root resource. The root resource path
  is derived from the lib name in the following manner:
  Consider a lib named by the symbol 'x.y.z; it has the root directory
  <classpath>/x/y/, and its root resource is <classpath>/x/y/z.clj, or
  <classpath>/x/y/z.cljc if <classpath>/x/y/z.clj does not exist. The
  root resource should contain code to create the lib's
  namespace (usually by using the ns macro) and load any additional
  lib resources.

  Libspecs

  A libspec is a lib name or a vector containing a lib name followed by
  options expressed as sequential keywords and arguments.

  Recognized options:
  :as takes a symbol as its argument and makes that symbol an alias to the
    lib's namespace in the current namespace.
  :as-alias takes a symbol as its argument and aliases like :as, however
    the lib will not be loaded. If the lib has not been loaded, a new
    empty namespace will be created (as with create-ns).
  :refer takes a list of symbols to refer from the namespace or the :all
    keyword to bring in all public vars.

  Prefix Lists

  It's common for Clojure code to depend on several libs whose names have
  the same prefix. When specifying libs, prefix lists can be used to reduce
  repetition. A prefix list contains the shared prefix followed by libspecs
  with the shared prefix removed from the lib names. After removing the
  prefix, the names that remain must not contain any periods.

  Flags

  A flag is a keyword.
  Recognized flags: :reload, :reload-all, :verbose
  :reload forces loading of all the identified libs even if they are
    already loaded (has no effect on libspecs using :as-alias)
  :reload-all implies :reload and also forces loading of all libs that the
    identified libs directly or indirectly load via require or use
    (has no effect on libspecs using :as-alias)
  :verbose triggers printing information about each load, alias, and refer

  Example:

  The following would load the libraries clojure.zip and clojure.set
  abbreviated as 's'.

  (require '(clojure zip [set :as s]))
-------------------------
clojure.core/run!
([proc coll])
  Runs the supplied procedure (via reduce), for purposes of side
  effects, on successive items in the collection. Returns nil
-------------------------
clojure.core/transduce
([xform f coll] [xform f init coll])
  reduce with a transformation of f (xf). If init is not
  supplied, (f) will be called to produce it. f should be a reducing
  step function that accepts both 1 and 2 arguments, if it accepts
  only 2 you can add the arity-1 with 'completing'. Returns the result
  of applying (the transformed) xf to init and the first item in coll,
  then applying xf to that result and the 2nd item, etc. If coll
  contains no items, returns init and f is not called. Note that
  certain transforms may inject or skip items.
-------------------------
clojure.core/unreduced
([x])
  If x is reduced?, returns (deref x), else returns x
nil
user=> (require '{clojure.repl :refer [source]])
Syntax error reading source at (REPL:20:41).
Unmatched delimiter: ]
Syntax error reading source at (REPL:20:42).
Unmatched delimiter: )
user=> (require '[clojure.repl :refer [source]])
nil
user=> (source identity)
(defn identity
  "Returns its argument."
  {:added "1.0"
   :static true}
  [x] x)
nil
user=> (+ 2 3)
5
user=>
