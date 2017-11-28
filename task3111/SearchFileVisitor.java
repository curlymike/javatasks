import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.ArrayList;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {

  private List<Path> foundFiles;
  private String partOfName;
  private String partOfContent;
  private int minSize;
  private int maxSize;

  /**************************************************
   *
   **************************************************/

  public SearchFileVisitor() {
    foundFiles = new ArrayList<Path>();
    partOfName = null;
    partOfContent = null;
    minSize = -1;
    maxSize = -1;
  }

  /**************************************************
   *
   **************************************************/

  @Override
  public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
    byte[] content = Files.readAllBytes(file); // размер файла: content.length

    boolean minSizeOk = minSize == -1 || content.length >= minSize;
    boolean maxSizeOk = maxSize == -1 || content.length <= maxSize;
    boolean nameOk = partOfName == null || file.getFileName().toString().contains(partOfName);
    boolean contentOk = partOfContent == null || new String(content).contains(partOfContent);

    //System.out.println(content.length + " " + minSizeOk + " " + maxSizeOk + " " + nameOk + " " + contentOk + " - " + file.getFileName());

    if (minSizeOk && maxSizeOk && nameOk && contentOk) {
      foundFiles.add(file);
    }

    return super.visitFile(file, attrs);
  }

  /**************************************************
   *
   **************************************************/

  public List<Path> getFoundFiles() {
    return foundFiles;
  }

  /**************************************************
   *
   **************************************************/

  public void setPartOfName(String str) {
    partOfName = str;
  }

  public void setPartOfContent(String str) {
    partOfContent = str;
  }

  public void setMinSize(int number) {
    minSize = number;
  }

  public void setMaxSize(int number) {
    maxSize = number;
  }

  /**************************************************
   *
   **************************************************/

  /**************************************************
   *
   **************************************************/

  /**************************************************
   *
   **************************************************/

  /**************************************************
   *
   **************************************************/

  /**************************************************
   *
   **************************************************/

  /**************************************************
   *
   **************************************************/

  /**************************************************
   *
   **************************************************/

  /**************************************************
   *
   **************************************************/


}
