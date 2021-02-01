## 浏览器

浏览器是JavaScript中非常重要的话题。

不同浏览器对JavaScript的支持的差异主要在于API的接口不同以及各浏览器对ES6标准的特性的支持不同。

主流的浏览器包括：

- IE 6 ~ 11：据说是国内市容最多的浏览器，从IE10开始支持ES6
- Chrome：基于Webkit（浏览器内核）的浏览器，内置V8（JavaScript引擎），支持ES6
- Firefox：基于Gecko（内核）的浏览器，内置OdinMonkey（引擎），支持ES6
- Safari：基于Webkit的浏览器，支持ES6

大部分国产浏览器都是IE内核加一个壳（也有号称同时支持IE和Webkit的双核浏览器）。

移动设备上的浏览器基本都是Webkit内核，加之HTML5的普及，所以移动设备的浏览器对JavaScript的支持也很好，最新版均支持ES6。

### 浏览器对象

JavaScript可以获取很多浏览器的对象并进行操作，以下讨论常用的对象：

#### window

window对象不仅是去全局作用域，同时表示浏览器窗口。

可以用`window`对象的`innerWidth`和`innerHeight`属性获取浏览器窗口的内部宽度和高度，内部宽高是指除菜单栏、工具栏、边框等元素后用于显示网页的净宽高：

```JavaScript
// 可以试一下调整浏览器窗口大小
console.log('window inner size: ' + window.innerWidth + ' * ' + window.innerHeight);
```

对应地还有`outerWidth`和`outerHeight`属性可以获取浏览器窗口的净宽高

```JavaScript
console.log('window outer size: ' + window.outerWidth + ' * ' + window.outerHeight);
```

注意，IE <= 8不支持上述操作。

#### navigator

`navigator`对象表示浏览器信息，常用属性包括：

- `navigator.appName`：浏览器名称
- `navigator.appVersion`：浏览器版本
- `navigator.language`：浏览器设置的语言
- `navigator.platform`：操作系统类型
- `navigator.userAgent`：浏览器设定的`User-Agent`字符串

试一下：

```JavaScript
console.log('appName = ' + navigator.appName);
console.log('appVersion = ' + navigator.appVersion);
console.log('language = ' + navigator.language);
console.log('platform = ' + navigator.platform);
console.log('userAgent = ' + navigator.userAgent);
```

当然可以用这个对象直接查看浏览器信息：

![BroswerInformation](pics\BrowserInformation.png)

注意，`navigation`的信息可以很容易地被用户修改，所以JavaScript读取到的值未必准确，有时候为了兼容性需要判断浏览器版本，请不要使用以下写法：

```JavaScript
var width;
if (getIEVersion(navigator.userAgent) < 9) {
    width = document.body.clientWidth;
}
else {
    width = window.innerWidth;
}
```

这种写法里的判断方式未必准确，同时代码很难维护，正确的方式是利用JavaScript对不存在的属性返回`undefined`的特性：

```JavaScript
var width = window.innerWidth || document.body.clientWidth;
```

#### screen

`screen`对象提供屏幕的信息，常用属性包括：

- `screen.width`：返回屏幕宽度，单位为像素
- `screen.height`：返回屏幕高度，单位为像素
- `screen.colorDepth`：返回颜色位数

看一个例子：

```JavaScript
console.log('screen size = ' + screen.width + ' x ' + screen.height);
```

#### location

`location`对象提供当前页面的url信息，这是一个url：

```URL
http://www.example.com:8080/path/index.html?a=1&b=2#TOP
```

可以用`location.herf`获取：

```JavaScript
location.protocol; // 'http'
location.host; // 'www.example.com'
location.port; // '8080'
location.pathname; // '/path/index.html'
location.search; // '?a=1&b=2'
location.hash; // 'TOP'
```

`location`还可以加载一个新页面或重新加载当前页面：

```JavaScript
// location.reload()重新加载当前页面
// location.assign()加载一个新页面
if (confirm('重新加载当前页' + location.href + '?')) {
    location.reload();
} else {
    location.assign('/'); // 设置一个新的URL地址
}
```

#### document

`document`表示当前页面，HTML在浏览器中以DOM形式表示为树形结构，`document`对象就是整个DOM树的根节点。

这里简单讨论`document`的几个属性和方法：

