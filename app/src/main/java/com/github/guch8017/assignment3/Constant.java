package com.github.guch8017.assignment3;

public class Constant {
    public static final int UNKNOWN = -1;

    public static final String LOGIN_RESULT = "LOGIN_RESULT";
    public static final int LOGIN_SUCCESS = 1;
    public static final int LOGIN_FAILED = 0;

    public static final String HOST_URL = "http://106.52.171.165:8077";
    public static final String LOGIN_S = "/login";

    public static final String JS_REMOVE_ELEMENTS =
            "javascript: (function(){" +
            "var ic_sf = document.getElementsByClassName('icon icon-shuffle')[0];if(ic_sf != null){ic_sf.remove()}" +
            "var ic_menu = document.getElementsByClassName('icon icon-menu3')[0];if(ic_menu != null){ic_menu.style.visibility = 'hidden';}" +
            "var ic_dl = document.getElementsByClassName('icon icon-download2')[0];if(ic_dl != null){ic_dl.remove();}" +
            "var ic_usr = document.querySelector(\"#top-bar-user > span > span.user-image.default-user-image\");if(ic_usr != null){ic_usr.remove();}" +
            "var ic_login = document.querySelector(\"#top-bar-signin > a > span.icon.icon-login.tablet-hide.laptop-hide.desktop-hide\");if(ic_login != null){ic_login.remove();}" +
            "var it_up = document.querySelector(\"#menu-fullscreen > ul > li.top-btn-el.current\");if(it_up !=  null){it_up.remove();}})()";

    public static final String JS_MENU_CLICK =
            "javascript: (function(){document.getElementsByClassName('icon icon-menu3')[0].click();document.querySelector(\"#menu-fullscreen > ul > li.top-btn-el.current\").remove()})()";
}
