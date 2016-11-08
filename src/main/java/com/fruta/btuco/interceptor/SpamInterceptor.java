package com.fruta.btuco.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by facundo on 12/20/15.
 */
public class SpamInterceptor extends HandlerInterceptorAdapter {

    private List servingList;

    public SpamInterceptor() {
        this.servingList = new ArrayList<String>();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String ip = request.getRemoteAddr();

        if(servingList.contains(ip)){
            System.out.println(ip + " blocked!");
            return false;
        }

        servingList.add(ip);

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String ip = request.getRemoteAddr();
        servingList.remove(ip);
    }
}
