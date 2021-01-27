# learning JavaScript

## 简介

- 为什么要学JavaScript
    > 在Web世界里，只有JavaScript能跨平台、跨浏览器驱动网页，与用户交互。JavaScript一度被认为是一种玩具编程语言，它有很多缺陷，所以不被大多数后端开发人员所重视。很多人认为，写JavaScript代码很简单，并且JavaScript只是为了在网页上添加一点交互和动画效果。但这是完全错误的理解。JavaScript确实很容易上手，但其精髓却不为大多数开发人员所熟知。编写高质量的JavaScript代码更是难上加难。一个合格的开发人员应该精通JavaScript和其他编程语言。如果你已经掌握了其他编程语言，或者你还什么都不会，请立刻开始学习JavaScript，不要被Web时代所淘汰。
- [JS的历史，ECMAECMAScript和JS版本看这里](intro-to-JS.md)
- HTML，CSS与JS
    - HTML：HyperText Markup Language，用于页面元素布局
    - CSS：Cascading Style Sheets，用于页面元素装饰
    - JavaScript：控制元素的行为，主要用于DOM处理

## 语法

### 一些最基本的东西

- 浏览器和文本编辑器/IDE
    - 建议的浏览器：Firefox、Chrome、Edge都可以
    - 不建议的浏览器：IE、360、QQ、2345、猎豹...你们懂的
    - 建议的文本编辑器/IDE：VScode、Sublime Text、Notepad++、IDEA、WebStorm
    - 不能用：Word、记事本...
- “跑起来”
     - 直接嵌在网页的任何部分
     - 直接写在`<head>`里
     - 写单独的`.js`文件，在HTML文件中引用
     - 交互式运行
     - `<script type="text/javascript">`：可以但没必要
- 语句和代码块
    - 语句结尾写封号`;`
    - 代码块用花括号`{}`组织，但仍然要注意缩进
