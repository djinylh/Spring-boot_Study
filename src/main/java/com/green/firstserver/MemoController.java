package com.green.firstserver;

import com.green.firstserver.medel.MemoGetOneRes;
import com.green.firstserver.medel.MemoGetRes;
import com.green.firstserver.medel.MemoPostReq;
import com.green.firstserver.medel.MemoPutReq;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 빈(Bean) 등록, 스프링 컨테이너 객체 생성을 대리로 맡긴다. 요청/응답 담당자
@RequiredArgsConstructor // 파이날 변수를 초기화
// 인스턴스 변수의 생성자를 자동으로 만들어줌
public class MemoController {

    private final MemoService memoService;
    //DI 받는 법 3가지 Dependency Injection 외부에서 주소값이 날라오는 것
    // 1. 필드 주입
    // 2. setter 주입 (메소드 주입)
    // 3. 생성자 주입 **
    @PostMapping("/memo")
    public String postMemo(@RequestBody MemoPostReq req){ // @RequestBody는 JSON 데이터를 받아줌.
        System.out.println("postMemo"+req);
        int result = memoService.insMemo(req);

        return result == 1 ? "성공" :"실패";
    }



    @GetMapping("/memo")
    public List<MemoGetRes> getMemo() {
        return memoService.selMemoList();
    }

    @GetMapping("/memo/{id}")
    public MemoGetOneRes getMemo(@PathVariable int id) {
        System.out.println("getMemo: "+ id);
        return memoService.selMemo(id);
    }
    @PutMapping("/memo")
    public String putMemo(@RequestBody MemoPutReq req ) {
        System.out.println("putMemo"+req);
        int result = memoService.updMemo(req);

        return  result == 1 ? "성공" :"실패";

    }

    @DeleteMapping("/memo")
    public String delsMemo(@RequestParam int id){
        System.out.println("delMemo"+id);
        int result = memoService.delMemo(id);
        return result == 1 ? "성공" :"실패";
    }
}
