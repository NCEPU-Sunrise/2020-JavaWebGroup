## 函数

### 函数的定义与调用

### 变量的作用域与解构赋值

### 方法

这是一个对象的定义：

```JavaScript
var xiaoming = {
    name: '小明',
    birth: 1990
};
```

给`xiaoming`绑定一个方法，比如返回他的年龄：

```JavaScript
var xiaoming = {
    name: '小明',
    birth: 1990,
    age: function () {
        var y = new Date().getFullYear();
        return y - this.birth;
    }
};

xiaoming.age; // function xiaoming.age()
xiaoming.age(); // 今年调用是25,明年调用就变成26了
```

绑定到对象上的函数称为方法

### 高阶函数

### 闭包

### 箭头函数

### 生成器

## 对象（复习）

对象是键值对的集合

```JavaScript

```

如何访问一个对象的属性

```JavaScript

```

修改对象

```JavaScript

```

`in`

```JavaScript

```

`hasOwnProperty()`

```JavaScript

```

下面我们先不急着说类，就讨论对象

## 标准对象

俗话说，“Java是一种纯粹的面向对象语言”，“Java中一切皆对象”，JavaScript也是如此，JavaScript中一切皆对象，当然对象和对象也是有区别的，在JavaScript中可以用typeof获取对象类型：

```JavaScript
typeof 123; // 'number'
typeof NaN; // 'number'
typeof 'str'; // 'string'
typeof true; // 'boolean'
typeof undefined; // 'undefined'
typeof Math.abs; // 'function'
typeof null; // 'object'
typeof []; // 'object'
typeof {}; // 'object'
```

首先我们可以看到`typeof`的返回值是字符串，其次，除了`number`、`string`、`boolean`、`function`和`undefined`之外，其他数据的类型都是`object`（包括`null`）

在Java中，我们可以通过封装类实现一些操作（比如数据类型转换），在JavaScript中也有类似的操作，称为包装对象

`number`，`boolean`和`string`有包装对象（八错，`string`也有包装对象），包装对象用`new`创建：

```JavaScript
var n = new Number(123);
var b = new Boolean(true);
var s = new String ('str');
```

我们试一试这几个包装对象的类型，显然都是object

```JavaScript
typeof n; // 'object'
typeof b; // 'object'
typeof s; // 'object'
```

还记得`===`么，用`===`比较的时候会先比较左式和右式的类型，所以包装对象和原始值的比较返回`false`：

```JavaScript
typeof new Number(123); // 'object'
new Number(123) === 123; // false

typeof new Boolean(true); // 'object'
new Boolean(true) === true; // false

typeof new String('str'); // 'object'
new String('str') === 'str'; // false
```

这个结果（尤其对`string`）不是我们想要的，所以，在任何情况下都应该避免使用包装对象（再说一遍，尤其是`string`对象）

（所以我们讲这么多的目的就是为了让你避免JavaScript的糟粕[doge]，别急，下面还有更糟粕的[doge]）

在使用`Number()`、`Boolean()`、`String()`（注意首字母大写和符号嗷）的时候，如果你不加`new`，那么这三个万一就是普通函数（普通指的是它们不再产生包装对象），其功能为将其他数据类型转换为`number`、`boolean`、`string`（again，注意大小写）：

```JavaScript
var n = Number('123'); // 123，相当于parseInt()或parseFloat()
typeof n; // 'number'

var b = Boolean('true'); // true
typeof b; // 'boolean'

var b2 = Boolean('false'); // true! 'false'字符串转换结果为true！因为它是非空字符串！
var b3 = Boolean(''); // false

var s = String(123.45); // '123.45'
typeof s; // 'string'
```

根据我们已知的内容，可以总结以下规则：

- 可以使用`typeof`操作符判断一个对象的类型（不过只对`number`、`boolean`、`string`、`function`和`undefined`有效）
- 具体地，判断`null`用`===`，如`myVar === null`
- 具体地，判断`Array`用`Array.isArray()`，如`Array.isArray(arr)`
- 可以这样判断某个全局变量是否存在：`typeof window.myVar === 'undefined'`
- 事实上，在函数内部判断某个变量是否存在的方法同理：`typeof myVar === 'undefined'`
- 不要创建或使用包装对象
- 用`parseInt()`或`parseFloat()`转换任意数据数据类型到`number`
- 用`String()`（注意没有new）转换任意数据类型到`string`，当然，可以调用某个数据类型的`toString()`方法（关于这个我们下面还有几点要说）
- 通常不需要讲某类型转换为`boolean`，直接写在需要判断的地方就可以了，比如`if (myVar) {...}`