- 注释
    - 单行注释`\\`
    - 多行注释`\**\`

举几个例子：

这是一个（赋值）语句：

```JavaScript
var x = 0;
```

下面的语句仅包含一个字符串，但确实是一个完整的语句：

```JavaScript
'Hello World';
```

下面的一行包含两个语句，每个语句用`;`结束，不要在一行中写多个语句：

```JavaScript
var x = 0; var y = 1;
```

这是一个语句块：

```JavaScript
if (x > y) {
    [x, y] = [y, x];
}
```

这也是一个语句块，展示了语句块的嵌套，注意缩进：

```JavaScript
for (i = 0; i < 100; i++) {
    if (i % 2 === 0) {
        console.log(i);
    }
}
```

关于注释：

```JavaScript
// 这是一个注释
alert("hello"); // 这也是一个注释
/* 这还是一个注释 */
/* 这依然是一个注释
这个注释可以写多行
*/
```

### 数据类型与变量

#### 变量

变量本质上是内存中的一块空间，在JavaScript中用一个变量名表示，变量名是大小写英文、数字、`$`和`_`的组合，且不能用数字开头。变量名也不能是JavaScript的关键字，如`if`、`while`等。变量名可以用中文，但请不要给自己找麻烦。申明一个变量用`var`语句，用`=`赋值：

```JavaScript
var a;
var b = 1;
var answer = true;
var t = null;
```

可以把任意数据类型赋值给变量，同一个变量可以反复赋值，而且可以是不同类型的变量，但是只能用`var`申明一次，这种变量本身类型不固定的语言称之为动态语言，JS显然是是动态语言：

```JavaScript
var a = 123;
a = 'A';
```

JavaScript在设计之初，为了方便初学者学习，并不强制要求用`var`申明变量，如果一个变量没有通过`var`声明就被使用，那么该变量就自动被申明为全局变量，这样的设计的结果就是很容易导致变量相互影响，产生难以调试的错误。为了修补JavaScript这一严重设计缺陷，ECMA在后续规范中推出了strict模式，在strict模式下运行的JavaScript代码，强制通过var申明变量，未使用var声明变量就使用的，将导致运行错误。

启用strict模式的方法是在JavaScript代码的第一行写上：

```JavaScript
'use strict';
```

#### 数据类型与运算

JS中定义了如下几种数据类型：

- Number
- 字符串
- 布尔值
- 空值：null和undefined
- 数组
- 对象

一个一个讨论：

##### Number

JS不区分整数和浮点数，下面的都是合法Number类型

```JavaScript
123;
0.123;
1.23e6;
-99;
NaN; // Not a number，表示无法计算的结果，比如 0 / 0
Infinity; // 无穷大，当数值超过了JavaScript的Number所能表示的最大值时，表示为Infinity，比如 2 / 0
0xff00; // 十六进制用0x前缀和0-9，a-f表示
```

Number可以做运算，如：

```JavaScript
1 + 2; // 3
(1 + 2) * 5 / 2; // 7.5
2 / 0; // Infinity
0 / 0; // NaN
10 % 3; // 1
10.5 % 3; // 1.5
```

Number可以比较，结果是一个布尔值：

```JavaScript
2 > 5; // false
5 >= 2; // true
7 == 7; // true
```

特别注意相等运算符有两种：

第一种是`==`比较，它会自动转换数据类型再比较，很多时候，会得到非常诡异的结果；

第二种是`===`比较，它不会自动转换数据类型，如果数据类型不一致，返回false，如果一致，再比较，始终使用这一种进行整数的比较

浮点数在计算过程中会产生误差，所以不能直接比较：

```JavaScript
1 / 3 === (1 - 2 / 3); // false
```

应该这么比：

```JavaScript
Math.abs(1 / 3 - (1 - 2 / 3)) < 0.0000001; // true
```

NaN与所有其他值都不相等，包括它自己：

```JavaScript
NaN === NaN; // false
```

好在有`isNaN()`函数：

```JavaScript
isNaN(NaN); // true
```

##### 字符串

字符串是以单引号'或双引号"括起来的任意文本，如：

```JavaScript
"abc"
'abc'
'a' // 这是一个字符串
```

字符串转义：

既然`'`和`"`都可以表示字符串，那么某些简单的场合不需要转义：

```JavaScript
"I' m a student"; // 单双引号交替使用
```

但要显示这种内容：

```
I'm "OK"
```

就需要用到转义字符`\`：

```JavaScript
'\'';
'\"';
'\n';
'\\';
```

转义字符有如下用法：

```JavaScript
'\x41'; //ASCII字符可以以\x##形式的十六进制表示
'\u4e2d\u6587'; //用\u####表示一个Unicode字符
```

多行字符串：

多行字符用反引号`表示

```JavaScript
`这
是一个
多行字符`
```

模板字符串：

先讨论字符串拼接，用`+`即可：

```JavaScript
var name = '小明';
var age = 20;
var message = '你好, ' + name + ', 你今年' + age + '岁了!';
alert(message);
```

如果有很多变量需要连接，用`+`号就比较麻烦。ES6新增了一种模板字符串，表示方法和上面的多行字符串一样，但是它会自动替换字符串中的变量：

```JavaScript
var name = '小明';
var age = 20;
var message = `你好, ${name}, 你今年${age}岁了!`;
alert(message);
```

字符串的操作：

- 要获取字符串某个指定位置的字符，使用类似Array的下标操作，索引号从0开始:

```JavaScript
var s = 'Hello, world!';
s[0]; // 'H'
s[6]; // ' '
s[7]; // 'w'
s[12]; // '!'
s[13]; // undefined 超出范围的索引不会报错，但一律返回undefined
```

需要注意的是字符串是不可变的，如果对字符串的某个索引赋值不会有任何错误，但也没有任何效果：

```JavaScript
var s = 'Hello, world!';
var s = 'Test';
s[0] = 'X';
alert(s); // s仍然为'Test'
```

