package com.zsp.util;

/**
 * author：Andy on 2020/11/10 0010-11:40
 * email:zsp872126510@gmail.com
 */


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * 日志记录
 *
 * @author Norton Lai
 * @created 2018-8-25 下午4:41:56
 */
public class Log {
    // 源生日志记录对象
    private static final Logger log = LoggerFactory.getLogger(Log.class);
    // 本对象的路径
    private static String thisClassUrl = Log.class.getName();

    // 私有构造
    private Log() {
    }

    /**
     * 为日志自定义一个变量 seat 日志里可以添加这个位置信息[%X{seat}]
     *
     * @return
     * @author Norton Lai
     * @created 2018-8-25 下午7:04:34
     */
    private static void setSeat() {
        MDC.put("seat", getInvokInfo());
    }

    /**
     * 返回此方法的调用者信息.<br>
     * 即谁调用此方法就返回调用位置的类名 方法名 行号 <br>
     * 例: >> net.evecom.cwyun.pdk.vmware.Main.main() 第 102 行 方法会从堆栈最上层往下找到第一个 非 Thread、CkUtil的调用者 ，如果没找到就取最底层的调用者信息
     *
     * @return
     * @author Norton Lai
     * @created 2017-10-16 下午2:42:43
     */
    private static String getInvokInfo() {
        StackTraceElement[] ste = Thread.currentThread().getStackTrace();
        String className = null;
        String methodName = null;
        int lineNumber = 0;
        // 从栈的最上开始 往下找 找到第一个不为Log和线程的类
        for (int i = 0; i < ste.length; i++) {
            className = ste[i].getClassName();

            if ("java.lang.Thread".equals(className) || thisClassUrl.equals(className)) {
                if (i != (ste.length - 1)) {
                    continue;// 如果不是最后一个就跳过，如果是最后一个那就没办法了，返回这栈信息吧
                }
            }
            methodName = ste[i].getMethodName();
            lineNumber = ste[i].getLineNumber();
            break;
        }
        return className + "." + methodName + "()@" + lineNumber + "";
    }

    /**
     * 日志记录
     *
     * @param arg0
     * @author Norton Lai
     * @created 2018-8-25 下午7:10:11
     */
    public static void debug(String arg0) {
            setSeat();
            log.debug(arg0);
    }

    /**
     * 日志记录
     *
     * @param arg0
     * @author Norton Lai
     * @created 2018-8-25 下午7:10:11
     */
    public static void debug(String arg0, Object arg1) {
        if (log.isDebugEnabled()) {
            setSeat();
            log.debug(arg0, arg1);
        }
    }

    /**
     * 日志记录
     *
     * @param arg0
     * @author Norton Lai
     * @created 2018-8-25 下午7:10:11
     */
    public static void debug(String arg0, Object[] arg1) {
        if (log.isDebugEnabled()) {
            setSeat();
            log.debug(arg0, arg1);
        }
    }

    /**
     * 日志记录
     *
     * @param arg0
     * @author Norton Lai
     * @created 2018-8-25 下午7:10:11
     */
    public static void debug(String arg0, Throwable arg1) {
        if (log.isDebugEnabled()) {
            setSeat();
            log.debug(arg0, arg1);
        }
    }

    /**
     * 日志记录
     *
     * @param arg0
     * @author Norton Lai
     * @created 2018-8-25 下午7:10:11
     */
    public static void error(String arg0) {
        if (log.isErrorEnabled()) {
            setSeat();
            log.error(arg0);
        }
    }

    /**
     * 日志记录
     *
     * @param arg0
     * @author Norton Lai
     * @created 2018-8-25 下午7:10:11
     */
    public static void error(String arg0, Object arg1) {
        if (log.isErrorEnabled()) {
            setSeat();
            log.error(arg0, arg1);
        }
    }

    /**
     * 日志记录
     *
     * @param arg0
     * @author Norton Lai
     * @created 2018-8-25 下午7:10:11
     */
    public static void error(String arg0, Object[] arg1) {
        if (log.isErrorEnabled()) {
            setSeat();
            log.error(arg0, arg1);
        }
    }

