/*
 * Created by Antonio Lozano on 2/20/2020.
 */

package mx.com.retrofit.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IGetDataService
{
    @GET("/photos")
    Call<List<RetroPhoto>> getAllPhotos();
}

