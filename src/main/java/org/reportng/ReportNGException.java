package org.reportng;

/**
 * @author 喻海洋
 * Created Time: 2018/05/18 下午4:49
 */
public class ReportNGException extends RuntimeException {
    public ReportNGException(String string) {
        super(string);
    }

    public ReportNGException(String string, Throwable throwable) {
        super(string, throwable);
    }
}