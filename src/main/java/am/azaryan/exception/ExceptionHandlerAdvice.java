package am.azaryan.exception;

import am.azaryan.security.SpringUser;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
@RequiredArgsConstructor
public class ExceptionHandlerAdvice {

    @ExceptionHandler(NullPointerException.class)
    public ModelAndView allExceptionHandler(@AuthenticationPrincipal SpringUser springUser) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/error-404-basic");
        springUser.isAccountNonExpired();
        return modelAndView;
    }

}
