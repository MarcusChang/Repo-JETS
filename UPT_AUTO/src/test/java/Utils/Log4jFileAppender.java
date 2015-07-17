package Utils;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Priority;

/**
 * 继承log4j的日志打印器，
 * 实现按级别输出到不同日志的功能。
 * To change this template use File | Settings | File Templates.
 */
public class Log4jFileAppender extends DailyRollingFileAppender {

    public boolean isAsSevereAsThreshold(Priority priority)
    {
        if( threshold == null ){
            return true;
        }
        //如果是INFO 级别的答应 info和warn warn 主要是在spring的全局异常时使用
        if( Priority.INFO_INT  == this.getThreshold().toInt() ) {
            if( priority.toInt() == Priority.INFO_INT || priority.toInt() == Priority.WARN_INT ){
                return true;
            }

        }
        //如果是error只打印error
        if( Priority.ERROR_INT == this.getThreshold().toInt() ){
            return  this.getThreshold().equals(priority);
        }

        return  false;
    }


}