不是所有对象都有`toString()`方法，比如`null`（虽然它“伪装”成`object`类型）和`undefined`，事实上，`number`对象调用`toString()`方法不是一帆风顺的，各位试一下下面的三条语句，下次上课我问问结果[doge]：

```JavaScript
123.toString(); // res:
123..toString(); // res:
(123).toString(); // res:
```

它们的结果一样么？（自己试一下）为什么不一样捏？（别问，问就是不知道）

至此，我们对JavaScript中的对象的理解更加深入了，下面讨论JavaScript中的三种标准对象：Date，RegExp，JSON

### Date

JavaScript中用`Date`对象表示时间和日期以及完成相关操作，先看个例子，获取当前系统时间：

```JavaScript
var now = new Date();
now;
now.getFullYear();
now.getMonth();
now.getDate();
now.getDay();
now.getHours();
now.getMinutes();
now.getSeconds();
now.getMilliseconds();
now.getTime();
```

这里所谓的当前系统时间是浏览器从本机获取的时间，所以未必准确

各位可能注意到了一个问题，JavaScript的`Date`对象月份值从0开始，牢记0=1月，1=2月，2=3月，......，11=12月

当然可以创建一个指定日期和时间的`Date`对象，一种写法是：

```JavaScript
var d = new Date(2015, 5, 19, 20, 15, 30, 123);
d; // Fri Jun 19 2015 20:15:30 GMT+0800 (CST)
```

第二种写法是解析一个符合`ISO 8601`格式的字符串：

```JavaScript
var d = Date.parse('2015-06-24T19:49:22.875+08:00');
d; // 1435146562875
```

这种方式返回的不是`Date`对象而是时间戳，当然可以很容易地把时间戳转换为`Date`，这也是创建`Date`对象的第三种方法：

```JavaScript
var d = new Date(1435146562875);
d; // Wed Jun 24 2015 19:49:22 GMT+0800 (CST)
d.getMonth(); // 5
```

所谓时间戳，时间戳是一个自增的整数，它表示从1970年1月1日零时整的GMT时区开始的那一刻，到现在的毫秒数，假设浏览器所在电脑的时间是准确的，那么世界上无论哪个时区的电脑，它们此刻产生的时间戳数字都是一样的，所以，时间戳可以精确地表示一个时刻，并且与时区无关

获取当前时间戳用`Date.now()`方法或`getTime()`方法：

```JavaScript
if (Date.now) {
    console.log(Date.now()); // 老版本IE没有now()方法
} else {
    console.log(new Date().getTime());
}
```

最后讨论一下时区，`Date`对象表示的时间总是按浏览器所在时区显示的，不过我们既可以显示本地时间，也可以显示调整后的UTC时间：

```JavaScript
var d = new Date(1435146562875);
d.toLocaleString(); // '2015/6/24 下午7:49:22'，本地时间（北京时区+8:00），显示的字符串与操作系统设定的格式有关
d.toUTCString(); // 'Wed, 24 Jun 2015 11:49:22 GMT'，UTC时间，与本地时间相差8小时
```

在我们传递`number`类型的时间戳的前提下，不需要关心时区转换，浏览器可以自行处理这个问题（指转换为本地时间），所以，在大多数情况下我们只需要传递时间戳，或者把时间戳从数据库里读出来，再让JavaScript自动转换为当地时间就可以了

### RegExp

讨论正则表达式首先要认识到字符串是一种极其重要的数据结构，而正则表达式是用来匹配字符串的强大工具，其设计思路是用描述性的语言给字符串定义一个规则（正则表达式也是用字符串表示的，所以可以说正则表达式解决了“如何用字符串描述字符串”的问题），符合规则的字符串认为“匹配”，否则就是不合法字符串

比如说匹配一个字符串是否是合法的email地址，我们要做两步操作：

1. 创建一个用于匹配email地址的正则表达式
2. 用该正则表达式匹配用户输入看看是否合法

所以第一步我们先简单讨论正则表达式的写法，也就是解决“用字符串描述字符串”的问题

