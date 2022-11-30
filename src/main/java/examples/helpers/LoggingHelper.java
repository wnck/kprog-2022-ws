package examples.helpers;

public class LoggingHelper {
  private static final org.slf4j.Logger logger =
      org.slf4j.LoggerFactory.getLogger(LoggingHelper.class);

  public static String getMethod() {
    StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
    return stackTrace[2].getMethodName();
  }
}
