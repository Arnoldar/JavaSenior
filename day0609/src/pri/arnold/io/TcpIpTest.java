package pri.arnold.io;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @Author: Arnold
 * @Date: 2022/6/20 10:07
 */
public class TcpIpTest {

    //客户端
    @Test
    public void test() {

        Socket socket = null;
        OutputStream ops = null;
        BufferedInputStream bis = null;
        try {
            InetAddress ip = InetAddress.getByName("127.0.0.1");
            socket = new Socket(ip,8899);
            ops = socket.getOutputStream();

            File file = new File("haha.txt");
            bis = new BufferedInputStream(new FileInputStream(file));

            int len;
            byte[] cBuf = new byte[1024];
            while ((len = bis.read(cBuf)) != -1){
                ops.write(cBuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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

    //服务器
    @Test
    public void test1(){

        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        BufferedOutputStream bos = null;
        try {
            ss = new ServerSocket(8899);
            socket = ss.accept();

            File file = new File("hhhh.txt");
            is = socket.getInputStream();
            bos = new BufferedOutputStream(new FileOutputStream(file));

            int len;
            byte[] cBuf = new byte[1024];
            while ((len = is.read(cBuf)) != -1){
                bos.write(cBuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
