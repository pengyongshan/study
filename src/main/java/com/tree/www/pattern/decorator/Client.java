package com.tree.www.pattern.decorator;

import java.io.*;

/**
 * Created by pysh on 2018/3/21.
 */
public class Client {
    public static void main(String[] args) throws Exception {
        DataOutputStream dout = new DataOutputStream(new EncryptOutputStream(
                new BufferedOutputStream(new FileOutputStream("test.txt"))));
        dout.write("abcdefghijk".getBytes());
        dout.close();
    }
}

class EncryptOutputStream extends FilterOutputStream {

    public EncryptOutputStream(OutputStream os) {
        super(os);
    }

    @Override
    public void write(int b) throws IOException {
        b = b + 2;
        if (b >= (97 + 26)) {
            b = b - 26;
        }
        super.write(b);
    }
}
