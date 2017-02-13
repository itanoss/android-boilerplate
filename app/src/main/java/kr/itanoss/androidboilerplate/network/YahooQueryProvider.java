package kr.itanoss.androidboilerplate.network;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YahooQueryProvider {
    /**
     * https://developer.yahoo.com/weather/
     */
    @GET("v1/public/yql")
    Observable<Map<String, Object>> query(@Query(value = "q", encoded = true) String query, @Query("format") String format);
}
