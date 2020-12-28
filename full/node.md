# Node

## Core Node

1. ### Node Glossary
    node, nvm, npm, npx, Globals(process, __dirname, module, require, global/DONOTUSE, )

2. ### Node commands
```
    nvm --version  
    nvm install 12  
    node --version  
    npm install express --save  
    node //Repl  
    node path/to/your/file.js  
  
    var lib = require('../rel/path/to/lib') //Local  
    var lib = require('lib') //Remote  

    module exports 
```

3. ### Callbacks, Promises, Async Await
```
    // callback takes error as first arg, and result as second  
    doAsyncThing((error, result) => {})

    //Promises  
    doAsyncThing().then(result => {}).catch(error => {})  

    //Async
    const run = async () => {  
    const results = await doAsyncThing() // must return a promise  
        console.log('hello')  
    }  

```

4. ### Debugging
```
    console.log()

    node --inspect
    //Editor integration

```