先看精确匹配，所谓精确匹配可以理解为正则表达式的结构与被其描述的字符串完全一致，或者说以直接给出字符的形式描述，具体地，`0`就匹配一个字符`0`，`\d`可以匹配一个数字，`\w`可以匹配一个字母或数字，`.`可以匹配任意字符，`\s`匹配一个空白符（比如空格，tab），比如：

- `'00\d'`可以匹配`'007'`，但不能匹配`'00A'`
- `'\d\d\d'`可以匹配`'010'`
- `'\w\w'`可以匹配`'js'`
- `'js.'`可以匹配`'jsp'`，`'jss'`，`'js~'`等

进一步地，是匹配变长字符串，上面讨论的记法规定了能匹配的对象的类型（数字/数字/任意字符），下面给出的符号不在乎字符类型了，它们看起来就像单位，包括：

- `*`：表示任意个字符（包括0个）
- `+`：表示至少一个字符
- `?`：表示0个或1个字符
- `{n}`：表示n个字符
- `{n, m}`：表示n~m个字符

举个例子说明：`\d{3}\s+\d{3,8}`

从左到右拆出来看，`\d{3}`表示匹配三个数字，`\s+`表示至少有一个空格，`\d{3,8}`表示3~8个数字，比如`12345`，所以上面这个正则表达式可以匹配任意一个空格隔开的带区号的电话号码

