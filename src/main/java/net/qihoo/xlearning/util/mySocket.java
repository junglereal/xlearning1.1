package net.qihoo.xlearning.util;

import net.qihoo.xlearning.container.XLearningContainer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * Created by admin on 18/1/24.
 */
public class mySocket  {


    public  boolean  inited  = false;
    public  int port = 0;
    private static final Log LOG = LogFactory.getLog(mySocket.class);
    public static boolean isPortUsing(String host,int port) throws UnknownHostException {
        boolean flag = false;
        InetAddress Address = InetAddress.getByName(host);
        try {
            Socket socket = new Socket(Address,port); //建立一个Socket连接
            flag = true;
        } catch (IOException e) {
        }
        return flag;
    }
    public  int  genRandom(int max ,int  min){
        Random random = new Random();

        int s = random.nextInt(max)%(max-min+1) + min;

        return s;
    }

    public  int  getLocalPort (){

        if(inited)
            return  port;

        inited = true;
        port =  genRandom(60000,20000);
        try {
            port =  genRandom(60000,20000);
            /**
            while (isPortUsing("localhost",port)){
                port =  genRandom(60000,20000);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
             ***/
            LOG.info("getLocalPort find port:" + port);
            return port;
        } catch (Exception e) {
            e.printStackTrace();

        }

        return  port ;

    }
}
