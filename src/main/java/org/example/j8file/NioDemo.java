package org.example.j8file;

import java.io.IOException;
import java.nio.file.*;

public class NioDemo {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello Web");
//        Files.write(Paths.get("a.txt"),"sss".getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);
        info(Paths.get("a.txt"));
        System.out.println(Paths.get("a.txt").toAbsolutePath());
        System.out.println(Files.getFileStore(Paths.get("a.txt")));
    }

    static void say(String id, Object result) {
        System.out.print(id + ": ");
        System.out.println(result);
    }

    private static void show(String id, Object p) {
        System.out.println(id + ": " + p);
    }

    private static void info(Path p) throws IOException {
        show("toString", p);
        show("Exists", Files.exists(p));
        show("RegularFile", Files.isRegularFile(p));
        show("Directory", Files.isDirectory(p));
        show("Absolute", p.isAbsolute());
        show("FileName", p.getFileName());
        show("Parent", p.getParent());
        show("Root", p.getRoot());
        show("nameCount", p.getNameCount());
        System.out.println("******************");
        say("Exists", Files.exists(p));
        say("Directory", Files.isDirectory(p));
        say("Executable", Files.isExecutable(p));
        say("Readable", Files.isReadable(p));
        say("RegularFile", Files.isRegularFile(p));
        say("Writable", Files.isWritable(p));
        say("notExists", Files.notExists(p));
        say("Hidden", Files.isHidden(p));
        say("size", Files.size(p));
        say("FileStore", Files.getFileStore(p));
        say("LastModified: ", Files.getLastModifiedTime(p));
        say("Owner", Files.getOwner(p));
        say("ContentType", Files.probeContentType(p));
        say("SymbolicLink", Files.isSymbolicLink(p));
        if(Files.isSymbolicLink(p)) {
            say("SymbolicLink", Files.readSymbolicLink(p));
        }
        if(FileSystems.getDefault().supportedFileAttributeViews().contains("posix")) {
            say("PosixFilePermissions",
                    Files.getPosixFilePermissions(p));
        }
        System.out.println("******************");
        System.out.println(System.getProperty("os.name"));
        FileSystem fsys = FileSystems.getDefault();
        for(FileStore fs : fsys.getFileStores()) {
            show("File Store", fs);
        }

        System.out.println("******************");

    }


}
