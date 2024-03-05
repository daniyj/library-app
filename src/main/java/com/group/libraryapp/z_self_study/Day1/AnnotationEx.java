package com.group.libraryapp.z_self_study.Day1;

public class AnnotationEx {
    public static void main(String[] args) {
        Class<?> clazz = MyClass.class;

        //@Author 어노테이션 정보 가져오기
        Author authorAnnotation = clazz.getAnnotation(Author.class);

        if (authorAnnotation != null) {
            // 어노테이션 멤버 값 출력
            System.out.println("Author: " + authorAnnotation.name());
            System.out.println("Date: " + authorAnnotation.date());
        }else {
            System.out.println("Author annotation not found");
        }
    }
}
