#NetworkChannel


A unique TCP connection is identifiedby five elements:

    the IP address of the server
    port of the server
    the IP address of the client
    port of the client
    the protocol (TCP/IP, UDP, etc.)


##Blocking vs. Non-Blocking Mechanisms

Non-blocking mechanisms are not the same as asynchronous mechanisms (although this is often
debated depending on who you ask). For example, in a non-blocking environment, if an answer can’t be returned
rapidly, the API returns immediately with an error and does nothing else, while in an asynchronous environment,
the API always returns immediately, having started a behind-the-scenes effort to serve your request. In other
words, with a non-blocking mechanism, a function won’t wait while on the stack, and with an asynchronous
mechanism, work may continue on behalf of the function call after that call has left the stack. Asynchronous is
more familiar with parallel (as threading), while non-blocking often refers to polling.



