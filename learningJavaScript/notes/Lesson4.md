## 错误处理

错误处理是语言中很重要的成分。

错误分两种，一种是程序逻辑错误，对于这种错误，修复程序。另一种错误是在执行过程中，程序遇到无法预测（准确地说，是知道可能会发生错误，但不知道发生哪一种以及何时发生）的异常情况报错，比如网络连接中断、读取不存在的文件、没有操作权限等，对于这种错误，我们需要处理，可能还需要返回错误信息。

对于原始的语言，错误通过错误码返回，比如：

```C
int fd = open("/path/to/file", O_RDONLY);
if (fd == 1) {
    printf("Error when opening file!\n");
}
else {
    // TODO
}
```

这种写法的好处在于不需要额外的错误处理机制，坏处是手动处理返回值往往是一件很麻烦的事，并且返回值的意义需要提前约定。显然，这里的好处是微不足道的，坏处却能是使得编码过程变得相当复杂，所以高级语言提供了更抽象（抽象往往意味着高级）的错误处理逻辑，比如`try-catch-finally`。

### `try...catch...finally`

有如下代码：

```JavaScript
var r1, r2, s = null;
try {
    r1 = s.length; // 此处应产生错误
    r2 = 100; // 该语句不会执行
} catch (e) {
    console.log('出错了：' + e);
} finally {
    console.log('finally');
}
console.log('r1 = ' + r1); // r1应为undefined
console.log('r2 = ' + r2); // r2应为undefined
```

运行后提示"出错了：TypeError: Cannot read property 'length' of null"，于是我们发现这里`try...catch-finally`的执行流程和`Java`中的并无二致，具体地说就是：

当代码块被`try { ... }`包裹的时候，就表示这部分代码执行过程中可能会发生错误，一旦发生错误，就不再继续执行后续代码，转而跳到`catch`块。`catch (e) { ... }`包裹的代码就是错误处理代码，变量`e`表示捕获到的错误。最后，无论有没有错误，`finally`一定会被执行。

再具体一点，有错误发生时，执行流程是这样的：

1. 
2. 
3. 

没有错误发生时，则如下：

1. 
2. 
3. 

最后说一句，`catch(e) {...}`和`finally {...}`都可以省略，下面的写法都是对的：

```JavaScript
try {
    ...
} catch (e) {
    ...
} finally {
    ...
}
```

```JavaScript
try {
    ...
} catch (e) {
    ...
}
```

```JavaScript
try {
    ...
} finally {
    ...
}
```

#### 错误类型

JavaScript有一个标准的`Error`对象表示错误，还有从`Error`派生的`TypeError`和`ReferenceError`等错误对象，在处理错误时通过`catch(e)`捕获`e`访问错误对象：

```JavaScript
try {
    ...
} catch (e) {
    if (e instanceof TypeError) {
        alert('Type error!');
    } else if (e instanceof Error) {
        alert(e.message);
    } else {
        alert('Error: ' + e);
    }
}
```

`e`是一个习惯用法，当然可以用其他变量命名。

#### 抛出错误

程序可以主动抛出一个错误让执行流程直接跳转到`catch`块，抛出错误使用`throw`语句。

举个例子，用户输入一个数字（程序接收到的是字符串，用`praseInt()`转换成整数），当用户输入不合法时，抛出错误：

```JavaScript
var r, n, s;
try {
    s = prompt('请输入一个数字');
    n = parseInt(s);
    if (isNaN(n)) {
        throw new Error('输入错误');
    }
    // 计算平方:
    r = n * n;
    console.log(n + ' * ' + n + ' = ' + r);
} catch (e) {
    console.log('出错了：' + e);
}
```

事实上JavaScript允许抛出任意对象，但最好使用Error对象。当用catch捕捉错误时，一定要编写错误处理语句，否则不知道程序执行过程中到底有没有错误。处理错误时不要简单粗暴地把错误信息显示给用户，这里只是为了演示方便。

### 错误传播

下面讨论如果代码发生了错误而没有被`try...catch`捕获的情况，示例代码如下：

```JavaScript
function getLength(s) {
    return s.length;
}

function printLength() {
    console.log(getLength('abc')); // 3
    console.log(getLength(null)); // Error!
}

printLength();
```

如果在一个函数内部发生了错误，它自身没有捕获，错误就会被抛到外层调用函数，如果外层函数也没有捕获，该错误会一直沿着函数调用链向上抛出，直到被JavaScript引擎捕获，代码终止执行。所以，我们不必在每一个函数内部捕获错误，只需要在合适的地方来个统一捕获：

```JavaScript
function main(s) {
    console.log('BEGIN main()');
    try {
        foo(s);
    } catch (e) {
        console.log('出错了：' + e);
    }
    console.log('END main()');
}

function foo(s) {
    console.log('BEGIN foo()');
    bar(s);
    console.log('END foo()');
}

function bar(s) {
    console.log('BEGIN bar()');
    console.log('length = ' + s.length);
    console.log('END bar()');
}

main(null);
```

当`bar()`函数传入参数`null`时，代码会报错，错误会向上抛给调用方`foo()`函数，`foo()`函数没有`try ... catch`语句，所以错误继续向上抛给调用方`main()`函数，`main()`函数有`try ... catch`语句，所以错误最终在`main()`函数被处理了。

至于在哪些地方捕获错误比较合适，需要视情况而定。

### 异步错误处理

这部分不是必须的。

编写JavaScript代码时，我们要时刻牢记，JavaScript引擎是一个事件驱动的执行引擎，代码总是以单线程执行，而回调函数的执行需要等到下一个满足条件的事件出现后，才会被执行。

比如`setTimeout()`函数可以传入回调函数，并在指定的时间后执行：

```JavaScript
function printTime() {
    console.log('It is time!');
}

setTimeout(printTime, 1000);
console.log('done');
```

上面的代码会先打印`done`，一秒后打印`It is time!`。如果`printTime()`函数内部发生错误，用`try`包裹住`setTimeout()`并没有什么用：

```JavaScript
function printTime() {
    throw new Error();
}

try {
    setTimeout(printTime, 1000);
    console.log('done');
} catch (e) {
    console.log('error');
}
```

原因就在于调用`setTimeout()`函数时，传入的`printTime`函数并未立刻执行！紧接着，JavaScript引擎会继续执行`console.log('done');`语句，而此时并没有错误发生。直到1秒钟后，执行`printTime`函数时才发生错误，但此时除了在`printTime`函数内部捕获错误外，外层代码并无法捕获。

所以，涉及到异步代码，无法在调用时捕获，原因就是在捕获的当时，回调函数并未执行。