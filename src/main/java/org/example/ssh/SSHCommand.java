package org.example.ssh;

import com.jcraft.jsch.*;
import org.springframework.util.ObjectUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SSHCommand {

    public static void main(String[] args) throws JSchException {
        String username = "web";
        String password = "1213";
        String host = "192.168.0.235";
        int timeout = 2000;
        int port = 22;
        JSch jSch = new JSch();
        Session session = jSch.getSession(username, host, port);
        session.setPassword(password);
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.setTimeout(timeout);
        session.connect(2000);
        // 打印root目录下的信息
//        String cmd = "/usr/bin/free -g";
        String cmd = "df -Bg";
//        String cmd = "ps aux | grep bash 2>&1";
//        String cmd = "cat /proc/cpuinfo | grep processor | wc -l";
        List<String> result = exec(session, cmd);
        if(!ObjectUtils.isEmpty(result)){
            result.forEach(i->{
                System.out.println(i);
            });
        }
        if (session != null) {
            try {
                session.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 执行命令
     * @param command 命令
     * @return list
     * @throws JSchException err
     */
    public static  List<String> exec(Session session,String command) throws JSchException {
        List<String> resultLines = new ArrayList<>();
        ChannelExec channel = null;
        try{
            channel = (ChannelExec) session.openChannel("exec");
            channel.setPty(false);
            channel.setCommand(command);
            channel.setInputStream(null);
            channel.setErrStream(System.err);
            channel.connect();
            InputStream input = channel.getInputStream();
            try {
                BufferedReader inputReader = new BufferedReader(new InputStreamReader(input));
                String inputLine;
                while((inputLine = inputReader.readLine()) != null) {
                    resultLines.add(inputLine);
                }
            } finally {
                if (input != null) {
                    try {
                        input.close();
                    } catch (Exception e) {
                        // todo...
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException ignored) {
        } finally {
            if (channel != null) {
                try {
                    channel.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return resultLines;
    }
}
