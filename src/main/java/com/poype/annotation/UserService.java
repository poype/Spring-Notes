package com.poype.annotation;

public class  UserService {

    // 容器注解
    @ContainerAnnotation({
            @UseCase(id=1, description = "one"),
            @UseCase(id = 2, description = "two"),
            @UseCase(id = 3)})
    public String findName() {
        return "Lucy";
    }
}
