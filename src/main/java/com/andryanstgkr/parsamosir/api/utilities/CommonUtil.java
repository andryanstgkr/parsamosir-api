package com.andryanstgkr.parsamosir.api.utilities;

import java.io.PrintWriter;
import java.io.StringWriter;

public class CommonUtil {

    public static String getErrorStackTrace(Exception e) {
        String errorStackTrace = "";
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        errorStackTrace = sw.toString();
        return errorStackTrace;
    }
}
