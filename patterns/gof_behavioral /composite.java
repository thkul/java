package patterns.gof_behavioral;

import java.util.ArrayList;
import java.util.List;

// A way to treat single objects and whole groups the same. 
// Great for anything that grows into a tree.

public class composite {
  // Common interface for both files and folders
  public interface FileSystemComponent {
    void show(String indent);
  }

  // Leaf element
  public class FileItem implements FileSystemComponent {
    private final String name;
    public FileItem(String name) { this.name = name; }
    @Override
    public void show(String indent) {
      System.out.println(indent + "- File: " + name);
    }
  }

  // Composite element
  public class Folder implements FileSystemComponent {
    private final String name;
    private final List<FileSystemComponent> children = new ArrayList<>();
    public Folder(String name) { this.name = name; }
    public void add(FileSystemComponent component) {
      children.add(component);
    }
    @Override
    public void show(String indent) {
      System.out.println(indent + "+ Folder: " + name);
      for (FileSystemComponent child : children) { child.show(indent + "   "); }
    }
  }
}
