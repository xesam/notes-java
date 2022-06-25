package io.github.xesam.lang.tools;

import javax.tools.FileObject;
import javax.tools.JavaFileObject;
import java.io.*;
import java.net.URI;

/**
 * Created by xe on 14-11-21.
 */
public class FileObjectTest {
    public static void main(String[] args) {
        StringFileObject stringFileObject = new StringFileObject("java.lang.String", "test");
//        System.out.println(URI.create("string:///test" + JavaFileObject.Kind.SOURCE.extension));
        System.out.println(stringFileObject.toUri());
        try {
            Reader reader = stringFileObject.openReader(false);
            BufferedReader bf = new BufferedReader(reader);
            System.out.println(bf.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    final static class StringFileObject implements FileObject {

        private String className;
        private String source;

        public StringFileObject(String className, String source) {
            this.className = className;
            this.source = source;
        }

        @Override
        public URI toUri() {
            return URI.create("string:///" + className.replaceAll("\\.", "/") + JavaFileObject.Kind.SOURCE.extension);
        }

        @Override
        public String getName() {
            return toUri().getPath();
        }

        @Override
        public InputStream openInputStream() throws IOException {
            return new ByteArrayInputStream(source.getBytes());
        }

        @Override
        public OutputStream openOutputStream() throws IOException {
            throw new UnsupportedOperationException();
        }

        @Override
        public Reader openReader(boolean ignoreEncodingErrors) throws IOException {
            return new InputStreamReader(openInputStream());
        }

        @Override
        public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
            return source;
        }

        @Override
        public Writer openWriter() throws IOException {
            return new OutputStreamWriter(openOutputStream());
        }

        @Override
        public long getLastModified() {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean delete() {
            throw new UnsupportedOperationException();
        }
    }
}


