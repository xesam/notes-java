package io.github.xesam.lang.generic;

public class Main {
    public class Response<T> {
        T get() {
            return null;
        }
    }

    public class Result<T> {
        T get() {
            return null;
        }
    }

    public class StringResult extends Result<String> {
        @Override
        String get() {
            return "abc";
        }
    }

    public interface Client<T extends Result> {
        Response<T> get();
    }

    public static class Sample implements Client<StringResult> {
        @Override
        public Response<StringResult> get() {
            return null;
        }
    }
}
