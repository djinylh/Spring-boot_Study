package com.green.firstserver;

import com.green.firstserver.medel.MemoGetOneRes;
import com.green.firstserver.medel.MemoGetRes;
import com.green.firstserver.medel.MemoPostReq;
import com.green.firstserver.medel.MemoPutReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // 빈등록
@RequiredArgsConstructor
public class MemoService {
    //Persistence DB작업 처리 ( 로직 + DB작업 지시 )
    //생성자로 주입받고 싶음.


    private final MemoMapper memoMapper;



    public int insMemo(MemoPostReq req) {

        return memoMapper.insMemo(req);
    }

    public List<MemoGetRes> selMemoList() {
        return memoMapper.selMemoList();
    }
    public MemoGetOneRes selMemo(int id) {
        return memoMapper.selMemo(id);
    }
    public int updMemo(MemoPutReq req){

        return memoMapper.updMemo(req);
    }
    public int delMemo(int id){
        return memoMapper.delMemo(id);
    }
}