写正则表达式的过程中可能遇到需要转义的字符，转义用`\`，比如，上面说的电话号码若要表示成这样`010-12345`，正则表达式就需要修改为`\d{3}\-\d{3,8}`

继续，要做更精确的匹配，可以用`[]`表示范围，比如

- `[0-9a-zA-Z\_]`可以匹配一个数字、字母或者下划线
- `[0-9a-zA-Z\_]+`可以匹配至少由一个数字、字母或者下划线组成的字符串，比如'a100'，'0_Z'，'js2015'等等
- `[a-zA-Z\_\$][0-9a-zA-Z\_\$]*`可以匹配由字母或下划线、$开头，后接任意个由一个数字、字母或者下划线、$组成的字符串，也就是JavaScript允许的变量名
- `[a-zA-Z\_\$][0-9a-zA-Z\_\$]{0, 19}`更精确地限制了变量的长度是1-20个字符（前面1个字符+后面最多19个字符）

除此之外，还有：

- `A|B`可以匹配A或B，`(J|j)ava(S|s)cript`可以匹配`'JavaScript'`、`'Javascript'`、`'javaScript'`或者`'javascript'`
- `^`表示行的开始，`^\d`表示必须以数字开头
- `$`表示行的结束，`\d$`表示必须以数字结束

更多关于正则表达式的内容可以看这里：[runoob.com/regexp](https://www.runoob.com/regexp/regexp-tutorial.html)

然后就可以讨论在JavaScript中如何使用正则表达式，同时也就是讨论匹配的问题

JavaScript有两种创建正则表达式的方式，第一种是直接写：

```JavaScript
var re1 = /ABC\-001/;
```

第二种是通过`new RegExp('正则表达式')`创建一个正则表达式对象：

```JavaScript
var re2 = new RegExp('ABC\\-001');
```

两种写法没有区别（当然，第二种写法要注意转义）：

```JavaScript
re1; // /ABC\-001/
re2; // /ABC\-001/
```

RegExp对象的test方法可以测试给定字符串是否合法：

```JavaScript
var re = /^\d{3}\-\d{3,8}$/;
re.test('010-12345'); // true
re.test('010-1234x'); // false
re.test('010 12345'); // false
```

刚刚说了字符串是一种很重要的数据结构，正则表达式在处理字符串上有很多应用：

- 切分字符串
- 分组
- 贪心匹配
- 全局搜素

正则表达式的内容非常之多，这里简单介绍一下思想，具体的内容都不展开，各位在需要的时候自行搜索查阅资料即可

### JSON

> JSON（JavaScript Object Notation）是一种轻量级的数据交换语言，以文字为基础，且易于让人阅读，同时也方便了机器进行解析和生成。JSON简单说就是javascript中的对象和数组，所以这两种结构就是对象和数组两种结构，通过这两种结构可以表示各种复杂的结构，其可以将JavaScript 对象中表示的一组数据转换为字符串，然后就可以在函数之间轻松地传递这个字符串，或者在异步应用程序中将字符串从Web客户机传递给服务器端程序。JSON采用完全独立于程序语言的文本格式，但是也使用了类C语言的习惯（包括C、C++、C#、Java、JavaScript、Perl、Python等）。这些特性使JSON成为理想的数据交换语言。

> 如同人类通过交流相互合作，计算机网络中计算机的相互合作也依赖于彼此的信息交流。人类间的相互交流可以通过当面交流，电话，短信，邮件，IM应用来实现，但这建立在两人使用共同语言的基础上。计算机间可以以TCP等方式传输数据，但我们需要预定义一种为双方计算机所接受的“语言“，方能使数据交流正常进行，这种语言我们称之为”数据交换语言“。基于数据交互的基础性，各种开发语言基本都提供了自身的数据交换功能或者对通用交换语言标准的接口。但在不同的系统不同的语言间交换数据时，我们一般倾向于使用无关于平台及语言的数据交换语言。此类语言主要包括XML，JSON，YAML，Protobuf等，常用于接口调用，配置文件，数据存储等场景。

[详情可以看这里](https://zhuanlan.zhihu.com/p/27487096)或自行搜索

JSON出现之前大家都用XML传递数据，随着时间推演XML附加的规范越来越多导致可用性越来越差，为了摆脱这种状态，Douglas Crockford发明了JSON

JSON实际上是JavaScript的一个子集（终于扯上关系了），在JSON中有如下数据类型：

- number
- boolean
- string
- null
- array：就是JavaScript中的`Array`的表示方式`[]`
- object：就是JavaScript中的`{...}表示方式`
- 上述数据类型的任意组合

JSON还定死了字符集必须是UTF-8，为了统一解析，JSON的字符串规定必须用双引号""，Object的键也必须用双引号""

由于JSON非常简单，很快就风靡Web世界，并且成为ECMA标准，几乎所有编程语言都有解析JSON的库，而在JavaScript中，我们可以直接使用JSON，因为JavaScript内置了JSON的解析

把任何JavaScript对象变成JSON，就是把这个对象序列化成一个JSON格式的字符串，这样才能够通过网络传递给其他计算机

如果我们收到一个JSON格式的字符串，只需要把它反序列化成一个JavaScript对象，就可以在JavaScript中直接使用这个对象

#### 序列化

我们有一个对象叫xiaoming：

```JavaScript
var xiaoming = {
    name: '小明',
    age: 14,
    gender: true,
    height: 1.65,
    grade: null,
    'middle-school': '\"W3C\" Middle School',
    skills: ['JavaScript', 'Java', 'Python', 'Lisp']
};
```

现在把这个对象序列化，通过`JSON.stringify()`方法：

```JavaScript
var s = JSON.stringify(xiaoming);
console.log(s);
```

得到的结果长这样：

```JSON
{"name":"小明","age":14,"gender":true,"height":1.65,"grade":null,"middle-school":"\"W3C\" Middle School","skills":["JavaScript","Java","Python","Lisp"]}
```

可以加上参数，控制输出格式等，比如要按照缩进输出：

```JavaScript
JSON.stringify(xiaoming, null, '  ');
```

结果整齐很多：

```JavaScript
{
  "name": "小明",
  "age": 14,
  "gender": true,
  "height": 1.65,
  "grade": null,
  "middle-school": "\"W3C\" Middle School",
  "skills": [
    "JavaScript",
    "Java",
    "Python",
    "Lisp"
  ]
}
```

stringify中的第二个参数控制筛选对象的键值，比如我们只想输出指定的属性：

```JavaScript
JSON.stringify(xiaoming, ['name', 'skills'], '  ');
```

结果显然就是：

```JavaScript
{
  "name": "小明",
  "skills": [
    "JavaScript",
    "Java",
    "Python",
    "Lisp"
  ]
}
```

甚至可以传入一个函数对键值对做预处理：

```JavaScript
function convert(key, value) {
    if (typeof value === 'string') {
        return value.toUpperCase();
    }
    return value;
}

JSON.stringify(xiaoming, convert, '  ');
```

convert函数的作用是显然的：

```JavaScript
{
  "name": "小明",
  "age": 14,
  "gender": true,
  "height": 1.65,
  "grade": null,
  "middle-school": "\"W3C\" MIDDLE SCHOOL",
  "skills": [
    "JAVASCRIPT",
    "JAVA",
    "PYTHON",
    "LISP"
  ]
}
```

在某些情况下需要更精细地控制序列化的方式，可以用`toJSON()`方法，直接返回JSON应该序列化的数据：

```JavaScript
var xiaoming = {
    name: '小明',
    age: 14,
    gender: true,
    height: 1.65,
    grade: null,
    'middle-school': '\"W3C\" Middle School',
    skills: ['JavaScript', 'Java', 'Python', 'Lisp'],
    toJSON: function () {
        return { // 只输出name和age，并且改变了key：
            'Name': this.name,
            'Age': this.age
        };
    }
};

