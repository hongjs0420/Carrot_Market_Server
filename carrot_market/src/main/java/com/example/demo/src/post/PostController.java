package com.example.demo.src.post;

import com.example.demo.src.post.PostProvider;
import com.example.demo.src.post.PostService;
import com.example.demo.src.user.model.PostLoginReq;
import com.example.demo.src.user.model.PostLoginRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.post.model.*;
import com.example.demo.utils.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static com.example.demo.config.BaseResponseStatus.*;
import static com.example.demo.utils.ValidationRegex.*;

@RestController
@RequestMapping("/post")
public class PostController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final PostProvider postProvider;
    @Autowired
    private final PostService postService;
    @Autowired
    private final JwtService jwtService;




    public PostController(PostProvider postProvider, PostService postService, JwtService jwtService){
        this.postProvider = postProvider;
        this.postService = postService;
        this.jwtService = jwtService;
    }

    /**
     * 특정 유저전체 판매중, 판매완료 게시물 조회 API
     * [GET] /post/:userId
     * @return BaseResponse<AllPostSelectRes>
     */
    @ResponseBody
    @GetMapping("/{userId}")
    public BaseResponse<List<AllPostSelectRes>> allPostSelect(@PathVariable("userId") int userId){
        try{

            List<AllPostSelectRes> allPostSelectRes = postProvider.allPostSelect(userId);
            return new BaseResponse<>(allPostSelectRes);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }

    }

    /**
     * 특정 유저전체 판매중 게시물 조회 API
     * [GET] /post/sales/:userId
     * @return BaseResponse<AllPostSelectRes>
     */

    @ResponseBody
    @GetMapping("/sales/{userId}")
    public BaseResponse<List<AllPostSelectRes>> salePostSelect(@PathVariable("userId") int userId){
        try{

            List<AllPostSelectRes> salePostSelect = postProvider.salePostSelect(userId);
            return new BaseResponse<>(salePostSelect);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }

    }

    /**
     * 특정 유저전체 판매완료 게시물 조회 API
     * [GET] /post/deal-complete/:sellerUserId
     * @return BaseResponse<AllPostSelectRes>
     */

    @ResponseBody
    @GetMapping("/deal-complete/{sellerUserId}/sale")
    public BaseResponse<List<AllPostSelectRes>> dealCompletePostSelect(@PathVariable("sellerUserId") int sellerUserId){
        try{

            List<AllPostSelectRes> dealCompletePostSelect = postProvider.dealCompletePostSelect(sellerUserId);
            return new BaseResponse<>(dealCompletePostSelect);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }

    }

    /**
     * 특정 유저의 판매 게시물 중 숨김 게시물 조회 API
     * [GET] /post/hide/:userId
     * @return BaseResponse<AllPostSelectRes>
     */

    @ResponseBody
    @GetMapping("/hide/{userId}")
    public BaseResponse<List<AllPostSelectRes>> hidePostSelect(@PathVariable("userId") int userId){
        try{

            List<AllPostSelectRes> hidePostSelect = postProvider.hidePostSelect(userId);
            return new BaseResponse<>(hidePostSelect);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }

    }


    /**
     * 특정 유저전체 구매완료 게시물 조회 API
     * [GET] /post/deal-complete/:buyerUserId
     * @return BaseResponse<AllPostSelectRes>
     */

    @ResponseBody
    @GetMapping("/deal-complete/{buyerUserId}/purchase")
    public BaseResponse<List<AllPostSelectRes>> purchaseCompletePostSelect(@PathVariable("buyerUserId") int buyerUserId){
        try{

            List<AllPostSelectRes> purchaseCompletePostSelect = postProvider.purchaseCompletePostSelect(buyerUserId);
            return new BaseResponse<>(purchaseCompletePostSelect);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }

    }

    /**
     * 게시물 대표 이미지 조회 게시물(가장 먼저 들어간 이미지를 반환합니다.)
     * [GET] /post/title-image?postId={postId}
     * @return BaseResponse<AllPostSelectRes>
     */

    @ResponseBody
    @GetMapping("/title-image")
    public BaseResponse<GetPostImage> getPostTitleImage(@RequestParam("postId") int postId){
        try{
            GetPostImage getPostTitleImage = postProvider.getPostTitleImage(postId);
            return new BaseResponse(getPostTitleImage);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }

    }

    /**
     * 게시물 이미지 조회 게시물(가장 먼저 들어간 이미지를 반환합니다.)
     * [GET] /post/title-image?postId={postId}
     * @return BaseResponse<AllPostSelectRes>
     */

    @ResponseBody
    @GetMapping("/image")
    public BaseResponse<List<GetPostImage>> getPostAllImage(@RequestParam("postId") int postId){
        try{
            List<GetPostImage> getPostAllImage = postProvider.getPostAllImage(postId);
            return new BaseResponse<>(getPostAllImage);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }

    }
    //게시물 추가
    @ResponseBody
    @PostMapping("")
    public BaseResponse<PostPostRes> post(@RequestBody PostPostReq postPostReq){
        try{
            /*
            //휴대폰번호 입력 체크
            if(postPostReq.getUserId() == 0){
                return new BaseResponse<>(POST_USERS_EMPTY_PHONE);
            }

             */

            PostPostRes postPostRes = postProvider.post(postPostReq);
            return new BaseResponse<>(postPostRes);
        } catch (BaseException exception){
            return new BaseResponse<>(exception.getStatus());
        }
    }

}
