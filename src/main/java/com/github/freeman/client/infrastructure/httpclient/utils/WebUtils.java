package com.github.freeman.client.infrastructure.httpclient.utils;

import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;


public abstract class WebUtils {


    private WebUtils() {
    }


    /*
     *  Save state to ServletContext, key = value = state
     */
    public static void saveState(HttpServletRequest request, String state) {
        final ServletContext servletContext = request.getSession().getServletContext();
        servletContext.setAttribute(state, state);
    }

    /*
     *  Validate state when callback from Oauth Server.
     *  If validation successful, will remove it from ServletContext.
     */
    public static boolean validateState(HttpServletRequest request, String state) {
        if (StringUtils.isEmpty(state)) {
            return false;
        }
        final ServletContext servletContext = request.getSession().getServletContext();
        final Object value = servletContext.getAttribute(state);

        if (value != null) {
            servletContext.removeAttribute(state);
            return true;
        }
        return false;
    }
}