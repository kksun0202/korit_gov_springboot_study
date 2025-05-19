package com.korit.springboot.controller;

// 요청 URL: /api/age 응답 데이터: { name: 김선영, age:32 }
// 요청 URL: /api/names 응답 데이터: ["김선영", "김선일", "김선이"]
// 요청 URL: /api/students 응답 데이터: [{name: 김선영, age:32}, {name: 김선일, age:32}]
// 요청 URL: /api/students2 응답 데이터:
/*
    [
        {
            name: 김선영,
            age: 32,
            hobby: [축구, 농구]
        },
        {
            name: 김선일,
            age: 33,
            hobby: [골프, 낚시]
        }
    ]
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HttpStudyController2 {

    @GetMapping("/age")
    public Map<String, Object> getAge() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "김선영");
        map.put("age", 32);
        map.put("address", "북구");

        Map<String, Object> map2 = Map.of("name", "김선영", "age", 32);
//        map2.put("address", "북구");  // 실행 x -> new HashMap<>() 과  Map.of()의 차이 알기

        return map;
    }

    @GetMapping("/names")
    public List<String> getNames() {
        List<String> names = List.of("김선영","김선일","김선이");
        return names;
    }

    @GetMapping("/names2")
    public String[] getNames2() {
        String[] names = {"김선영", "김선일", "김선이"};
        return names;
    }

    @GetMapping("/students")
    public List<Map<String, Object>> getStudents() {
//        List<Map<String, Object>> students = new ArrayList<>();
//        Map<String, Object> student1 = new HashMap<>();
//        Map<String, Object> student2 = new HashMap<>();
//
//        student1.put("name","김선영");
//        student1.put("age", 32);
//        student2.put("name","김선일");
//        student2.put("age", 32);
//
//        students.add(student1);
//        students.add(student2);
//
//        return students;
        return List.of(
                Map.of("name", "김선영", "age", 32),
                Map.of("name", "김선일", "age", 33)
        );
    }

    @GetMapping("/students2")
    public List<Map<String, Object>> getStudents2() {
        List<Map<String, Object>> students = new ArrayList<>();
        Map<String, Object> student1 = new HashMap<>();
        Map<String, Object> student2 = new HashMap<>();
        List<String> hobbys = new ArrayList<>();
        List<String> hobbys2 = new ArrayList<>();

        hobbys.add("축구");
        hobbys.add("농구");
        hobbys2.add("골프");
        hobbys2.add("낚시");
        
        student1.put("name", "김선영");
        student1.put("age", 32);
        student1.put("hobby", hobbys);
        student2.put("name", "김선일");
        student2.put("age", 33);
        student2.put("hobby", hobbys2);

        students.add(student1);
        students.add(student2);

        return students;
    }
}