- length：返回字符串的长度

```JavaScript
var s = 'Hello, world!';
s.length; // 13
```

- toUpperCase：转大写

```JavaScript
var s = 'Hello';
s.toUpperCase(); // 返回'HELLO'
```

- toLowerCase：转小写

```JavaScript
var s = 'Hello';
var lower = s.toLowerCase(); // 返回'hello'并赋值给变量lower
lower; // 'hello'
```

- indexOf：返回子串的index

```JavaScript
var s = 'hello, world';
s.indexOf('world'); // 返回7
s.indexOf('World'); // 没有找到指定的子串，返回-1
```

- substring：返回子串

```JavaScript
var s = 'hello, world'
s.substring(0, 5); // 从索引0开始到5（不包括5），返回'hello'
s.substring(7); // 从索引7开始到结束，返回'world'
```

##### 布尔值

布尔值只有`true`、`false`两种，并且要么是`true`，要么是`false`，如：

```JavaScript
true; // 这是一个true值
false; // 这是一个false值
2 > 1; // 这是一个true值
2 >= 3; // 这是一个false值
```

布尔值存在的意义就是参与逻辑运算并用在条件判断中，常见的逻辑运算包括：

- &&
- ||
- !

当然各种比较运算也与布尔值关系密切，这部分内容见上Number的部分

##### 空值

`null`表示一个“空”的值，它和`0`以及空字符串`''`不同，`0`是一个数值，`''`表示长度为0的字符串，而`null`表示“空”

在其他语言中，也有类似JavaScript的`null`的表示，例如Java也用`null`，Swift用`nil`，Python用`None`表示

在JavaScript中，还有一个和`null`类似的`undefined`，它表示“未定义”

JavaScript的设计者希望用`null`表示一个空的值，而`undefined`表示值未定义。事实证明，这并没有什么用，区分两者的意义不大。大多数情况下，我们都应该用`null`，`undefined`仅仅在判断函数参数是否传递的情况下有用

##### 数组

数组是一组按顺序排列的集合，集合的每个值称为元素，JavaScript的数组可以包括任意数据类型：

```JavaScript
[1, 2, 3.14, 'Hello', null, true];
```

创建数组有两种方式，，出于代码的可读性考虑，强烈建议直接使用[]：

```JavaScript
var arr = [1, 2, 3.14, 'Hello', null, true];
var arr = new Array(1, '2', 3, null);
```

数组的元素可以通过索引来访问，索引的起始值为0，可以通过对索引把对应的元素修改为新值：

```JavaScript
var arr = ['A', 'B', 'C'];
arr[1] = 99;
arr; // arr现在变为['A', 99, 'C']
```

- length

要取得Array的长度，直接访问`length`属性：

```JavaScript
var arr = [1, 2, 3.14, 'Hello', null, true];
arr.length; // 6
```

注意，直接给Array的`length`赋一个新的值会导致Array大小的变化：

```JavaScript
var arr = [1, 2, 3];
arr.length; // 3
arr.length = 6;
arr; // arr变为[1, 2, 3, undefined, undefined, undefined]
arr.length = 2;
arr; // arr变为[1, 2]
```

通过索引赋值时若索引超过范围同样会导致`length`的变化：

```JavaScript
var arr = [1, 2, 3];
arr[5] = 'x';
arr; // arr变为[1, 2, 3, undefined, undefined, 'x']
```

大多数其他编程语言不允许直接改变数组的大小，越界访问索引会报错。然而，JavaScript的Array却不会有任何错误。在编写代码时，不建议直接修改Array的大小，访问索引时要确保索引不会越界

- indexOf：搜索一个指定元素的位置

```JavaScript
var arr = [10, 20, '30', 'xyz'];
arr.indexOf(10); // 元素10的索引为0
arr.indexOf(20); // 元素20的索引为1
arr.indexOf(30); // 元素30没有找到，返回-1
arr.indexOf('30'); // 元素'30'的索引为2
```

