#try-with-resources

##【Java记录】try-with-resources的一个坑

今天处理 AsynchronousFileChannel 时候的一个问题，代码如下：

    public static void main(String[] args) throws Exception {

        String filePath = "/home/xe/git/osc/JavaNote/Lang/data/Test.java";
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Set<OpenOption> openOptions = new HashSet<>(Arrays.asList(new StandardOpenOption[]{StandardOpenOption.READ}));

        try (AsynchronousFileChannel asynchronousFileChannel = AsynchronousFileChannel.open(Paths.get(filePath), openOptions, executorService)) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            asynchronousFileChannel.read(buffer, 0, buffer, new CompletionHandler<Integer, ByteBuffer>() {
                @Override
                public void completed(Integer result, ByteBuffer attachment) {
                    System.out.println("completed,result = " + result);
                    executorService.shutdown();
                }

                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {
                    System.out.println("failed");
                    exc.printStackTrace();
                    executorService.shutdown();
                }
            });
        } catch (Exception e) {
        }
    }

一直提示：

    java.nio.channels.AsynchronousCloseException

一直找不到问题的原因，因为我并没有显式的去关闭 AsynchronousFileChannel，后来才发现，是被 try-with-resources 特性给关闭了，悲伤的故事。

所以，在异步调用中， 还是谨慎的处理通告的关闭操作比较好。


