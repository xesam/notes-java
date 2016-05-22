#Class

##basic
Class类没有公开的构造方法，但是如果我要反射一个出来会怎样？

获取class引用

int.class

Integer.TYPE

##getDeclaringClass vs getEnclosingClass

匿名内部类getDeclaringClass返回null，getEnclosingClass返回包含此匿名内部类的class。
因为在java语言规范里面，类A的匿名内部类不属于类A


##

<table border="1" summary="Class Methods for Locating Fields">
    <caption>Class Methods for Locating Fields</caption>
    <tbody><tr>
    <th id="h1">
    <a class="APILink" target="_blank" href="http://docs.oracle.com/javase/8/docs/api/java/lang/Class.html"><code>Class</code></a> API</th>
    <th id="h2">List of members?</th>
    <th id="h3">Inherited members?</th>
    <th id="h4">Private members? <!-- Field =====================--></th>
    </tr>
    <tr>
    <td headers="h1">
    <a class="APILink" target="_blank" href="http://docs.oracle.com/javase/8/docs/api/java/lang/Class.html#getDeclaredField-java.lang.String-"><code>getDeclaredField()</code></a></td>
    <td headers="h2" align="center">no</td>
    <td headers="h3" align="center">no</td>
    <td headers="h4" align="center">yes</td>
    </tr>
    <tr>
    <td headers="h1">
    <a class="APILink" target="_blank" href="http://docs.oracle.com/javase/8/docs/api/java/lang/Class.html#getField-java.lang.String-"><code>getField()</code></a></td>
    <td headers="h2" align="center">no</td>
    <td headers="h3" align="center">yes</td>
    <td headers="h4" align="center">no</td>
    </tr>
    <tr>
    <td headers="h1">
    <a class="APILink" target="_blank" href="http://docs.oracle.com/javase/8/docs/api/java/lang/Class.html#getDeclaredFields--"><code>getDeclaredFields()</code></a></td>
    <td headers="h2" align="center">yes</td>
    <td headers="h3" align="center">no</td>
    <td headers="h4" align="center">yes</td>
    </tr>
    <tr>
    <td headers="h1">
    <a class="APILink" target="_blank" href="http://docs.oracle.com/javase/8/docs/api/java/lang/Class.html#getFields--"><code>getFields()</code></a></td>
    <td headers="h2" align="center">yes</td>
    <td headers="h3" align="center">yes</td>
    <td headers="h4" align="center">no</td>
    </tr>
    </tbody>
</table>


<table border="1" summary="Class Methods for Locating Methods">
<caption>Class Methods for Locating Methods</caption>
<tbody><tr>
<th id="h101">
<a class="APILink" target="_blank" href="http://docs.oracle.com/javase/8/docs/api/java/lang/Class.html"><code>Class</code></a> API</th>
<th id="h102">List of members?</th>
<th id="h103">Inherited members?</th>
<th id="h104">Private members?</th>
</tr>
<tr>
<td headers="h101">
<a class="APILink" target="_blank" href="http://docs.oracle.com/javase/8/docs/api/java/lang/Class.html#getDeclaredMethod-java.lang.String-java.lang.Class...-"><code>getDeclaredMethod()</code></a></td>
<td headers="h102" align="center">no</td>
<td headers="h103" align="center">no</td>
<td headers="h104" align="center">yes</td>
</tr>
<tr>
<td headers="h101">
<a class="APILink" target="_blank" href="http://docs.oracle.com/javase/8/docs/api/java/lang/Class.html#getMethod-java.lang.String-java.lang.Class...-"><code>getMethod()</code></a></td>
<td headers="h102" align="center">no</td>
<td headers="h103" align="center">yes</td>
<td headers="h104" align="center">no</td>
</tr>
<tr>
<td headers="h101">
<a class="APILink" target="_blank" href="http://docs.oracle.com/javase/8/docs/api/java/lang/Class.html#getDeclaredMethods--"><code>getDeclaredMethods()</code></a></td>
<td headers="h102" align="center">yes</td>
<td headers="h103" align="center">no</td>
<td headers="h104" align="center">yes</td>
</tr>
<tr>
<td headers="h101">
<a class="APILink" target="_blank" href="http://docs.oracle.com/javase/8/docs/api/java/lang/Class.html#getMethods--"><code>getMethods()</code></a></td>
<td headers="h102" align="center">yes</td>
<td headers="h103" align="center">yes</td>
<td headers="h104" align="center">no</td>
</tr>
</tbody></table>

<table border="1" summary="Class Methods for Locating Constructors">
<caption>Class Methods for Locating Constructors</caption>
<tbody><tr>
<th id="h201">
<a class="APILink" target="_blank" href="http://docs.oracle.com/javase/8/docs/api/java/lang/Class.html"><code>Class</code></a> API</th>
<th id="h202">List of members?</th>
<th id="h203">Inherited members?</th>
<th id="h204">Private members?</th>
</tr>
<tr>
<td headers="h201">
<a class="APILink" target="_blank" href="http://docs.oracle.com/javase/8/docs/api/java/lang/Class.html#getDeclaredConstructor-java.lang.Class...-"><code>getDeclaredConstructor()</code></a></td>
<td headers="h202" align="center">no</td>
<td headers="h203" align="center">N/A<sup>1</sup></td>
<td headers="h204" align="center">yes</td>
</tr>
<tr>
<td headers="h201">
<a class="APILink" target="_blank" href="http://docs.oracle.com/javase/8/docs/api/java/lang/Class.html#getConstructor-java.lang.Class...-"><code>getConstructor()</code></a></td>
<td headers="h202" align="center">no</td>
<td headers="h203" align="center">N/A<sup>1</sup></td>
<td headers="h204" align="center">no</td>
</tr>
<tr>
<td headers="h201">
<a class="APILink" target="_blank" href="http://docs.oracle.com/javase/8/docs/api/java/lang/Class.html#getDeclaredConstructors--"><code>getDeclaredConstructors()</code></a></td>
<td headers="h202" align="center">yes</td>
<td headers="h203" align="center">N/A<sup>1</sup></td>
<td headers="h204" align="center">yes</td>
</tr>
<tr>
<td headers="h201">
<a class="APILink" target="_blank" href="http://docs.oracle.com/javase/8/docs/api/java/lang/Class.html#getConstructors--"><code>getConstructors()</code></a></td>
<td headers="h202" align="center">yes</td>
<td headers="h203" align="center">N/A<sup>1</sup></td>
<td headers="h204" align="center">no</td>
</tr>
</tbody></table>