- slice：截取Array的部分元素，然后返回一个新的Array

```JavaScript
var arr = ['A', 'B', 'C', 'D', 'E', 'F', 'G'];
arr.slice(0, 3); // 从索引0开始，到索引3结束，但不包括索引3: ['A', 'B', 'C']
arr.slice(3); // 从索引3开始到结束: ['D', 'E', 'F', 'G']
```

可以通过如下方式复制一个Array：

```JavaScript
var arr = ['A', 'B', 'C', 'D', 'E', 'F', 'G'];
var aCopy = arr.slice();
aCopy; // ['A', 'B', 'C', 'D', 'E', 'F', 'G']
aCopy === arr; // false
```

- push & pop：`push()`向Array的末尾添加若干元素，`pop()`删除Array中的最后一个元素

```JavaScript
var arr = [1, 2];
arr.push('A', 'B'); // 返回Array新的长度: 4
arr; // [1, 2, 'A', 'B']
arr.pop(); // pop()返回'B'
arr; // [1, 2, 'A']
arr.pop(); arr.pop(); arr.pop(); // 连续pop 3次
arr; // []
arr.pop(); // 空数组继续pop不会报错，而是返回undefined
arr; // []
```

- unshift & shift：`unshift()`向Array的头部添加若干元素，`shift()`则删除Array的第一个元素

```JavaScript
var arr = [1, 2];
arr.unshift('A', 'B'); // 返回Array新的长度: 4
arr; // ['A', 'B', 1, 2]
arr.shift(); // 'A'
arr; // ['B', 1, 2]
arr.shift(); arr.shift(); arr.shift(); // 连续shift 3次
arr; // []
arr.shift(); // 空数组继续shift不会报错，而是返回undefined
arr; // []
```

- sort：对当前Array进行排序，它会直接修改当前Array的元素位置，直接调用时，按照默认顺序排序

```JavaScript
var arr = ['B', 'C', 'A'];
arr.sort();
arr; // ['A', 'B', 'C']
```

当然可以按照指定顺序排序，有机会再说（或自行搜索）

- reverse：翻转Array

```JavaScript
var arr = ['one', 'two', 'three'];
arr.reverse(); 
arr; // ['three', 'two', 'one']
```

- splice：从指定的索引开始删除若干元素，然后再从该位置添加若干元素

```JavaScript
var arr = ['Microsoft', 'Apple', 'Yahoo', 'AOL', 'Excite', 'Oracle'];
// 从索引2开始删除3个元素,然后再添加两个元素:
arr.splice(2, 3, 'Google', 'Facebook'); // 返回删除的元素 ['Yahoo', 'AOL', 'Excite']
arr; // ['Microsoft', 'Apple', 'Google', 'Facebook', 'Oracle']
// 只删除,不添加:
arr.splice(2, 2); // ['Google', 'Facebook']
arr; // ['Microsoft', 'Apple', 'Oracle']
// 只添加,不删除:
arr.splice(2, 0, 'Google', 'Facebook'); // 返回[],因为没有删除任何元素
arr; // ['Microsoft', 'Apple', 'Google', 'Facebook', 'Oracle']
```

- concat：连接两个Array并返回一个新Array（不会修改当前Array）

```JavaScript
var arr = ['A', 'B', 'C'];
var added = arr.concat([1, 2, 3]);
added; // ['A', 'B', 'C', 1, 2, 3]
arr; // ['A', 'B', 'C']
```

- join：把当前Array的每个元素都用指定的字符串连接起来，然后返回连接后的字符串（如果Array的元素不是字符串，将自动转换为字符串后再连接）

```JavaScript
var arr = ['A', 'B', 'C', 1, 2, 3];
arr.join('-'); // 'A-B-C-1-2-3'
```

最后简单介绍多维数组，所谓多维数组就是数组的数组的...以二维数组为例，就是数组的数组：