    /**
     * 日志记录
     *
     * @param arg0
     * @author Norton Lai
     * @created 2018-8-25 下午7:10:11
     */
    public static void error(String arg0, Throwable arg1) {
        if (log.isErrorEnabled()) {
            setSeat();
            log.error(arg0, arg1);
        }
    }

    /**
     * 日志记录
     *
     * @param arg0
     * @author Norton Lai
     * @created 2018-8-25 下午7:10:11
     */
    public static void info(String arg0) {
        if (log.isInfoEnabled()) {
            setSeat();
            log.info(arg0);
        }
    }

    /**
     * 日志记录
     *
     * @param arg0
     * @author Norton Lai
     * @created 2018-8-25 下午7:10:11
     */
    public static void info(String arg0, Object arg1) {
        if (log.isInfoEnabled()) {
            setSeat();
            log.info(arg0, arg1);
        }
    }

    /**
     * 日志记录
     *
     * @param arg0
     * @author Norton Lai
     * @created 2018-8-25 下午7:10:11
     */
    public static void info(String arg0, Object[] arg1) {
        if (log.isInfoEnabled()) {
            setSeat();
            log.info(arg0, arg1);
        }
    }

    /**
     * 日志记录
     *
     * @param arg0
     * @author Norton Lai
     * @created 2018-8-25 下午7:10:11
     */
    public static void info(String arg0, Throwable arg1) {
        if (log.isInfoEnabled()) {
            setSeat();
            log.info(arg0, arg1);
        }
    }

    /**
     * 日志记录
     *
     * @param arg0
     * @author Norton Lai
     * @created 2018-8-25 下午7:10:11
     */
    public static void trace(String arg0) {
        if (log.isTraceEnabled()) {
            setSeat();
            log.trace(arg0);
        }
    }

    /**
     * 日志记录
     *
     * @param arg0
     * @author Norton Lai
     * @created 2018-8-25 下午7:10:11
     */
    public static void trace(String arg0, Object arg1) {
        if (log.isTraceEnabled()) {
            setSeat();
            log.trace(arg0, arg1);
        }
    }

    /**
     * 日志记录
     *
     * @param arg0
     * @author Norton Lai
     * @created 2018-8-25 下午7:10:11
     */
    public static void trace(String arg0, Object[] arg1) {
        if (log.isTraceEnabled()) {
            setSeat();
            log.trace(arg0, arg1);
        }
    }

    /**
     * 日志记录
     *
     * @param arg0
     * @author Norton Lai
     * @created 2018-8-25 下午7:10:11
     */
    public static void trace(String arg0, Throwable arg1) {
        if (log.isTraceEnabled()) {
            setSeat();
            log.trace(arg0, arg1);
        }
    }

    /**
     * 日志记录
     *
     * @param arg0
     * @author Norton Lai
     * @created 2018-8-25 下午7:10:11
     */
    public static void warn(String arg0) {
        if (log.isWarnEnabled()) {
            setSeat();
            log.warn(arg0);
        }
    }

    /**
     * 日志记录
     *
     * @param arg0
     * @author Norton Lai
     * @created 2018-8-25 下午7:10:11
     */
    public static void warn(String arg0, Object arg1) {
        if (log.isWarnEnabled()) {
            setSeat();
            log.warn(arg0, arg1);
        }
    }

    /**
     * 日志记录
     *
     * @param arg0
     * @author Norton Lai
     * @created 2018-8-25 下午7:10:11
     */
    public static void warn(String arg0, Object[] arg1) {
        if (log.isWarnEnabled()) {
            setSeat();
            log.warn(arg0, arg1);
        }
    }

    /**
     * 日志记录
     *
     * @param arg0
     * @author Norton Lai
     * @created 2018-8-25 下午7:10:11
     */
    public static void warn(String arg0, Throwable arg1) {
        if (log.isWarnEnabled()) {
            setSeat();
            log.warn(arg0, arg1);
        }
    }

}