- `title`属性

`document`的`title`属性从HTML文档的`<title>`标签中读取，并且可以动态改变：

```JavaScript
document.title = 'learningJavaScript';
```

注意观察浏览器窗口标题的变化

- ID&TagName

要查找DOM树的某个节点，需要从`document`对象开始（从根节点开始，这非常自然），通常根据ID和TagName。

先准备HTML数据：

```HTML
<dl id="drink-menu" style="border:solid 1px #ccc;padding:6px;">
    <dt>摩卡</dt>
    <dd>热摩卡咖啡</dd>
    <dt>酸奶</dt>
    <dd>北京老酸奶</dd>
    <dt>果汁</dt>
    <dd>鲜榨苹果汁</dd>
</dl>
```

用`document`对象提供的`getElementById()`和`getElementByTagName()`可以按ID获得一个DOM节点和按Tag获取一组DOM节点（这个操作和我们讲过的CSS selector很像）：

```JavaScript
var menu = document.getElementByID('drink-menu');
var drinks = document.getElementsByTagName('dt');

var i;
var s = '提供的饮料有：';

for (i = 0; i < drinks.length; i++) {
    s = s + drinks[i].innerHTML + ',';
}

console.log(s);
```

- `cookie`属性

cookie是由服务器发送的`key-value`标识符，用来区分发送请求的用户，具体地说，当一个用户成功登录后，服务器发送一个cookie给浏览器，如`user=ADSFFD3243243...（加密的字符串）`，未来浏览器访问该网站时会自动附上cookie，服务器通过cookie区分出用户。cookie还可以存储网站的一些设置，比如页面显示的语言。这个话题的展开在计算机网络中继续。

JavaScript可以通过`document.cookie`读取当前页面的cookie：

![CookieDemo](pics\BaiduCookie.png)

用户的登录信息往往也存在Cookie中，JavaScript可以读取页面Cookie，HTML页面中也可以映入第三方JavaScript代码，那么倘若引入的第三方JavaScript代码中存在恶意代码，比如：

```HTML
<!-- 当前页面在www.example.com -->
<html>
    <head>
        <script src="http://www.foo.com/jquery.js"></script>
    </head>
    ...
</html>
```

那么`www.foo.com`有可能能直接获取`www.examople.com`网站的用户登录信息。为了解决这个问题，服务器在设置cookie时往往使用`HTTPOnly`，这样cookie将不能被JavaScript读取，这个行为由浏览器实现，主流浏览器均支持该选项。

#### history

`history`对象保存了浏览器的历史记录，调用`history`对象的`back()`和`forward()`方法可以实现前进和后退操作，但现代Web界面大量使用AJAX和页面交互，简单粗暴地调用`history`的方法并不是好的选择。

事实上，在任何情况下都不应该使用`history`对象。

### 操作DOM

（我们下文讨论的DOM节点是指`Element`，DOM节点实质上是`Node`，在HTML中`Node`包括`Element`、`Comment`、`CDATA_SECTION`、`Document`（根节点）等，但`Element`是实际控制页面的`Node`绝大多数我们只关心）

HTML文档被浏览器解析后就是一棵DOM树，改变HTML结构本质上就是改变DOM树的结构，JavaScript可以操作DOM，而操作DOM节点有如下操作：

- 更新：更新该DOM节点表示的HTML的内容
- 遍历：遍历该DOM节点下的子节点
- 添加：在该DOM节点下新增一个子节点，相当于动态加了一个HTML节点
- 删除：删除该DOM节点的内容以及它包含的所有子节点

要操作DOM节点，首先要拿到这个节点，实现这一步有不同的方法，常用的是前面讲过的`document.getElementById()`和`document.getElementsByTagName()`，还有CSS选择器`document.getElementsByClassName()`。

ID在HTML文档中是唯一的，`document.getElementById()`可以定位唯一的DOM节点，而`document.getElementByTagName()`和`document.getElementByClassName()`总是返回一组DOM节点，要精确选择DOM需要先定位父节点，然后进一步缩小范围：

