package Service.Impl;

import Service.UserService;

/**
 * Created by lih on 2017/3/30.
 */
public class UserServiceImpl implements UserService {
    @Override
    public String getName(int id) {
        System.out.println("----get name now ---------");
        return "name" + id;
    }

    @Override
    public Integer getAge(int id) {
        System.out.println("----get age now ---------");
        return id;
    }

    @Override
    public Integer getNonAop(int id) {
        System.out.println("----get no aop method now ---------");
        return id;
    }
}
