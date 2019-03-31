import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution {

    private static int filesCount;
    private static int dirsCount;
    private static long filesTotalSize;

    public static void main(String[] args) throws IOException {

        BufferedReader cbr = new BufferedReader(new InputStreamReader(System.in));

        Path path = Paths.get(cbr.readLine());

        if (Files.isDirectory(path)) {

            filesCount = dirsCount = 0;
            filesTotalSize = 0;

            int depth = path.getNameCount() + 1;

            Files.walkFileTree(path, new SimpleFileVisitor<Path>() {

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    filesCount++;
                    filesTotalSize += Files.size(file);
                    return super.visitFile(file, attrs);
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    if (!dir.equals(path)) {
                        dirsCount++;
                    }
                    return super.postVisitDirectory(dir, exc);
                }
            });

            System.out.println("Всего папок - " + dirsCount);
            System.out.println("Всего файлов - " + filesCount);
            System.out.println("Общий размер - " + filesTotalSize);

        } else {
            System.out.println(path.toAbsolutePath() + " - не папка");
        }


    }
}
