package cool.happycoding.code.log.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * description
 *
 * @author lanlanhappy 2021/03/18 10:01 上午
 */
public abstract class AbstractPrintHandler implements PrintHandler{

     public boolean isMultipart(HttpServletRequest servletRequest){
         return false;
     }

     public boolean isBinary(HttpServletRequest servletRequest){
         return false;
     }

     public boolean isDownload(HttpServletResponse response){
         return false;
     }

}
