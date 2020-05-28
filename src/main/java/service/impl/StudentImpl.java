package service.impl;

import service.IStudent;

/**
 * @ClassName StudentImpl
 * @Description: TODO
 * @Author lxc
 * @Date 2020/5/28 12:25
 * @Version V1.0
 **/
public class StudentImpl implements IStudent {

    public StudentImpl(){}
    @Override
    public void addStudent(String name) {
        System.out.println("添加学生:"+name);
    }
}
