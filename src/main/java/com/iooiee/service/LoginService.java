package com.iooiee.service;

import com.iooiee.domain.User;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: Yanggc
 * DateTime: 2020-05-15 10:05
 */

public interface LoginService {
    public User getUserByName(String getMapByName);
}
