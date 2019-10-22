package com.cloud.zhpt.exception;

/**
 * @ClassName ExceptionInfoEnum
 * @Description
 * @Author SW
 * @Date 2019/10/17 11:06
 **/
public enum  ExceptionCode {
    ZP400("RT0000400"),
    ZP401("RT0000401"),
    ZP403("RT0000403"),
    ZP404("RT0000404"),
    ZP500("RT0000500");


    private ExceptionCode(String code) {
        this.code = code;
    }

    private  String code;

    public String getCode() {
        return code;
    }
}
