package org.example.j8file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileTool {


    public static void main(String[] args) throws IOException {
        Map<String, Long> collect = Files.readAllLines(Paths.get("/home/web/logs/ip_count.log"))
                .stream()
                .map(s -> {
                    String[] split = s.trim().split("\\s");
                    return new IPCount(split[1], Long.parseLong(split[0]));
                })
                .collect(Collectors.groupingBy(IPCount::getIp, Collectors.summingLong(IPCount::getCount)));

        List<String> collect1 = collect.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(s -> s.getKey() + " " + s.getValue())
                .collect(Collectors.toList());

        BufferedWriter writer = new BufferedWriter(new FileWriter("./aa.log"));
        collect1.forEach(s->{
            try {
                writer.write(s+"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        writer.close();


    }

}