JSON.stringify(xiaoming); // '{"Name":"小明","Age":14}'
```

#### 反序列化

拿到一个JSON格式的字符串，用`JSON.parse()`转换为JavaScript对象：

```JavaScript
JSON.parse('[1,2,3,true]'); // [1, 2, 3, true]
JSON.parse('{"name":"小明","age":14}'); // Object {name: '小明', age: 14}
JSON.parse('true'); // true
JSON.parse('123.45'); // 123.45
```

`JSON.parse()`还可以接收函数，转换解析出的属性：

```JavaScript
var obj = JSON.parse('{"name":"小明","age":14}', function (key, value) {
    if (key === 'name') {
        return value + '同学';
    }
    return value;
});
console.log(JSON.stringify(obj)); // {name: '小明同学', age: 14}
```

最后做个练习：

```JavaScript
// 用浏览器访问OpenWeatherMap的天气API，查看返回的JSON数据，然后返回城市、天气预报等信息
var url = 'https://api.openweathermap.org/data/2.5/forecast?q=Beijing,cn&appid=800f49846586c3ba6e7052cfc89af16c';
$.getJSON(url, function (data) {
    var info = {
        city: data.city.name,
        weather: data.list[0].weather[0].main,
        time: data.list[0].dt_txt
    };
    alert(JSON.stringify(info, null, '  '));
});
```

## 面向对象编程

JavaScript的面向对象和大多数其他语言的面向对象不同，在**那些**语言中，下面的两个概念很重要：

- 类：类是实例的模板
- 实例：对象是模板的实例

类和实例是**大多数**面向对象语言的基本概念，但是JavaScript中，这些概念需要稍作修改

JavaScript不区分类和实例的概念，而通过*原型*（prototype）实现面向对象编程

现象下面这个场景，我们要创建`xiaoming`这个具体的学生对象，但是并没有一个`Student`类型，怎么办捏，这时候我们发现恰好有这么一个对象：

```JavaScript
var robot = {
    name: 'Robot',
    height: 1.6,
    run: function() {
        console.log(this.name + 'is running...')
    }
}
```

你看这个对象有名字有身高甚至还会跑，这些东西小明也有也会，不妨根据它来创建`xiaoming`（在此之前先改个名字）:

```JavaScript
var Student = {
    name: 'Robot',
    height: 1.2,
    run: function () {
        console.log(this.name + ' is running...');
    }
};

var xiaoming = {
    name: '小明'
};

xiaoming.__proto__ = Student;
```

注意最后一行代码把`xiaoming`的原型指向了对象`Student`，看上去`xiaoming`仿佛是从`Student`继承下来的：

```JavaScript
xiaoming.name; // '小明'
xiaoming.run(); // 小明 is running...
```

`xiaoming`有自己的`name`属性，但并没有定义`run()`方法，不过，由于小明是从`Student`继承而来，只要`Student`有`run()`方法，`xiaoming`也可以调用

JavaScript的原型链和Java的Class区别就在，它没有“Class”的概念，所有对象都是实例，所谓继承关系不过是把一个对象的原型指向另一个对象而已

当然可以把`xiaoming`的原型指向其他对象：

```JavaScript
var Bird = {
    fly: function () {
        console.log(this.name + ' is flying...');
    }
};

xiaoming.__proto__ = Bird;
```

现在`xiaoming`已经无法`run()`了，不过他可以`fly()`，事实上他已经变成了一只鸟（好家伙）：

```JavaScript
xiaoming.fly(); // 小明 is flying...
```

注意，上面的写法仅仅为了演示，在编写JavaScript代码时，不要直接用`obj.__proto__`去改变一个对象的原型，并且，低版本的IE也无法使用`__proto__`，`Object.create()`方法可以传入一个原型对象，并创建一个基于该原型的新对象，但是新对象什么属性都没有，我们写一个函数来创建`xiaoming`：

```JavaScript
// 原型对象:
var Student = {
    name: 'Robot',
    height: 1.2,
    run: function () {
        console.log(this.name + ' is running...');
    }
};