```JavaScript
// 返回ID为'test'的节点：
var test = document.getElementById('test');

// 先定位ID为'test-table'的节点，再返回其内部所有tr节点：
var trs = document.getElementById('test-table').getElementsByTagName('tr');

// 先定位ID为'test-div'的节点，再返回其内部所有class包含red的节点：
var reds = document.getElementById('test-div').getElementsByTagName('red');

// 获取节点test下的所有直属子节点:
var cs = test.children;

// // 获取节点test下第一个、最后一个子节点：
var first = test.firstElementChild;
var last = test.lastElementChild;
```

除此之外，还可以使用`querySelector()`和`querySelectorAll()`，这里的`selector`正是CSS中的选择器，这种方式更加方便，但IE支持不好：

```JavaScript
// 通过querySelector获取ID为q1的节点：
var q1 = document.querySelector('#q1');

// 通过querySelectorAll获取q1节点内的符合条件的所有节点：
var ps = q1.querySelectorAll('div.highlighted > p');
```

做一个小练习，有如下HTML结构：

```HTML
<!-- HTML结构 -->
<div id="test-div">
<div class="c-red">
    <p id="test-p">JavaScript</p>
    <p>Java</p>
  </div>
  <div class="c-red c-green">
    <p>Python</p>
    <p>Ruby</p>
    <p>Swift</p>
  </div>
  <div class="c-green">
    <p>Scheme</p>
    <p>Haskell</p>
  </div>
</div>
```

找出指定条件的节点：

```JavaScript
// 选择<p>JavaScript</p>:
var js = ...;

// 选择<p>Python</p>,<p>Ruby</p>,<p>Swift</p>:
var arr = ...;

// 选择<p>Haskell</p>:
var haskell = ...;
```

答案&测试：

```JavaScript
// 答案：
var js = document.getElementById('test-p');
var arr = document.getElementsByClassName('c-red')[1].getElementsByTagName('p');
var haskell = document.getElementsByClassName('c-green')[1].lastElementChild;

// 解法不止一种：
var js = document.querySelector('#test-p');
var arr = document.querySelector('.c-red.c-green').children;
var haskell = document.querySelectorAll('.c-green')[1].lastElementChild;

// 测试：
if (!js || js.innerText !== 'JavaScript') {
    alert('选择JavaScript失败!');
} else if (!arr || arr.length !== 3 || !arr[0] || !arr[1] || !arr[2] || arr[0].innerText !== 'Python' || arr[1].innerText !== 'Ruby' || arr[2].innerText !== 'Swift') {
    console.log('选择Python,Ruby,Swift失败!');
} else if (!haskell || haskell.innerText !== 'Haskell') {
    console.log('选择Haskell失败!');
} else {
    console.log('测试通过!');
}
```

#### 更新DOM

拿到DOM节点后，就可以对它进行更新（修改），这里讨论的修改限于修改文本。

修改节点文本，有两种方法：

##### 修改`innerHTML`属性

这种方式不仅可以修改一个DOM节点的文本内容，还可以直接通过HTML代码修改DOM节点内部的子树：

```JavaScript
// 获取<p id="p-id">...<p>
var p = document.getElementById('p-id');
// 设置文本，自行测试效果
p.innerHTML = 'abc';
// 设置HTML，<p>...</p>的内部结构发生变化
p.innerHTML = 'abc <span style="color: red">RED</span> xyz';
```

