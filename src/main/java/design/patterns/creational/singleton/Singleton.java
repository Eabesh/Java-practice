package design.patterns.creational.singleton;

class Singleton {

  private volatile static Singleton firstInstance = null;
  private static final Object lock = new Object();

  private Singleton() {}

  public static Singleton getInstance() {
    if (firstInstance == null) firstInstance = new Singleton();
    return firstInstance;
  }

  /**
   * The above method has a problem where two threads coming simultaneously can create two
   * instances.
   */
  public static synchronized Singleton getInstanceSync() {
    if (firstInstance == null) firstInstance = new Singleton();
    return firstInstance;
  }

  /** double lock checking, in above code, synchronised is blocking all the methods, therefore
   * synchronised block is ued for creating the object and reads outside the synchronised. */

  public static Singleton getFirstInstance() {
    if (firstInstance != null) return firstInstance;
    else {
      synchronized (lock) {
        if (firstInstance == null) {
          firstInstance = new Singleton();
          return firstInstance;
        } else return firstInstance;
      }
    }
  }

  /** In the above code, problem arises when a thread reads while the object is being creadted. To overcome this
   * we can decalre first Instance as volatile.
   **/

}
