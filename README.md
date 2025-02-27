shadow-cljs "release" compilation of the npm lib lexical (0.25.0) produces javascript that throws exceptions in 
the browser.  

The previous version of lexical worked fine (0.24.0), and development builds are ok, but release compilation with any 
optimization level produces js that generates exceptions in the browser from the lexical library code.

To reproduce

```
$ npm install
$ shadow-cljs start
$ shadow-cljs release frontend
```

* In the browser focus the lexical editor widget 
* type some characters 
* then press delete

The console will contain messages like 
```
Uncaught TypeError: Q is not a function...
```

Using Chrome Developer tools to "pause on caught exceptions" shows that the underlying error is  
```
"ReferenceError: Must call super constructor in derived class before accessing 'this' or returning from derived constructor".
``` 

The problem can be fixed by downgrading to lexical 0.24.0 or by using a development build
```
$ shadow-cljs compile frontend
```