```JavaScript
var arr = [[1, 2, 3], [4, 5, 6], [7, 8, 9]];
```

对于多维数组，目前知道如何取值即可，比如要获得上述数组中的数字`9`：

```JavaScript
var i = arr[2][2]; // i的值为9
```

##### 对象

JavaScript的对象是一组由键-值组成的无序集合，如：

```JavaScript
var person = {
    name: 'Bob',
    age: 20,
    tags: ['js', 'web', 'mobile'],
    city: 'Beijing',
    hasCar: true,
    zipcode: null
};
```

键又称属性，对象的键都是字符串类型，值可以是任意数据类型

获取对象的属性用如下方式：

```JavaScript
person.name; // 'Bob'
person.zipcode; // null
```

访问属性是通过`.`操作符完成的，但这要求属性名必须是一个有效的变量名，若属性名包含特殊字符，就必须用`''`括起来：

```JavaScript
var xiaohong = {
    name: '小红',
    'middle-school': 'No.1 Middle School'
};
```

`xiaohong`的属性名`middle-school`不是一个有效的变量，就需要用`''`括起来，访问这个属性也无法使用`.`操作符，必须用`['xxx']`来访问：

```JavaScript
xiaohong['middle-school']; // 'No.1 Middle School'
xiaohong['name']; // '小红'
xiaohong.name; // '小红'
```

显然用`.`访问对象的属性更简洁，我们在编写JavaScript代码的时候，属性名尽量使用标准的变量名，这样就可以直接通过`object.prop`的形式访问一个属性

访问不存在的属性不报错，而是返回undefined：

```JavaScript
var xiaoming = {
    name: '小明'
};
console.log(xiaoming.name);
console.log(xiaoming.age); // undefined
```

由于JavaScript的对象是动态类型，可以自由地给一个对象添加或删除属性：

```JavaScript
var xiaoming = {
    name: '小明'
};
xiaoming.age; // undefined
xiaoming.age = 18; // 新增一个age属性
xiaoming.age; // 18
delete xiaoming.age; // 删除age属性
xiaoming.age; // undefined
delete xiaoming['name']; // 删除name属性
xiaoming.name; // undefined
delete xiaoming.school; // 删除一个不存在的school属性也不会报错
```

检查一个对象是否拥有某一属性，可以用`in`：

```JavaScript
var xiaoming = {
    name: '小明',
    birth: 1990,
    school: 'No.1 Middle School',
    height: 1.70,
    weight: 65,
    score: null
};
'name' in xiaoming; // true
'grade' in xiaoming; // false
```

需要注意的是用`in`判定存在的属性包括当前对象继承来的属性：

```JavaScript
'toString' in xiaoming; // true
```

`toString`定义在`object`对象中，而所有对象最终都会在原型链上指向`object`，所以`xiaoming`也拥有`toString`属性

要判定一个属性是否真的是一个对象自身拥有的，可以用`hasOwnProperty()`方法：

```JavaScript
var xiaoming = {
    name: '小明'
};
xiaoming.hasOwnProperty('name'); // true
xiaoming.hasOwnProperty('toString'); // false
```

##### Map，Set，Iterable

虽然这一节的标题这么写，但实际上Map和Set是一对，Iterable的层级更高

上节提到，JavaScript中的对象是键值对，且键必须是字符串，但在实际操作中，使用其他类型的数据作为键也很合理，ES6引入了Map来解决这个问题

Map是一组键值对的结构，除了键可以不是字符串之外，Map作为一种重要的数据结构能在`O（1）`的时间复杂度下完成查找

初始化一个Map有两种方法，意识用二维数组：

```JavaScript
var m = new Map([['Michael', 95], ['Bob', 75], ['Tracy', 85]]);
```

二是先初始化一个空Map，然后添加键值对：

```JavaScript
var m = new Map(); // 空Map
m.set('Adam', 67); // 添加新的key-value
m.set('Bob', 59);
```

