package com.cloud.zhpt.dto;

import com.cloud.zhpt.entity.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @ClassName UserDto
 * @Description
 * @Author SW
 * @Date 2019/9/12 22:48
 **/
@Getter
@Setter
@ToString
public class UserDto extends User implements Serializable {

    private static final long serialVersionUID = 554262417111655721L;

    private String sid;

    /**
     * 加密的user信息
     */
    private String encryptUser;



}
