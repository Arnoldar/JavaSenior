package pri.arnold.io;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: Arnold
 * @Date: 2022/6/21 15:35
 */
public class TcpIpTest1 {

    @Test
    public void test() {

        Socket socket = null;
        OutputStream ops = null;
        BufferedInputStream bis = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            InetAddress ip = InetAddress.getByName("127.0.0.1");
            socket = new Socket(ip, 9090);
            ops = socket.getOutputStream();

            File file = new File("haha.txt");
            bis = new BufferedInputStream(new FileInputStream(file));

            byte[] cBuf = new byte[1024];
            int len;
            while ((len = bis.read(cBuf)) != -1) {
                ops.write(cBuf, 0, len);
            }
            socket.shutdownOutput();

            is = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] cBuf1 = new byte[1024];
            int len1;
            while ((len1 = is.read(cBuf1)) != -1) {
                baos.write(cBuf1);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null)
                    baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (ops != null)
                    ops.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test1() {

        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        BufferedOutputStream bos = null;
        OutputStream os = null;
        try {
            ss = new ServerSocket(9090);
            socket = ss.accept();
            is = socket.getInputStream();

            File file = new File("xslw3.txt");
            bos = new BufferedOutputStream(new FileOutputStream(file));

            byte[] cBuf = new byte[1024];
            int len;
            while ((len = is.read(cBuf)) != -1) {
                bos.write(cBuf, 0, len);
            }

            System.out.println("发送消息");
            os = socket.getOutputStream();
            os.write("接收成功".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null)
                    os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (ss != null)
                    ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