目前掌握Map的以下方法即可：

```JavaScript
m.has('Adam'); // 是否存在key 'Adam': true
m.get('Adam'); // 67
m.delete('Adam'); // 删除key 'Adam'
m.get('Adam'); // undefined
```

一个key只能对应一个value，所以，多次对一个key放入value，后面的值会把前面的值冲掉：

```JavaScript
var m = new Map();
m.set('Adam', 67);
m.set('Adam', 88);
m.get('Adam'); // 88
```

Set和Map类似，但只是key的集合，并且key不能重复

创建一个Set：

```JavaScript
var s1 = new Set(); // 空Set
var s2 = new Set([1, 2, 3]); // 含1, 2, 3
```

重复元素会被过滤：

```JavaScript
var s = new Set([1, 2, 3, 3, '3']);
s; // Set {1, 2, 3, "3"}
```

添加元素：

```JavaScript
s.add(4);
s; // Set {1, 2, 3, 4}
s.add(4);
s; // 仍然是 Set {1, 2, 3, 4}
```

删除元素：

```JavaScript
var s = new Set([1, 2, 3]);
s; // Set {1, 2, 3}
s.delete(3);
s; // Set {1, 2}
```

为了统一集合类型，ES6标准引入了新的iterable类型，Array、Map和Set都属于iterable类型

目前掌握Iterable对象的遍历即可，遍历的方式包括`for...in`、`for...of`和`forEach`，见下节循环

### 控制流

#### 分支

JavaScript使用`if...else...`来进行条件判断：

```JavaScript
var age = 20;
if (age >= 18) { // 如果age >= 18为true，则执行if语句块
    alert('adult');
}
else { // 否则执行else语句块
    alert('teenager');
}
```

else不是必须的：

```JavaScript
var age = 20;
if (age >= 18) { // 如果age >= 18为true，则执行if语句块
    alert('adult');
}
```

多行的条件判断，也就是`if-else if`：

```JavaScript
var age = 3;
if (age >= 18) {
    alert('adult');
}
else if (age >= 6) {
    alert('teenager');
}
else {
    alert('kid');
}
```

老生常谈的括号问题：如果语句块只包含一条语句，那么可以省略`{}`：

```JavaScript
var age = 20;
if (age >= 18)
    alert('adult');
else
    alert('teenager');
```

但是这样有危险，如果后来想添加一些语句，却忘了写`{}`，就改变了`if...else...`的语义：

```JavaScript
var age = 20;
if (age >= 18)
    alert('adult');
else
    console.log('age < 18'); // 添加一行日志
    alert('teenager'); // <- 这行语句已经不在else的控制范围了
```

所以，`{}`不应该被省略，即使只有一条语句

对于判断条件，还有一点需要注意：

JavaScript把`null`、`undefined`、`0`、`NaN`和空字符串`''`视为`false`，其他值一概视为`true`

#### 循环

JS的循环语句包括`for`和`while`

比如求`1 + 2 + 3 + ... + 10000`可以写成：

```JavaScript
var sum = 0;
var i;
for (i = 1; i <= 10000; i++) {
    sum += i;
}
sum; // 50005000
```

当然`for`最常用的地方是遍历数组：

```JavaScript
var arr = ['Apple', 'Google', 'Microsoft'];
var i, x;
for (i=0; i<arr.length; i++) {
    x = arr[i];
    console.log(x);
}
```

for循环在已知循环的初始和结束条件时非常有用，但在某些情况下用while循环更佳，下面举的例子和这句话没什么关系：

```JavaScript
// 求100以内所有奇数的积
var sum = 1;
var i = 1;
while (i < 100) {
    sum *= i;
    i += 2;
}
sum;
```

`do...while`和`while`循环的唯一区别在于，不是在每次循环开始的时候判断条件，而是在每次循环完成的时候判断条件（当然对下面这个例子都一样）：

