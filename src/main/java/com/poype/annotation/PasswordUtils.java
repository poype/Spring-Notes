package com.poype.annotation;

public class PasswordUtils {

    @UseCase(id = 47, description = "password must contain at least one numeric")
    public boolean validatePassword(String password) {
        System.out.println("validate password");
        return true;
    }

    @UseCase(id = 48)
    public String encryptPassword(String password) {
        System.out.println("encrypt password");
        return "123456";
    }

    @UseCase(id = 49, description = "New passwords can't equal previously used ones")
    public boolean checkForNewPassword(String password) {
        System.out.println("check for new password");
        return true;
    }

    private void test() {
        System.out.println("测试静态方法");
    }
}
