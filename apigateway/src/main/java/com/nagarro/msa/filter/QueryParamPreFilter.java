package com.nagarro.msa.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


public class QueryParamPreFilter extends ZuulFilter {
	@Override
	public int filterOrder() {
		return PRE_DECORATION_FILTER_ORDER - 1; // run before PreDecoration
	}

	@Override
	public String filterType() {
		return PRE_TYPE;
	}

	@Override
	public boolean shouldFilter() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return((authentication.getName()!=null));
		}
    @Override
    public Object run() {
    	
    	RequestContext ctx = RequestContext.getCurrentContext();
    	  Map<String, List<String>> newParameterMap = new HashMap<>();
    	    Map<String, String[]> parameterMap = ctx.getRequest().getParameterMap();
    	    //getting the current parameter
    	    for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
    	      String key = entry.getKey();
    	      String[] values = entry.getValue();
    	      newParameterMap.put(key, Arrays.asList(values));
    	    }
    	    //add a new parameter
    		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	    String paramkey = "username";
    	    String currentUserName = authentication.getName();
    	    newParameterMap.put(paramkey,Arrays.asList(currentUserName));
    	    ctx.setRequestQueryParams(newParameterMap);
    	return null;
    }
}