```JavaScript
// 还是求100以内奇数的积
var sum = 1;
var i = 1;
do {
    sum *= i;
    i += 2; 
} while (i < 100);
sum;
```

`do...while`循环的循环体会至少执行1次，而`for`和`while`循环可能一次都不执行

上面的三种循环都是各位烂熟于心的，下面的几种循环我估计有人没见过：

- for...in：一次访问一个对象的所有属性

```JavaScript
var o = {
    name: 'Jack',
    age: 20,
    city: 'Beijing'
};
for (var key in o) {
    console.log(key); // 'name', 'age', 'city'
}
```

要过滤掉对象继承的属性，用`hasOwnProperty()`实现

Array也是对象，而它的每个元素的索引被视为对象的属性，因此，`for ... in`循环可以直接循环出Array的索引（注意索引的类型是字符串）：

```JavaScript
var a = ['A', 'B', 'C'];
for (var i in a) {
    console.log(i); // '0', '1', '2'
    console.log(a[i]); // 'A', 'B', 'C'
}
```

当我们手动给Array对象添加了额外的属性后，for...in循环将带来意想不到的意外效果：

```JavaScript
var a = ['A', 'B', 'C'];
a.name = 'Hello';
for (var x in a) {
    console.log(x); // '0', '1', '2', 'name'
}
```

for...in包含了Array的`name`属性，却不包含比如`length`之类的属性，这种不伦不类的输出在ES6里的通过for...of得到了解决

- for...of

具有iterable类型的集合可以通过for...of循环来遍历：

```JavaScript
var a = ['A', 'B', 'C'];
var s = new Set(['A', 'B', 'C']);
var m = new Map([[1, 'x'], [2, 'y'], [3, 'z']]);
for (var x of a) { // 遍历Array
    console.log(x);
}
for (var x of s) { // 遍历Set
    console.log(x);
}
for (var x of m) { // 遍历Map
    console.log(x[0] + '=' + x[1]);
}
```

for...of解决了上述for...in的问题：

```JavaScript
var a = ['A', 'B', 'C'];
a.name = 'Hello';
for (var x of a) {
    console.log(x); // 'A', 'B', 'C'
}
```

- forEach

更好的方式是直接使用iterable内置的forEach方法，它接收一个函数，每次迭代就自动回调该函数，以Array为例：

```JavaScript
var a = ['A', 'B', 'C'];
a.forEach(function (element, index, array) {
    // element: 指向当前元素的值
    // index: 指向当前索引
    // array: 指向Array对象本身
    console.log(element + ', index = ' + index);
});
```

Set与Array类似，但Set没有索引，因此回调函数的前两个参数都是元素本身：

```JavaScript
var s = new Set(['A', 'B', 'C']);
s.forEach(function (element, sameElement, set) {
    console.log(element);
});
```

Map的回调函数参数依次为`value`、`key`和`map`本身：

```JavaScript
var m = new Map([[1, 'x'], [2, 'y'], [3, 'z']]);
m.forEach(function (value, key, map) {
    console.log(value);
});
```

当然function的参数个数未必总是三个，如：

```JavaScript
var a = ['A', 'B', 'C'];
a.forEach(function (element) {
    console.log(element);
});
```

## 函数

### 为什么需要函数

- 函数可以去冗余
- 借助抽象，我们才能不关心底层的具体计算过程，直接在更高的层次上思考问题，函数就是最基本的一种代码抽象的方式

JavaScript的函数是“头等公民”，可以像变量一样使用

### 函数定义与调用

函数的定义方式如下：

```JavaScript
function abs(x) {
    if (x >= 0) {
        return x;
    } else {
        return -x;
    }
}
```

其中，`function`表示这是一个函数的定义，`abs`是函数的名称，`(x)`列出函数的参数，多个参数用逗号分隔，`{}`中的部分是函数体，函数执行到`return`语句结束，没有`return`语句的情况下结果为`undefined` 

