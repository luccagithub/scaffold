package com.zfax.scaffold.controller;

/**
 * @description:
 * @author: Born
 * @create: 2018-06-22 16:45
 **/
public interface Urls {

    interface Admins {

        String ROOT = "/admins";

        String ONE = ROOT + "/{id}";
        String DETAILS = ROOT + "/details/{id}";
        String DUBBO = ROOT + "/dubbo";
        String MONGO = ROOT + "/mongodb";
        String EVENT_MESSAGE = ROOT + "/event-message";
        String CURRENT_ADMIN = ROOT + "/current-admin/info";
        String FEIGN = ROOT + "/feign";
    }
}
