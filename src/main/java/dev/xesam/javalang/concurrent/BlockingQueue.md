#BlockingQueue

##主要特点

A Queue that additionally supports operations that wait for the queue to become non-empty when retrieving an element, and wait for space to become available in the queue when storing an element.

##几个存取方法

<table border="" cellpadding="3" cellspacing="1">
 <caption>Summary of BlockingQueue methods</caption>
  <tbody><tr>
    <td></td>
    <td>Throws exception</td>
    <td>Special value</td>
    <td>Blocks</td>
    <td>Times out</td>
  </tr>
  <tr>
    <td>Insert</td>
    <td>add(e)</td>
    <td>offer(e)</td>
    <td>put(e)</td>
    <td>offer(e, time, unit)</td>
  </tr>
  <tr>
    <td>Remove</td>
    <td>remove()</td>
    <td>poll()</td>
    <td>take()</td>
    <td>poll(time, unit)</td>
  </tr>
  <tr>
    <td>Examine</td>
    <td>element()</td>
    <td>peek()</td>
    <td>not applicable</td>
    <td>not applicable</td>
  </tr>
 </tbody></table>

##offer,add,put
add(E e)

    throwing an IllegalStateException if no space is currently available.

offer(E e)

    returning false if no space is currently available.

put(E e)

    waiting if necessary for space to become available.

offer(e, time, unit)

    waiting up to the specified wait time if necessary for space to become available.