JS中的函数也是对象，所以以上函数定义可以写成，这里用到了匿名函数，将匿名函数赋值给变量`abs`，可以通过该变量调用对应函数：

```JavaScript
var abs = function (x) {
    if (x >= 0) {
        return x;
    } else {
        return -x;
    }
};
```

这两种写法完全等价，记住这个说法，下一节讨论作用域的时候还要提这件事，注意两种写法的区别尤其是结尾的封号

调用函数时，写对函数名，顺序传入参数即可：

```JavaScript
abs(10); // 返回10
abs(-9); // 返回9
```

讨论函数的时候，最重要的部分总是参数，JS允许传入参数的数量与定义不匹配，但在这种情况下往往不能指望结果正确：

```JavaScript
abs(10, 'blablabla'); // 返回10
abs(-9, 'haha', 'hehe', null); // 返回9
abs(); // 返回NaN
```

一个健壮的函数应当对传入的参数做检查，比较简单的有：

```JavaScript
function abs(x) {
    if (typeof x !== 'number') {
        throw 'Not a number';
    }
    if (x >= 0) {
        return x;
    } else {
        return -x;
    }
}
```

JS提供了一些关键字以方便对传入的参数操作，这里介绍`arguments`和`rest`

`arguments`只在函数内部起作用，并且永远指向当前函数的调用者传入的所有参数，arguments类似Array但它不是一个Array：

```JavaScript
function foo(x) {
    console.log('x = ' + x); // 10
    for (var i=0; i < arguments.length; i++) {
        console.log('arg ' + i + ' = ' + arguments[i]); // 10, 20, 30
    }
}
foo(10, 20, 30); 
```

利用这个关键字，可以获得调用者传入的所有参数，即使函数本身没有定义：

```JavaScript
function abs() {
    if (arguments.length === 0) {
        return 0;
    }
    var x = arguments[0];
    return x >= 0 ? x : -x;
}
abs(); // 0
abs(10); // 10
abs(-9); // 9
```

通过`arguments`可以知道传入的参数的全部情况，经常通过这种方式实现“可选参数”：

```JavaScript
// foo(a[, b], c)
// 接收2~3个参数，b是可选参数，如果只传2个参数，b默认为null：
function foo(a, b, c) {
    if (arguments.length === 2) {
        // 实际拿到的参数是a和b，c为undefined
        c = b; // 把b赋给c
        b = null; // b变为默认值
    }
    // ...
}
```

`rest`可以视为`arguments`的补充，先看下面这个例子：

```JavaScript
function foo(a, b) {
    var i, rest = [];
    if (arguments.length > 2) {
        for (i = 2; i < arguments.length; i++) {
            rest.push(arguments[i]);
        }
    }
    console.log('a = ' + a);
    console.log('b = ' + b);
    console.log(rest);
}
```

为了获取`a`、`b`之外的参数，我们除了使用`arguments`之外还有更好的方法：

```JavaScript
function foo(a, b, ...rest) {
    console.log('a = ' + a);
    console.log('b = ' + b);
    console.log(rest);
}

foo(1, 2, 3, 4, 5);
// 结果:
// a = 1
// b = 2
// Array [ 3, 4, 5 ]

foo(1);
// 结果:
// a = 1
// b = undefined
// Array []
```

`rest`参数写在最后，用`...`标识，多余的参数（在上面的例子中就是除`a`、`b`之外的参数）以数组的形式交给`rest`，这样，不需要`arguments`也能获得全部参数（在参数数量不足的情况下`rest`接收一个空数组），最后举个例子，求和函数：

```JavaScript
function sum(...rest) {
    var sum = 0;
    for (var elem of rest) {
        if (typeof elem === 'number') {
            sum += elem;
        }
    }
    return sum;
}
```

### 变量作用域与解构赋值

### 方法

### 高阶函数

#### map/reduce

#### filter

#### sort

#### Array

### 闭包

### 箭头函数

### generator 