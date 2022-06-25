#Java 1.0
对字节的支持
##InputStream
    public abstract int read() throws IOException

返回的是一个byte，范围0-255

##OutputStream
    public abstract void write(int b) throws IOException
写入的是一个byte，范围0-255

#Java 1.1
增加了对字符的支持

##Reader
    public int read() throws IOException
返回的是一个char，范围0-65535

##Writer
    public void write(int c) throws IOException
写入的是一个char，范围0-65535

另外，由于Writer可以处理字符，所以也可以直接处理String
   
    public void write(String str) throws IOException

# java 1.4
selectors


