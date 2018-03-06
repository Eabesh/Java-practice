package design.patterns.creational.factory;

/**
 * Created by abhay on 24/02/18.
 */
public class WebsiteFactory {

  public static Website getWebsite(WebsiteType websiteType) {
    switch (websiteType) {
      case BLOG: {
        return new Blog();
      }
      case SHOP: {
        return new Shop();
      }
      default:
        return null;
    }
  }
}