function createStudent(name) {
    // 基于Student原型创建一个新对象:
    var s = Object.create(Student);
    // 初始化新对象:
    s.name = name;
    return s;
}

var xiaoming = createStudent('小明');
xiaoming.run(); // 小明 is running...
xiaoming.__proto__ === Student; // true
```

这是创建原型继承的一种方法，JavaScript还有其他方法来创建对象，我们展开讲

### 创建对象

JavaScript对每个创建的对象都会设置一个原型，指向它的原型对象

当我们用`obj.xxx`访问一个对象的属性时，JavaScript引擎先在当前对象上查找该属性，如果没有找到，就到其原型对象上找，如果还没有找到，就一直上溯到`Object.prototype`对象，最后，如果还没有找到，就只能返回`undefined`

我们随便创建一个对象：

```JavaScript
var arr = [1, 2, 3];
```

它有自己的原型链：

```
arr ----> Array.prototype ----> Object.prototype ----> null
```

`Array.prototype`定义了`indexOf()`、`shift()`等方法，因此你可以在所有的`Array`对象上直接调用这些方法

再创建一个对象，比如一个函数：

```JavaScript
function foo() {
    return 0;
}
```

它也有原型链：

```
foo ----> Function.prototype ----> Object.prototype ----> nul
```

由于`Function.prototype`定义了`apply()`等方法，因此，所有函数都可以调用`apply()`方法

需要注意的事，我们应该尽可能避免把原型链写得很长以避免花费很多时间在原型链上查找以访问一个对象的属性

下面讨论构造函数，除了直接用`{...}`创建对象外，还可以用构造函数创建对象，先定义一个构造函数：

```JavaScript
function Student(name) {
    this.name = name;
    this.hello = function () {
        alert('Hello, ' + this.name + '!');
    }
}
```

乍一看这就是一个普通函数，返回值为`undefined`，要把它作为构造函数使用，用关键字`new`调用它：

```JavaScript
var xiaoming = new Student('小明');
xiaoming.name; // '小明'
xiaoming.hello(); // Hello, 小明!
```

构造函数返回一个对象，它绑定的`this`指向新创建的对象并返回`this`（不需要在最后`return this`）

新创建的`xiaoming`的原型链是：

```
xiaoming ----> Student.prototype ----> Object.prototype ----> null
```

可想而知，倘若你又创建了`xiaohong`，`xiaojun`等对象，其原型与`xiaoming`一样

用`new Student()`创建的对象还从原型上获得了一个`constructor`属性，它指向函数`Student`本身：

```JavaScript
xiaoming.constructor === Student.prototype.constructor; // true
Student.prototype.constructor === Student; // true

Object.getPrototypeOf(xiaoming) === Student.prototype; // true

xiaoming instanceof Student; // true
```

这些东西可以用图片表示：

![pic](pics\ConstructorChaining.png)

红色箭头是原型链，注意，`Student.prototype`指向的对象就是`xiaoming`、`xiaohong`的原型对象，这个原型对象自己还有个属性`constructor`，指向`Student`函数本身

另外，函数`Student`恰好有个属性`prototype`指向`xiaoming`、`xiaohong`的原型对象，但是`xiaoming`、`xiaohong`这些对象可没有`prototype`这个属性，不过可以用`__proto__`这个非标准用法来查看

现在我们就认为`xiaoming`、`xiaohong`这些对象“继承”自`Student`

有一个问题有必要提一嘴：

```JavaScript
xiaoming.name; // '小明'
xiaohong.name; // '小红'
xiaoming.hello; // function: Student.hello()
xiaohong.hello; // function: Student.hello()
xiaoming.hello === xiaohong.hello; // false
```

xiaoming和xiaohong各自的name不同，这是对的，但是xiaoming和xiaohong各自的hello是两个不同的函数，虽然函数名称和代码都是相同的，如果我们通过new Student()创建了很多对象，这些对象的hello函数实际上只需要共享同一个函数就可以了，这样可以节省很多内存，具体怎么操作呢，根据对象的属性查找原则，我们只要把hello函数移动到xiaoming、xiaohong这些对象共同的原型上就可以了，也就是Student.prototype：

![pic](pics\SharedFunction.png)

代码写成这样：

```JavaScript
function Student(name) {
    this.name = name;
}

Student.prototype.hello = function () {
    alert('Hello, ' + this.name + '!');
};
```

然后可以讨论继承，分为原型继承和class继承

### 原型继承

### class继承