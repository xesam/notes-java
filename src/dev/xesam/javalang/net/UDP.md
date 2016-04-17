## new DatagramSocket(null)

注意空参数构造函数的区别。

DatagramSocket ds = new DatagramSocket(null); // 指定Null很重要，否则Java会自动随机选个可用端口来绑定
ds.setReuseAddress(true); // 绑定之前先设置Reuse
ds.bind(new InetSocketAddress(30002)); // 然后再绑定
System.out.println("REUSEADDR is enabled: " + ds.getReuseAddress()); // 返回结果是true，说明才有效