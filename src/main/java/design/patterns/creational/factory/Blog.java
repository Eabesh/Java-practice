package design.patterns.creational.factory;

/**
 * Created by abhay on 24/02/18.
 */
public class Blog extends Website{
  @Override
  public void createWebsite() {
    pages.add(new PostPage());
  }
}
