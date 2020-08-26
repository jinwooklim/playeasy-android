package com.prography.playeasy.match.api;

import com.prography.playeasy.match.domain.dtos.request.MatchUpdateRequestDto;
import com.prography.playeasy.match.domain.dtos.response.MapResponseDto;
import com.prography.playeasy.match.domain.dtos.response.MatchCreateResponseDto;
import com.prography.playeasy.match.domain.dtos.response.MatchDetailDto;
import com.prography.playeasy.match.domain.dtos.request.MatchPostRequestDto;
import com.prography.playeasy.match.domain.dtos.response.MatchListDto;
import com.prography.playeasy.match.domain.dtos.response.MatchUpdateResponseDto;
import com.prography.playeasy.match.domain.models.Match;


import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface RetrofitMatchApi {
//RetrofitMatchApi.class

//todo String 으로수정?
    @GET("/api/match/list")
    Call<MatchListDto> getMatchList(@Query("date") String date);
//    @GET("/api/match/list")
//    Call<List<MatchDto>> getMatchList(@Query("date") String date,@Query("status") String status);
    /**
     * 매치 상세 조회
     * @param matchId 클릭한 매치의 ID
     * @example /api/match?id={matchId}
     * @return MatchResponseDto-->Match로 수정
     */
//todo-issue
    //토큰 보내는 게 맞나
    @GET("/api/match")
    Call<MatchDetailDto> getMatch(@Header("authorization") String token,@Body int matchId);
   //3번쨰 매치 수정
    @PUT("/api/match")
    Call <MatchUpdateResponseDto> reviseMatch(@Header("authorization") String token,
                                                  @Body MatchUpdateRequestDto matchUpdaterequestDto);

    //매치 마감
    @PUT("/api/match/status")
   Call <MatchDetailDto> closeMatch(@Body HashMap<String,Object> body);

  // Call <MatchDetailDto> closeMatch( @Body  body);
//    int matchId = 0;
//    enum status{WAITING,CONFIRMED,CANCEL} status;
//    String nestedJson="{"+matchId+":"+matchId+","+"statusType" +":"+ status+"}";
//    Gson gson=new Gson();
//    Map<String,Object> result=gson.fromJson(nestedJson,Map.class);


    @POST("/api/match")
    Call<MatchCreateResponseDto> postMatch(@Header("authorization") String token,
                                           @Body MatchPostRequestDto requestVO);

    @GET("/api/map/search")
    Call<MapResponseDto> getMap(@Query("keyWord") String keyWord);

}
