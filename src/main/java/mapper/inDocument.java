package mapper;

import pojo.document;

public interface inDocument {
 public document[] list();
 public document get(String id);
 public void add(document docu);

}
