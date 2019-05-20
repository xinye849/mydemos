package xin.yuan.exceptions;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @authorknightx
 * @create2019/4/15
 * @since 1.0.0
 */
public class SysExceptionResolve implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        if (e instanceof ArithmeticException){
            e = (ArithmeticException)e;
        }else {
           e = new ArithmeticException();

        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("error",e.getMessage());
        mv.setViewName("error");
        return mv;
    }

}
