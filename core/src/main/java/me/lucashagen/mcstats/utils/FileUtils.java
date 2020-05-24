package me.lucashagen.mcstats.utils;

import me.lucashagen.mcstats.Main;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collections;

public class FileUtils {

    /**
     * Blocked constructor
     */
    private FileUtils() {

    }

    /**
     * Copies a file or folder from the .jar, to the file system.
     *
     * @param source File to be copied (from the .jar)
     * @param target Where to copy the file to
     * @throws URISyntaxException URI syntax error
     * @throws IOException IO Exception
     */
    public static void copyFromJar(String source, final Path target)
            throws URISyntaxException, IOException {
        URI resource = Main.class.getResource("").toURI();
        FileSystem fileSystem = FileSystems.newFileSystem(
                resource,
                Collections.<String, String>emptyMap()
        );


        final Path jarPath = fileSystem.getPath(source);

        Files.walkFileTree(jarPath, new SimpleFileVisitor<Path>() {

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                Path currentTarget = target.resolve(jarPath.relativize(dir).toString());
                Files.createDirectories(currentTarget);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.copy(file, target.resolve(jarPath.relativize(file).toString()), StandardCopyOption.REPLACE_EXISTING);
                return FileVisitResult.CONTINUE;
            }

        });
    }

}
