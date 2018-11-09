package com.humy.springboot.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: Hu Min
 * @Date: 2018/11/5 15:38
 * @Description:
 */
public class FilterUtils {
    private static final List<Pattern> urlPattern = new ArrayList<>();
    static{
        urlPattern.add(Pattern.compile("^.*/favicon.ico$"));
    }
    public FilterUtils() {

    }
    public static boolean isInclude(String url) {
        for (Pattern pattern : urlPattern) {
            Matcher matcher = pattern.matcher(url);
            if (matcher.matches()) {

                return true;
            }
        }
        return false;
    }
}
