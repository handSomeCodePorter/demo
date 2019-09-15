package com.cloud.zhpt.dto;

import com.cloud.zhpt.entity.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName UserDto
 * @Description
 * @Author SW
 * @Date 2019/9/12 22:48
 **/
@Getter
@Setter
@ToString
public class UserDto extends User {

    private String sid;



}