使用这个属性的时候要注意是否写入HTML，对从网络拿到的字符串，注意编码，防范[XSS攻击](https://zhuanlan.zhihu.com/p/26177815)。

##### 修改`innerText`/`textContent`属性

这种方式可以自动对字符串进行HTML编码，保证无法设置任何HTML标签：

```JavaScript
// 获取<p id="p-id">...</p>
var p = document.getElementById('p-id');
// 设置文本:
p.innerText = '<script>alert("Hi")</script>';
// HTML被自动编码，无法设置一个<script>节点:
// <p id="p-id">&lt;script&gt;alert("Hi")&lt;/script&gt;</p>
```

读取属性时，`innerText`不返回隐藏元素的文本，`textContent`返回所有文本。

若要修改CSS，可以用DOM节点的`style`属性，该属性对应所有CSS，课直接获取或设置，注意CSS和JavaScript的命名方式有差异，比如CSS允许`font-size`，但这并不是JavaScript中的有效的属性名，所以在JavaScript中改成`fontSize`：

```JavaScript
// 获取<p id="p-id">...</p>
var p = document.getElementById('p-id');
// 设置CSS:
p.style.color = '#ff0000';
p.style.fontSize = '20px';
p.style.paddingTop = '2em';
```

#### 插入DOM

获取某个DOM节点后，可以进行插入操作，如果这个节点是空的，比如`<div></div>`，那么直接用`innerHTML = '<span>child</span>'`修改DOM节点内容即可，相当于插入了新节点。

如果DOM节点非空，那么显然不能使用上面的操作，有如下两种方式：

##### `appendChile`将子节点添加到父节点的最后一个子节点

假设HTML代码如下：

```HTML
<!-- HTML结构 -->
<p id="js">JavaScript</p>
<div id="list">
    <p id="java">Java</p>
    <p id="python">Python</p>
    <p id="scheme">Scheme</p>
</div>
```

将`<p id="js">JavaScript</p>`添加到`<div id="list">`的最后一项，可以这么写：

```JavaScript
var js = document.getElementById('js');
var list = document.getElementById('list');
list.appendChild(js);
```

HTML结构变成这样：

```HTML
<!-- HTML结构 -->
<div id="list">
    <p id="java">Java</p>
    <p id="python">Python</p>
    <p id="scheme">Scheme</p>
    <p id="js">JavaScript</p>
</div>
```

由于`js`节点本来已经存在，所以在做完上述操作之后这个节点首先从原来的位置删除，然后插入到新的位置。

更多时候是从零开始创建一个新的节点：

```JavaSCript
var list = document.getElementById('list');
var haskell = document.createElement('p');
haskell.id = 'haskell';
haskell.innerTest = 'Haskell';
list.appendChild(haskell);
```

HTML结构变成这样：

```HTML
<!-- HTML结构 -->
<div id="list">
    <p id="java">Java</p>
    <p id="python">Python</p>
    <p id="scheme">Scheme</p>
    <p id="haskell">Haskell</p>
</div>
```

借助上述操作可以实现很多功能，比如给文档动态增加CSS定义，在`<head>`节点末尾增加一个`<style>`节点即可：

```JavaScript
var d = document.createElement('style');
d.setAttribute('type', 'text/css');
d.innerHTML = 'p { color: red }';
document.getElementsByTagName('head')[0].appendChild(d);
```

##### `insertBefore`把子节点插入到指定位置

用`parentElement.insertBefore(newElement, referenceElement);`，子节点会插入到`referenceElement`之前，还是这段HTML代码，要把`Haskell`插入到`Python`之前：

```HTML
<!-- HTML结构 -->
<div id="list">
    <p id="java">Java</p>
    <p id="python">Python</p>
    <p id="scheme">Scheme</p>
</div>
```

```JavaScript
var
    list = document.getElementById('list'),
    ref = document.getElementById('python'),
    haskell = document.createElement('p');
haskell.id = 'haskell';
haskell.innerText = 'Haskell';
list.insertBefore(haskell, ref);
```

使用`insertBefore`重点是要拿到一个“参考子节点”的引用。很多时候，需要循环一个父节点的所有子节点，可以通过迭代`children`属性实现：

```JavaScript
var
    i, c,
    list = document.getElementById('list');
for (i = 0; i < list.children.length; i++) {
    c = list.children[i]; // 拿到第i个子节点
}
```

#### 删除DOM

删除DOM节点的操作相对容易得多，要删除一个节点，首先要获取这个节点和它的父节点，调用父节点的`removeChild`：

```JavaScript
// 获取待删除的节点
var self = document.getElementById('to-be-removed');
// 获取待删除节点的父节点
var parent = self.parentElement;
// 删除目标节点
var removed = parent.removeChild(self);
removed === slef; // true
```

在遍历一个父节点的子节点是注意`children`是一个只读属性并未在子节点变化时会实时更新，比如对下面的结构：

```HTML
<div id="parent">
    <p>First</p>
    <p>Second</p>
</div>
```

删除子节点：

```JavaScript
var parent = document.getElementById('parent');
parent.removeChild(parent.children[0]);
parent.removeChild(parent.children[1]); // <-- 浏览器报错
```

当`<p>First</p>`节点被删除后，`parent.children`的节点数量已经从2变为了1，索引`[1]`已经不存在了。删除多个节点时，要注意`children`属性时刻都在变化。

### 操作表单

表单也是DOM树，表单的输入框、下拉框等可以接受用户输入，所以用JavaScript操作表单可以获得用户输入的内容，或者对一个输入框设置新的内容。

HTML表单输入控件有如下几种：

- 文本框：用于输入文本，`<input type="text">`
- 口令框：用于输入口令，`<input type="password">`
- 单选框：用于选择一项，`<input type="radio">`
- 复选框：用于选择多项，`<input type="checkbox">`
- 下拉框：用于选择一项，`<select>`
- 隐藏文本：用户不可见，提交表单时会把隐藏的文本发送给服务器，`<input type="hidden">`

#### 获取值

当我们获得一个`<input>`节点的引用，可以直接调用`value`获取用户输入：

```JavaScript
// <input type="text" id="email">
var input = document.getElementById('email');
input.value; // '用户输入的值'
```

这种方式对`text`、`password`、`hidden`、`select`都有效，对于单选框和复选框，我们关心的往往是用户是否勾选选项，返回值意义不大，所以通常`checked`判断：

```JavaScript
// <label><input type="radio" name="weekday" id="monday" value="1"> Monday</label>
// <label><input type="radio" name="weekday" id="tuesday" value="2"> Tuesday</label>
var mon = document.getElementById('monday');
var tue = document.getElementById('tuesday');
mon.value; // '1'
tue.value; // '2'
mon.checked; // true或者false
tue.checked; // true或者false
```

#### 设置值

与获取值类似，可以设置`text`、`password`、`hidden`、`select`的`value`：

```JavaScript
// <input type="text" id="email">
var input = document.getElementById('email');
input.value = 'test@example.com'; // 文本框的内容已更新
```

对于单选框和复选框，设置`checked`为`true`或`false`即可。

#### HTML5控件

HTML5增加了大量标准控件，常用的包括`date`、`datetime`、`datetime-local`、`color`等，都使用`input`标签：

```HTML
<input type="date" value="2015-07-01">
```

```HTML
<input type="datetime-local" value="2015-07-01T02:03:04">
```

```HTML
<input type="color" value="#ff0000">
```

不支持HTML5的浏览器无法识别新的控件，会把它们当做`type="text"`来显示。支持HTML5的浏览器将获得格式化的字符串。例如，`type="date"`类型的`input`的`value`将保证是一个有效的`YYYY-MM-DD`格式的日期，或者空字符串。同学们自行尝试控件的效果。

#### 提交表单

最后讨论一下提交表单，JavaScript有两种表单提交方式（包括AJAX是三种，AJAX以后再说）。

通过`<form>`元素的`submit()`方法可以提交表单，比如响应一个`<button>`的`click`时间，在JavaScript中提交表单：

```HTML
<!-- HTML -->
<form id="test-form">
    <input type="text" name="test">
    <button type="button" onclick="doSubmitForm()">Submit</button>
</form>

<script>
function doSubmitForm() {
    var form = document.getElementById('test-form');
    // 可以在此修改form的input...
    // 提交form:
    form.submit();
}
</script>
```

这种方式的缺点是扰乱了浏览器对form的正常提交。浏览器默认点击`<button type="submit">`时提交表单，或者用户在最后一个输入框按回车键。因此，第二种方式是响应`<form>`本身的`onsubmit`事件，在提交`form`时作修改：

```HTML
<!-- HTML -->
<form id="test-form" onsubmit="return checkForm()">
    <input type="text" name="test">
    <button type="submit">Submit</button>
</form>

<script>
function checkForm() {
    var form = document.getElementById('test-form');
    // 可以在此修改form的input...
    // 继续下一步:
    return true;
}
</script>
```

`return true`告诉浏览器继续提交，如果`return false`，浏览器将不会继续提交form，这种情况通常对应用户输入有误，提示用户错误信息后终止提交form。

最后简单提一嘴安全性的问题，在检查和修改`<input>`时，要充分利用`<input type="hidden">`来传递数据。

例如，很多登录表单希望用户输入用户名和口令，但是，安全考虑，提交表单时不传输明文口令，而是口令的MD5。普通JavaScript开发人员会直接修改`<input>`：

```HTML
<!-- HTML -->
<form id="login-form" method="post" onsubmit="return checkForm()">
    <input type="text" id="username" name="username">
    <input type="password" id="password" name="password">
    <button type="submit">Submit</button>
</form>

<script>
function checkForm() {
    var pwd = document.getElementById('password');
    // 把用户输入的明文变为MD5:
    pwd.value = toMD5(pwd.value);
    // 继续下一步:
    return true;
}
</script>
```

用户输入了口令提交时，口令框的显示会突然从几个`*`变成32个`*`（因为MD5有32个字符）。要想不改变用户的输入，可以利用`<input type="hidden">`实现：

```HTML
<!-- HTML -->
<form id="login-form" method="post" onsubmit="return checkForm()">
    <input type="text" id="username" name="username">
    <input type="password" id="input-password">
    <input type="hidden" id="md5-password" name="password">
    <button type="submit">Submit</button>
</form>

<script>
function checkForm() {
    var input_pwd = document.getElementById('input-password');
    var md5_pwd = document.getElementById('md5-password');
    // 把用户输入的明文变为MD5:
    md5_pwd.value = toMD5(input_pwd.value);
    // 继续下一步:
    return true;
}
</script>
```

注意到id为md5-password的`<input>`标记了`name="password"`，而用户输入的`id`为`input-password`的`<input>`没有`name`属性。没有`name`属性的`<input>`的数据不会被提交。

### 操作文件

还得是HTML表单，在HTML表单中，可以且只可以通过控件`<input type="file">`上传文件，注意当表单包含这个控件时，表单的`enctype`必须为`multipart/from-data`，`method`必须指定为`post`，这样浏览器才能正确编码并以正确格式发送表单数据。出于安全考虑，浏览器只允许用户点击`<input type="file">`来选择本地文件，用JavaScript对`<input type="file">`的value赋值是没有任何效果的。当用户选择了上传某个文件后，JavaScript也无法获得该文件的真实路径：

![submit a file](pics\SubmitFile.png)

通常，上传的文件都由后台服务器处理，JavaScript可以在提交表单时对文件扩展名做检查，以便防止用户上传无效格式的文件：

```JavaScript
var f = document.getElementById('test-file-upload');
var filename = f.value; // 'C:\fakepath\test.png'
if (!filename || !(filename.endsWith('.jpg') || filename.endsWith('.png') || filename.endsWith('.gif'))) {
    alert('Can only upload image file.');
    return false;
}
```

由于JavaScript对用户上传的文件操作非常有限，尤其是无法读取文件内容，使得很多需要操作文件的网页不得不用Flash这样的第三方插件来实现。

随着HTML5的普及，新增的File API允许JavaScript读取文件内容，获得更多的文件信息。

HTML5的File API提供了`File`和`FileReader`两个主要对象，可以获得文件信息并读取文件。

比如：

```JavaScript
var
    fileInput = document.getElementById('test-image-file'),
    info = document.getElementById('test-file-info'),
    preview = document.getElementById('test-image-preview');
// 监听change事件:
fileInput.addEventListener('change', function () {
    // 清除背景图片:
    preview.style.backgroundImage = '';
    // 检查文件是否选择:
    if (!fileInput.value) {
        info.innerHTML = '没有选择文件';
        return;
    }
    // 获取File引用:
    var file = fileInput.files[0];
    // 获取File信息:
    info.innerHTML = '文件: ' + file.name + '<br>' +
                     '大小: ' + file.size + '<br>' +
                     '修改: ' + file.lastModifiedDate;
    if (file.type !== 'image/jpeg' && file.type !== 'image/png' && file.type !== 'image/gif') {
        alert('不是有效的图片文件!');
        return;
    }
    // 读取文件:
    var reader = new FileReader();
    reader.onload = function(e) {
        var
            data = e.target.result; // 'data:image/jpeg;base64,/9j/4AAQSk...(base64编码)...'            
        preview.style.backgroundImage = 'url(' + data + ')';
    };
    // 以DataURL的形式读取文件:
    reader.readAsDataURL(file);
});
```

这个例子演示了如何读取用户选取的图片文件，并在一个`<div>`中预览图像：

![FileAPIDemo](pics\FileAPI.png)

以DataURL的形式读取到的文件是一个字符串，类似于`data:image/jpeg;base64,/9j/4AAQSk...(base64编码)...`，常用于设置图像。如果需要服务器端处理，把字符串`base64`，后面的字符发送给服务器并用Base64解码就可以得到原始文件的二进制内容。

### AJAX