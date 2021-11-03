package com.example.demo.src.post;


import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.post.model.*;
import com.example.demo.utils.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import static com.example.demo.config.BaseResponseStatus.*;

//Provider : Read의 비즈니스 로직 처리
@Service
public class PostProvider {

    private final PostDao postDao;
    private final JwtService jwtService;


    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public PostProvider(PostDao postDao, JwtService jwtService) {
        this.postDao = postDao;
        this.jwtService = jwtService;
    }

    //특정유저 전체 판매중, 판매완료 게시물 조회
    public List<AllPostSelectRes> allPostSelect(int userId) throws BaseException{
        int checkUserId = postDao.checkUserId(userId);
        if(checkUserId == 0){//정상 상태가 아닌 유저라면
            throw new BaseException(POST_POST_INVALID_USER);
        }
        //게시물이 없는지 조회

        try{
            List<AllPostSelectRes> allPostSelectRes = postDao.allPostSelect(userId);//getUser(userIdx)를 반환받아서 반환한다.
            return allPostSelectRes;
        } catch(Exception exception){
            throw new BaseException(DATABASE_ERROR);
        }

    }
    //특정 유저 판매중 게시물 조회
    public List<AllPostSelectRes> salePostSelect(int userId) throws BaseException{
        int checkUserId = postDao.checkUserId(userId);
        if(checkUserId == 0){//정상 상태가 아닌 유저라면
            throw new BaseException(POST_POST_INVALID_USER);
        }
        try{
            List<AllPostSelectRes> salePostSelect = postDao.salePostSelect(userId);//getUser(userIdx)를 반환받아서 반환한다.
            return salePostSelect;
        } catch(Exception exception){
            throw new BaseException(DATABASE_ERROR);
        }

    }
    //특정 유저 판매완료 게시물 조회
    public List<AllPostSelectRes> dealCompletePostSelect(int sellerUserId) throws BaseException{
        int checkUserId = postDao.checkUserId(sellerUserId);
        if(checkUserId == 0){//정상 상태가 아닌 유저라면
            throw new BaseException(POST_POST_INVALID_USER);
        }
        try{
            List<AllPostSelectRes> dealCompletePostSelect = postDao.dealCompletePostSelect(sellerUserId);//getUser(userIdx)를 반환받아서 반환한다.
            return dealCompletePostSelect;
        } catch(Exception exception){
            throw new BaseException(DATABASE_ERROR);
        }

    }

    //특정 유저 구매완료 게시물 조회
    public List<AllPostSelectRes> purchaseCompletePostSelect(int buyerUserId) throws BaseException{
        int checkUserId = postDao.checkUserId(buyerUserId);
        if(checkUserId == 0){//정상 상태가 아닌 유저라면
            throw new BaseException(POST_POST_INVALID_USER);
        }
        try{
            List<AllPostSelectRes> purchaseCompletePostSelect = postDao.purchaseCompletePostSelect(buyerUserId);//getUser(userIdx)를 반환받아서 반환한다.
            return purchaseCompletePostSelect;
        } catch(Exception exception){
            throw new BaseException(DATABASE_ERROR);
        }

    }


}
